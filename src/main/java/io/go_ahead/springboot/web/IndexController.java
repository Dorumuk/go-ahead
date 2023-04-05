package io.go_ahead.springboot.web;

import io.go_ahead.springboot.config.auth.LoginUser;
import io.go_ahead.springboot.config.auth.dto.SessionUser;
import io.go_ahead.springboot.service.PostsService;
import io.go_ahead.springboot.web.dto.PostsResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@Controller
public class IndexController {

    private final PostsService postsService;
    private final HttpSession httpSession;

    /*
     * src/main/resources/templates 로 앞의 경로가 고정됨.
     * mustache starter 라이브러리로 인해 .mustache 확장자로 자동 지정
     * */
    @GetMapping("/")
    public String index(Model model, @LoginUser SessionUser user) {
        model.addAttribute("posts", postsService.findAllDesc());

        // 세션값을 가져오는 부분
//        SessionUser user = (SessionUser) httpSession.getAttribute("user"); ==> @LoginUser SessionUser user 파라미터로 치환

        if (user != null) {
            model.addAttribute("userName", user.getName());
        }
        return "index";
    }

    @GetMapping("/posts/save")
    public String postsSave() {
        return "posts-save";
    }

    @GetMapping("/posts/update/{id}")
    public String postsUpdate(@PathVariable Long id, Model model) {
        PostsResponseDto dto = postsService.findById(id);
        model.addAttribute("post", dto);

        return "posts-update";
    }
}
