package com.global.bookproject.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Range;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "Authers")
@JsonIdentityInfo( generator = ObjectIdGenerators.PropertyGenerator.class, property = "autherID")
public class Auther {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Auther_ID")
    private Long autherID;

    @NotNull
    @NotEmpty
    @NotBlank
    @Size(min = 3 , message = "Minimum charcters are 3 ")
    @Column(name = "Auther_Name")
    private String autherName;

    @Column(name = "Auther_Rate")
    @Range(min = 0 , max = 100)
    private int autherRate;

    public Auther(Long autherID, String autherName, int autherRate) {
        this.autherID = autherID;
        this.autherName = autherName;
        this.autherRate = autherRate;
    }

    public Auther() {

    }

    @OneToMany(mappedBy = "auther")
    private List<Book> books;
}
