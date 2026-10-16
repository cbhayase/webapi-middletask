package com.example.webapimiddletask.mapper;

import com.example.webapimiddletask.dto.Book;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface BookMapper {
    @Select("SELECT id, title, author, genre, published_year FROM books")
    List<Book> findAll();

    @Insert("INSERT INTO books (title, author, genre, published_year) VALUES (#{title}, #{author}, #{genre}, #{publishedYear})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    int insert(Book book);

    @Select("SELECT id, title, author, genre, published_year FROM books WHERE id = #{id}")
    Book findById(long id);
}
