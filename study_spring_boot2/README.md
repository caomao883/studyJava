多配置，开发，生产环境
 3-1项目属性配置(20_09)
1.修改application.yml,添加application-dev.yml,application-prod.yml
方法一:
2.1通过application.yml 的active:判断环境
spring:
  profiles:
    active: prod

方法二:
mvn install 
2.2  通过下面方法启动
java -jar target/xxx.jar :--spring.profiles.active=prod


