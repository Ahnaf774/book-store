package com.example.bookStore.Controller;

import com.example.bookStore.DTO.BookDTO;
import com.example.bookStore.Model.Book;
import com.example.bookStore.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Book> addBook(@RequestBody BookDTO bookDTO) {
        return  bookService.addBook(bookDTO);

    }

    @GetMapping("/{id}")
    public Mono<Book> getBook(@PathVariable String id) {

        return bookService.getBookById(id);
    }


    @PutMapping("/{id}")
        public Mono<Book> updateBook(@PathVariable String id, @RequestBody BookDTO bookDTO) {
           return bookService.updateBook(id, bookDTO);
        }



    @DeleteMapping("/{id}")
    public Mono<Void> deleteBook(@PathVariable String id) {
        return bookService.removeBook(id);
    }

    @GetMapping
    public Flux<Book> getAllBooks() {
        return bookService.getAllBooks();
    }
}

