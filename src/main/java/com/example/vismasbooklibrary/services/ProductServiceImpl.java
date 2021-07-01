package com.example.vismasbooklibrary.services;

import com.example.vismasbooklibrary.models.Book;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl {

    ObjectMapper objectMapper = new ObjectMapper();

    public List<Book> fetchBooks() throws IOException {
        List<Book> books = objectMapper.readValue(new File("C:\\Users\\PC\\Documents\\JSONfile\\file.json"), objectMapper.getTypeFactory().constructCollectionType(List.class, Book.class));
        return books;
    }

    public void createBook(Book book) throws IOException {
        List<Book> books = fetchBooks();
        books.add(book);
        objectMapper.writeValue(Paths.get("C:\\Users\\PC\\Documents\\JSONfile\\file.json").toFile(), books);
        List<Book> books2 = objectMapper.readValue(new File("C:\\Users\\PC\\Documents\\JSONfile\\file.json"), objectMapper.getTypeFactory().constructCollectionType(List.class, Book.class));
        System.out.println(books2);
    }

    public Book findOneBook(Long guid) throws IOException {
        Book foundBook = null;
        List<Book> books = fetchBooks();
        System.out.println(books);
        for (Book book : books) {
            if (book.getGuid().equals(guid)) {
                foundBook = book;
            }
        }
        return foundBook;
    }

    @SneakyThrows
    public List<Book> filterByAuthor(String author) {
        return fetchBooks().stream()
                .filter(book -> book.getAuthor().equals(author))
                .collect(Collectors.toList());

    }

    @SneakyThrows
    public List<Book> filterByCategory(String category) {
        return fetchBooks().stream()
                .filter(book -> book.getCategory().equals(category))
                .collect(Collectors.toList());
    }

    @SneakyThrows
    public List<Book> filterByLanguage(String language) {
        return fetchBooks().stream()
                .filter(book -> book.getLanguage().equals(language))
                .collect(Collectors.toList());

    }

    @SneakyThrows
    public List<Book> filterByISBN(String isbn) {
        return fetchBooks().stream()
                .filter(book -> book.getIsbn().equals(isbn))
                .collect(Collectors.toList());


    }

    @SneakyThrows
    public List<Book> filterByName(String name) {
        return fetchBooks().stream()
                .filter(book -> book.getName().equals(name))
                .collect(Collectors.toList());
    }

    @SneakyThrows
    public List<Book> filterByStatus(String status) {
        return fetchBooks().stream()
                .filter(book -> book.getStatus().equals(status))
                .collect(Collectors.toList());
    }

    @SneakyThrows
    public void deleteByGUID(Long guid) {
        List<Book> books = fetchBooks().stream()
                .filter(book -> !book.getGuid().equals(guid))
                .collect(Collectors.toList());
        objectMapper.writeValue(Paths.get("C:\\Users\\PC\\Documents\\JSONfile\\file.json").toFile(), books);
    }
    @SneakyThrows
    public void borrowBooks(String name, Map<String, Integer> booksBasket) {
        List<Book> books = fetchBooks();
        if(!acceptableDuration(booksBasket)) {
        }
        for (Map.Entry<String, Integer> entry : booksBasket.entrySet()) {
            for(Book book : books) {
               if(book.getName().equals(entry.getKey())){
                   book.setBorrower(name);
                }
//            List<Book> books = fetchBooks().stream()
//                    .forEach(book. -> !book.getGuid().equals(guid))
//                    .collect(Collectors.toList());
//            for (Map.Entry<Book, Integer> entry : booksBasket.entrySet()) {
//                entry.getKey().setBorrower(name);

            }
        }

        }

//        booksOrder.entrySet().stream()
//                .forEach(entry -> entry.getKey());
//
//        booksOrder
//        List<Book> books = fetchBooks().stream()


    private Boolean acceptableDuration(Map<String, Integer> booksBasket) {
        Boolean answer = true;
        for (Map.Entry<String, Integer> entry : booksBasket.entrySet()) {
            if (entry.getValue() > 60) {
                answer = false;
            }
        }
        return answer;
    }
        }
