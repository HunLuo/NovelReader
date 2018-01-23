package com.web.novel.controller;

import com.google.gson.JsonObject;
import com.paypal.api.payments.Links;
import com.paypal.api.payments.Payment;
import com.paypal.base.rest.PayPalRESTException;
import com.web.novel.config.PaypalPaymentIntent;
import com.web.novel.config.PaypalPaymentMethod;
import com.web.novel.pojo.Book;
import com.web.novel.service.BookService;
import com.web.novel.service.PaypalService;
import com.web.novel.utils.URLUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/")
public class PaymentController {

    public static final String PAYPAL_SUCCESS_URL = "success";
    public static final String PAYPAL_CANCEL_URL = "cancel";
    public static final String PAY_MESSAGE_SUCCESS="支付成功";
    public static final String PAY_MESSAGE_ERROR="支付失败";

    private Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private PaypalService paypalService;
    @Autowired
    private BookService bookService;

    @RequestMapping(method = RequestMethod.GET)
    public String index(){
        return "index";
    }

    @RequestMapping(method = RequestMethod.POST, value = "pay")
    public String pay (@RequestParam("bookId") int bookId, HttpServletRequest request){
        String cancelUrl = URLUtils.getBaseURl(request) + "/" + PAYPAL_CANCEL_URL;
        String successUrl = URLUtils.getBaseURl(request) + "/" + PAYPAL_SUCCESS_URL+"?bookId="+bookId;
        Book book = bookService.getOneBookById(bookId);
        Double total = Double.parseDouble(book.getBookNewPrice());
        String bookName = book.getBookName();
        System.out.println(total);

        try {

            Payment payment = paypalService.createPayment(
                    total,
                    "USD",
                    PaypalPaymentMethod.paypal,
                    PaypalPaymentIntent.sale,
                    bookName,
                    cancelUrl,
                    successUrl);
            for(Links links : payment.getLinks()){
                if(links.getRel().equals("approval_url")){
                    System.out.println(links.getHref());
                    return "redirect:" + links.getHref();
                }
            }
        } catch (PayPalRESTException e) {
            log.error(e.getMessage());
        }
        return "redirect:/";
    }

    @RequestMapping(method = RequestMethod.GET, value = PAYPAL_CANCEL_URL)
    @ResponseBody
    public String cancelPay(){
        JsonObject result = new JsonObject();
        result.addProperty("result", "error");
        result.addProperty("resultCode", "101");
        result.addProperty("resultMessage", PAY_MESSAGE_ERROR);
        result.addProperty("bookId", "null");
        return result.toString();
    }

    @RequestMapping(method = RequestMethod.GET, value = PAYPAL_SUCCESS_URL)
    public String successPay(@RequestParam("paymentId") String paymentId, @RequestParam("PayerID") String payerId,@RequestParam("bookId") String bookId){
        JsonObject result = new JsonObject();
        try {
            Payment payment = paypalService.executePayment(paymentId, payerId);
            if(payment.getState().equals("approved")){
                result.addProperty("result", "success");
                result.addProperty("resultCode", "100");
                result.addProperty("resultMessage", PAY_MESSAGE_SUCCESS);
                result.addProperty("bookId", bookId);
                return "redirect:/download.html?bookId="+bookId;
            }
        } catch (PayPalRESTException e) {
            log.error(e.getMessage());
            result.addProperty("result", "error");
            result.addProperty("resultCode", "101");
            result.addProperty("resultMessage", PAY_MESSAGE_ERROR+e.getMessage());
            result.addProperty("bookId", "null");
            return "redirect:/error.html";

        }
        result.addProperty("result", "error");
        result.addProperty("resultCode", "101");
        result.addProperty("bookId", "null");
        result.addProperty("resultMessage", PAY_MESSAGE_ERROR);
        return result.toString();
    }

}
