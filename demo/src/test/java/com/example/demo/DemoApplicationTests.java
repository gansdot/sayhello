package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.net.URL;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@DisplayName("HelloApplicationControllerTests")
class DemoApplicationTests {

	// bind RANDOM_PORT
	@LocalServerPort
	private int port;
	
    @Autowired
    private TestRestTemplate restTemplate;

    @DisplayName("sayHello Rest point Test")    
    @Test
    @Order(1)
    public void getHello() throws Exception {

        ResponseEntity<String> response = restTemplate.getForEntity(
			new URL("http://localhost:" + port + "/hello/name").toString(), String.class);
        assertEquals("Hello name", response.getBody());

    }

}
