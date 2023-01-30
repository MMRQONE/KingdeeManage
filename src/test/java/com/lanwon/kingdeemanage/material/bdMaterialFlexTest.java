package com.lanwon.kingdeemanage.material;

import com.google.gson.Gson;
import com.kingdee.bos.webapi.entity.RepoRet;
import com.kingdee.bos.webapi.sdk.K3CloudApi;
import com.kingdee.webapi.javasdk.common.SeqHelper;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.UUID;

import static org.junit.Assert.fail;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class bdMaterialFlexTest {
    static String FNumber = SeqHelper.genNumber("WL");
    static String FName = "auwl_" + UUID.randomUUID().toString();


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


    /*本接口用于实现弹性域保存功能*/
    @Test
    public void dtestFlexSave() throws Exception {
        K3CloudApi api = new K3CloudApi();
        String  data =   "{\"Model\":[{\"FFLEX8\":{\"FNumber\": "+"\""+FNumber+"\""+"}}]}";
        String result = api.flexSave("BD_FLEXITEMDETAILV",data);
        Gson gson = new Gson();
        RepoRet repoRet = gson.fromJson(result, RepoRet.class);
        if (repoRet.getResult().getResponseStatus().isIsSuccess()) {
            System.out.printf("弹性域保存接口: %s%n", gson.toJson(repoRet.getResult()));
        } else {
            fail("弹性域保存接口: " + gson.toJson(repoRet.getResult().getResponseStatus()));
        }
    }
}
