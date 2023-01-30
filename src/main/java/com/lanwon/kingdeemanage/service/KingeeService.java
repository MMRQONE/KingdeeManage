//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.lanwon.kingdeemanage.service;

import com.kingdee.bos.webapi.entity.OperatorResult;
import com.kingdee.bos.webapi.entity.SaveResult;

public interface KingeeService {
    SaveResult save(String formid, String saveParam) throws Exception;

    OperatorResult submit(String formid, String operateParam) throws Exception;

    OperatorResult Audit(String formid, String operateParam) throws Exception;

    OperatorResult unAudit(String formid, String operateParam) throws Exception;

    Object view(String formid, String operateParam) throws Exception;

    Object query(String data) throws Exception;
}
