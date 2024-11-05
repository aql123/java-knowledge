package com.zyf.tenant.cache.service;

import com.zyf.tenant.cache.constant.RedisConstants;
import com.zyf.tenant.cache.entity.UserEntity;
import com.zyf.tenant.cache.mapper.UserMapper;
import com.zyf.tenant.cache.utils.RedisKeyResolver;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * UserService
 */
@Slf4j
@Service
//@CacheConfig(cacheNames = RedisConstants.GLOBALLY)
public class CommonNotService {

    @Autowired
    private UserMapper mapper;

    @Autowired
    private RedisTemplate redisTemplate;

    public List<UserEntity> selectList() {
        List<UserEntity> list = mapper.list();
        log.info("list：{}", list.size());

        System.out.println("从缓存读取!");

        final Object o = redisTemplate.opsForValue().get(RedisKeyResolver.keys("test","demo"));
        if (o != null) {
            System.out.println("从缓存读取成功!");
            return (List<UserEntity>) o;
        } else {
            System.out.println("读取不到, 现放入缓存!");
            redisTemplate.opsForValue().set(RedisKeyResolver.keys("test","demo"), list);
            System.out.println("放入成功!");
            return list;
        }
    }

    @Cacheable(cacheNames = "commonNot", key = "#root.args[0]")
    public UserEntity getOne(Integer id) {
        log.info("getOne：{}", id);
        return mapper.getOne(id);
    }

}
