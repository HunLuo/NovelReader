package com.web.novel.dao;

import com.web.novel.pojo.UserBook;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface UserBookMapper {
    int deleteByPrimaryKey(Integer userBookId);

    int insert(UserBook record);

    UserBook selectByPrimaryKey(Integer userBookId);

    List<UserBook> selectAll();

    int updateByPrimaryKey(UserBook record);
}