# Git

## 本地仓库与远程仓库关联?

1. 在远程仓库（例如GitHub、GitLab等）上创建一个空的仓库，获取远程仓库的URL地址。

2. 在本地的git仓库目录下使用以下命令将本地仓库关联到远程仓库：

   ```
   git remote add origin 远程仓库的URL地址
   ```

3. 可以使用以下命令验证是否成功关联：

   ```
   git remote -v
   ```

4. 最后，使用以下命令将本地代码推送到远程仓库：

   ```
   git push -u origin master
   ```

## 如何删除远程分支？

```
git branch -r
git push origin --delete master
```

# Spring

## Spring配置类的作用

在Spring中，配置类的作用是用于配置和定义应用程序中的Bean和其他组件。通过配置类，开发者可以替代传统的XML配置方式，以Java代码的形式来定义应用程序的组件、依赖关系、和其他配置信息。

Spring的配置类使用注解`@Configuration`进行标记，它告诉Spring容器该类是一个配置类。配置类通常包含一系列用`@Bean`注解标记的方法，这些方法返回的对象会被Spring容器实例化并纳入应用程序的上下文中。

配置类可以用于定义数据源、事务管理器、各种服务、持久化层组件等。它们还可以配置各种Spring框架的特性和功能，如**AOP**、**事务管理**、国际化等。

使用配置类的好处是它更加类型安全，可以通过Java代码来进行配置，避免了繁琐的XML配置，并提供了更好的代码组织和维护性。同时，配置类也可以与其他注解一起使用，如`@ComponentScan`、`@EnableAutoConfiguration`等，进一步简化配置工作。

## WebMvcConfigurationSupport类的作用

WebMvcConfigurationSupport是Spring Framework中的一个类，它是用于配置Web MVC的支持的基类。在Spring Boot应用中，我们可以通过继承WebMvcConfigurationSupport类，并重写其中的方法来自定义Web MVC的配置。

WebMvcConfigurationSupport类的主要作用有以下几点：

1. 提供自定义配置：通过继承WebMvcConfigurationSupport类，我们可以重写其中的方法来自定义Web MVC的配置，例如添加拦截器、配置视图解析器、设置跨域访问等。
2. 替代Spring Boot的自动配置：当我们继承WebMvcConfigurationSupport类时，Spring Boot的自动配置会被禁用，从而允许我们完全控制Web MVC的配置。
3. 兼容WebMvcConfigurer接口：WebMvcConfigurationSupport类实现了WebMvcConfigurer接口，因此我们也可以通过实现WebMvcConfigurer接口来自定义Web MVC的配置。不过，使用WebMvcConfigurationSupport类可以更方便地集成其他配置。

**需要注意的是，使用WebMvcConfigurationSupport类时，需要谨慎处理，因为它会完全覆盖Spring Boot的自动配置，可能会导致一些问题。**通常情况下，推荐使用WebMvcConfigurer接口来进行局部的Web MVC配置，而不是直接继承WebMvcConfigurationSupport类。这样可以更好地与Spring Boot的自动配置进行整合，避免不必要的冲突和复杂性。

## 过滤器和拦截器的区别

过滤器（Filter）和拦截器（Interceptor）都是Spring框架中用于对请求进行预处理和后处理的组件，但它们之间有一些区别：

1. 定义位置：
   - 过滤器是Servlet规范中的一部分，由Servlet容器负责管理，因此不属于Spring框架的一部分。过滤器在请求到达Servlet之前进行预处理，响应返回给客户端之前进行后处理。
   - 拦截器是Spring框架自己实现的一部分，由Spring容器负责管理。拦截器是在Spring MVC框架中生效，可以拦截Controller的请求处理。
2. 依赖：
   - 过滤器依赖于Servlet容器，它与具体的应用框架无关，可以在任何支持Servlet规范的容器中使用。
   - 拦截器是Spring框架的一部分，依赖于Spring容器。
3. 配置方式：
   - 过滤器的配置是在web.xml中进行的，由Servlet容器管理。
   - 拦截器的配置是在Spring的配置文件中进行的，由Spring容器管理。
4. 执行顺序：
   - 过滤器是在请求到达Servlet之前进行预处理，响应返回给客户端之前进行后处理，因此它的执行顺序是在Servlet之前。
   - 拦截器是在请求到达Controller之前进行预处理，响应返回给客户端之前进行后处理，因此它的执行顺序是在Controller之前。
5. 功能范围：
   - 过滤器可以在整个应用中进行拦截，对所有请求起作用。
   - 拦截器只对Spring MVC中的Controller请求起作用，它可以根据需要选择拦截哪些请求。

总的来说，过滤器更加通用，适用于所有Servlet规范的应用，而拦截器是Spring框架提供的一种更加灵活和强大的请求拦截方式，适用于Spring MVC应用。

## Servlet过滤器

[Servlet过滤器_servlet filter init-param_pan_junbiao的博客-CSDN博客](https://blog.csdn.net/pan_junbiao/article/details/88353292)

## SpringMVC拦截器

[Spring MVC 系列之拦截器 Interceptor 最全总结_springmvc interceptor_大鹏cool的博客-CSDN博客](https://blog.csdn.net/zzuhkp/article/details/121242297)

## AntPathMatcher路径匹配器

### Ant风格

![image-20230801205029122](typora/picture/note.assets/image-20230801205029122.png)

### AntPathMatcher的使用



# Lombok

## 什么是Lombok？

Lombok是Java开发中的一种工具库，它通过使用注解来简化Java代码的编写，减少样板代码（boilerplate code）的量，提高代码的可读性和简洁性。

Lombok提供了许多注解，这些注解可以在编译阶段自动为类生成相应的代码，例如生成getter和setter方法、构造函数、equals和hashCode方法等。使用Lombok后，我们可以通过简单的注解来实现这些功能，而不需要手动编写重复的代码，让代码更加简洁高效。

常用的Lombok注解包括：

1. @Getter和@Setter：自动生成字段的getter和setter方法。
2. @ToString：自动生成toString方法。
3. @EqualsAndHashCode：自动生成equals和hashCode方法。
4. @NoArgsConstructor：自动生成无参构造函数。
5. @AllArgsConstructor：自动生成全参构造函数。
6. @Data：自动生成所有字段的getter、setter、equals、hashCode和toString方法。

除了上述常用注解外，Lombok还提供了其他方便的注解，可以根据项目的需要进行选择和使用。Lombok的使用大大简化了Java代码的编写，提高了开发效率，因此在许多Java项目中被广泛使用。

# Slf4j

## 什么是Slf4j？

Slf4j（Simple Logging Facade for Java）是一个Java日志框架，用于在代码中记录日志信息。它提供了一种简单的抽象层，使得开发者可以在代码中使用统一的日志接口，而不用直接依赖于具体的日志实现。

Slf4j的设计目标是为了解决Java应用中日志框架的多样性和复杂性问题。在Java开发中，常见的日志框架有Log4j、java.util.logging、Logback等，它们各自有不同的API和配置方式。这样在项目中使用不同的日志框架可能会导致代码的耦合性增加，维护和切换日志框架也会变得复杂。

Slf4j的优点在于它提供了一套统一的接口，可以将日志信息传递给底层具体的日志实现框架。这样，开发者在代码中只需要使用Slf4j提供的接口，而不用关心具体的日志实现。同时，Slf4j还支持运行时动态绑定日志实现，可以在不修改代码的情况下切换底层的日志框架。

使用Slf4j的步骤一般包括以下几个部分：

1. 在项目中引入Slf4j库的依赖。
2. 在代码中使用Slf4j提供的接口记录日志信息，如Logger接口。
3. 配置底层的日志实现，通常是通过在项目的配置文件中指定具体的日志框架。

总的来说，Slf4j为Java开发者提供了一种简单、统一且灵活的方式来管理日志输出，使得日志记录变得更加便捷和易于维护。

# MyBatis-Plus

先不记录，后面需要系统性的学习

# fastjson

先不记录，后面需要系统新的学习