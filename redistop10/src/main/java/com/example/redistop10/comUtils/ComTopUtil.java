package com.example.redistop10.comUtils;

import com.example.redistop10.entity.ComDto;
import org.apache.logging.log4j.util.PropertySource;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.util.CollectionUtils;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author : chezj
 * @date : 2022/11/6 14:53
 */
public class ComTopUtil {

    public static String comTopFlag = "comTop10";
    private static StringRedisTemplate redisTemplate;

    public static StringRedisTemplate getRedisTemplate() {
        if (null == redisTemplate) {
            synchronized (ComTopUtil.class) {
                redisTemplate = SpringContextUtil.getBean(StringRedisTemplate.class);
                return redisTemplate;
            }
        }
        return redisTemplate;
    }


    /**
     * 添加公司
     *
     * @param comName
     */
    public static void ComTopAdd(String comName) {
        getRedisTemplate().opsForZSet().incrementScore(comTopFlag, comName, 1);
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime localDateTime = LocalDateTime.of(LocalDate.now(), LocalTime.of(23, 59, 59));
        Duration between = Duration.between(now, localDateTime);
        getRedisTemplate().expire(comTopFlag, between);
    }

    /**
     * 通过索引区间返回有序集合成指定区间内的成员 分数从高到低
     *
     * @param key  键
     * @param size 获取个数
     * @return 成员集合
     */
    public static List<ComDto> ComTopGet(String key, int size) {
        List<ComDto> comDtos = null;
        try {
            Set<ZSetOperations.TypedTuple<String>> typedTuples = getRedisTemplate().opsForZSet().reverseRangeWithScores(key, 0, size - 1);
            if (!CollectionUtils.isEmpty(typedTuples)) {
                comDtos = typedTuples.stream().map(stringTypedTuple -> ComDto.builder()
                        .value(stringTypedTuple.getValue())
                        .score(stringTypedTuple.getScore())
                        .build()).sorted((c1, c2) -> (int) -( - c2.getScore())).collect(Collectors.toList());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return comDtos;
    }


}


