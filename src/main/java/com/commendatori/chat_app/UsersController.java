package com.commendatori.chat_app;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UsersController {

 final UserRepository userRepository;

 public UsersController(UserRepository userRepository) {
  this.userRepository = userRepository;
 }


 @PostMapping("/register")
 public UserResponse register(@RequestBody UserRegistrationForm userRegistrationForm){

  User user = User.builder()
          .username(userRegistrationForm.username())
          .email(userRegistrationForm.email())
          .publiclyVisible(userRegistrationForm.publiclyVisible())
          .password(userRegistrationForm.password())
          .build();

  User persistedUser = userRepository.save(user);

  return UserResponse.fromUser(persistedUser);

 }

}
