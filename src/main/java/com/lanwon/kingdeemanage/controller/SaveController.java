//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.lanwon.kingdeemanage.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.kingdee.bos.webapi.entity.OperateParam;
import com.kingdee.bos.webapi.entity.OperatorResult;
import com.kingdee.bos.webapi.entity.SaveParam;
import com.kingdee.bos.webapi.entity.SaveResult;
import com.lanwon.kingdeemanage.service.KingeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SaveController {
    @Autowired
    KingeeService kingeeService;

    public SaveController() {
    }

    @PostMapping({"save"})
    public SaveResult Save(@RequestBody String ParamStr) throws Exception {
        JSONObject Param = JSON.parseObject(ParamStr);
        String formid = (String)Param.get("fromid");
        JSONObject model = (JSONObject)Param.get("Model");
        SaveParam<JSONObject> param = new SaveParam(model);
        SaveResult saveResult = this.kingeeService.save(formid, JSON.toJSONString(param, true));
        return saveResult;
    }

    @PostMapping({"SaveAndAudit"})
    public Object SaveAndAudit(@RequestBody String ParamStr) throws Exception {
        JSONObject Param = JSON.parseObject(ParamStr);
        String formid = (String)Param.get("fromid");
        JSONObject model = (JSONObject)Param.get("Model");
        SaveParam<JSONObject> param = new SaveParam(model);
        String Key = (String)Param.get("Key");
        String fEntryID = (String)model.get(Key);
        boolean unAuditisSuccess;
        if (fEntryID.isEmpty()) {
            SaveResult saveResult = this.kingeeService.save(formid, JSON.toJSONString(param, true));
            String id = saveResult.getResult().getId();
            unAuditisSuccess = saveResult.getResult().getResponseStatus().isIsSuccess();
            if (unAuditisSuccess) {
                OperateParam operateParam = new OperateParam();
                operateParam.setIds(id);
                OperatorResult submitoperatorResult = this.kingeeService.submit(formid, JSON.toJSONString(operateParam, true));
                boolean submitIsSuccess = submitoperatorResult.getResult().getResponseStatus().isIsSuccess();
                if (submitIsSuccess) {
                    OperatorResult auditoperatorResult = this.kingeeService.Audit(formid, JSON.toJSONString(operateParam, true));
                    return auditoperatorResult;
                } else {
                    return submitoperatorResult;
                }
            } else {
                return saveResult;
            }
        } else {
            OperateParam operateParam = new OperateParam();
            operateParam.setIds(fEntryID);
            OperatorResult unAuditoperatorResult = this.kingeeService.unAudit(formid, JSON.toJSONString(operateParam, true));
            unAuditisSuccess = unAuditoperatorResult.getResult().getResponseStatus().isIsSuccess();
            if (unAuditisSuccess) {
                SaveResult saveResult = this.kingeeService.save(formid, JSON.toJSONString(param, true));
                boolean saveisSuccess = saveResult.getResult().getResponseStatus().isIsSuccess();
                if (saveisSuccess) {
                    OperatorResult submitoperatorResult = this.kingeeService.submit(formid, JSON.toJSONString(operateParam, true));
                    boolean submitIsSuccess = submitoperatorResult.getResult().getResponseStatus().isIsSuccess();
                    if (submitIsSuccess) {
                        OperatorResult auditoperatorResult = this.kingeeService.Audit(formid, JSON.toJSONString(operateParam, true));
                        return auditoperatorResult;
                    } else {
                        return submitoperatorResult;
                    }
                } else {
                    return saveResult;
                }
            } else {
                return unAuditoperatorResult;
            }
        }
    }

    @PostMapping({"SaveAndAudit2"})
    public Object SaveAndAudit2(@RequestBody String ParamStr) throws Exception {
        JSONObject Param = JSON.parseObject(ParamStr);
        String formid = (String)Param.get("fromid");
        JSONObject model = (JSONObject)Param.get("Model");
        SaveParam<JSONObject> param = new SaveParam(model);
        SaveResult saveResult = this.kingeeService.save(formid, JSON.toJSONString(param, true));
        String id = saveResult.getResult().getId();
        boolean saveisSuccess = saveResult.getResult().getResponseStatus().isIsSuccess();
        if (saveisSuccess) {
            OperateParam operateParam = new OperateParam();
            operateParam.setIds(id);
            OperatorResult submitoperatorResult = this.kingeeService.submit(formid, JSON.toJSONString(operateParam, true));
            boolean submitIsSuccess = submitoperatorResult.getResult().getResponseStatus().isIsSuccess();
            if (submitIsSuccess) {
                OperatorResult auditoperatorResult = this.kingeeService.Audit(formid, JSON.toJSONString(operateParam, true));
                return auditoperatorResult;
            } else {
                return submitoperatorResult;
            }
        } else {
            return saveResult;
        }
    }
}
