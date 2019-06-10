package com.lindj.boot.config.shiro.cache;

import com.lindj.boot.config.shiro.token.TokenProperties;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;
import org.apache.shiro.cache.CacheManager;
import org.redisson.api.RedissonClient;

/**
 * @author lindj
 * @date 2019/5/31 0031
 * @description 自定义cacheManager，
 */
public class MyRedissonShiroCacheManager implements CacheManager {

    private RedissonClient redissonClient;
    private TokenProperties tokenProperties;

    public MyRedissonShiroCacheManager(RedissonClient redissonClient, TokenProperties tokenProperties){
        this.redissonClient = redissonClient;
        this.tokenProperties = tokenProperties;
    }

    @Override
    public <K, V> Cache<K, V> getCache(String s) throws CacheException {
        return new MyCache<K, V>(redissonClient, tokenProperties);
    }
}
