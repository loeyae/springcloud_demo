package com.loeyae.cloud.service.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Hellow Api
 *
 * @author ZhangYi<loeyae @ gmail.com>
 * @version 1.0
 * @date 2020/4/24 17:58
 */
public interface HellowApi {

    @GetMapping(path = "/hellow")
    JSONObject hellow();

    @PostMapping(path = "hellow")
    JSONObject hellow(@RequestBody JSONObject param);
}
