package org.example.jwtvalidator.dto;


import lombok.Data;

@Data
public class UpdateProfile {
    private String firstName;
    private String lastName;
    private String email;
    private String dob;
    private String address;

}
