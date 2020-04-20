package com.ssh.study.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

//@EnableJpaAuditing //JPA Auditing 활성화
@SpringBootApplication // 스프링 부트의 자동 설정, 스프링 빈 읽기와 생성을 모두 자동으로 설정
public class Application { // 프로젝트의 메인 클래스, 이 위치부터 읽기 때문에 항상 프로젝트 최상단에 위치해야함.

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args); // 내장 WAS를 실행(톰캣 설치 필요 없음) -> 언제 어디서나 같은 환경에서 배포 가능
    }
}
