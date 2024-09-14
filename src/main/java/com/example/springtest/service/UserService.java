package com.example.springtest.service;

import com.example.springtest.common.Constants;
import com.example.springtest.dto.UserFormDTO;
import com.example.springtest.exception.ResourceNotFoundException;
import com.example.springtest.feignclient.ThirdPartyServiceClient;
import com.example.springtest.model.User;
import com.example.springtest.dto.UserRequest;
import com.example.springtest.respository.APIConfigRepository;
import com.example.springtest.respository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ThirdPartyServiceClient thirdPartyServiceClient;

    @Autowired
    private APIConfigRepository apiConfigRepository;

    public Map<String, Boolean> getMissingFields(Long userId) {

        Optional<User> userOptional = userRepository.findById(userId);
        Map<String, Boolean> missingFields = new HashMap<>();

        if (userOptional.isPresent()) {
            User user = userOptional.get();
            missingFields.put(Constants.FIRST_NAME, user.getFirstName() == null || user.getFirstName().isEmpty());
            missingFields.put(Constants.LAST_NAME, user.getLastName() == null || user.getLastName().isEmpty());
            missingFields.put(Constants.BIRTHDATE, user.getBirthdate() == null || user.getBirthdate().isEmpty());
            missingFields.put(Constants.BIRTHPLACE, user.getBirthplace() == null || user.getBirthplace().isEmpty());
            missingFields.put(Constants.SEX, user.getSex() == null || user.getSex().isEmpty());
            missingFields.put(Constants.CURRENT_ADDRESS, user.getCurrentAddress() == null || user.getCurrentAddress().isEmpty());
        } else {
            throw new ResourceNotFoundException("User not found with id: " + userId);
        }

        return missingFields;
    }


    public void updateUserDetails(Long userId, UserFormDTO userFormData) {
        Optional<User> userOptional = userRepository.findById(userId);

        if (userOptional.isPresent()) {
            User user = userOptional.get();
            if (userFormData.getBirthdate() != null || !userFormData.getBirthdate().isEmpty()) {
                user.setBirthdate(userFormData.getBirthdate());
            }
            if (userFormData.getBirthplace() != null || !userFormData.getBirthplace().isEmpty()) {
                user.setBirthplace(userFormData.getBirthplace());
            }
            if (userFormData.getSex() != null || !userFormData.getSex().isEmpty()) {
                user.setSex(userFormData.getSex());
            }
            if (userFormData.getCurrentAddress() != null || !userFormData.getCurrentAddress().isEmpty()) {
                user.setCurrentAddress(userFormData.getCurrentAddress());
            }

            userRepository.save(user);
        } else {
            throw new ResourceNotFoundException("User not found with id: " + userId);
        }
    }

    public void callThirdPartyService(UserFormDTO userFormDTO) {

        String apiURL = apiConfigRepository.findTopByOrderByIdDesc()
                .orElseThrow(() -> new ResourceNotFoundException("API URL not found")).getServiceURL();

        UserRequest userRequest = new UserRequest(userFormDTO.getFirstName(), userFormDTO.getLastName(), userFormDTO.getBirthdate()
        , userFormDTO.getBirthplace(), userFormDTO.getSex(), userFormDTO.getCurrentAddress());

        thirdPartyServiceClient.submitToThirdParty(apiURL, userRequest);
    }
}
