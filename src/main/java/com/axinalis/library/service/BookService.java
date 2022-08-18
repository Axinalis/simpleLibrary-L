package com.axinalis.library.service;

import com.axinalis.library.dto.BookDto;
import com.axinalis.library.repository.BookRepository;
import com.axinalis.library.service.mapping.BookMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {

    private static Logger log = LoggerFactory.getLogger(BookService.class);
    @Autowired
    private BookRepository bookRepository;

    public List<BookDto> listBooks(){
        List<BookDto> books = new ArrayList<>();
        bookRepository.findAll().forEach(book ->
                books.add(BookMapper.mapEntityToDto(book))
        );
        return books;
    }

    public BookDto getBook(Long id){
        return BookMapper
                .mapEntityToDto(bookRepository
                        .findById(id)
                        .orElseThrow(RuntimeException::new));
    }

    public BookDto createBook(BookDto book) {
        book.setId(null);
        return BookMapper
                .mapEntityToDto(bookRepository.save(BookMapper
                        .mapDtoToEntity(book)));
    }

    public BookDto updateBook(Long id, BookDto book) {
        book.setId(id);
        return BookMapper
                .mapEntityToDto(bookRepository.save(BookMapper
                        .mapDtoToEntity(book)));
    }

    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }
}
