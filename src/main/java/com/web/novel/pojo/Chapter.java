package com.web.novel.pojo;

public class Chapter {
    private Integer chapterId;

    private Integer bookId;

    private String chapterName;

    private Integer chapterNumber;

    private String chapterUrl;

    private String chapterImage;

    private Integer chapterIsCharge;

    public Integer getChapterId() {
        return chapterId;
    }

    public void setChapterId(Integer chapterId) {
        this.chapterId = chapterId;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public String getChapterName() {
        return chapterName;
    }

    public void setChapterName(String chapterName) {
        this.chapterName = chapterName == null ? null : chapterName.trim();
    }

    public Integer getChapterNumber() {
        return chapterNumber;
    }

    public void setChapterNumber(Integer chapterNumber) {
        this.chapterNumber = chapterNumber;
    }

    public String getChapterUrl() {
        return chapterUrl;
    }

    public void setChapterUrl(String chapterUrl) {
        this.chapterUrl = chapterUrl == null ? null : chapterUrl.trim();
    }

    public String getChapterImage() {
        return chapterImage;
    }

    public void setChapterImage(String chapterImage) {
        this.chapterImage = chapterImage;
    }

    public Integer getChapterIsCharge() {
        return chapterIsCharge;
    }

    public void setChapterIsCharge(Integer chapterIsCharge) {
        this.chapterIsCharge = chapterIsCharge;
    }
}