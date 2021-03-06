package com.example.springboot;

import com.example.springboot.bean.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;

/**
 * Spring boot 单元测试：
 * 可以在测试期间很方便的类似编码一样进行自动注入等容器的功能
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBoot01HelloworldQuickApplicationTests {

	@Autowired
	Person person;

	@Test
	public void contextLoads() {
		System.out.println(person);
	}



}
