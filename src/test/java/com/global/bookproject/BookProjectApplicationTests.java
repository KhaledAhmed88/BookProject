package com.global.bookproject;

import com.global.bookproject.entity.Auther;
import com.global.bookproject.service.AutherService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class BookProjectApplicationTests {

    @Autowired
    AutherService autherService;
    @Test
    void findByAutherNameNotFoundTest() {
        Optional<Auther> auther = autherService.findByAutherName("Mohsen");
        assertEquals(false,auther.isPresent());
    }
    @Test
    void findByAutherNameFoundTest() {
        Optional<Auther> auther = autherService.findByAutherName("Mostafa");
        assertEquals(true,auther.isPresent());
        assertEquals("Mostafa",auther.get().getAutherName());
    }


}
