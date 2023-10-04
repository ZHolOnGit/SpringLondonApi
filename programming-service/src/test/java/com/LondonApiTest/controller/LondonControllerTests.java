package com.LondonApiTest.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.LondonApiTest.model.Person;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class LondonControllerTests {

  //Can only really do this one test and test for a list with more than 0 users
  //Mocks the service call, mock returns List<Person>, use the when()

  LondonController londonController;
//  @Test
//  @DisplayName("Controller method returns 200 with an empty list of Person")
//  public void testSuccessResponse() {
//    ArrayList peopleList = new ArrayList();
//
//    when(londonController.getAllLondonPeople()).thenReturn();
//
//    ResponseEntity<List<Person>> actualResult = londonController.getAllLondonPeople();
//
//    assertNotNull(actualResult);
//    assertEquals(HttpStatus.OK,actualResult.getStatusCode());
//    assertNotNull(actualResult.getBody());
//    assertEquals(0,actualResult.getBody().size());
//  }
}
