package com.example.springboot.bean;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@ToString
//@Component
//@ConfigurationProperties(prefix = "person")
public class Person {
    /**
     * 在XML中配置
     * <bean class="Person">  该标签作用相当于@Component
     *      <property name="lastName" value="字面量/${key}/#{SpEl}"></property>
     * </bean>
     */
//    @Value("${person.last-name}")
    private String lastName;

//    @Value("#{22+1}")
    private Integer age;

//    @Value("true")
    private Boolean boss;
    private Date birth;

    private Map<String,Object> maps;
    private List<Object> lists;
    private Dog dog;

}
