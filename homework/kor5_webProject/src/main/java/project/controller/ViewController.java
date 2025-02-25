package project.controller;

import lombok.Getter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {

    @GetMapping("")
    public String index() {
        return "/index.html";
    }

    @GetMapping("/patient/register")
    public String patientRegister() {
        return "/patientMgmt/register.html";
    }
}
