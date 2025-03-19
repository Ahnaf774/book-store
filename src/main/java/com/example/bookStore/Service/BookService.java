package com.example.bookStore.Service;

import com.example.bookStore.DTO.BookDTO;
import com.example.bookStore.Model.Book;
import com.example.bookStore.Repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class BookService {

    private final BookRepository bookRepository;




    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Mono<Book> addBook(BookDTO bookDTO) {
        return Mono.just(bookDTO)
                .map(dto -> Book.builder()
                        .id(dto.getId())
                        .title(dto.getTitle())
                        .author(dto.getAuthor())
                        .genre(dto.getGenre())
                        .price(dto.getPrice())
                        .build())
                .flatMap(bookRepository::save);
    }

    public Mono<Book> getBookById(String id) {
        return bookRepository.findById(id);
    }

    public Mono<Void> removeBook(String id) {
        return bookRepository.deleteById(id);
    }

    public Mono<Book> updateBook(String id,BookDTO bookDTO) {
        return Mono.just(bookDTO)
                .map(dto -> Book.builder()
                        .id(id)
                        .title(dto.getTitle())
                        .author(dto.getAuthor())
                        .genre(dto.getGenre())
                        .price(dto.getPrice())
                        .build())
                .flatMap(bookRepository::update);

    }
        public Flux<Book> getAllBooks() {
            return bookRepository.getAllBooks();

    }
}
