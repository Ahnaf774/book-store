package com.example.bookStore.Repository;

import com.example.bookStore.Model.Book;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Flux;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbAsyncTable;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedAsyncClient;
import software.amazon.awssdk.enhanced.dynamodb.TableSchema;

@Repository
public class BookRepository {

    private final DynamoDbAsyncTable<Book> table;

    public BookRepository(DynamoDbEnhancedAsyncClient client) {
        this.table = client.table("Books", TableSchema.fromBean(Book.class));
    }

    public Mono<Book> save(Book book) {
        return   Mono.fromFuture(() -> table.putItem(book))
                .thenReturn(book);
    }

    public Mono<Book> findById(String id) {
        return Mono.fromFuture(table.getItem(r -> r.key(k -> k.partitionValue(id))));
    }

    public Flux<Book> findAll() {
        return Flux.from(table.scan().items());
    }

    public Mono<Void> deleteById(String id) {
        return Mono.fromFuture(table.deleteItem(r -> r.key(k -> k.partitionValue(id)))).then();

    }
     public Mono<Book> update(Book book) {
            return Mono.fromFuture(() -> table.putItem(book)) // Performs the update (or insert if not present)
                       .thenReturn(book); // Return the updated book
        }

    public Flux<Book> getAllBooks() {
        return Flux.from(table.scan().items()); // Convert items to Flux
    }
}

