# spring-boot-default-time-zone

### The problem

How to set the default time zone in a Spring Boot application and ensure that no one will change it by accident?

### The solution

_There are [other possible solutions](#other-possible-solutions) to the problem, but I like this one the best as it's in
plain view in the code for the developers to see, and it's guarded by a test_.

Set the default time zone in a method annotated with `@PostConstruct`. This also makes it possible to write a Spring
Boot test to ensure it's not change by accident.

```java

@SpringBootApplication
public class SpringBootDefaultTimeZoneApplication {

    public static void main(String[] args) {
//        If the time zone is set here it's not picked up in Spring Boot test
//        TimeZone.setDefault(TimeZone.getTimeZone("Antarctica/South_Pole"));

        SpringApplication.run(SpringBootDefaultTimeZoneApplication.class, args);
    }

    @PostConstruct
    public void setDefaultTimeZone() {
        TimeZone.setDefault(TimeZone.getTimeZone("Antarctica/South_Pole"));
    }
}
```

Code: [SpringBootDefaultTimeZoneApplication.java](src/main/java/no/elme/example/spring_boot_default_time_zone/SpringBootDefaultTimeZoneApplication.java)

#### The test that verifies

```java

@SpringBootTest
class SpringBootDefaultTimeZoneApplicationTests {

    @Test
    void whenChangingTheDefaultTimeZoneDuringStartup_expectTimeZoneToBeTheSouthPoleAntarctica() {
        TimeZone defaultTimeZone = TimeZone.getDefault();

        assertThat(defaultTimeZone.getID()).isEqualTo("Antarctica/South_Pole");
    }
}
```

Code: [SpringBootDefaultTimeZoneApplicationTests.java](src/test/java/no/elme/example/spring_boot_default_time_zone/SpringBootDefaultTimeZoneApplicationTests.java)

### Other possible solutions

1. Environment variable

```
ENV_TZ="Antarctica/South_Pole"
```

2. JVM parameter

```
java -Duser.timezone=Antarctica/South_Pole
```
