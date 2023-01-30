//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.lanwon.kingdeemanage;

import com.kingdee.bos.webapi.sdk.K3CloudApi;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class KingdeeManageApplication {
    public KingdeeManageApplication() {
    }

    public static void main(String[] args) {
        SpringApplication.run(KingdeeManageApplication.class, args);
    }

    @Bean
    public K3CloudApi getK3CloudApi() {
        K3CloudApi api = new K3CloudApi();
        return api;
    }
}
