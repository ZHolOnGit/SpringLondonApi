package com.LondonApiTest.service;


import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.LondonApiTest.model.Person;
import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.web.reactive.function.client.WebClient;

public class LondonServiceTest {

  private final LondonService londonService = new LondonService();

  private WireMockServer wireMockServer;

  @BeforeEach
  public void setup(){
    wireMockServer = new WireMockServer(8080);
    wireMockServer.start();
    WireMock.configureFor("localhost", wireMockServer.port());
  }

  @AfterEach
  public void shutDown(){
    wireMockServer.stop();
  }
  @Test
  @DisplayName("Service test to test if user who is listed in London and within radius will be added twice")
  public void testDuplicate(){

    WireMock.stubFor(WireMock.get(WireMock.urlEqualTo("https://london-api.onrender.com/users"))
        .willReturn(aResponse()
            .withBodyFile("resources/testdata/within50.json")));

    WireMock.stubFor(WireMock.get(WireMock.urlEqualTo("https://london-api.onrender.com/city/London/users"))
        .willReturn(aResponse()
            .withBodyFile("resources/testdata/inLondon.json")));

    String user = londonService.webClient.get()
        .uri("/users")
        .retrieve()
        .bodyToMono(String.class)
        .block();

    System.out.println(user);

    //List<Person> londoners = londonService.findLondonders();

    //System.out.println(londoners);

    //assertEquals(2,londoners.size());

    assertNotNull(user);



//    List<Person> personList = new ArrayList<>();
//    //Can pull this person from JSON???
//    personList.add(new Person("1","John","Doe","email.email","123.123.234",51.7134,-0.9887));
//    Mockito.when(londonService.mapJsonToPerson(londonService.getCity("London"))).thenReturn(personList);
//    Mockito.when(londonService.mapJsonToPerson(londonService.getAllUsers())).thenReturn(personList);
//
//    List<Person> londoners = londonService.findLondonders();
//
//
//    assertNotNull(londoners);
//    assertEquals(1,londoners.size());


  }



  //This will be the biggest test class, needs to mock out datasets using wiremock for the web client???

  //Test for 1 from city and 0 from all users and vise versa

  //Test for duplicates from city and all user list

}
