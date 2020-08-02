

1、当我们修改了方法的返回值，是能够进行热部署的；
2、当我们重新创建了一个方法，是能够进行热部署的；
3、当我们重新创建了一个Class,是能够进行热部署的；



我们要使用第三方的json解析框架的话：
1、我们需要在pom.xml中引入相应的依赖；
2、需要在App.java中继承WebMvcConfigurerAdapter重写方法：configureMessageConverters 添加我们自己定义的json解析框架;
2.1 @Bean注入第三方的json解析框架：

@Bean
public HttpMessageConverters fastJsonHttpMessageConverters() {
	// 1、需要先定义一个 convert 转换消息的对象;
	FastJsonHttpMessageConverter fastConverter = new FastJsonHttpMessageConverter();
	
	//2、添加fastJson 的配置信息，比如：是否要格式化返回的json数据;
	FastJsonConfig fastJsonConfig = new FastJsonConfig();
	fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat);
	
	//3、在convert中添加配置信息.
	fastConverter.setFastJsonConfig(fastJsonConfig);
	
	
	HttpMessageConverter<?> converter = fastConverter;
	return new HttpMessageConverters(converter);
}






1、第1节 Spring Boot之Hello World
-------------------------------------------------
1、新建一个HelloController;

2、编写Spring Boot 启动类;

3、进行访问测试，默认的端口号是8080;

2.自定义注解
-------------------------------
[springboot 自定义注解](https://blog.csdn.net/yb546822612/article/details/88116654)

com.kfit.myannotiation
TestAnnotationAspect #定义切面类

@Around 在切点before前执行，可以控制切点

@After 在切点后,return前执行,

@Before 在切点前执行方法,内容为指定的切点
@Aspect 将一个类定义为一个切面类

