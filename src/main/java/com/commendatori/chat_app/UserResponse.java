package com.commendatori.chat_app;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserResponse {
    Long userId;
    String username;
    String email;
    boolean publiclyVisible;

    public static UserResponse fromUser(User user){

        return UserResponse.builder()
                .userId(user.getUserId())
                .username(user.getUsername())
                .email(user.getEmail())
                .publiclyVisible(user.isPubliclyVisible())
                .build();
    }
}
