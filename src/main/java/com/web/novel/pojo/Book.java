package com.web.novel.pojo;

public class Book {
    private Integer bookId;

    private String bookName;

    private String bookUrl;

    private String bookDescription;

    private String bookOldPrice;

    private String bookNewPrice;

    private Integer bookReadAmount;

    private Integer bookBuyAmount;

    private String bookImage;

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName == null ? null : bookName.trim();
    }

    public String getBookUrl() {
        return bookUrl;
    }

    public void setBookUrl(String bookUrl) {
        this.bookUrl = bookUrl == null ? null : bookUrl.trim();
    }

    public String getBookDescription() {
        return bookDescription;
    }

    public void setBookDescription(String bookDescription) {
        this.bookDescription = bookDescription == null ? null : bookDescription.trim();
    }

    public String getBookOldPrice() {
        return bookOldPrice;
    }

    public void setBookOldPrice(String bookOldPrice) {
        this.bookOldPrice = bookOldPrice == null ? null : bookOldPrice.trim();
    }

    public String getBookNewPrice() {
        return bookNewPrice;
    }

    public void setBookNewPrice(String bookNewPrice) {
        this.bookNewPrice = bookNewPrice == null ? null : bookNewPrice.trim();
    }

    public Integer getBookReadAmount() {
        return bookReadAmount;
    }

    public void setBookReadAmount(Integer bookReadAmount) {
        this.bookReadAmount = bookReadAmount;
    }

    public Integer getBookBuyAmount() {
        return bookBuyAmount;
    }

    public void setBookBuyAmount(Integer bookBuyAmount) {
        this.bookBuyAmount = bookBuyAmount;
    }

    public String getBookImage() {
        return bookImage;
    }

    public void setBookImage(String bookImage) {
        this.bookImage = bookImage;
    }
}