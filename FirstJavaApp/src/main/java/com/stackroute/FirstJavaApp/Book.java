package com.stackroute.FirstJavaApp;

import org.springframework.beans.factory.annotation.Autowired;

public class Book {
String bookid;
String bookname;

@Autowired
Author author;


public String getBookid() {
	return bookid;
}
public void setBookid(String bookid) {
	this.bookid = bookid;
}
public String getBookname() {
	return bookname;
}
public void setBookname(String bookname) {
	this.bookname = bookname;
}
public Author getAuthor() {
	return author;
}
public void setAuthor(Author author) {
	this.author = author;
}

	
}
