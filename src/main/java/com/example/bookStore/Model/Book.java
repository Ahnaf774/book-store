package com.example.bookStore.Model;
import lombok.Data;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey;

@Data
@DynamoDbBean
public class Book {
    private String id;
    private String title;
    private String author;
    private String genre;
    private Double price;
    private long soldUnits;

    @DynamoDbPartitionKey
    public String getId() {
        return id;
    }
}

