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


@RequestMapping(value={"girl2","girl3"})
http://127.0.0.1:8082/girl/girl2
http://127.0.0.1:8082/girl/girl3
结果一样

@PathVariable 路径可以带参数的
com.uestc.boot2.GirlController2
http://127.0.0.1:8082/girl/100/girl2
@RequestMapping(value="/{id}/girl2",method=RequestMethod.GET)
public String sayhello(@PathVariable("id") Integer id) {


@RequestParam 路径参数
1.@RequestParam("id")
com.uestc.boot2.GirlController3
http://127.0.0.1:8082/girl/girl4?id=111

2.@RequestParam(value = "id",required = false, defaultValue = "0")
com.uestc.boot2.GirlController4
http://127.0.0.1:8082/girl/girl5
