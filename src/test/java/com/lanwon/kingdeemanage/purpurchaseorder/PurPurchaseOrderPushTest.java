package com.lanwon.kingdeemanage.purpurchaseorder;

import static org.junit.Assert.fail;

import java.util.UUID;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.kingdee.bos.webapi.entity.*;
import com.kingdee.bos.webapi.sdk.K3CloudApi;
import com.kingdee.webapi.javasdk.common.SeqHelper;
import org.junit.FixMethodOrder;
import org.junit.Test;
import com.google.gson.Gson;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class   PurPurchaseOrderPushTest {
    K3CloudApi api = new K3CloudApi();
    static String FNumber = SeqHelper.genNumber("CGDD");
    static String FName = "aucgdd_" + UUID.randomUUID().toString();
    private static String chaseorderid = "";
    private static String POChangeid = "";


    String json = "{ \"NeedUpDateFields\": [], \"NeedReturnFields\": [], \"IsDeleteEntry\": \"true\", \"SubSystemId\": \"\", \"IsVerifyBaseDataField\": \"false\", \"IsEntryBatchFill\": \"true\", \"ValidateFlag\": \"true\", \"NumberSearch\": \"true\", \"IsAutoAdjustField\": \"false\", \"InterationFlags\": \"\", \"IgnoreInterationFlag\": \"\", \"IsControlPrecision\": \"false\", \"ValidateRepeatJson\": \"false\", \"Model\": { \"FBillTypeID\": { \"FNUMBER\": \"CGDD01_SYS\" }, \"FDate\": \"2022-09-29 00:00:00\", \"FSupplierId\": { \"FNumber\": \"FINGYS000100\" }, \"FPurchaseOrgId\": { \"FNumber\": \"100\" }, \"FProviderId\": { \"FNumber\": \"FINGYS000100\" }, \"FSettleId\": { \"FNumber\": \"FINGYS000100\" }, \"FChargeId\": { \"FNumber\": \"FINGYS000100\" }, \"FChangeStatus\": \"A\", \"FACCTYPE\": \"Q\", \"FPOOrderFinance\": { \"FSettleCurrId\": { \"FNumber\": \"PRE001\" }, \"FExchangeTypeId\": { \"FNumber\": \"HLTX01_SYS\" }, \"FExchangeRate\": 1, \"FPriceTimePoint\": \"1\", \"FFOCUSSETTLEORGID\": { \"FNumber\": \"100\" }, \"FIsIncludedTax\": true, \"FISPRICEEXCLUDETAX\": true, \"FLocalCurrId\": { \"FNumber\": \"PRE001\" }, \"FSupToOderExchangeBusRate\": 1 }, \"FPOOrderEntry\": [ { \"FProductType\": \"1\", \"FMaterialId\": { \"FNumber\": \"BOSTEST001\" }, \"FMaterialDesc\": \"BOSTEST001\", \"FUnitId\": { \"FNumber\": \"Pcs\" }, \"FQty\": 1, \"FPriceUnitId\": { \"FNumber\": \"Pcs\" }, \"FPriceUnitQty\": 1, \"FPriceBaseQty\": 1, \"FDeliveryDate\": \"2022-09-29 10:42:29\", \"FEntryTaxRate\": 13, \"FRequireOrgId\": { \"FNumber\": \"100\" }, \"FReceiveOrgId\": { \"FNumber\": \"100\" }, \"FEntrySettleOrgId\": { \"FNumber\": \"100\" }, \"FStockUnitID\": { \"FNumber\": \"Pcs\" }, \"FStockQty\": 1, \"FStockBaseQty\": 1, \"FDeliveryMaxQty\": 1, \"FDeliveryMinQty\": 1, \"FDeliveryEarlyDate\": \"2022-09-29 10:42:29\", \"FDeliveryLastDate\": \"2022-09-29 10:42:29\", \"FPriceCoefficient\": 1, \"FPlanConfirm\": true, \"FSalUnitID\": { \"FNumber\": \"Pcs\" }, \"FSalQty\": 1, \"FCentSettleOrgId\": { \"FNumber\": \"100\" }, \"FDispSettleOrgId\": { \"FNumber\": \"100\" }, \"FDeliveryStockStatus\": { \"FNumber\": \"KCZT02_SYS\" }, \"FSalBaseQty\": 1, \"FEntryPayOrgId\": { \"FNumber\": \"100\" }, \"FEntryDeliveryPlan\": [ { \"FDeliveryDate_Plan\": \"2022-09-29 10:42:29\", \"FPlanQty\": 1, \"FPREARRIVALDATE\": \"2022-09-29 10:42:29\" } ] } ], \"FBillNo\":"+"\""+FNumber+"\""+" }}";



    /* 本接口用于实现采购订单 (PUR_PurchaseOrder)的保存功能 */
    @Test
    public void atestSavePurchaseOrder() throws Exception {
        String result = api.save("PUR_PurchaseOrder", json);
        Gson gson = new Gson();
        RepoRet sRet = gson.fromJson(result, RepoRet.class);
        if (sRet.isSuccessfully()) {
            chaseorderid = sRet.getResult().getId();
            System.out.printf("采购订单保存接口: %s%n", gson.toJson(sRet.getResult()));
        } else {
            fail("采购订单保存接口: " + gson.toJson(sRet.getResult()));
        }
    }


    /*本接口用于实现采购订单 (PUR_PurchaseOrder)的提交功能*/
    @Test
    public void btestSubmitPurchaseOrder() throws Exception {
        String data = "{\"CreateOrgId\": 0,\"Numbers\": "+"\""+FNumber+"\""+" ,\"Ids\": \"\",\"SelectedPostId\": 0,\"NetworkCtrl\": \"\",\"IgnoreInterationFlag\": \"\"}";
        String result = api.submit("PUR_PurchaseOrder", data);
        Gson gson = new Gson();
        RepoRet repoRet = gson.fromJson(result, RepoRet.class);
        if (repoRet.getResult().getResponseStatus().isIsSuccess()) {
            System.out.printf("采购订单提交接口: %s%n", gson.toJson(repoRet.getResult()));
        } else {
            fail("采购订单提交接口: " + gson.toJson(repoRet.getResult()));
        }

    }

    /*本接口用于实现采购订单 (PUR_PurchaseOrder)的审核功能*/
    @Test
    public void ctestauditPurchaseOrder() throws Exception {
        String data = "{\"CreateOrgId\": 0,\"Numbers\": "+"\""+FNumber+"\""+" ,\"Ids\": \"\",\"SelectedPostId\": 0,\"NetworkCtrl\": \"\",\"IsVerifyProcInst\":\"\",\"IgnoreInterationFlag\": \"\"}";
        String result = api.audit("PUR_PurchaseOrder", data);
        Gson gson = new Gson();
        RepoRet repoRet = gson.fromJson(result, RepoRet.class);
        if (repoRet.getResult().getResponseStatus().isIsSuccess()) {
            System.out.printf("采购订单审核接口: %s%n", gson.toJson(repoRet.getResult()));
        } else {
            fail("采购订单审核接口: " + gson.toJson(repoRet.getResult()));
        }
    }

    /*本接口用于实现采购订单 (PUR_PurchaseOrder)下推采购订单变更单(PUR_POChange)功能*/
    @Test
    public void dtestPurchaseOrderPushPOChange() throws Exception {
        String  paradata = "{\"Ids\": "+"\""+chaseorderid+"\""+",\"Numbers\": [],\"EntryIds\": \"\",\"RuleId\": \"PUR_PurchaseOrder-PUR_POChange\",\"TargetBillTypeId\": \"d588ab5aeb23490aadbb665874b1eabf\",\"TargetOrgId\": 0,\"TargetFormId\": \"PUR_POChange\",\"IsEnableDefaultRule\": false,\"IsDraftWhenSaveFail\": true,\"CustomParams\": {}}";
        String result = api.push("PUR_PurchaseOrder", paradata);
        Gson gson = new Gson();
        RepoRet repoRet = gson.fromJson(result, RepoRet.class);
        if (repoRet.getResult().getResponseStatus().isIsSuccess()) {
            String entity = gson.toJson(repoRet.getResult().getResponseStatus().getSuccessEntitys().get(0));
            POChangeid = new JsonParser().parse(entity).getAsJsonObject().get("Id").toString();
            System.out.printf("采购订单下推采购变更单接口: %s%n", result);
        } else {
            fail("采购订单下推采购变更单接口: " + result );
        }
    }

    /*本接口用于实现采购订单变更单(PUR_POChange)的查看功能*/
    @Test
    public void etestviewPurPochange() throws Exception {
        String data = "{ \"CreateOrgId\": 0, \"Number\": \"\", \"Id\": "+POChangeid+", \"IsSortBySeq\": \"false\"}";
        String result = api.view("PUR_POChange", data);
        Gson gson = new Gson();
        RepoRet repoRet = gson.fromJson(result, RepoRet.class);
        if (repoRet.getResult().getResponseStatus().isIsSuccess()) {

            System.out.printf("采购订单变更单查看接口: %s%n", gson.toJson(repoRet.getResult()));
        } else {
            fail("采购订单变更单查看接口: " + gson.toJson(repoRet.getResult()));
        }
    }


    /*本接口用于实现采购订单变更单(PUR_POChange)的保存功能*/
    @Test
    public void ftestSavePurPochange() throws Exception {
        String data = "{\"NeedUpDateFields\": [\"FBillNo\",\"FChangeReason\"],\"NeedReturnFields\": [\"FBillNo\",\"FChangeReason\"],\"IsDeleteEntry\": \"true\",\"SubSystemId\": \"\",\"IsVerifyBaseDataField\": \"false\",\"IsEntryBatchFill\": \"true\",\"ValidateFlag\": \"true\",\"NumberSearch\": \"true\",\"IsAutoAdjustField\": \"false\",\"InterationFlags\": \"\",\"IgnoreInterationFlag\": \"\",\"IsControlPrecision\": \"false\",\"ValidateRepeatJson\": \"false\",\"Model\": {\"FID\": "+POChangeid+",\"FChangeReason\": \"变更\",\"FEntity\": [{\"FEntryID\": "+POChangeid+" ,\"FDeliEntity\": [{\"FDetailID\": "+POChangeid+"}]}]}}";
        String result = api.save("PUR_POChange", data);
        Gson gson = new Gson();
        RepoRet repoRet = gson.fromJson(result, RepoRet.class);
        if (repoRet.getResult().getResponseStatus().isIsSuccess()) {

            System.out.printf("采购订单变更单保存接口: %s%n", result);
        } else {
            fail("采购订单变更单保存接口: " + result);
        }
    }

}
