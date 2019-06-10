package com.lindj.boot.config.shiro.cache;

import com.lindj.boot.config.shiro.token.TokenProperties;
import com.lindj.boot.util.JwtUtil;
import com.lindj.boot.util.SecurityConsts;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;
import org.redisson.api.RBucket;
import org.redisson.api.RedissonClient;

import java.util.Collection;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * @author lindj
 * @date 2019/6/3 0003
 * @description 自定义cache对接redisson
 */
public class MyCache<K, V> implements Cache<K, V> {

    private RedissonClient redissonClient;

    private TokenProperties tokenProperties;

    public MyCache(RedissonClient redissonClient, TokenProperties tokenProperties) {
        this.redissonClient = redissonClient;
        this.tokenProperties = tokenProperties;
    }

    private String getKey(Object key) {
        return SecurityConsts.PREFIX_SHIRO_CACHE + JwtUtil.getClaim(key.toString(),
                SecurityConsts.ACCOUNT);
    }

    @Override
    public Object get(Object key) throws CacheException {
        return this.redissonClient.getBucket(getKey(key)).get();
    }

    @Override
    public Object put(Object key, Object value) throws CacheException {
        // 读取配置文件，获取Redis的Shiro缓存过期时间
        RBucket<Object> bucket = this.redissonClient.getBucket(getKey(key));
        bucket.set(value, tokenProperties.getTokenExpireTime() * 60 * 1000L, TimeUnit.MILLISECONDS);
        return null;
    }

    @Override
    public Object remove(Object key) throws CacheException {
        RBucket<Object> bucket = this.redissonClient.getBucket(key.toString());
        if (bucket == null || bucket.get() == null) {
            return null;
        }
        bucket.delete();
        return null;
    }

    @Override
    public void clear() throws CacheException {
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public Set keys() {

        return null;
    }

    @Override
    public Collection values() {

        return null;
    }
}
