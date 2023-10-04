package com.LondonApiTest.service;

import com.LondonApiTest.Utility.DistanceUtil;
import com.LondonApiTest.model.Person;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

//Assumed that "London" is traf square (which is considered the center of london for cartographic uses
@Service
@RequiredArgsConstructor
public class LondonService {
    private static final int radius = 50;
    private static final double[] centerCoordsRads = {Math.toRadians(51.5080),Math.toRadians(-0.1281)};//[0]lat, [1]long
    public final WebClient webClient = WebClient.builder().build();
    private final ObjectMapper objectMapper = new ObjectMapper();

    //Can test these by passing in mock data
    public List<Person> findLondonders(){

      List<Person> allPeople = mapJsonToPerson(getAllUsers());
      List<Person>  listedInCity = mapJsonToPerson(getCity("London"));

      List<Person> filteredPeopleList = allPeople.stream().filter(person ->
          DistanceUtil.withinRadius(person.getLatitude(), person.getLongitude(),radius,centerCoordsRads)).toList();

      List<Person> londoners = new ArrayList<>();

      londoners.addAll(filteredPeopleList);
      londoners.addAll(listedInCity);

      return londoners;
    }

    private List<Person> mapJsonToPerson(Mono<String> mono){
        Flux<Person> personFlux = mono.flatMapMany( json -> {
            try {
                return Flux.fromArray(objectMapper.readValue(json,Person[].class));
            } catch (Exception e) {
                return Flux.error(e);
            }
        });
        return personFlux.collectList().block();
    }
    //These functions are what call the London Api itself, they return the JSON data stored in a Mono<String>
    private Mono<String> getAllUsers(){
        return webClient.get()
            .uri("/users")
            .retrieve()
            .bodyToMono(String.class);
    }
    private Mono<String> getCity(String city){
      return webClient.get()
          .uri("/city/" + city + "/users")
          .retrieve()
          .bodyToMono(String.class);
    }
}
