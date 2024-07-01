package org.example.project.controller;

import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson2.JSON;
import org.example.project.common.convention.result.Result;
import org.example.project.common.convention.result.Results;
import org.example.project.dto.req.ShortLinkCreateReqDTO;
import org.example.project.dto.res.ShortLinkCreateResDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShortLinkController {

    /**
     * 创建短链接
     */
    @PostMapping("/api/short-link/admin/v1/create")
    public Result<ShortLinkCreateResDTO> createShortLink(@RequestBody ShortLinkCreateReqDTO requestParam) {
        HttpRequest httpRequest = HttpUtil.createPost("http://127.0.0.1:8001/api/short-link/v1/create").body(JSON.toJSONString(requestParam));
        HttpResponse execute = httpRequest.execute();
        return Results.success(JSON.parseObject(execute.body(), ShortLinkCreateResDTO.class));
    }

//    /**
//     * 分页查询短链接
//     */
//    @GetMapping("/api/short-link/admin/v1/page")
//    public Result<IPage<ShortLinkPageResDTO>> pageShortLink(ShortLinkPageReqDTO requestParam) {
//        Map<String, Object> requestMap = new HashMap<>();
//        requestMap.put("gid", requestParam.getGid());
//        requestMap.put("current", requestParam.getCurrent());
//        requestMap.put("size", requestParam.getSize());
//        String actualUrl = HttpUtil.get("http://127.0.0.1:8001/api/short-link/v1/page", requestMap);
//        Type type = new TypeReference<Result<IPage<ShortLinkPageRespDTO>>>() {
//        }.getType();
//        return JSON.parseObject(actualUrl, type);
//    }
}

///**
// * 有效期
// */
//@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
//private Date validDate;
//
///**
// * 有效期
// */
//@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
//private Date createTime;

