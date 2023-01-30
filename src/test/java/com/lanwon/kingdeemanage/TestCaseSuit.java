package com.lanwon.kingdeemanage;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;


@RunWith(Suite.class)
@SuiteClasses({ com.kingdee.webapi.javasdk.material.BdMaterialTest.class,
        com.kingdee.webapi.javasdk.purpurchaseorder.PurPurchaseOrderTest.class, com.kingdee.webapi.javasdk.accountbalance.GlrptAccoutBalanceTest.class,
        com.kingdee.webapi.javasdk.material.bdMaterialFlexTest.class,com.kingdee.webapi.javasdk.purpurchaseorder.PurPurchaseOrderPushTest.class
})



public class TestCaseSuit {
}
