package com.LondonApiTest.service;


import com.LondonApiTest.Utility.DistanceUtil;
import com.LondonApiTest.model.Person;
import java.util.ArrayList;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

//Assumed that "London" is traf square (which is considered the center of london for cartographic uses


@Service
@RequiredArgsConstructor
@Slf4j
public class LondonService {
    private static final int radius = 50;

    private static final double[] centerCoordsRads = {Math.toRadians(51.5080),Math.toRadians(-0.1281)};//[0]lat, [1]long

    private DistanceUtil distanceUtil;

    //Can test these by passing in mock data
    public List<Person> findLondonders(List<Person> listedInCity, List<Person> allPeople){

        List<Person> filteredPeopleList = allPeople.stream().filter(person ->
            distanceUtil.withinRadius(person.getLatitude(), person.getLongitude(),radius,centerCoordsRads)).toList();

      List<Person> londoners = new ArrayList<>();

      londoners.addAll(filteredPeopleList);
      londoners.addAll(listedInCity);

      return londoners;
    }

}
