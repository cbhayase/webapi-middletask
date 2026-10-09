package com.example.webapimiddletask.mapper;

import com.example.webapimiddletask.dto.Book;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface BookMapper {
    @Select("SELECT id, title, author, genre, published_year FROM books")
    List<Book> findAll();
}
