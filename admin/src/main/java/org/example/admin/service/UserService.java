package org.example.admin.service;


import com.baomidou.mybatisplus.extension.service.IService;
import org.example.admin.dao.entity.UserDO;
import org.example.admin.dto.req.UserLoginReqDTO;
import org.example.admin.dto.req.UserRegisterReqDTO;
import org.example.admin.dto.req.UserUpdateReqDTO;
import org.example.admin.dto.res.UserLoginResDTO;
import org.example.admin.dto.res.UserResDTO;
import org.springframework.web.bind.annotation.RequestBody;

// 用户接口层
public interface UserService extends IService<UserDO> {
    /**
     * 根据用户名查询用户信息
     * @param username
     * @return 用户返回实体
     */
    UserResDTO getUserByUsername(String username);

    /**
     * check if username exists
     * @param username
     * @return true if exists
     */
    Boolean availableUserName(String username);

    /**
     * Register User
     * @param requestParam
     */
    void Register(UserRegisterReqDTO requestParam);


    /**
     * Update user using username
     * @param requestParam
     */
    void update(@RequestBody UserUpdateReqDTO requestParam);

    /**
     * User login
     * @param requestParam user login request parameter
     * @return user login response parameter
     */
    UserLoginResDTO  login(UserLoginReqDTO requestParam);

    /**
     * check if user is logged in
     * @param token
     * @return true if logged in
     */
    Boolean checkLogin(String username, String token);
}

