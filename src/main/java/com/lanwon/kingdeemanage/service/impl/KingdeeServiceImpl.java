//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.lanwon.kingdeemanage.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.kingdee.bos.webapi.entity.OperatorResult;
import com.kingdee.bos.webapi.entity.RepoError;
import com.kingdee.bos.webapi.entity.RepoResult;
import com.kingdee.bos.webapi.entity.RepoStatus;
import com.kingdee.bos.webapi.entity.SaveResult;
import com.kingdee.bos.webapi.sdk.K3CloudApi;
import com.lanwon.kingdeemanage.service.KingeeService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KingdeeServiceImpl implements KingeeService {
    @Autowired
    K3CloudApi api;

    public KingdeeServiceImpl() {
    }

    public SaveResult save(String formid, String saveParam) throws Exception {
        String resultString = this.api.save(formid, saveParam);
        SaveResult saveResult = (SaveResult)JSON.parseObject(resultString, SaveResult.class);
        if (saveResult == null) {
            ArrayList<RepoError> errors = new ArrayList();
            RepoError repoError = new RepoError();
            repoError.setMessage("调用金蝶云接口失败");
            errors.add(repoError);
            saveResult.getResult().getResponseStatus().setErrors(errors);
            saveResult.getResult().getResponseStatus().setErrorCode("500");
            saveResult.getResult().getResponseStatus().setIsSuccess(false);
        }

        return saveResult;
    }

    public OperatorResult submit(String formid, String operateParam) throws Exception {
        String resultString = this.api.submit(formid, operateParam);
        OperatorResult operatorResult = (OperatorResult)JSON.parseObject(resultString, OperatorResult.class);
        if (operatorResult == null) {
            ArrayList<RepoError> errors = new ArrayList();
            RepoError repoError = new RepoError();
            repoError.setMessage("调用金蝶云接口失败");
            errors.add(repoError);
            operatorResult.getResult().getResponseStatus().setErrors(errors);
            operatorResult.getResult().getResponseStatus().setErrorCode("500");
            operatorResult.getResult().getResponseStatus().setIsSuccess(false);
        }

        return operatorResult;
    }

    public OperatorResult Audit(String formid, String operateParam) throws Exception {
        String resultString = this.api.audit(formid, operateParam);
        OperatorResult operatorResult = (OperatorResult)JSON.parseObject(resultString, OperatorResult.class);
        if (operatorResult == null) {
            ArrayList<RepoError> errors = new ArrayList();
            RepoError repoError = new RepoError();
            repoError.setMessage("调用金蝶云接口失败");
            errors.add(repoError);
            operatorResult.getResult().getResponseStatus().setErrors(errors);
            operatorResult.getResult().getResponseStatus().setErrorCode("500");
            operatorResult.getResult().getResponseStatus().setIsSuccess(false);
        }

        return operatorResult;
    }

    public OperatorResult unAudit(String formid, String operateParam) throws Exception {
        String resultString = this.api.unAudit(formid, operateParam);
        OperatorResult operatorResult = (OperatorResult)JSON.parseObject(resultString, OperatorResult.class);
        if (operatorResult == null) {
            ArrayList<RepoError> errors = new ArrayList();
            RepoError repoError = new RepoError();
            repoError.setMessage("调用金蝶云接口失败");
            errors.add(repoError);
            operatorResult.getResult().getResponseStatus().setErrors(errors);
            operatorResult.getResult().getResponseStatus().setErrorCode("500");
            operatorResult.getResult().getResponseStatus().setIsSuccess(false);
        }

        return operatorResult;
    }

    public Object view(String formid, String operateParam) throws Exception {
        String resultStr = this.api.view(formid, operateParam);
        JSONObject obj = JSON.parseObject(resultStr);
        if (obj.isEmpty()) {
            RepoError repoError = new RepoError();
            repoError.setMessage("调用金蝶云接口失败");
            ArrayList<RepoError> errors = new ArrayList();
            errors.add(repoError);
            RepoStatus repoStatus = new RepoStatus();
            repoStatus.setErrors(errors);
            repoStatus.setErrorCode("500");
            RepoResult repoResult = new RepoResult();
            repoResult.setResponseStatus(repoStatus);
            OperatorResult operatorResult = new OperatorResult();
            operatorResult.setResult(repoResult);
            return operatorResult;
        } else {
            return obj;
        }
    }

    public Object query(String data) throws Exception {
        List<List<Object>> ts = this.api.executeBillQuery(data);
        if (ts.isEmpty()) {
            RepoError repoError = new RepoError();
            repoError.setMessage("没有匹配的数据");
            ArrayList<RepoError> errors = new ArrayList();
            errors.add(repoError);
            RepoStatus repoStatus = new RepoStatus();
            repoStatus.setErrors(errors);
            repoStatus.setErrorCode("500");
            RepoResult repoResult = new RepoResult();
            repoResult.setResponseStatus(repoStatus);
            OperatorResult operatorResult = new OperatorResult();
            operatorResult.setResult(repoResult);
            return operatorResult;
        } else {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("result", ts);
            return jsonObject;
        }
    }
}
