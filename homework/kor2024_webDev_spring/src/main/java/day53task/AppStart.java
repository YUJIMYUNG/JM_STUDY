package day53task;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
public class AppStart {
    public static void main(String[] args) {
        SpringApplication.run(AppStart.class);
    }
}

@RestController
class day53taskController {
    @PostMapping("/day53task")
    public String postMethod(){
        System.out.println("day53taskController.postMathod");
        return "day53task POST 메소드 통신 성공";
    }

    @GetMapping("/day53task")
    public String getMethod() {
        System.out.println("day53taskController.getMethod");
        return "day53task GET 메소드 통신 성공";
    }

    @PutMapping("/day53task")
    public String putMethod() {
        System.out.println("day53taskController.putMethod");
        return "day53task PUT 메소드 통신 성공";
    }

    @DeleteMapping("/day53task")
    public String deleteMethod() {
        System.out.println("day53taskController.deleteMethod");
        return "day53task DELETE 메소드 통신 성공";
    }
}
