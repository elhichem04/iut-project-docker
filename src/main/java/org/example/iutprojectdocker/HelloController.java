package org.example.iutprojectdocker;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import orh.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    private final StringRedisTemplate redisTemplate;

    @Value("${APP_USER:World}")
    private String user;

    public HelloController(StringRedisTemplate redis Template) {
        this.redisTemplate = redisTemplate;
    }

    @GetMapping("/")
    public String hello() {
        Long count = redisTemplate.opsForValue().increment("visits");
        return "Hello " + user + " J'ai été visité " + count + " fois.";
    }
}
