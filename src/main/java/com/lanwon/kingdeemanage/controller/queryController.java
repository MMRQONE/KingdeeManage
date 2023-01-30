//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.lanwon.kingdeemanage.controller;

import com.lanwon.kingdeemanage.service.KingeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class queryController {
    @Autowired
    KingeeService kingeeService;

    public queryController() {
    }

    @PostMapping({"query"})
    public Object query(@RequestBody String data) throws Exception {
        System.out.println(data);
        Object resultStr = this.kingeeService.query(data);
        System.out.println(resultStr.toString());
        return resultStr;
    }
}
