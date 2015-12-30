# CDI extended

The goal is to provide an example which is easy understandable how we can extend the standard CDI mechanism to inject
property values comming from a resource bundle (or properties file).

With this simple extension, you can inject property values in the following way:

```java
public class Bean {

    @Inject
    @Property("key1")
    private String property1;

    @Inject
    @Property("key2")
    private Integer property2;

    @Inject
    @Property("key3")
    private Long property3;
    
    @Inject
    @Property("key4")
    private Boolean property4;
}
```

Enjoiy ;-)