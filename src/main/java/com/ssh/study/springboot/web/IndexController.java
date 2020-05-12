package com.ssh.study.springboot.web;

import com.ssh.study.springboot.config.auth.LoginUser;
import com.ssh.study.springboot.config.auth.dto.SessionUser;
import com.ssh.study.springboot.service.PostsService;
import com.ssh.study.springboot.web.dto.PostsResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RequiredArgsConstructor
@Controller
public class IndexController {

    private final PostsService postsService;

    @GetMapping("/")
    public String index(Model model, @LoginUser SessionUser user) {
        model.addAttribute("posts", postsService.findAllDesc());

        if (user != null) { // userName이라고 할 경우 윈도우의 userName을 가져오기 때문에 다른 변수명을 사용하는 것이 좋다
            model.addAttribute("userName1", user.getName());
        }
        return "index";
    }

    @GetMapping("/view")
    public String view(Model model, @LoginUser SessionUser user) {
        System.out.println("view controller");
        model.addAttribute("posts", postsService.findAllDesc());
        if (user != null) { // userName이라고 할 경우 윈도우의 userName을 가져오기 때문에 다른 변수명을 사용하는 것이 좋다
            model.addAttribute("userName1", user.getName());
        }
        return "view";
    }

    @GetMapping("/posts/save")
    public String postsSave(Model model, @LoginUser SessionUser user) {
        System.out.println("save controller");
        if (user != null) { // userName이라고 할 경우 윈도우의 userName을 가져오기 때문에 다른 변수명을 사용하는 것이 좋다
            model.addAttribute("userName1", user.getName());
        }
        return "posts-save";
    }

    @GetMapping("/posts/update/{id}")
    public String postsUpdate(@PathVariable Long id, Model model) {
        PostsResponseDto dto = postsService.findById(id);
        model.addAttribute("post", dto);

        return "posts-update";
    }
}
