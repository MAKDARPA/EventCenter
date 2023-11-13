package com.events.center.events_center.dto.beans;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class UserBean {
    private Integer userId;
    private String username;
    private String password;
    private String role;

    private String code;
    private String message;

    private List<EventBean> eventBeans;

    public UserBean(Integer userId, String username, String password, String role) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.role = role;
    }
}
