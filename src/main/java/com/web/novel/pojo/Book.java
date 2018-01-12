package com.web.novel.pojo;

public class Book {
    private Integer bookId;

    private String bookName;

    private String bookUrl;

    private String bookOldPrice;

    private String bookNewPrice;

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
}