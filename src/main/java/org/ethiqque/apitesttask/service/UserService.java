package org.ethiqque.apitesttask.service;

import org.ethiqque.apitesttask.dto.RequiredFieldsResponseDto;
import org.ethiqque.apitesttask.dto.UserInputDto;

public interface UserService {

    RequiredFieldsResponseDto getRequiredFields(Long userId);

    void processFormSubmission(Long userId, UserInputDto userInputDto);
}
