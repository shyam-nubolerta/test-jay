package com.example.springtest.controller;

import com.example.springtest.dto.UserFormDTO;
import com.example.springtest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/missing-fields/{userId}")
    public ResponseEntity<Map<String, Boolean>> getMissingFields(@PathVariable Long userId) {
        return ResponseEntity.of(Optional.ofNullable(userService.getMissingFields(userId)));
    }

    @PostMapping("/submit/{userId}")
    public ResponseEntity<String> submit(@PathVariable Long userId, @RequestBody UserFormDTO userFormData) {

        userService.updateUserDetails(userId, userFormData);
        userService.callThirdPartyService(userFormData);

        return ResponseEntity.ok("Form submitted successfully");
    }
}
