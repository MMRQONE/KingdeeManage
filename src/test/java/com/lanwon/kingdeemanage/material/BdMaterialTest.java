package com.lanwon.kingdeemanage.material;

import static org.junit.Assert.fail;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.UUID;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.kingdee.bos.webapi.entity.*;
import com.kingdee.bos.webapi.sdk.K3CloudApi;
import com.kingdee.webapi.javasdk.common.SeqHelper;
import com.google.gson.Gson;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;



@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class BdMaterialTest {
    static String FNumber = SeqHelper.genNumber("WL");
    static String FName = "auwl_" + UUID.randomUUID().toString();
    private static String groupid = "";
    private static String materid = "";
    private static String fileid = "";
//    static K3CloudApi api = new K3CloudApi();



    /* 本接口用于实现物料 (BD_Material) 的保存功能 */
    @Test
    public void atestSaveMaterial() throws Exception {
        K3CloudApi api = new K3CloudApi();
        com.kingdee.webapi.javasdk.material.BdMaterial c = new com.kingdee.webapi.javasdk.material.BdMaterial();
        String data = "{\"NeedUpDateFields\": [],\"NeedReturnFields\": [],\"IsDeleteEntry\": \"true\",\"SubSystemId\": \"\",\"IsVerifyBaseDataField\": \"false\",\"IsEntryBatchFill\": \"true\",\"ValidateFlag\": \"true\",\"NumberSearch\": \"true\",\"IsAutoAdjustField\": \"false\",\"InterationFlags\": \"\",\"IgnoreInterationFlag\": \"\",\"IsControlPrecision\": \"false\",\"ValidateRepeatJson\": \"false\",\"Model\": {\"FNumber\": "+"\""+FNumber+"\""+",\"FName\": "+"\""+FName+"\""+",\"FImgStorageType\": \"A\",\"FCreateOrgId\": {\"FNumber\": \"100\"},\"FUseOrgId\": {\"FNumber\": \"100\"},\"FSubHeadEntity\": {\"FTimeUnit\": \"H\"},\"SubHeadEntity\": {\"FErpClsID\": \"1\",\"FFeatureItem\": \"1\",\"FCategoryID\": {\"FNumber\": \"CHLB01_SYS\"},\"FTaxType\": {\"FNumber\": \"WLDSFL01_SYS\"},\"FTaxRateId\": {\"FNUMBER\": \"SL02_SYS\"},\"FBaseUnitId\": {\"FNumber\": \"Pcs\"},\"FIsPurchase\": true,\"FIsInventory\": true,\"FIsSale\": true,\"FWEIGHTUNITID\": {\"FNUMBER\": \"kg\"},\"FVOLUMEUNITID\": {\"FNUMBER\": \"m\"}},\"SubHeadEntity1\": {\"FStoreUnitID\": {\"FNumber\": \"Pcs\"},\"FUnitConvertDir\": \"1\",\"FIsLockStock\": true,\"FCountCycle\": \"1\",\"FCountDay\": 1,\"FCurrencyId\": {\"FNumber\": \"PRE001\"},\"FSNManageType\": \"1\",\"FSNGenerateTime\": \"1\"},\"SubHeadEntity2\": {\"FSaleUnitId\": {\"FNumber\": \"Pcs\"},\"FSalePriceUnitId\": {\"FNumber\": \"Pcs\"},\"FMaxQty\": 100000,\"FIsReturn\": true,\"FISAFTERSALE\": true,\"FISPRODUCTFILES\": true,\"FWARRANTYUNITID\": \"D\",\"FOutLmtUnit\": \"SAL\"},\"SubHeadEntity3\": {\"FPurchaseUnitId\": {\"FNumber\": \"Pcs\"},\"FPurchasePriceUnitId\": {\"FNumber\": \"Pcs\"},\"FQuotaType\": \"1\",\"FIsReturnMaterial\": true,\"FPOBillTypeId\": {\"FNUMBER\": \"CGSQD01_SYS\"},\"FPrintCount\": 1,\"FMinPackCount\": 1},\"SubHeadEntity4\": {\"FPlanningStrategy\": \"1\",\"FMfgPolicyId\": {\"FNumber\": \"ZZCL001_SYS\"},\"FFixLeadTimeType\": \"1\",\"FVarLeadTimeType\": \"1\",\"FCheckLeadTimeType\": \"1\",\"FOrderIntervalTimeType\": \"3\",\"FMaxPOQty\": 100000,\"FEOQ\": 1,\"FVarLeadTimeLotSize\": 1,\"FIsMrpComBill\": true,\"FReserveType\": \"1\",\"FCanDelayDays\": 999,\"FAllowPartDelay\": true,\"FPlanOffsetTimeType\": \"1\",\"FWriteOffQty\": 1},\"SubHeadEntity5\": {\"FProduceUnitId\": {\"FNumber\": \"Pcs\"},\"FProduceBillType\": {\"FNUMBER\": \"SCDD03_SYS\"},\"FOrgTrustBillType\": {\"FNUMBER\": \"SCDD06_SYS\"},\"FBOMUnitId\": {\"FNumber\": \"Pcs\"},\"FIssueType\": \"1\",\"FOverControlMode\": \"1\",\"FMinIssueQty\": 1,\"FMinIssueUnitId\": {\"FNUMBER\": \"Pcs\"},\"FStandHourUnitId\": \"3600\",\"FBackFlushType\": \"1\"},\"SubHeadEntity7\": {\"FSubconUnitId\": {\"FNumber\": \"Pcs\"},\"FSubconPriceUnitId\": {\"FNumber\": \"Pcs\"},\"FSubBillType\": {\"FNUMBER\": \"WWDD01_SYS\"}},\"FEntityAuxPty\": [{\"FAuxPropertyId\": {\"FNumber\": \"10\"}},{\"FAuxPropertyId\": {\"FNumber\": \"20\"}},{\"FAuxPropertyId\": {\"FNumber\": \"30\"}}],\"FEntityInvPty\": [{\"FInvPtyId\": {\"FNumber\": \"01\"},\"FIsEnable\": true},{\"FInvPtyId\": {\"FNumber\": \"02\"},\"FIsEnable\": true},{\"FInvPtyId\": {\"FNumber\": \"03\"}},{\"FInvPtyId\": {\"FNumber\": \"04\"}},{\"FInvPtyId\": {\"FNumber\": \"06\"}}]}}";
        String result = api.save("BD_Material",  data);
        Gson gson = new Gson();
        RepoRet sRet = gson.fromJson(result, RepoRet.class);
        if (sRet.isSuccessfully()) {
            materid = sRet.getResult().getId();
            System.out.printf("物料保存接口: %s%n", gson.toJson(sRet.getResult()));
        } else {
            fail("物料保存接口: " + gson.toJson(sRet.getResult()));
        }
    }


    /*本接口用于实现物料 (BD_Material) 的提交功能*/
    @Test
    public void btestSubmitMaterial() throws Exception {
        K3CloudApi api = new K3CloudApi();
        String data = "{\"CreateOrgId\": 0,\"Numbers\": "+"\""+FNumber+"\""+" ,\"Ids\": \"\",\"SelectedPostId\": 0,\"NetworkCtrl\": \"\",\"IgnoreInterationFlag\": \"\"}";
        String result = api.submit("BD_Material", data);
        Gson gson = new Gson();
        RepoRet repoRet = gson.fromJson(result, RepoRet.class);
        if (repoRet.getResult().getResponseStatus().isIsSuccess()) {
            System.out.printf("物料提交接口: %s%n", gson.toJson(repoRet.getResult()));
        } else {
            fail("物料提交接口: " + gson.toJson(repoRet.getResult()));
        }

    }

    /*本接口用于实现物料 (BD_Material) 的审核功能*/
    @Test
    public void ctestauditMaterial() throws Exception {
        K3CloudApi api = new K3CloudApi();
        String data = "{\"CreateOrgId\": 0,\"Numbers\": ["+"\""+FNumber+"\""+"],\"Ids\": \"\",\"InterationFlags\": \"\",\"NetworkCtrl\": \"\",\"IsVerifyProcInst\": \"\",\"IgnoreInterationFlag\": \"\"}";
        String result = api.audit("BD_Material", data);
        Gson gson = new Gson();
        RepoRet repoRet = gson.fromJson(result, RepoRet.class);
        if (repoRet.getResult().getResponseStatus().isIsSuccess()) {
            System.out.printf("物料审核接口: %s%n", gson.toJson(repoRet.getResult()));
        } else {
            fail("物料审核接口: "+gson.toJson(repoRet.getResult()));
        }

    }



    /*本接口用于实现物料 (BD_Material) 的分配功能*/
    @Test
    public void etestallocateMaterial() throws Exception {
        K3CloudApi api = new K3CloudApi();
        String data = "{ \"PkIds\": "+materid+", \"TOrgIds\": \"100002\"}";
        String result = api.allocate("BD_Material", data);
        Gson gson = new Gson();
        RepoRet repoRet = gson.fromJson(result, RepoRet.class);
        if (repoRet.getResult().getResponseStatus().isIsSuccess()) {
            System.out.printf("物料分配接口: %s%n", gson.toJson(repoRet.getResult()));
        } else {
            fail("物料分配接口: "+gson.toJson(repoRet.getResult()));
        }

    }

    /*本接口用于实现物料 (BD_Material) 的取消分配功能*/
    @Test
    public void ftestcancelAllocatetMaterial() throws Exception {
        K3CloudApi api = new K3CloudApi();
        String data = "{ \"PkIds\": "+materid+", \"TOrgIds\": \"100002\"}";
        String result = api.cancelAllocate("BD_Material", data);
        Gson gson = new Gson();
        RepoRet repoRet = gson.fromJson(result, RepoRet.class);
        if (repoRet.getResult().getResponseStatus().isIsSuccess()) {
            System.out.printf("物料取消分配接口: %s%n", gson.toJson(repoRet.getResult()));
        } else {
            fail("物料取消分配接口: "+gson.toJson(repoRet.getResult()));
        }

    }

    /*本接口用于实现物料 (BD_Material) 的反审核功能*/
    @Test
    public void gestunauditMaterial() throws Exception {
        K3CloudApi api = new K3CloudApi();
        String data = "{\"CreateOrgId\": 0,\"Numbers\": ["+"\""+FNumber+"\""+"],\"Ids\": \"\",\"InterationFlags\": \"\",\"NetworkCtrl\": \"\",\"IsVerifyProcInst\": \"\",\"IgnoreInterationFlag\": \"\"}";
        String result = api.unAudit("BD_Material", data);
        Gson gson = new Gson();
        RepoRet repoRet = gson.fromJson(result, RepoRet.class);
        if (repoRet.getResult().getResponseStatus().isIsSuccess()) {
            System.out.printf("物料反审核接口: %s%n", gson.toJson(repoRet.getResult()));
        } else {
            fail("物料反审核接口: " + gson.toJson(repoRet.getResult()));
        }
    }


    /*本接口用于实现物料 (BD_Material) 的附件上传功能*/
    @Test
    public void htestAttachmentUploadMaterial() throws Exception {
        K3CloudApi api = new K3CloudApi();
        String  json = "{\"FileName\":\"1016.txt\",\"FEntryKey\":\"\",\"FormId\": \"BD_MATERIAL\",\"IsLast\": true,\"InterId\": "+materid+"," +
                "\"BillNO\": "+"\""+FNumber+"\""+",\"AliasFileName\": \"test\",\"SendByte\": \"6L+Z5piv5rWL6K+V5paH5Lu25ZKMYmFzZTY05a2X56ym5Liy5LqS6L2s\"}";
        String result = api.attachmentUpload(json);
        Gson gson = new Gson();
        RepoRet repoRet = gson.fromJson(result, RepoRet.class);
        if (repoRet.getResult().getResponseStatus().isIsSuccess()) {
            JsonElement jsondata = new JsonParser().parse(result);
            fileid = jsondata.getAsJsonObject().get("Result").getAsJsonObject().get("FileId").toString();
            System.out.printf("物料附件上传接口: %s%n", result);
        } else {
            fail("物料附件上传接口: " + result);
        }
    }

    /*本接口用于实现物料 (BD_Material) 的附件下载功能*/
    @Test
    public void itestattachmentDownLoadMaterial() throws Exception {
        K3CloudApi api = new K3CloudApi();
        String  json = " {\"FileId\": "+fileid+", \"StartIndex\": 0}";
        String result = api.attachmentDownLoad(json);
        Gson gson = new Gson();
        RepoRet repoRet = gson.fromJson(result, RepoRet.class);
        if (repoRet.getResult().getResponseStatus().isIsSuccess()) {
            System.out.printf("物料附件下载接口: %s%n", result);
        } else {
            fail("物料附件下载接口: " + result);
        }
    }


    /*本接口用于实现物料 (BD_Material) 的禁用功能*/
    @Test
    public void jtestForbidMaterial() throws Exception {
        K3CloudApi api = new K3CloudApi();
        String data = "{\"CreateOrgId\": 0,\"Numbers\": ["+"\""+FNumber+"\""+"],\"Ids\": \"\",\"PkEntryIds\":[],\"NetworkCtrl\": \"\",\"IgnoreInterationFlag\": \"\"}";
        String result = api.excuteOperation("BD_Material", "Forbid", data);
        Gson gson = new Gson();
        RepoRet repoRet = gson.fromJson(result, RepoRet.class);
        if (repoRet.getResult().getResponseStatus().isIsSuccess()) {

            System.out.printf("物料禁用接口: %s%n", gson.toJson(repoRet.getResult()));
        } else {
            fail("物料提交接口: " + gson.toJson(repoRet.getResult()));
        }
    }

    /*本接口用于实现物料 (BD_Material) 的反禁用功能*/
    @Test
    public void ktestenableMaterial() throws Exception {
        K3CloudApi api = new K3CloudApi();
        String data = "{\"CreateOrgId\": 0,\"Numbers\": ["+"\""+FNumber+"\""+"],\"Ids\": \"\",\"PkEntryIds\":[],\"NetworkCtrl\": \"\",\"IgnoreInterationFlag\": \"\"}";
        String result = api.excuteOperation("BD_Material", "enable",data);
        Gson gson = new Gson();
        RepoRet repoRet = gson.fromJson(result, RepoRet.class);
        if (repoRet.getResult().getResponseStatus().isIsSuccess()) {

            System.out.printf("物料反禁用接口: %s%n", gson.toJson(repoRet.getResult()));
        } else {
            fail("物料反禁用接口: " + gson.toJson(repoRet.getResult()));
        }
    }

    /*本接口用于实现物料 (BD_Material) 的查看功能*/
    @Test
    public void ltestviewMaterial() throws Exception {
        Properties properties = new Properties();
        File file = new File((new File("./src")).getCanonicalPath() + "/kdwebapi.properties");
        System.out.println("读取根目录下的配置文件->" + file.getPath());
        InputStream inputStream = new FileInputStream(file.getPath());
        properties.load(new InputStreamReader(inputStream, "utf-8"));
        inputStream.close();
        IdentifyInfo  iden = new IdentifyInfo();
        iden.setUserName(properties.getProperty("X-KDApi-UserName"));
        iden.setAppId(properties.getProperty("X-KDApi-AppID"));
        iden.setdCID(properties.getProperty("X-KDApi-AcctID"));
        iden.setAppSecret(properties.getProperty("X-KDApi-AppSec"));
        iden.setlCID(2052);
        iden.setServerUrl(properties.getProperty("X-KDApi-ServerUrl"));
        K3CloudApi api = new K3CloudApi(iden);
        String  data = "{\"CreateOrgId\": 0,\"Number\": "+"\""+FNumber+"\""+",\"Id\": \"\",\"IsSortBySeq\": \"false\"}";
        String result = api.view("BD_Material", data);
        Gson gson = new Gson();
        RepoRet repoRet = gson.fromJson(result, RepoRet.class);
        if (repoRet.getResult().getResponseStatus().isIsSuccess()) {
            System.out.printf("物料查看接口: %s%n", gson.toJson(repoRet.getResult()));
        } else {
            fail(gson.toJson(repoRet.getResult()));
        }
    }


    /*本接口用于实现物料 (BD_Material)的单据查询功能*/
    @Test
    public void mtestQueryMaterial() throws Exception {
        K3CloudApi api = new K3CloudApi();
        String json = "{\n" +
                "    \"FormId\": \"BD_Material\",\n" +
                "    \"FieldKeys\": \"FMATERIALID,FNumber,FName,FCreateOrgId,FUseOrgId\",\n" +
                "    \"FilterString\": \"FNumber=\'" + FNumber + "\'\",\n" +
                "    \"OrderString\": \"\",\n" +
                "    \"TopRowCount\": 0,\n" +
                "    \"StartRow\": 0,\n" +
                "    \"Limit\": 2000,\n" +
                "    \"SubSystemId\": \"\"\n" +
                "}";
         String result = String.valueOf(api.executeBillQuery(json));
        System.out.println("物料单据查询接口: " + result);

    }

    /*本接口用于实现物料 (BD_Material)的删除功能*/
    @Test
    public void ntestdeleteMaterial() throws Exception {
        K3CloudApi api = new K3CloudApi();
        String  data = "{\"CreateOrgId\": 0,\"Numbers\": ["+"\""+FNumber+"\""+"],\"Id\": \"\",\"IsSortBySeq\": \"false\"}";
        String result = api.delete("BD_Material", data);
        Gson gson = new Gson();
        RepoRet repoRet = gson.fromJson(result, RepoRet.class);
        if (repoRet.getResult().getResponseStatus().isIsSuccess()) {

            System.out.printf("物料删除接口: %s%n", gson.toJson(repoRet.getResult().getResponseStatus().getSuccessEntitys()));
        } else {
            fail(gson.toJson(repoRet.getResult().getResponseStatus()));
        }
    }

    /*本接口用于实现物料 (BD_Material) 的分组保存功能*/
    @Test
    public void otestgroupSaveMaterial() throws Exception {
        K3CloudApi api = new K3CloudApi();
        String  json = "{\"GroupFieldKey\": \"\", \"GroupPkId\": 0, \"FParentId\": 0, \"FNumber\": "+"\""+FNumber+"\""+", \"FName\": "+"\""+FNumber+"\""+", \"FDescription\": \"\"}";
        String result = api.groupSave("BD_Material", json);
        Gson gson = new Gson();
        RepoRet repoRet = gson.fromJson(result, RepoRet.class);
        if (repoRet.getResult().getResponseStatus().isIsSuccess()) {

            System.out.printf("物料分组保存接口: %s%n", gson.toJson(repoRet.getResult().getResponseStatus().getSuccessEntitys()));
            String re = gson.toJson(repoRet.getResult().getResponseStatus().getSuccessEntitys().get(0));
            JsonElement jsondata = new JsonParser().parse(re);
            JsonElement id = jsondata.getAsJsonObject().get("Id");
            groupid = id.toString();
        } else {
            fail("物料分组保存接口: " + gson.toJson(repoRet.getResult().getResponseStatus()));
        }

    }


    /*本接口用于实现物料 (BD_Material) 的分组查询功能*/
    @Test
    public void ptestqueryGroupInfoMaterial() throws Exception {
        K3CloudApi api = new K3CloudApi();
        String  json = "{\"FormId\": \"BD_MATERIAL\", \"GroupFieldKey\": \"FMaterialGroup\", \"GroupPkIds\": "+groupid+", \"Ids\": \"\"}";
        String result = api.queryGroupInfo(json);
        Gson gson = new Gson();
        RepoRet repoRet = gson.fromJson(result, RepoRet.class);
        if (repoRet.getResult().getResponseStatus().isIsSuccess()) {

            System.out.printf("物料分组查询接口: %s%n", gson.toJson(repoRet.getResult()));
        } else {
            fail("物料分组查询接口: " + gson.toJson(repoRet.getResult().getResponseStatus()));
        }

    }

    /*本接口用于实现物料 (BD_Material) 的分组删除功能*/
    @Test
    public void qtestgroupDeleteMaterial() throws Exception {
        K3CloudApi api = new K3CloudApi();
        String  json = "{\"FormId\": \"BD_MATERIAL\", \"GroupFieldKey\": \"FMaterialGroup\", \"GroupPkIds\": "+groupid+",}";
        String result = api.groupDelete(json);
        Gson gson = new Gson();
        RepoRet repoRet = gson.fromJson(result, RepoRet.class);
        if (repoRet.getResult().getResponseStatus().isIsSuccess()) {

            System.out.printf("物料分组删除接口: %s%n", gson.toJson(repoRet.getResult()));
        } else {
            fail("物料分组删除接口: " + gson.toJson(repoRet.getResult().getResponseStatus()));
        }

    }

    /*本接口用于实现物料 (BD_Material) 的切换组织接口功能*/
    @Test
    public void rtestswitchOrg() throws Exception {
        K3CloudApi api = new K3CloudApi();
        String  json = "{ \"OrgNumber\": \"200\"}";
        String result = api.switchOrg(json);
        /*为不影响组织数据，切换组织后再切换回来*/
        String  json2 = "{ \"OrgNumber\": \"100\"}";
        String result2 = api.switchOrg(json);
        Gson gson = new Gson();
        RepoRet repoRet = gson.fromJson(result2, RepoRet.class);
        if (repoRet.getResult().getResponseStatus().isIsSuccess()) {

            System.out.printf("物料切换组织接口: %s%n", gson.toJson(repoRet.getResult()));
        } else {
            fail("物料切换组织接口: " + gson.toJson(repoRet.getResult().getResponseStatus()));
        }

    }


    /*本接口用于实现物料 (BD_Material) 的批量保存功能*/
    @Test
    public void stestBatchSaveCustomer() throws Exception {
        K3CloudApi api = new K3CloudApi();
        List<String> materialsmodel = new ArrayList<String>();
        int count =0;
        for (int i = 0; i < 2; i++) {
            String m =  "{\"FNumber\": "+"\""+SeqHelper.genNumber("WL")+"\""+",\"FName\": "+"\""+"auwl_" + UUID.randomUUID().toString()+"\""+",\"FImgStorageType\": \"A\",\"FCreateOrgId\": {\"FNumber\": \"100\"},\"FUseOrgId\": {\"FNumber\": \"100\"},\"FSubHeadEntity\": {\"FTimeUnit\": \"H\"},\"SubHeadEntity\": {\"FErpClsID\": \"1\",\"FFeatureItem\": \"1\",\"FCategoryID\": {\"FNumber\": \"CHLB01_SYS\"},\"FTaxType\": {\"FNumber\": \"WLDSFL01_SYS\"},\"FTaxRateId\": {\"FNUMBER\": \"SL02_SYS\"},\"FBaseUnitId\": {\"FNumber\": \"Pcs\"},\"FIsPurchase\": true,\"FIsInventory\": true,\"FIsSale\": true,\"FWEIGHTUNITID\": {\"FNUMBER\": \"kg\"},\"FVOLUMEUNITID\": {\"FNUMBER\": \"m\"}},\"SubHeadEntity1\": {\"FStoreUnitID\": {\"FNumber\": \"Pcs\"},\"FUnitConvertDir\": \"1\",\"FIsLockStock\": true,\"FCountCycle\": \"1\",\"FCountDay\": 1,\"FCurrencyId\": {\"FNumber\": \"PRE001\"},\"FSNManageType\": \"1\",\"FSNGenerateTime\": \"1\"},\"SubHeadEntity2\": {\"FSaleUnitId\": {\"FNumber\": \"Pcs\"},\"FSalePriceUnitId\": {\"FNumber\": \"Pcs\"},\"FMaxQty\": 100000,\"FIsReturn\": true,\"FISAFTERSALE\": true,\"FISPRODUCTFILES\": true,\"FWARRANTYUNITID\": \"D\",\"FOutLmtUnit\": \"SAL\"},\"SubHeadEntity3\": {\"FPurchaseUnitId\": {\"FNumber\": \"Pcs\"},\"FPurchasePriceUnitId\": {\"FNumber\": \"Pcs\"},\"FQuotaType\": \"1\",\"FIsReturnMaterial\": true,\"FPOBillTypeId\": {\"FNUMBER\": \"CGSQD01_SYS\"},\"FPrintCount\": 1,\"FMinPackCount\": 1},\"SubHeadEntity4\": {\"FPlanningStrategy\": \"1\",\"FMfgPolicyId\": {\"FNumber\": \"ZZCL001_SYS\"},\"FFixLeadTimeType\": \"1\",\"FVarLeadTimeType\": \"1\",\"FCheckLeadTimeType\": \"1\",\"FOrderIntervalTimeType\": \"3\",\"FMaxPOQty\": 100000,\"FEOQ\": 1,\"FVarLeadTimeLotSize\": 1,\"FIsMrpComBill\": true,\"FReserveType\": \"1\",\"FCanDelayDays\": 999,\"FAllowPartDelay\": true,\"FPlanOffsetTimeType\": \"1\",\"FWriteOffQty\": 1},\"SubHeadEntity5\": {\"FProduceUnitId\": {\"FNumber\": \"Pcs\"},\"FProduceBillType\": {\"FNUMBER\": \"SCDD03_SYS\"},\"FOrgTrustBillType\": {\"FNUMBER\": \"SCDD06_SYS\"},\"FBOMUnitId\": {\"FNumber\": \"Pcs\"},\"FIssueType\": \"1\",\"FOverControlMode\": \"1\",\"FMinIssueQty\": 1,\"FMinIssueUnitId\": {\"FNUMBER\": \"Pcs\"},\"FStandHourUnitId\": \"3600\",\"FBackFlushType\": \"1\"},\"SubHeadEntity7\": {\"FSubconUnitId\": {\"FNumber\": \"Pcs\"},\"FSubconPriceUnitId\": {\"FNumber\": \"Pcs\"},\"FSubBillType\": {\"FNUMBER\": \"WWDD01_SYS\"}},\"FEntityAuxPty\": [{\"FAuxPropertyId\": {\"FNumber\": \"10\"}},{\"FAuxPropertyId\": {\"FNumber\": \"20\"}},{\"FAuxPropertyId\": {\"FNumber\": \"30\"}}],\"FEntityInvPty\": [{\"FInvPtyId\": {\"FNumber\": \"01\"},\"FIsEnable\": true},{\"FInvPtyId\": {\"FNumber\": \"02\"},\"FIsEnable\": true},{\"FInvPtyId\": {\"FNumber\": \"03\"}},{\"FInvPtyId\": {\"FNumber\": \"04\"}},{\"FInvPtyId\": {\"FNumber\": \"06\"}}]}";
            materialsmodel.add(m);
            count = i+1;
        }
        String data = "{\"NumberSearch\":\"true\",\"ValidateFlag\":\"true\",\"IsDeleteEntry\":\"true\",\"IsEntryBatchFill\":\"true\",\"NeedUpDateFields\":[],\"NeedReturnFields\":[],\"SubSystemId\":\"\",\"InterationFlags\":\"\",\"Model\":"+materialsmodel+",\"BatchCount\":"+count+",\"IsVerifyBaseDataField\":\"false\",\"IsAutoAdjustField\":\"false\",\"IgnoreInterationFlag\":\"false\",\"IsControlPrecision\":\"false\",\"ValidateRepeatJson\":\"false\",}";
        // 批量保存物料信息
        String sRet = api.batchSave("BD_Material", data);
        Gson gson = new Gson();
        RepoRet repoRet = gson.fromJson(sRet, RepoRet.class);
        if (repoRet.isSuccessfully()) {
            for (int i = 0; i < materialsmodel.size(); i++)
                System.out.println(String.format("批量保持物料:%s%s", i+1,
                        gson.toJson(repoRet.getResult().getResponseStatus().getSuccessEntitys().get(i))));
        } else {
            fail("物料批量保存接口："+gson.toJson(repoRet.getResult()));
        }
    }

    /*本接口用于实现发送消息功能*/
    @Test
    public void ttestsendmsg() throws Exception {
        K3CloudApi api = new K3CloudApi();
        String  data =  "{\"Model\":[{\"FTitle\":\"我是标题\",\"FContent\":\"我是内容\",\"FReceivers\":\"demo\",\"FType\":\"1\"}]}";
        String result = api.sendMsg(data);
        Gson gson = new Gson();
        RepoRet repoRet = gson.fromJson(result, RepoRet.class);
        if (repoRet.getResult().getResponseStatus().isIsSuccess()) {

            System.out.printf("消息发送接口: %s%n", gson.toJson(repoRet.getResult()));
        } else {
            fail("消息发送接口: " + gson.toJson(repoRet.getResult().getResponseStatus()));
        }
    }

}




