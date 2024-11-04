package com.example.chambre.config;

import lombok.*;
import org.springframework.boot.context.properties.ConfigurationProperties;


@ConfigurationProperties(prefix = "global.params")
@Data @AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class GlobalConfig {
    int p1;
    int p2;
}
