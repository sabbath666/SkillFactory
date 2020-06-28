package ru.skillfactory.cowsay;

import com.github.ricksbrown.cowsay.plugin.CowExecutor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class CowsayApplication {

    @GetMapping
    public String cowsay(){
        CowExecutor cowExecutor = new CowExecutor();
        cowExecutor.setHtml(true);
        cowExecutor.setMessage("Привед");
        return cowExecutor.execute();
    }
    public static void main(String[] args) {
        SpringApplication.run(CowsayApplication.class, args);
    }

}
