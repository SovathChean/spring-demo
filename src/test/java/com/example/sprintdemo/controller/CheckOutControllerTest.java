package com.example.sprintdemo.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

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
import com.example.sprintdemo.dto.CheckOutDto;
import com.example.sprintdemo.dto.CheckOutProductsDto;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SprintDemoApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CheckOutControllerTest {
    private static final String BASIC_URL = "http://localhost:%s/checkout";

    private static final Integer ID = 1;

    private CheckOutProductsDto ckProduct = new CheckOutProductsDto();
    private static final Integer ProductQty = 100;
    private static final Integer ProductId = 1;
    private static final Integer UserId = 2;
    private static final Integer ProductBeforeDeductQty = 200;
    private static final Integer ProductAfterDeductQty = 100;
    

    
    @Autowired
    private TestRestTemplate testRestTemplate;

    @LocalServerPort
    private int port;
    
    @Test
    public void should_save_checkout() {
        //Given
        String url = String.format(BASIC_URL, port);
        System.out.println(url);
        CheckOutDto createRequest = givenCreateRequest();
        HttpEntity<CheckOutDto> request = HttpHelper.getHttpEntity(createRequest);
        //When
        ResponseEntity<CheckOutDto> response = testRestTemplate.exchange(url, HttpMethod.POST, request, CheckOutDto.class);
        //Then
        System.out.println(response);
        assertEquals(response.getStatusCode(), HttpStatus.OK);
        assertNotNull(response.getBody());
        assertEquals(response.getBody().getUserId(), UserId);
        List<CheckOutProductsDto> responseProduct = response.getBody().getProducts();
        responseProduct.forEach(product -> {
        	Integer afterDeduct = ProductBeforeDeductQty - product.getQty();
            assertEquals(product.getProductId(), ProductId);
            assertEquals(product.getQty(), ProductQty);
           
            assertEquals(afterDeduct, ProductAfterDeductQty);
        });
    }

    private CheckOutDto givenCreateRequest() {
    	CheckOutDto createRequest = new CheckOutDto();
    	List<CheckOutProductsDto> ckDtoList = new ArrayList<>();
    	createRequest.setUserId(UserId);
        ckDtoList.forEach(product -> {
        	product.setProductId(ProductId);
        	product.setQty(ProductQty);
        	product.setProductId(ProductId);
        });
        return createRequest;

	}


}
