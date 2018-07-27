package com.chadrc.training;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import static org.junit.Assert.assertEquals;

@SpringBootTest
public class HomeControllerTests {

    @Autowired
    private HomeController homeController = new HomeController();

    @Test
    public void okStatus() {
        ResponseEntity<StatusResponse> responseEntity = homeController.root();
        assertEquals("OK", responseEntity.getBody().getStatus());
    }
}
