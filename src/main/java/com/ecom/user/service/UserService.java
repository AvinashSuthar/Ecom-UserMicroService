package com.ecom.user.service;

import com.ecom.user.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {

    List<User> getUsers();
}
