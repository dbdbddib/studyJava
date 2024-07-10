package com.example.myjpa.category;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CategoryControllerTest {
    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    public void CateforyTest() {
        String url = "http://localhost:"+port;
        CategoryDto requestInsert = CategoryDto.builder().build();
        ResponseEntity<ICategory> responstInsert = this.testRestTemplate.postForEntity(url +
                "/ct", requestInsert, ICategory.class);
        assertThat(responstInsert).isNotNull();
        assertThat(responstInsert.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);

        CategoryDto requestInsert2 = CategoryDto.builder().name("RestFulAPI Input").build();
        ResponseEntity<ICategory> responstInsert2 = this.testRestTemplate.postForEntity(url +
                "/ct", requestInsert2, ICategory.class);
        assertThat(responstInsert).isNotNull();
        assertThat(responstInsert.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(responstInsert2.getBody().getName()).isEqualTo("RestFulAPI Input");
    }
}
