package com.nomad.app.controller;

import com.nomad.app.model.Reply;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@RestController
@Api("This is The Information API Documentation")
public class InformationController {
    private static final Logger logger = LoggerFactory.getLogger(InformationController.class);

    @GetMapping("/hello-swagger")
    @ApiOperation("Return String hello swagger")
    public String helloSwagger() {
        return "hello swagger";
    }

    @GetMapping(value = "/info")
    @ApiOperation("Return app-info swagger")
    public Reply<Map<String, Object>> showInfo(HttpServletResponse response, @RequestParam("test") String test) {
        response.setStatus(200);
        Map<String, Object> info = new HashMap<>();
        info.put("app", "swagger");
        info.put("package", this.getClass().getPackage().getName());
        info.put("test-string", test);
        return Reply.ok(info);
    }
}
