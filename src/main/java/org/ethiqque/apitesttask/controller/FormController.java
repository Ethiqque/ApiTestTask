package org.ethiqque.apitesttask.controller;

import lombok.RequiredArgsConstructor;
import org.ethiqque.apitesttask.dto.RequiredFieldsResponseDto;
import org.ethiqque.apitesttask.dto.UserInputDto;
import org.ethiqque.apitesttask.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/form")
@RequiredArgsConstructor
public class FormController {

    private final UserService userService;

    @GetMapping("/required-fields/{userId}")
    public ResponseEntity<RequiredFieldsResponseDto> getRequiredFields(@PathVariable Long userId) {
        RequiredFieldsResponseDto responseDto = userService.getRequiredFields(userId);
        return ResponseEntity.ok(responseDto);
    }

    @PostMapping("/submit/{userId}")
    public ResponseEntity<?> submitForm(@PathVariable Long userId, @RequestBody UserInputDto userInputDto) {
        userService.processFormSubmission(userId, userInputDto);
        return ResponseEntity.ok(Map.of("status", "Submitted successfully"));
    }
}
