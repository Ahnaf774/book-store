package com.example.bookStore.Model;
import lombok.Builder;
import lombok.Data;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey;

@Data
@DynamoDbBean
@Builder
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

