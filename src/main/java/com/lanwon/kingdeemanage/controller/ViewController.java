//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.lanwon.kingdeemanage.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.lanwon.kingdeemanage.service.KingeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ViewController {
    @Autowired
    KingeeService kingeeService;

    public ViewController() {
    }

    @PostMapping({"View"})
    public Object View(@RequestBody String paramStr) throws Exception {
        JSONObject paramJson = JSON.parseObject(paramStr);
        String formid = (String)paramJson.get("fromid");
        String data = paramJson.get("data").toString();

        Object resultStr = this.kingeeService.view(formid, data);
        return resultStr;
    }
}
