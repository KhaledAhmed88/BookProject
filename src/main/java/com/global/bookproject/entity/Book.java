package com.global.bookproject.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name ="Books")
@JsonIdentityInfo( generator = ObjectIdGenerators.PropertyGenerator.class, property = "bookID")

public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Book_ID")
    private Long bookID;

    @NotNull
    @Size(min = 1 ,message = "Please Enter at least 3 charcters")
    @Column(name = "Book_Name")
    private String bookName;

    @Column(name = "Book_Price")
    private double bookPrice;

    @Column(name = "Book_Weight")
    private int bookWeight;


    @NotNull
    @ManyToOne
    @JoinColumn(name = "Auther_ID")
    private Auther auther;
    public Book(Long bookID, String bookName, double bookPrice, Auther auther) {
        this.bookID = bookID;
        this.bookName = bookName;
        this.bookPrice = bookPrice;
        this.auther = auther;
    }

    public Book() {
    }


}
