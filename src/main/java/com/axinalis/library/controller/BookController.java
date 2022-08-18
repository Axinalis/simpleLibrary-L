package com.axinalis.library.controller;

import com.axinalis.library.dto.BookDto;
import com.axinalis.library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("library")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping
    public List<BookDto> getBooksList(){
        return bookService.listBooks();
    }

    @GetMapping("{id}")
    public BookDto getBook(@PathVariable Long id){
        return bookService.getBook(id);
    }

    @PostMapping
    public BookDto createBook(@RequestBody BookDto book){
        return bookService.createBook(book);
    }

    @PutMapping("{id}")
    public BookDto updateBook(@PathVariable Long id, @RequestBody BookDto book){
        return bookService.updateBook(id, book);
    }

    @DeleteMapping("{id}")
    public void deleteBook(@PathVariable Long id){
        bookService.deleteBook(id);
    }

}
