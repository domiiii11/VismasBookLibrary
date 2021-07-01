package com.example.vismasbooklibrary.controllers;

import com.example.vismasbooklibrary.models.Book;
import com.example.vismasbooklibrary.services.ProductServiceImpl;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;


import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/books", consumes = {"application/json"})
public class BookController {

    private ProductServiceImpl productServiceImpl;


    @PostMapping(value = "/book")
    public void createBook(@RequestBody Book book) throws IOException {
        System.out.println(book);
        productServiceImpl.createBook(book);
    }

    // rest api to take a book from the library
    @GetMapping("/GUID/{GUID}")
    public Book findOneBook(@PathVariable Long GUID) throws IOException {
      return productServiceImpl.findOneBook(GUID);
    }

    @GetMapping("/author/{author}")
    public List<Book> filterByAuthor(@PathVariable String author) {
        return productServiceImpl.filterByAuthor(author);
    }

    @GetMapping("/category/{category}")
    public List<Book> filterByCategory(@PathVariable String category) {
        return productServiceImpl.filterByCategory(category);
    }

    @GetMapping("/language/{language}")
    public List<Book> filterByLanguage(@PathVariable String language) {
        return productServiceImpl.filterByLanguage(language);
    }

    @GetMapping("/isbn/{ISBN")
    public List<Book> filterByISBN(@PathVariable String ISBN) {
        return productServiceImpl.filterByISBN(ISBN);
    }

    @GetMapping("/name/{name}")
    public List<Book> filterByName(@PathVariable String name) {
        return productServiceImpl.filterByName(name);
    }

    // This is improvisation "status"
    @GetMapping("/status/{status}")
    public List<Book> filterByStatus(@PathVariable String status) {
        return productServiceImpl.filterByStatus(status);
    }

    @DeleteMapping("/uuid/{UUID}")
    public void deleteByGUID(@PathVariable Long GUID) {
        productServiceImpl.deleteByGUID(GUID);
    }

    @PutMapping("/borrow/{name}")
    public void borrowBooks(@PathVariable String name, @RequestBody Map<String,Integer> books)
    {
       productServiceImpl.borrowBooks(name, books);

    }

}








