package com.example.webapimiddletask.dto;

import lombok.Data;

@Data
public class Book {
    private long id;
    private String title;
    private String author;
    private String genre;
    private int publishedYear;
}
