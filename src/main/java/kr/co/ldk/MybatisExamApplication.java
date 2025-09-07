package kr.co.ldk;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("kr.co.ldk.mapper")
public class MybatisExamApplication {
    public static void main(String[] args) {
        SpringApplication.run(MybatisExamApplication.class, args);
    }
}