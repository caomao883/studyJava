@SpringBootApplication
启动网页服务注解
@RestController
@RequestMapping("/hello")
网页的内容类

2.uestc.autowried
2.1 自动注入加有@Service的实现类，如果有多个实现类，则看拼音相同的，否则就@Service("abc")

@Value使用 例子CupSizeController
1.在application.yml 添加变量
2.在类里面添加@value("变量")