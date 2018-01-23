package com.web.novel.service;

import com.paypal.api.payments.Payment;
import com.paypal.base.rest.PayPalRESTException;
import com.web.novel.config.PaypalPaymentIntent;
import com.web.novel.config.PaypalPaymentMethod;

public interface PaypalService {
    Payment createPayment(
            Double total,
            String currency,
            PaypalPaymentMethod method,
            PaypalPaymentIntent intent,
            String description,
            String cancelUrl,
            String successUrl) throws PayPalRESTException;
    Payment executePayment(String paymentId, String payerId) throws PayPalRESTException;

}
