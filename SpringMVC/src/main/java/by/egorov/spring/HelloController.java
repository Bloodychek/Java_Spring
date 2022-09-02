package by.egorov.spring;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {
    @GetMapping("Hello world")
    public String sayHello(){
        return "Hello world";
    }
}
