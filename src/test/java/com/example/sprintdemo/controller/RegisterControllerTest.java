package com.example.sprintdemo.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.time.LocalDateTime;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.sprintdemo.SprintDemoApplication;
import com.example.sprintdemo.controller.helper.HttpHelper;
import com.example.sprintdemo.dto.UserDto;
import com.example.sprintdemo.model.GenderEnum;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = SprintDemoApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class RegisterControllerTest{
    private static final String BASIC_URL = "http://localhost:%s/register";

    private static final String Username = "ProductName";
    private static final GenderEnum Gender = GenderEnum.Male;
    private static final Integer CreateBy = 1;

    
    @Autowired
    private TestRestTemplate testRestTemplate;

    @LocalServerPort
    private int port;
    
    @Test
    public void should_register() {
        //Given
        String url = String.format(BASIC_URL, port);
        System.out.println(url);
        UserDto createRequest = givenCreateRequest();
        HttpEntity<UserDto> request = HttpHelper.getHttpEntity(createRequest);
        //When
        ResponseEntity<UserDto> response = testRestTemplate.exchange(url, HttpMethod.POST, request, UserDto.class);
        //Then
        System.out.println(response);
        assertEquals(response.getStatusCode(), HttpStatus.OK);
        assertNotNull(response.getBody());
        assertEquals(response.getBody().getUsername(), Username);
        assertEquals(response.getBody().getGender(), Gender);
        assertEquals(response.getBody().getCreatedBy(), CreateBy);
    }

    private UserDto givenCreateRequest() {
    	UserDto createRequest = new UserDto();
        createRequest.setUsername(Username);
        createRequest.setGender(Gender);
        createRequest.setCreatedBy(CreateBy);
        return createRequest;

	}

}
