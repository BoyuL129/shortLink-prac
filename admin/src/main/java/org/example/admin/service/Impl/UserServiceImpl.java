package org.example.admin.service.Impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.RequiredArgsConstructor;
import org.example.admin.common.convention.exception.ClientException;
import org.example.admin.common.enums.UserErrorCodeEnum;
import org.example.admin.dao.entity.UserDO;
import org.example.admin.dao.mapper.UserMapper;
import org.example.admin.dto.req.UserRegisterReqDTO;
import org.example.admin.dto.res.UserResDTO;
import org.example.admin.service.UserService;
import org.redisson.api.RBloomFilter;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

// 用户接口实现层
@Service
@RequiredArgsConstructor
public class UserServiceImpl extends ServiceImpl<UserMapper, UserDO> implements UserService {

    private final RBloomFilter<String> userRegisterCachePenetrationBloomFilter;
    @Override
    public UserResDTO getUserByUsername(String username) {
        LambdaQueryWrapper<UserDO> queryWrapper = Wrappers.lambdaQuery(UserDO.class)
                .eq(UserDO::getUsername, username);
        UserDO userDO = baseMapper.selectOne(queryWrapper);
        UserResDTO result = new UserResDTO();
        if(userDO != null){
            BeanUtils.copyProperties(userDO, result);
            return result;
        } else {
            throw new ClientException(UserErrorCodeEnum.USER_NULL);
        }
    }

    @Override
    public Boolean availableUserName(String username) {
        return !userRegisterCachePenetrationBloomFilter.contains(username);
    }



    @Override
    public void Register(UserRegisterReqDTO requestParam) {
        if (!availableUserName(requestParam.getUsername())) {
            throw new ClientException(UserErrorCodeEnum.USER_NAME_EXIST);
        }
        int inserted = baseMapper.insert(BeanUtil.toBean(requestParam, UserDO.class));
        if (inserted < 1) {
            throw new ClientException(UserErrorCodeEnum.USER_SAVE_ERROR);
        }
        userRegisterCachePenetrationBloomFilter.add(requestParam.getUsername());
    }
}
