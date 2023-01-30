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
public class   PurPurchaseOrderTest {
    K3CloudApi api = new K3CloudApi();
    static String FNumber = SeqHelper.genNumber("CGDD");
    static String FName = "aucgdd_" + UUID.randomUUID().toString();

    String json = "{\n" +
            "  \"NeedUpDateFields\": [],\n" +
            "  \"NeedReturnFields\": [],\n" +
            "  \"IsDeleteEntry\": \"true\",\n" +
            "  \"SubSystemId\": \"\",\n" +
            "  \"IsVerifyBaseDataField\": \"false\",\n" +
            "  \"IsEntryBatchFill\": \"true\",\n" +
            "  \"ValidateFlag\": \"true\",\n" +
            "  \"NumberSearch\": \"true\",\n" +
            "  \"IsAutoAdjustField\": \"false\",\n" +
            "  \"InterationFlags\": \"\",\n" +
            "  \"IgnoreInterationFlag\": \"\",\n" +
            "  \"Model\": {\n" +
            "    \"FBillTypeID\": {\n" +
            "      \"FNUMBER\": \"CGDD01_SYS\"\n" +
            "    },\n" +
            "    \"FDate\": \"2022-04-25 00:00:00\",\n" +
            "    \"FSupplierId\": {\n" +
            "      \"FNumber\": \"SCMGYS000002\"\n" +
            "    },\n" +
            "    \"FPurchaseOrgId\": {\n" +
            "      \"FNumber\": \"100\"\n" +
            "    },\n" +
            "    \"FPurchaseDeptId\": {\n" +
            "      \"FNumber\": \"FINBM000200\"\n" +
            "    },\n" +
            "    \"FPurchaserGroupId\": {\n" +
            "      \"FNumber\": \"FINYWZ000203\"\n" +
            "    },\n" +
            "    \"FPurchaserId\": {\n" +
            "      \"FNumber\": \"FINYG000202\"\n" +
            "    },\n" +
            "    \"FProviderId\": {\n" +
            "      \"FNumber\": \"SCMGYS000002\"\n" +
            "    },\n" +
            "    \"FSettleId\": {\n" +
            "      \"FNumber\": \"SCMGYS000002\"\n" +
            "    },\n" +
            "    \"FChargeId\": {\n" +
            "      \"FNumber\": \"SCMGYS000002\"\n" +
            "    },\n" +
            "    \"FChangeStatus\": \"A\",\n" +
            "    \"FACCTYPE\": \"Q\",\n" +
            "    \"FPOOrderFinance\": {\n" +
            "      \"FSettleModeId\": {\n" +
            "        \"FNumber\": \"JSFS01_SYS\"\n" +
            "      },\n" +
            "      \"FPayConditionId\": {\n" +
            "        \"FNumber\": \"FKTJ01_SYS\"\n" +
            "      },\n" +
            "      \"FSettleCurrId\": {\n" +
            "        \"FNumber\": \"PRE001\"\n" +
            "      },\n" +
            "      \"FExchangeTypeId\": {\n" +
            "        \"FNumber\": \"HLTX01_SYS\"\n" +
            "      },\n" +
            "      \"FExchangeRate\": 1,\n" +
            "      \"FPriceTimePoint\": \"1\",\n" +
            "      \"FFOCUSSETTLEORGID\": {\n" +
            "        \"FNumber\": \"100\"\n" +
            "      },\n" +
            "      \"FIsIncludedTax\": true,\n" +
            "      \"FISPRICEEXCLUDETAX\": true,\n" +
            "      \"FLocalCurrId\": {\n" +
            "        \"FNumber\": \"PRE001\"\n" +
            "      },\n" +
            "      \"FSupToOderExchangeBusRate\": 1\n" +
            "    },\n" +
            "    \"FPOOrderEntry\": [\n" +
            "      {\n" +
            "        \"FProductType\": \"1\",\n" +
            "        \"FMaterialId\": {\n" +
            "          \"FNumber\": \"SCMWL000012\"\n" +
            "        },\n" +
            "        \"FMaterialDesc\": \"SCMWL000012采购(可退物料)\",\n" +
            "        \"FUnitId\": {\n" +
            "          \"FNumber\": \"Pcs\"\n" +
            "        },\n" +
            "        \"FQty\": 6,\n" +
            "        \"FPriceUnitId\": {\n" +
            "          \"FNumber\": \"Pcs\"\n" +
            "        },\n" +
            "        \"FPriceUnitQty\": 6,\n" +
            "        \"FPriceBaseQty\": 6,\n" +
            "        \"FDeliveryDate\": \"2022-04-25 15:03:00\",\n" +
            "        \"FPrice\": 796.460177,\n" +
            "        \"FTaxPrice\": 900,\n" +
            "        \"FEntryTaxRate\": 13,\n" +
            "        \"FRequireOrgId\": {\n" +
            "          \"FNumber\": \"100\"\n" +
            "        },\n" +
            "        \"FRequireDeptId\": {\n" +
            "          \"FNumber\": \"SCMBM000001\"\n" +
            "        },\n" +
            "        \"FReceiveOrgId\": {\n" +
            "          \"FNumber\": \"100\"\n" +
            "        },\n" +
            "        \"FEntrySettleOrgId\": {\n" +
            "          \"FNumber\": \"100\"\n" +
            "        },\n" +
            "        \"FStockUnitID\": {\n" +
            "          \"FNumber\": \"Pcs\"\n" +
            "        },\n" +
            "        \"FStockQty\": 6,\n" +
            "        \"FStockBaseQty\": 6,\n" +
            "        \"FSupplierLot\": \"11111111111\",\n" +
            "        \"FDeliveryMaxQty\": 6,\n" +
            "        \"FDeliveryMinQty\": 6,\n" +
            "        \"FDeliveryEarlyDate\": \"2022-04-25 15:03:00\",\n" +
            "        \"FDeliveryLastDate\": \"2022-04-25 15:03:00\",\n" +
            "        \"FPriceCoefficient\": 1,\n" +
            "        \"FEntrySettleModeId\": {\n" +
            "          \"FNumber\": \"JSFS01_SYS\"\n" +
            "        },\n" +
            "        \"FReqTraceNo\": \"1111111111\",\n" +
            "        \"FPlanConfirm\": true,\n" +
            "        \"FSalUnitID\": {\n" +
            "          \"FNumber\": \"Pcs\"\n" +
            "        },\n" +
            "        \"FSalQty\": 6,\n" +
            "        \"FCentSettleOrgId\": {\n" +
            "          \"FNumber\": \"100\"\n" +
            "        },\n" +
            "        \"FDispSettleOrgId\": {\n" +
            "          \"FNumber\": \"100\"\n" +
            "        },\n" +
            "        \"FDeliveryStockStatus\": {\n" +
            "          \"FNumber\": \"KCZT02_SYS\"\n" +
            "        },\n" +
            "        \"FSalBaseQty\": 6,\n" +
            "        \"FEntryPayOrgId\": {\n" +
            "          \"FNumber\": \"100\"\n" +
            "        },\n" +
            "        \"FAllAmountExceptDisCount\": 5400,\n" +
            "        \"FEntryDeliveryPlan\": [\n" +
            "          {\n" +
            "            \"FDeliveryDate_Plan\": \"2022-04-25 15:03:00\",\n" +
            "            \"FPlanQty\": 6,\n" +
            "            \"FPREARRIVALDATE\": \"2022-04-25 15:03:00\"\n" +
            "          }\n" +
            "        ]\n" +
            "      },\n" +
            "      {\n" +
            "        \"FProductType\": \"1\",\n" +
            "        \"FMaterialId\": {\n" +
            "          \"FNumber\": \"SCMWL000012\"\n" +
            "        },\n" +
            "        \"FMaterialDesc\": \"SCMWL000012采购(可退物料)\",\n" +
            "        \"FUnitId\": {\n" +
            "          \"FNumber\": \"Pcs\"\n" +
            "        },\n" +
            "        \"FQty\": 6,\n" +
            "        \"FPriceUnitId\": {\n" +
            "          \"FNumber\": \"Pcs\"\n" +
            "        },\n" +
            "        \"FPriceUnitQty\": 6,\n" +
            "        \"FPriceBaseQty\": 6,\n" +
            "        \"FDeliveryDate\": \"2022-04-25 15:03:18\",\n" +
            "        \"FPrice\": 796.460177,\n" +
            "        \"FTaxPrice\": 900,\n" +
            "        \"FEntryTaxRate\": 13,\n" +
            "        \"FRequireOrgId\": {\n" +
            "          \"FNumber\": \"100\"\n" +
            "        },\n" +
            "        \"FReceiveOrgId\": {\n" +
            "          \"FNumber\": \"100\"\n" +
            "        },\n" +
            "        \"FEntrySettleOrgId\": {\n" +
            "          \"FNumber\": \"100\"\n" +
            "        },\n" +
            "        \"FStockUnitID\": {\n" +
            "          \"FNumber\": \"Pcs\"\n" +
            "        },\n" +
            "        \"FStockQty\": 6,\n" +
            "        \"FStockBaseQty\": 6,\n" +
            "        \"FDeliveryMaxQty\": 6,\n" +
            "        \"FDeliveryMinQty\": 6,\n" +
            "        \"FDeliveryEarlyDate\": \"2022-04-25 15:03:18\",\n" +
            "        \"FDeliveryLastDate\": \"2022-04-25 15:03:18\",\n" +
            "        \"FPriceCoefficient\": 1,\n" +
            "        \"FEntrySettleModeId\": {\n" +
            "          \"FNumber\": \"JSFS01_SYS\"\n" +
            "        },\n" +
            "        \"FPlanConfirm\": true,\n" +
            "        \"FSalUnitID\": {\n" +
            "          \"FNumber\": \"Pcs\"\n" +
            "        },\n" +
            "        \"FSalQty\": 6,\n" +
            "        \"FCentSettleOrgId\": {\n" +
            "          \"FNumber\": \"100\"\n" +
            "        },\n" +
            "        \"FDispSettleOrgId\": {\n" +
            "          \"FNumber\": \"100\"\n" +
            "        },\n" +
            "        \"FDeliveryStockStatus\": {\n" +
            "          \"FNumber\": \"KCZT02_SYS\"\n" +
            "        },\n" +
            "        \"FSalBaseQty\": 6,\n" +
            "        \"FEntryPayOrgId\": {\n" +
            "          \"FNumber\": \"100\"\n" +
            "        },\n" +
            "        \"FAllAmountExceptDisCount\": 5400,\n" +
            "        \"FEntryDeliveryPlan\": [\n" +
            "          {\n" +
            "            \"FDeliveryDate_Plan\": \"2022-04-25 15:03:18\",\n" +
            "            \"FPlanQty\": 6,\n" +
            "            \"FSUPPLIERDELIVERYDATE\": \"2022-04-25 15:03:18\",\n" +
            "            \"FPREARRIVALDATE\": \"2022-04-25 15:03:18\"\n" +
            "          }\n" +
            "        ]\n" +
            "      }\n" +
            "    ],\n" +
            "    \"FIinstallment\": [\n" +
            "      {\n" +
            "        \"FYFRATIO\": 100,\n" +
            "        \"FYFAMOUNT\": 10800\n" +
            "      }\n" +
            "    ],\n" +
            "    \"FBillNo\": "+"\""+FNumber+"\""+",\n" +
            "  },\n" +
            "  \"TargetFormId\": \"0\"\n" +
            "}";


    /* 本接口用于实现采购订单 (PUR_PurchaseOrder)的保存功能 */
    @Test
    public void atestSavePurchaseOrder() throws Exception {
        String result = api.save("PUR_PurchaseOrder", json);
        Gson gson = new Gson();
        RepoRet sRet = gson.fromJson(result, RepoRet.class);
        if (sRet.isSuccessfully()) {

            System.out.printf("%s%n", gson.toJson(sRet.getResult()));
        } else {
            fail("采购订单保存接口: " + gson.toJson(sRet.getResult()));
        }
    }


    /*本接口用于实现采购订单 (PUR_PurchaseOrder)的提交功能*/
    @Test
    public void btestSubmitPurchaseOrder() throws Exception {
        JsonObject jsonData = new JsonObject();
        jsonData.addProperty("Numbers", FNumber);
        String result = api.submit("PUR_PurchaseOrder", jsonData.toString());
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
        JsonObject jsonData = new JsonObject();
        jsonData.addProperty("Numbers", FNumber);
        String result = api.audit("PUR_PurchaseOrder", jsonData.toString());
        Gson gson = new Gson();
        RepoRet repoRet = gson.fromJson(result, RepoRet.class);
        if (repoRet.getResult().getResponseStatus().isIsSuccess()) {
            System.out.printf("采购订单审核接口: %s%n", gson.toJson(repoRet.getResult()));
        } else {
            fail("采购订单审核接口: " + gson.toJson(repoRet.getResult()));
        }

    }

    /*本接口用于实现采购订单 (PUR_PurchaseOrder)的反审核功能*/
    @Test
    public void dtestunauditPurchaseOrder() throws Exception {
        JsonObject jsonData = new JsonObject();
        jsonData.addProperty("Numbers", FNumber);
        String result = api.unAudit("PUR_PurchaseOrder", jsonData.toString());
        Gson gson = new Gson();
        RepoRet repoRet = gson.fromJson(result, RepoRet.class);
        if (repoRet.getResult().getResponseStatus().isIsSuccess()) {

            System.out.printf("采购订单反审核接口: %s%n", gson.toJson(repoRet.getResult()));
        } else {
            fail("采购订单反审核接口: " + gson.toJson(repoRet.getResult().getResponseStatus()));
        }
    }



    /*本接口用于实现采购订单 (PUR_PurchaseOrder)的查看功能*/
    @Test
    public void gtestviewPurchaseOrder() throws Exception {
        JsonObject jsonData = new JsonObject();
        jsonData.addProperty("Number", "1.17010070");
        String result = api.view("BD_MATERIAL", jsonData.toString());
        Gson gson = new Gson();
        RepoRet repoRet = gson.fromJson(result, RepoRet.class);
        RepoResult repoRet2 = gson.fromJson(result, RepoResult.class);
        if (repoRet.getResult().getResponseStatus().isIsSuccess()) {

            System.out.printf("采购订单查看接口: %s%n", gson.toJson(result));

            JsonParser parser = new JsonParser();
            JsonObject jsonObject  = parser.parse(result).getAsJsonObject();
            JsonObject s = jsonObject.get("Result").getAsJsonObject();
            JsonObject n = s.get("Result").getAsJsonObject();
            System.out.println("=====" + jsonObject.toString());
            System.out.printf("采购订单查看接口: %s%n", gson.toJson(repoRet));
            System.out.printf("采购订单查看接口: %s%n", gson.toJson(repoRet.getResult().getId()));
        } else {
            fail("采购订单查看接口: " + gson.toJson(repoRet.getResult()));
        }
    }

    /*本接口用于实现采购订单 (PUR_PurchaseOrder)的单据查询功能*/
    @Test
    public void htestQueryPurchaseOrder() throws Exception {
        String json = "{\n" +
                "    \"FormId\": \"PUR_PurchaseOrder\",\n" +
                "    \"FieldKeys\": \"FID,FBillNo\",\n" +
                "    \"FilterString\": \"FBillNo=\'" + FNumber + "\'\",\n" +
                "    \"OrderString\": \"\",\n" +
                "    \"TopRowCount\": 0,\n" +
                "    \"StartRow\": 0,\n" +
                "    \"Limit\": 2000,\n" +
                "    \"SubSystemId\": \"\"\n" +
                "}";
        String result = String.valueOf(api.executeBillQuery(json));
        System.out.println("采购订单单据查询接口: " + result);
    }


    /*本接口用于实现采购订单 (PUR_PurchaseOrder)的删除功能*/
    @Test
    public void itestdeletePurchaseOrder() throws Exception {
        JsonObject jsonData = new JsonObject();
        jsonData.addProperty("Numbers", FNumber);
        String result = api.delete("PUR_PurchaseOrder", jsonData.toString());
        Gson gson = new Gson();
        RepoRet repoRet = gson.fromJson(result, RepoRet.class);
        if (repoRet.getResult().getResponseStatus().isIsSuccess()) {

            System.out.printf("采购订单删除接口: %s%n", gson.toJson(repoRet.getResult().getResponseStatus()));
        } else {
            fail("采购订单删除接口: " + gson.toJson(repoRet.getResult().getResponseStatus()));
        }
    }

}
