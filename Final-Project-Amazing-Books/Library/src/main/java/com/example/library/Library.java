package com.example.library;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Library {

    @Id
    private Integer bookId;
    private Integer customerId;
    private Integer availableCopies;


    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public Integer getAvailableCopies() {
        return availableCopies;
    }

    public void setAvailableCopies(Integer availableCopies) {
        this.availableCopies = availableCopies;
    }
}
