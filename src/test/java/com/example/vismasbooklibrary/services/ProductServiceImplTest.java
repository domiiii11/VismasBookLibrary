package com.example.vismasbooklibrary.services;

import com.example.vismasbooklibrary.models.Book;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ProductServiceImplTest {


    private List<Book> books;

    private ProductServiceImpl productServiceImpl;

    @BeforeEach
    void setUp() {
        productServiceImpl = new ProductServiceImpl();

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

    }

    @Test
    void filterByLanguage() {
    }

    @Test
    void filterByISBN() {
    }

    @Test
    void filterByName() {
    }

    @Test
    void filterByStatus() {
    }

    @Test
    void deleteByGUID() {
    }

    @Test
    void borrowBooks() {
    }
}