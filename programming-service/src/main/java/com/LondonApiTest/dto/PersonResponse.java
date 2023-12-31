package com.LondonApiTest.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PersonResponse {
    @Id
    private String id;
    private String first_name;
    private String last_name;
    private String email;
    private String ip_address;
    private double latitude;
    private double longitude;
}
