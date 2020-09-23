package com.offcn.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Configuration
@PropertySource("classpath:test.properties")
@ConfigurationProperties("student")
public class Student {

    private Long id;
    private String name;
    private Integer age;
    private String address;
}
