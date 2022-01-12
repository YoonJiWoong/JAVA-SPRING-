package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("hello")
    public String hello(Model model){
        model.addAttribute("data","hello!! 헬로!");
        return  "hello";
    }

    // 정적컨텐츠는 resources/static/hello-static.html

    // MVC와 템플릿 엔진

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name1") String name, Model model){
        // name1 이라는 get파라미터에 값이 name으로해서  아래 model.addAttribute의 벨류값으로...
        model.addAttribute("name",name);
        return "hello-template";
    }

    // viewResolver ... Thymeleaf 템플릿 엔진 처리

    @GetMapping("hello-String")
    @ResponseBody
    public String helloString(@RequestParam("name") String name){
        return "hello "+name;
    }

    // @ResponseBody 를 사용하면 viewResolver를 사용하지 않음.
    // HTTP의 BODY에 문자내용을 직접 반환함 (html의 body 태그 아니야...)

    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name){

        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }

    // @ResponseBody 를 사용하고 객체를 반환하면 JSON 으로 변환됨.
    // @ResponseBody의 사용원리... viewResolver 대신에 HttpMessageConverter 가 동작
    // 기본 문자처리: StringHttpMessageConverter
    // 기본 객체처리: MappingJackson2HttpMessageConverter

    static class Hello{
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }


}
