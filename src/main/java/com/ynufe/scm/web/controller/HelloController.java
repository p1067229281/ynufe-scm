package com.ynufe.scm.web.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <pre>
 *     测试Swagger能否使用
 * </pre>
 * @author william
 * @date 2018/05/17
 *
 */
@Api(value = "测试Swagger文档能否使用")
@RestController
@Slf4j
@RequestMapping("/test")
public class HelloController {

    @GetMapping("/swagger2")
    @ApiOperation(value="根据用户编号获取用户姓名",notes = "test: 仅1和2有正确返回")
    public String test(){
        log.info("slf4j测试");
        return "swagger test success";
    }
}
