package com.in28minutes.springboot.myfirstwebapp.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SayHelloController {
    @RequestMapping("say-hello")
    @ResponseBody
    public String sayHello(){
        return "Hello, what are you learning today";
    }

    @RequestMapping("say-hello-html")
    @ResponseBody
    public String sayHelloHtml(){
        StringBuilder sb = new StringBuilder();
        sb.append("<html>");
        sb.append("<head>");
        sb.append("<title> My first HTML page </title>");
        sb.append("</head>");
        sb.append("<body>");
        sb.append("My first HTML page with a body.");
        sb.append("</body>");
        sb.append("</html>");

        return sb.toString();
    }

    // /src/main/resources/META-INF/resources/WEB-INF/jsp/sayHello.jsp
    @RequestMapping("say-hello-jsp")
    public String sayHelloJsp() {
        return "sayHello";
    }
}
