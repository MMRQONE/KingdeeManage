package com.lanwon.kingdeemanage.accountbalance;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.kingdee.bos.webapi.sdk.K3CloudApi;
import org.junit.Test;

import static org.junit.Assert.fail;

public class GlrptAccoutBalanceTest {
    K3CloudApi api = new K3CloudApi();
    String json = "{\n" +
            "  \"FieldKeys\": \"FBALANCEID,FBALANCENAME,FACCTTYPE,FACCTGROUP,FDETAILNUMBER,FDETAILNAME,FCyName\",\n" +
            "  \"SchemeId\": \"97ffa1271acc4846b209ea05ac8dec9c\",\n" +
            "  \"StartRow\": 0,\n" +
            "  \"Limit\": 2000,\n" +
            "  \"IsVerifyBaseDataField\": \"false\",\n" +
            "  \"Model\": {\n" +
            "    \"FACCTBOOKID\": {\n" +
            "      \"FNumber\": \"001\"\n" +
            "    },\n" +
            "    \"FCURRENCY\": \"1\",\n" +
            "    \"FSTARTYEAR\": \"2021\",\n" +
            "    \"FSTARTPERIOD\": \"12\",\n" +
            "    \"FENDYEAR\": \"2021\",\n" +
            "    \"FBALANCELEVEL\": \"1\",\n" +
            "    \"FENDPERIOD\": \"12\",\n" +
            "    \"FFORBIDBALANCE\": true,\n" +
            "    \"FBALANCEZERO\": true,\n" +
            "    \"FPERIODNOBALANCE\": true,\n" +
            "    \"FYEARNOBALANCE\": true\n" +
            "  },\n" +
            "  \"PkEntryIds\": []\n" +
            "}";

    /* 科目余额表 (GL_RPT_AccountBalance) 的查询报表数据功能 */
    @Test
    public void testGetSysReportDataAccountBalance()  throws Exception{
        String sFormId = "GL_RPT_AccountBalance";
        String result = api.getSysReportData(sFormId,json);
        JsonObject resultjson = new JsonParser().parse(result).getAsJsonObject();
        boolean IsSuccess = resultjson.get("Result").getAsJsonObject().get("IsSuccess").getAsBoolean();
        if (IsSuccess){
            System.out.println("科目余额表报表数据：" + result);
        }
        else {
            fail("科目余额表报表数据：" + result);
        }
    }
}
