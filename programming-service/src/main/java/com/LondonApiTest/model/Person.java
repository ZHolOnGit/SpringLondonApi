package com.LondonApiTest.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Person {
    @JsonProperty(value="id")
    private String id;
    @JsonProperty(value="first_name")
    private String firstNane;
    @JsonProperty(value="last_name")
    private String lastName;
    @JsonProperty(value="email")
    private String email;
    @JsonProperty(value="ip_address")
    private String ipAddress;
    @JsonProperty(value="latitude")
    private double latitude;
    @JsonProperty(value="longitude")
    private double longitude;
}
