package org.example.admin.controller;

// 用户管理控制层

import lombok.RequiredArgsConstructor;
import org.example.admin.common.convention.result.Result;
import org.example.admin.common.convention.result.Results;
import org.example.admin.dto.req.UserRegisterReqDTO;
import org.example.admin.dto.res.UserResDTO;
import org.example.admin.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    /**
     * search user information by username
     * @param username
     * @return
     */
    @GetMapping("/api/short-link/v1/user/{username}")
    public Result<UserResDTO> getUserByUsername(@PathVariable("username") String username) {
        return Results.success(userService.getUserByUsername(username));
    }

    @GetMapping("/api/short-link/v1/user/available-username")
    public Result<Boolean> availableUserName(@RequestParam("username") String username) {
        return Results.success(!userService.availableUserName(username));
    }

    /**
     * register user
     * @param requestParam
     * @return
     */
    @PostMapping("/api/short-link/v1/user")
    public Result<Void> register(@RequestBody UserRegisterReqDTO requestParam) {
        userService.Register(requestParam);
        return Results.success();
    }
}
