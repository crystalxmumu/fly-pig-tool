package top.todev.tool.autoconfigure;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * 缓存配置类
 * @author hk
 * @date  2018-12-15 08:44
 **/
@Data
@ConfigurationProperties(prefix = "top.todev.cache")
public class CacheConfigProperties implements Serializable {

    private static final long serialVersionUID = -3850239330429268664L;

    /**
     * 缓存配置Map<br/>
     * key为缓存前缀,value为缓存缺省有效时间(秒)
     */
    private Map<String, Long> configMap = new HashMap<>();
}
