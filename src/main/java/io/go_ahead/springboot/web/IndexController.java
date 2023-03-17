package io.go_ahead.springboot.web;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@Controller
public class IndexController {

    /*
     * src/main/resources/templates 로 앞의 경로가 고정됨.
     * mustache starter 라이브러리로 인해 .mustache 확장자로 자동 지정
     * */
    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/posts/save")
    public String postsSave() {
        return "posts-save";
    }
}
