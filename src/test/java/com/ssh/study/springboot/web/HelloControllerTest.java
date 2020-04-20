package com.ssh.study.springboot.web;

import com.ssh.study.springboot.web.HelloController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions; // 어디서 사용?
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.is;


@RunWith(SpringRunner.class) // 스프링 부트와 Junit 사이의 연결자 역할
@WebMvcTest(controllers = HelloController.class) // web에 집중할 수 있는 어노테이션
public class HelloControllerTest {

    @Autowired // 스프링이 관리하는 빈을 주입 받는다.
    private MockMvc mvc; // 웹 API 테스트시 사용, 스프링 MVC 테스트의 시작점, GET과 POST 테스트 가능
    
    @Test
    @WithMockUser(roles = "USER")
    public void hello_return() throws Exception{
        String hello = "hello";

        mvc.perform(get("/hello")) // MockMvc를 통해 해당 주소로 get 요청
                .andExpect(status().isOk()) // Header의 status 검증
                .andExpect(content().string(hello)); // 응답 본문의 내용 검증
    }

    @Test
    @WithMockUser(roles = "USER")
    public void helloDto_return() throws Exception{
        String name = " hello";
        int amount = 1000;

        mvc.perform(get("/hello/dto")
                .param("name", name)
                .param("amount", String.valueOf(amount)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is(name))).andExpect(jsonPath("$.amount", is(amount)));
    }
}
