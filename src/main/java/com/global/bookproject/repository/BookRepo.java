package com.global.bookproject.repository;

import com.global.bookproject.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepo extends JpaRepository<Book, Long> {

    @Query("SELECT COUNT(b) FROM Book b WHERE b.auther.autherID = :autherID")
    int getBookCountByAuthorID(@Param("autherID") Long autherID);
}
