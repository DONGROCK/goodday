package com.ohg.security.user.model.dao;

import com.ohg.security.user.model.dto.LoginUserDTO;
import com.ohg.security.user.model.dto.SingUpDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

LoginUserDTO findByUsername(String username);

int regist(SingUpDTO singUpDTO);
}
