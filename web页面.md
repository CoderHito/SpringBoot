#Spring Boot的web开发

1、`Spring Boot` 的`web`开发支持

> `Spring Boot`提供了 `spring-boot-starter-web`支持web开发，其中为我们提供了嵌入的Tomcat以及SpringMVC的依赖。

web相关的自动配置存储在`spring-boot-autoconfigure.jar`的`org.springframework.boot.autoconfigure.web`下

2、Thymeleaf模板引擎
> `Thymeleaf` 是一个`Java`类库，它是一个`xml/xhtml/html5`的模板引擎，可作为`View`层。提供了完美的`Spring MVC`的支持。

其他模板引擎


- Thymeleaf(Spring官方推荐)
- FreeMarker
- Velocity
- Groovy
- Mustache


3、demo

- 一种方式


 首先，需使用 `@Controller`注解，若使用 `@RestController`注解相当于多了一个 `@ResponseBody`。
 
 ![web开发.png](https://i.loli.net/2018/08/13/5b71898c0606b.png)

在templates目录下，新建一个普通html页面，浏览器访问[http://localhost:8011/index]()。

- 另一种方式

将页面写在static目录下，在浏览器可直接打开页面 [http://localhost:8011/index.html]()



