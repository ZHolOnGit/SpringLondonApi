package com.LondonApiTest.controller;

import com.LondonApiTest.model.Person;
import com.LondonApiTest.service.LondonService;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;


//Change to web client, the thing of the future, read up about retries?
//Streams? Lambdas?
@RestController
@RequestMapping("api/London")
@RequiredArgsConstructor
public class LondonController {
    //private final String baseApi = "https://london-api.onrender.com/";
    //private final WebClient.Builder webClientBuilder;
    //ObjectMapper objectMapper = new ObjectMapper();
    //private final LondonService londonService;
    @GetMapping
    public ResponseEntity<List<Person>> getAllLondonPeople(){

        List<Person> personList = new ArrayList<>();

      //  List<Person> cityList = mapJsonToPerson(getCity("London"));

      //  List<Person> allPeopleList = mapJsonToPerson(getAllUsers());

      //  personList = londonService.findLondonders(cityList,allPeopleList);

        return new ResponseEntity<>(personList, HttpStatus.OK);
    }

/*    public List<Person> mapJsonToPerson(Mono<String> mono){
        Flux<Person> personFlux = mono.flatMapMany( json -> {
            try {
                return Flux.fromArray(objectMapper.readValue(json,Person[].class));
            } catch (Exception e) {
                return Flux.error(e);
            }
        });
        return personFlux.collectList().block();

    }*/

    //Move these into the service layer, this is a backend function

/*    //These functions are what call the London Api itself, they return the JSON data stored in a Mono<String>
    public Mono<String> getAllUsers(){
        return webClientBuilder.build()
                .get()
                .uri(baseApi + "users")
                .retrieve()
                .bodyToMono(String.class);
    }

    public Mono<String> getCity(String city){
        return webClientBuilder.build()
                .get()
                .uri(baseApi + "city/" + city + "/users" )
                .retrieve()
                .bodyToMono(String.class);
    }*/

}
