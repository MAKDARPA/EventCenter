package com.events.center.events_center.dto.beans;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class UserBean {
    private Integer userId;
    private String userName;
    private String email;
    private String password;
    private String role;
    private Integer status;

//    private List<EventBean> eventBeans;

    public UserBean(Integer userId, String userName, String email, String password, String role, Integer status) {
        this.userId = userId;
        this.userName = userName;
        this.email= email;
        this.password = password;
        this.role = role;
        this.status = status;

    }
}
