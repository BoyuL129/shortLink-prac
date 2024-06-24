package org.example.admin.service;


import com.baomidou.mybatisplus.extension.service.IService;
import org.example.admin.dao.entity.UserDO;
import org.example.admin.dto.req.UserRegisterReqDTO;
import org.example.admin.dto.res.UserResDTO;

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

}

