package com.example.webapimiddletask.exception;

public class BookNotFoundException extends RuntimeException {
    public BookNotFoundException(long id) {
        super("指定されたIDの本が見つかりません：" + id);
    }
}
