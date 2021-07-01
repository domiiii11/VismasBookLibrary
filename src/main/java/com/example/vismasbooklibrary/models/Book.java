package com.example.vismasbooklibrary.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;
import java.util.UUID;

@Data
@Entity
@NoArgsConstructor
public class Book {

    @Id
    private Long guid;
    private String name;
    private String author;
    private String category;
    private String language;
    private String publicationDate;
    private String isbn;
    private String status;
    private String borrower;

}
