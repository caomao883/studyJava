@SpringBootApplication
启动网页服务注解
@RestController
@RequestMapping("/hello")
网页的内容类

2.uestc.autowried  http://127.0.0.1:8081/girl/sayhello
2.1 自动注入加有@Service的实现类，如果有多个实现类，则看拼音相同的，否则就@Service("abc")

@Value使用 例子CupSizeController，课程    3-1项目属性配置(20_09)
1.在application.yml 添加变量
2.在类里面添加@value("变量")
3.配置中使用配置
server:
  port: 8081
  context-path: /girl
cupSize: B
age: 18
context: "curSize: ${cupSize}, age:${age}}"

4.@ConfigurationProperties("girl") @Value升级版本 课程    3-1项目属性配置(20_09)
http://127.0.0.1:8081/girl/girl2
4.1 不用每个成员添加@Value
4.2 只需要application配置即可



