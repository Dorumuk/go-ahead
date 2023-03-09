package io.go_ahead.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
* @SpringBootApplication
* 자동 설정, 스프링 Bean 읽기/생성
* ! 이 어노테이션은 최상단 클래스에 있어야 함.
* */
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        // 내장 WAS(톰캣) 실행
        SpringApplication.run(Application.class, args);
    }
}
