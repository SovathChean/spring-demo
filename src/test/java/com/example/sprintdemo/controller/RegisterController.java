package com.example.sprintdemo.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.sprintdemo.SprintDemoApplication;
import com.example.sprintdemo.controller.helper.HttpHelper;
import com.example.sprintdemo.dto.ProductDto;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SprintDemoApplication.class, webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class RegisterController {
    private static final String BASIC_URL = "http://localhost:%s/products";

    private static final Integer ID = 1;

    private static final String ProductName = "ProductName";
    private static final String ProductCode = "ProductCode";
    private static final Integer ProductQty = 100;
    private static final Integer ProductCreatedBy = 1;

    
    @Autowired
    private TestRestTemplate testRestTemplate;

    @LocalServerPort
    private int port;
    
    @Test
    public void should_save_product() {
        //Given
        String url = String.format(BASIC_URL, port);
        System.out.println(url);
        ProductDto createRequest = givenCreateRequest();
        HttpEntity<ProductDto> request = HttpHelper.getHttpEntity(createRequest);
        //When
        ResponseEntity<ProductDto> response = testRestTemplate.exchange(url, HttpMethod.POST, request, ProductDto.class);
        //Then
        System.out.println(response);
        assertEquals(response.getStatusCode(), HttpStatus.OK);
        assertNotNull(response.getBody());
        assertEquals(response.getBody().getProductName(), ProductName);
        assertEquals(response.getBody().getProductCode(), ProductCode);
        assertEquals(response.getBody().getQty(), ProductQty);
        assertEquals(response.getBody().getCreatedBy(), ProductCreatedBy);
    }

    private ProductDto givenCreateRequest() {
		ProductDto createRequest = new ProductDto();
        createRequest.setProductCode(ProductCode);
        createRequest.setProductName(ProductCode);
        createRequest.setQty(ProductQty);
        createRequest.setCreatedBy(ProductCreatedBy);
        return createRequest;

	}
	@Test
    public void should_update_product() {
        //Given
        String url = String.format(BASIC_URL, port);
        System.out.println(url);
        ProductDto createRequest = givenCreateRequest();
        HttpEntity<ProductDto> request = HttpHelper.getHttpEntity(createRequest);
        //When
        ResponseEntity<ProductDto> response = testRestTemplate.exchange(url, HttpMethod.POST, request, ProductDto.class);
        //Then
        System.out.println(response.getStatusCode());
        assertEquals(response.getStatusCode(), HttpStatus.OK);
        assertNotNull(response.getBody());
        assertEquals(ID, response.getBody().getId());
    }
}
