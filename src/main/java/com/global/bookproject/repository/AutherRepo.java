package com.global.bookproject.repository;

import com.global.bookproject.entity.Auther;
import com.global.bookproject.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AutherRepo extends JpaRepository<Auther, Long> {

    Optional<Auther> findByAutherName(String autherName);

   //@Query("SELECT a FROM Auther a WHERE a.autherName = :autherName")
  // Optional<Auther> getAutherByAutherName(String autherName);


}


