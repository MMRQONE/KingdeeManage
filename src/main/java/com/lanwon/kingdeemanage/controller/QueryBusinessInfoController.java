package com.lanwon.kingdeemanage.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.kingdee.bos.webapi.entity.RepoRet;
import com.kingdee.bos.webapi.sdk.K3CloudApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QueryBusinessInfoController {
    @Autowired
    K3CloudApi api;

    public QueryBusinessInfoController() {
    }

    @GetMapping({"QueryBusinessInfo"})
    public JSONObject QueryBusinessInfo(@RequestParam("formid") String formid) throws Exception {
        String aaa = "{ \"FormId\": \"" + formid + "\" }";
        String resultString = this.api.queryBusinessInfo(aaa);
        RepoRet repoRet = (RepoRet)JSON.parseObject(resultString, RepoRet.class);
        JSONObject obj = JSON.parseObject(resultString);
        return repoRet.getResult().getResponseStatus().isIsSuccess() ? obj : obj;
    }
}
