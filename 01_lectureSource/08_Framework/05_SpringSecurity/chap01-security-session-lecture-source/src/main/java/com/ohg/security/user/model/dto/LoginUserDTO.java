package com.ohg.security.user.model.dto;

import com.ohg.security.common.UserRole;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@ToString
public class LoginUserDTO {

    private int userCode;
    private String userId;
    private String userName;
    private String password;
    private UserRole role;

    public int getUserCode() {
        return userCode;
    }

    public void setUserCode(int userCode) {
        this.userCode = userCode;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    /*
     * 다중 권한을 가진 회원이 존재하기 때문에
     * */
    public List<String> getRole() {

        if(this.role.getRole().length() > 0){
            return Arrays.asList(this.role.getRole().split(","));
        }

        return new ArrayList<>();
    }

    public void setRole(UserRole role) {
        this.role = role;
    }
}
