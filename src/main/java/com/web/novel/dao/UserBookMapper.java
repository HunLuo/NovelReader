package com.web.novel.dao;

import com.web.novel.pojo.UserBook;
import java.util.List;

public interface UserBookMapper {
    int deleteByPrimaryKey(Integer userBookId);

    int insert(UserBook record);

    UserBook selectByPrimaryKey(Integer userBookId);

    List<UserBook> selectAll();

    int updateByPrimaryKey(UserBook record);
}