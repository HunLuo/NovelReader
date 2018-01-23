package com.web.novel.service;

import com.web.novel.pojo.UserBook;

public interface UserBookService {
    Boolean addUserBook(UserBook userBook);
    Boolean isBought(int userId, int bookId);
}
