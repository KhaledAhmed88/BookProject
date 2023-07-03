package com.global.bookproject.service;

import com.global.bookproject.entity.Auther;
import com.global.bookproject.repository.AutherRepo;
import com.sun.source.tree.OpensTree;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
public class AutherServiceTest {

    @Autowired
    AutherService autherService;

    @MockBean
    AutherRepo autherRepo;

    @Test
    public void findByAutherNameFoundTest(){
        Optional<Auther> autherParam = Optional.of(new Auther(11L, "Mostafa" , 11));
        Mockito.when(autherRepo.findByAutherName(Mockito.anyString())).thenReturn(autherParam);
        Optional<Auther> auther= autherService.findByAutherName("");
        assertEquals(true, auther.isPresent());
        assertEquals("Mostafa", auther.get().getAutherName());
    }
    @Test
    public void findByAutherNameNotFoundTest(){
        Optional<Auther> autherParam = Optional.empty();
        Mockito.when(autherRepo.findByAutherName(Mockito.anyString())).thenReturn(autherParam);
        Optional<Auther> auther= autherService.findByAutherName("");
        assertFalse(auther.isPresent());
      //assertTrue(auther.isPresent());

    }
}
