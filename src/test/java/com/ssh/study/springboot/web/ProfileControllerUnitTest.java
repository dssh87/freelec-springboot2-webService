package com.ssh.study.springboot.web;

import org.junit.Test;
import org.springframework.mock.env.MockEnvironment;

import static org.assertj.core.api.Assertions.assertThat;

public class ProfileControllerUnitTest {

    @Test
    public void real_profile이_조회(){
        //given
        String exceptedProfile = "real";
        MockEnvironment env = new MockEnvironment();
        env.addActiveProfile(exceptedProfile);
        env.addActiveProfile("Oauth");
        env.addActiveProfile("real-db");

        ProfileController controller = new ProfileController(env);

        //when
        String profile = controller.profile();

        //then
        assertThat(profile).isEqualTo(exceptedProfile);
    }

    @Test
    public void real_profile이_없으면_첫번째_조회(){
        //given
        String exceptedProfile = "oauth";
        MockEnvironment env = new MockEnvironment();

        env.addActiveProfile(exceptedProfile);
        env.addActiveProfile("real-db");

        ProfileController controller = new ProfileController(env);

        //when
        String profile = controller.profile();

        //then
        assertThat(profile).isEqualTo(exceptedProfile);
    }

    @Test
    public void active_profile이_없으면_default가_조회(){
        //given
        String expectedProfile = "default";
        MockEnvironment env = new MockEnvironment();
        ProfileController controller = new ProfileController(env);

        //when
        String profile = controller.profile();

        //then
        assertThat(profile).isEqualTo(expectedProfile);
    }

}
