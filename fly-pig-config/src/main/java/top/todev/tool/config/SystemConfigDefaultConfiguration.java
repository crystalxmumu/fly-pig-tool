package top.todev.tool.config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import top.todev.tool.autoconfigure.CacheConfigProperties;

/**
 * 系统缺省配置类
 * @author hk
 * @date 2018-12-21 15:05
 */
@Configuration
@EnableConfigurationProperties(value = {CacheConfigProperties.class})
public class SystemConfigDefaultConfiguration {

}
