# 工程简介
基于金蝶云接口的二次开发
# 部署注意事项
1. 打包jar前把路径下（KingdeeManage/src/main/resources/lib）下的k3cloud-webapi-sdk8.0.4.jar放进本地maven仓库中 pom才可以识别到这个依赖。
  ``` 
   <dependency>
    <groupId>com.kingdee</groupId>
    <artifactId>k3cloud-webapi-sdk</artifactId>
    <version>8.0.2</version>
   </dependency>
   ```
2. 根目录下的kdwebapi.properties是金蝶云的相关配置项 金蝶云管理系统中的（第三方系统授权）
