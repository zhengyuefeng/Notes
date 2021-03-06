# 注册一个自定义的`ConfigurableWebBindingInitializer` 为 bean

在 SpringMVC 中,我们通过直接拓展`WebMvcConfigurationSupport`使用自定义的`ConfigurableWebBindingInitializer`(example [here](https://www.logicbig.com/tutorials/spring-framework/spring-web-mvc/custom-web-binding-initializer.html)).

在 SpringBoot 应用中,我们需要注册一个默认的`ConfigurableWebBindingInitializer`作为一个 bean,通换掉系统中的默认,如果你好奇你可以看`EnableWebMvcConfiguration` 中的`getConfigurableWebBindingInitializer()`,它是`WebMvcAutoConfiguration`的内部类

```java
/**
 * 自定义 ConfigurableWebBindingInitializer
 *
 * @author EricChen 2019/12/09 22:42
 */
@SpringBootApplication
public class WebBindingInitializerExample {
    @Bean
    public ConfigurableWebBindingInitializer getConfigurableWebBindingInitializer() {
        ConfigurableWebBindingInitializer initializer = new ConfigurableWebBindingInitializer();
        FormattingConversionService conversionService = new DefaultFormattingConversionService();
        //we can add our custom converters and formatters
        //conversionService.addConverter(...);
        //conversionService.addFormatter(...);
        initializer.setConversionService(conversionService);
        //we can set our custom validator
        //initializer.setValidator(....);

        //here we are setting a custom PropertyEditor
        initializer.setPropertyEditorRegistrar(propertyEditorRegistry -> {
            SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
            propertyEditorRegistry.registerCustomEditor(Date.class,
                    new CustomDateEditor(dateFormatter, true));
        });
        return initializer;
    }

    public static void main(String[] args) throws InterruptedException {
        SpringApplication.run(WebBindingInitializerExample.class, args);
    }
}

```



