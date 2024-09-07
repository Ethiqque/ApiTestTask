package org.ethiqque.apitesttask.validator;

import org.ethiqque.apitesttask.dto.UserInputDto;
import org.springframework.stereotype.Component;

@Component
public class UserValidator {

    public void validate(UserInputDto dto) {
        if(dto.getFirstName() != null){validateFirstName(dto.getFirstName());}
        if(dto.getLastName() != null){validateLastName(dto.getLastName());}
        if(dto.getBirthDate() != null){validateBirthDate(dto.getBirthDate());}
        if(dto.getBirthPlace() != null){validateBirthPlace(dto.getBirthPlace());}
        if(dto.getSex() != null){validateSex(dto.getSex());}
        if(dto.getCurrentAddress() != null){validateCurrentAddress(dto.getCurrentAddress());}
    }

    private void validateFirstName(String firstName) {

    }

    private void validateLastName(String lastName) {

    }

    private void validateBirthDate(String birthDate) {

    }

    private void validateBirthPlace(String birthPlace) {

    }

    private void validateSex(String sex) {

    }

    private void validateCurrentAddress(String currentAddress) {

    }
}
