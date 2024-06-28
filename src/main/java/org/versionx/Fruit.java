package org.versionx;

import java.util.Objects;

import io.quarkus.runtime.annotations.RegisterForReflection;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbAttribute;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey;

@RegisterForReflection
@DynamoDbBean
public class Fruit {

    private String fruitName;
    private String description;

    public Fruit() {
    }

    @DynamoDbPartitionKey
    @DynamoDbAttribute("fruitName")
    public String getFruitName() {
        return fruitName;
    }

    public void setFruitName(String fruitName) {
        this.fruitName = fruitName;
    }

    @DynamoDbAttribute("fruitDescription")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Fruit)) {
            return false;
        }

        Fruit other = (Fruit) obj;

        return Objects.equals(other.fruitName, this.fruitName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.fruitName);
    }
}