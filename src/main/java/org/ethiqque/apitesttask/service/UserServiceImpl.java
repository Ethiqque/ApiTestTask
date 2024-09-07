package org.ethiqque.apitesttask.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.ethiqque.apitesttask.client.ThirdPartyServiceClient;
import org.ethiqque.apitesttask.dto.RequiredFieldsResponseDto;
import org.ethiqque.apitesttask.dto.UserInputDto;
import org.ethiqque.apitesttask.entity.User;
import org.ethiqque.apitesttask.entity.APIUrl;
import org.ethiqque.apitesttask.exception.NotFoundException;
import org.ethiqque.apitesttask.mapper.UserMapper;
import org.ethiqque.apitesttask.repository.APIUrlRepository;
import org.ethiqque.apitesttask.repository.UserRepository;
import org.ethiqque.apitesttask.validator.UserValidator;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import feign.Feign;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final APIUrlRepository apiUrlRepository;
    private final UserMapper userMapper;
    private final UserValidator userValidator;

    @Value("${api.name.OUR_API_NAME}")
    private String apiName;

    @Override
    @Transactional
    public RequiredFieldsResponseDto getRequiredFields(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new NotFoundException("User not found"));

        List<String> missingFields = getMissingFields(user);

        return new RequiredFieldsResponseDto(missingFields);
    }

    @Override
    @Transactional
    public void processFormSubmission(Long userId, UserInputDto userInputDto) {
        userValidator.validate(userInputDto);

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new NotFoundException("User not found"));

        userMapper.updateUserFields(user, userInputDto);

        userRepository.save(user);

        APIUrl apiUrlEntity = apiUrlRepository.findByName(apiName);
        if (apiUrlEntity == null) {
            throw new NotFoundException("API URL not found for the given name");
        }
        String apiUrl = apiUrlEntity.getUrl();

        ThirdPartyServiceClient dynamicClient = Feign.builder()
                .target(ThirdPartyServiceClient.class, apiUrl);

        dynamicClient.submitUserDetails(user);
    }

    private List<String> getMissingFields(User user) {
        return List.of();
    }
}
