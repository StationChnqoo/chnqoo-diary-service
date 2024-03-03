package net.cctv3.chnqoodiaryservice.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@Data
@ConfigurationProperties(prefix = "my-config")
public class MyConfig {
    private String uploadRealPath;
    private String uploadCdnPath;
    private String environment;
}