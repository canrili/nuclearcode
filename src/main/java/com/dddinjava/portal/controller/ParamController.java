package com.dddinjava.portal.controller;

import com.dddinjava.portal.entity.Test;
import com.dddinjava.portal.util.ResponseResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import java.util.Collections;
import java.util.List;

/**
 * @author zhaox
 */
@Slf4j
@RestController
@RequestMapping("/form")
public class ParamController {

    /**
     * request中获取参数
     * @return
     */
    @PostMapping("/request")
    public ResponseEntity requestParam(HttpServletRequest request, String id, String name, Test test) {
        String id0 = request.getParameter("id");
        String name0 = request.getParameter("name");
        log.info("id => {}", id0);
        log.info("name => {}", name0);

        log.info("id => {}", id);
        log.info("name => {}", name);

        log.info("test => {}", test.toString());

        return ResponseEntity.ok().build();
    }


    /**
     * json 数据获取
     * @return
     */
    // @RequestBody Test test 推荐使用对象接受
    // @RequestBody HashMap test
    @PostMapping("/json")
    public ResponseEntity jsonParam(@RequestBody List<Test> test) {
        log.info("test => {}", test.toString());

        return ResponseEntity.ok().build();
    }

    /**
     * url参数
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public ResponseResult urlParam(@PathVariable Long id) {
        log.info("id = {}", id);
        ResponseResult responseResult = new ResponseResult("1", "查询成功", Collections.emptyList());
        return responseResult;
    }
}
