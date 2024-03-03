package net.cctv3.chnqoodiaryservice;

import net.cctv3.chnqoodiaryservice.config.MyConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
public class ChnqooDiaryServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(ChnqooDiaryServiceApplication.class, args);
    }
}