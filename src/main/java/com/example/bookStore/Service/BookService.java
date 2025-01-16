package com.example.bookStore.Service;

import com.example.bookStore.Model.Book;
import com.example.bookStore.Repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class BookService {
    @Autowired
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Mono<Book> addBook(Book book) {
        return bookRepository.save(book);
    }

    public Mono<Book> getBookById(String id) {
        return bookRepository.findById(id);
    }

    public Mono<Void> removeBook(String id) {
        return bookRepository.deleteById(id);
    }

    public Mono<Book> updateBook(Book book) {
        return bookRepository.update(book);

    }
        public Flux<Book> getAllBooks() {
            return bookRepository.getAllBooks();

    }
}
