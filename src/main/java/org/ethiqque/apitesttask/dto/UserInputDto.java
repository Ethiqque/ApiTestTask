package org.ethiqque.apitesttask.dto;

import lombok.Data;

@Data
public class UserInputDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String birthDate;
    private String birthPlace;
    private String sex;
    private String currentAddress;
}
