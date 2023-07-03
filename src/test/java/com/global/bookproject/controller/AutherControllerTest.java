package com.global.bookproject.controller;

import com.global.bookproject.entity.Auther;
import com.global.bookproject.service.AutherService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.mock.http.server.reactive.MockServerHttpRequest.get;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT )
public class AutherControllerTest {

    @Autowired
    TestRestTemplate restTemplate;
    @MockBean
    AutherService autherService;


    @Test
    public void findByAutherNameNotFoundTest(){

    Optional<Auther> autherParam = Optional.of(new Auther(11L, "Mostafa" , 11));
    Mockito.when(autherService.findByAutherName(Mockito.anyString())).thenReturn(autherParam);
    String autherName = "Mostafa";
    ResponseEntity<String> responseEntity=restTemplate.getForEntity("/api/v1/auther/name/" + autherName, String.class);
    assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
    assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    //assertThat(responseEntity.getBody()).isEqualTo("OK");
    }

    @Test
    public void createAutherTest ()throws Exception{

        Auther autherParam = new Auther(111L, "Adham" , 11);
        Mockito.when(autherService.createAuther(Mockito.any(Auther.class))).thenReturn(autherParam);
        String autherName = "Mostafa";
        ResponseEntity<String> responseEntity=restTemplate.getForEntity("/api/v1/auther/name/" + autherName, String.class);
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        //assertThat(responseEntity.getBody()).isEqualTo("OK");
    }
    @Test
    public void deleteAutherTest ()throws Exception{
        Mockito.doThrow(ChangeSetPersister.NotFoundException.class).when(autherService).deleteAuther(Mockito.anyLong());
        Mockito.doNothing().when(autherService).deleteAuther(Mockito.anyLong());
        Long autherID = 4L;
        ResponseEntity<String> responseEntity = restTemplate.exchange("/api/v1/author/" + autherID, HttpMethod.DELETE, null, String.class);
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
        assertEquals(HttpStatus.NOT_FOUND, responseEntity.getStatusCode());

        //assertThat(responseEntity.getBody()).isEqualTo("OK");
    }

}
