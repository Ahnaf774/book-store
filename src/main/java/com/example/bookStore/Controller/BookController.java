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
        Book book = new Book();
        book.setId(bookDTO.getId());
        book.setTitle(bookDTO.getTitle());
        book.setAuthor(bookDTO.getAuthor());
        book.setGenre(bookDTO.getGenre());
        book.setPrice(bookDTO.getPrice());
        return bookService.addBook(book);  // Call the addBook method from service
    }

    // Get a book by ID
    @GetMapping("/{id}")
    public Mono<Book> getBook(@PathVariable String id) {
        return bookService.getBookById(id);
    }

    // Update a book by ID
    @PutMapping("/{id}")
    public Mono<Book> updateBook(@PathVariable String id, @RequestBody BookDTO bookDTO) {
        // Map the DTO to the Book entity
        Book book = new Book();
        book.setId(id);
        book.setTitle(bookDTO.getTitle());
        book.setAuthor(bookDTO.getAuthor());
        book.setGenre(bookDTO.getGenre());
        book.setPrice(bookDTO.getPrice());
        return bookService.updateBook(book);
    }

    // Delete a book by ID
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Mono<Void> deleteBook(@PathVariable String id) {
        return bookService.removeBook(id);
    }

    @GetMapping
    public Flux<Book> getAllBooks() {
        return bookService.getAllBooks();
    }
}

