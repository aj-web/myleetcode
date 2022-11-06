package com.example.redistop10;

import com.example.redistop10.comUtils.ComTopUtil;
import com.example.redistop10.entity.ComDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import static com.example.redistop10.comUtils.ComTopUtil.comTopFlag;

@SpringBootTest
class Redistop10ApplicationTests {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Autowired
    private RedisTemplate<String,String> redisTemplate;


    @Test
    void hello() {
        ValueOperations<String,String> ops = redisTemplate.opsForValue();
        ops.set("k1", "v1");
        Object k1 = ops.get("k1");
        System.out.println(k1);
        System.out.println(stringRedisTemplate.opsForValue().get("k1"));
    }

    @Test
    void contextLoads() {
        ComTopUtil.ComTopAdd("comA");
        ComTopUtil.ComTopAdd("comB");
        ComTopUtil.ComTopAdd("comC");
        ComTopUtil.ComTopAdd("comD");
        ComTopUtil.ComTopAdd("comE");
        ComTopUtil.ComTopAdd("comF");
        ComTopUtil.ComTopAdd("comG");
        ComTopUtil.ComTopAdd("comH");
        ComTopUtil.ComTopAdd("comI");
        ComTopUtil.ComTopAdd("comJ");
        ComTopUtil.ComTopAdd("comK");
        ComTopUtil.ComTopAdd("comL");

        ComTopUtil.ComTopAdd("comA");
        ComTopUtil.ComTopAdd("comB");
        ComTopUtil.ComTopAdd("comC");

        List<ComDto> comDtos = ComTopUtil.ComTopGet(comTopFlag, 10);
        System.out.println(comDtos);
    }




}
