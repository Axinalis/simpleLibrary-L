package com.axinalis.library.repository;

import com.axinalis.library.entity.BookEntity;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<BookEntity, Long> {

}
