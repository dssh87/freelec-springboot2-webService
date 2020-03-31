package com.ssh.study.springboot.web.dto;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat; // junit의 기본 assertThat보다 자동완성이 좀 더 확실, 추가 lib 불필요


public class HelloResponseDtoTest {

    @Test
    public void lombok_test(){
        //given
        String name = "test";
        int amount = 1000;

        //when
        HelloResponseDto dto = new HelloResponseDto(name, amount);

        //then
        assertThat(dto.getName()).isEqualTo(name); // 테스트 검증 lib의 검증 메소드, 동등 비교
        assertThat(dto.getAmount()).isEqualTo(amount);
    }


}
