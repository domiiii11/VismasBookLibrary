package com.example.vismasbooklibrary.services;

import com.example.vismasbooklibrary.models.Book;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ProductServiceImplTest {


    private List<Book> books;

    private ProductServiceImpl productServiceImpl;

    private ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        productServiceImpl = new ProductServiceImpl();
        objectMapper = new ObjectMapper();

        books = new ArrayList<>();
        books.add(new Book(1l,"Dzeine Air", "Sarlote Bronte","Romanas","lietuviu","1976-05-04","15674654","false","Tomas Bernotas"));
        books.add(new Book(2l,"Dzeine Air", "Sarlote Bronte","Romanas","lietuviu","1976-05-04","15674654","false","Tomas Bernotas"));

    }

    @Test
    void fetchBooks() {
    }

    @Test
    void createBook() {
    }

    @Test
    void findOneBook() {
    }

    @Test
    void filterByAuthor() {

        List<Book> answer = productServiceImpl.filterByAuthor("Sarlote Bronte");

        assertNotNull(answer);

        boolean valid = false;
        for  (Book book : answer) {
            if (book.getGuid()== 2l) {
                valid = true;
            }
        }
        assertTrue(valid);
    }

    @Test
    void filterByCategory() {
        List<Book> answer = productServiceImpl.filterByCategory("Romanas");

        assertNotNull(answer);

        boolean valid = false;
        for  (Book book : answer) {
            if (book.getGuid()== 2l) {
                valid = true;
            }
        }
        assertTrue(valid);

    }

    @Test
    void filterByLanguage() {
        List<Book> answer = productServiceImpl.filterByLanguage("lietuviu");

        assertNotNull(answer);

        boolean valid = false;
        for  (Book book : answer) {
            if (book.getGuid()== 2l) {
                valid = true;
            }
        }
        assertTrue(valid);

    }

    @Test
    void filterByISBN() {
        List<Book> answer = productServiceImpl.filterByLanguage("15674654");

        assertNotNull(answer);

        boolean valid = false;
        for  (Book book : answer) {
            if (book.getGuid()== 2l) {
                valid = true;
            }
        }
        assertTrue(valid);
    }

    @Test
    void filterByName() {
        List<Book> answer = productServiceImpl.filterByName("Tomas Bernotas");

        assertNotNull(answer);

        boolean valid = false;
        for  (Book book : answer) {
            if (book.getGuid()== 2l) {
                valid = true;
            }
        }
        assertTrue(valid);
    }

    @Test
    void filterByStatus() {
        List<Book> answer = productServiceImpl.filterByStatus("false");

        assertNotNull(answer);

        boolean valid = false;
        for  (Book book : answer) {
            if (book.getGuid()== 2l) {
                valid = true;
            }
        }
        assertTrue(valid);
    }

    @Test
    void deleteByGUID() {

    }

    @Test
    void borrowBooks() {
    }
}