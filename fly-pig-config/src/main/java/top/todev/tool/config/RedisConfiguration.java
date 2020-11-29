package top.todev.tool.config;

import cn.hutool.core.map.MapUtil;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.jsontype.impl.LaissezFaireSubTypeValidator;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.module.paramnames.ParameterNamesModule;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.CacheKeyPrefix;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import top.todev.tool.autoconfigure.CacheConfigProperties;

import javax.annotation.Resource;
import java.time.Duration;
import java.util.Map;

/**
 * Redis配置类
 * @author hk
 * @date 2018-06-07 11:09
 */
@Slf4j
@Configuration
@EnableCaching
public class RedisConfiguration {

    private final static long DEFAULT_CACHE_TIME_HOUR = 1;
    private final CacheConfigProperties properties;

    @Resource(name="createJavaTimeModule")
    private JavaTimeModule javaTimeModule;

    public RedisConfiguration(CacheConfigProperties properties) {
        this.properties = properties;
    }

    /**
     * Redis缓存管理器
     * @param factory redis工厂类
     * @return Redis缓存管理器
     */
    @Bean
    public CacheManager cacheManager(RedisConnectionFactory factory) {
        return RedisCacheManager.builder(factory)
                .cacheDefaults(defaultCacheConfig())
                //加载配置的缓存，覆盖默认缓存
                .withInitialCacheConfigurations(cacheConfig())
                .transactionAware()
                .build();
    }

    /**
     * Redis缓存序列化配置
     * @return Redis缓存序列化配置
     */
    private RedisCacheConfiguration defaultCacheConfig() {
        Jackson2JsonRedisSerializer<Object> serializer = new Jackson2JsonRedisSerializer<>(Object.class);
        ObjectMapper om = new ObjectMapper();
        om.registerModule(javaTimeModule).registerModule(new ParameterNamesModule());
        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        // 指定序列化输入类型
        om.activateDefaultTyping(LaissezFaireSubTypeValidator.instance,
                ObjectMapper.DefaultTyping.NON_FINAL);
        serializer.setObjectMapper(om);
        return RedisCacheConfiguration.defaultCacheConfig()
                .serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(serializer))
                .entryTtl(Duration.ofHours(DEFAULT_CACHE_TIME_HOUR))
                .disableCachingNullValues();
    }

    /**
     * 设置缓存的过期时间
     * @return 缓存的过期时间Map
     */
    private Map<String, RedisCacheConfiguration> cacheConfig() {
        Map<String, RedisCacheConfiguration> map = MapUtil.newHashMap();
        if(properties != null && MapUtil.isNotEmpty(properties.getConfigMap())) {
            properties.getConfigMap()
                    .forEach((key, value) -> {
                        map.put(key, defaultCacheConfig()
                            .computePrefixWith(CacheKeyPrefix.simple())
                            .entryTtl(Duration.ofSeconds(value)));
                            log.info("配置{}缓存的时间为{}秒", key, value);
                    });
        }
        return map;
    }
}
