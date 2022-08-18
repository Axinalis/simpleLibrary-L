package com.axinalis.library.service.mapping;

import com.axinalis.library.dto.BookDto;
import com.axinalis.library.entity.BookEntity;

public class BookMapper {

    public static BookDto mapEntityToDto(BookEntity entity){
        BookDto dto = new BookDto();
        dto.setAuthor(entity.getAuthor());
        dto.setTitle(entity.getTitle());
        dto.setPages(entity.getPages());
        dto.setId(entity.getId());
        return dto;
    }

    public static BookEntity mapDtoToEntity(BookDto dto){
        BookEntity entity = new BookEntity();
        entity.setAuthor(dto.getAuthor());
        entity.setTitle(dto.getTitle());
        entity.setPages(dto.getPages());
        entity.setId(dto.getId());
        return entity;
    }

}
