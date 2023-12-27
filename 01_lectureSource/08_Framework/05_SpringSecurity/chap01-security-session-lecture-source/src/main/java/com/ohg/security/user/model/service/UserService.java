package com.ohg.security.user.model.service;

import com.ohg.security.auth.model.dto.AuthDetails;

public interface UserService {

    AuthDetails findByUserId(String username);
}
