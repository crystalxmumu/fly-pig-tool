package top.todev.tool.config;

import cn.hutool.core.date.LocalDateTimeUtil;
import cn.hutool.core.util.StrUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import static cn.hutool.core.date.DatePattern.*;
import static java.time.format.DateTimeFormatter.ISO_LOCAL_TIME;

/**
 * <p>
 * WebMVC 日期转换类
 * </p>
 * @author hk
 * @version 0.0.1
 * @since 0.0.1
 * @date 2020-09-24 10:55
 */
@Slf4j
@Configuration
public class MappingConverterAdapter {

    @Bean
    public Converter<String, LocalDateTime> localDateTimeConvert() {
        return new Converter<String, LocalDateTime>() {
            @Override
            public LocalDateTime convert(String source) {
                LocalDateTime date = null;
                try {
                    if (StrUtil.isNotBlank(source)) {
                        if(NORM_DATETIME_PATTERN.length() == source.length()) {
                            date = LocalDateTimeUtil.parse(source, NORM_DATETIME_FORMATTER);
                        } else if(NORM_DATE_PATTERN.length() == source.length()) {
                            date = LocalDateTimeUtil.parse(source, NORM_DATE_FORMATTER);
                        }
                    }
                } catch (Exception e) {
                    log.warn("日期时间[{}]格式[{}]转换错误: {}", source, NORM_DATETIME_PATTERN, e.getMessage());
                }
                return date;
            }
        };
    }

    @Bean
    public Converter<String, LocalDate> localDateConvert() {
        return new Converter<String, LocalDate>() {
            @Override
            public LocalDate convert(String source) {
                LocalDate date = null;
                try {
                    if (StrUtil.isNotBlank(source)) {
                        if( NORM_DATE_PATTERN.length() == source.length()) {
                            date = LocalDateTimeUtil.parseDate(source, NORM_DATE_FORMATTER);
                        } else if(NORM_DATETIME_PATTERN.length() == source.length()) {
                            date = LocalDateTimeUtil.parseDate(source, NORM_DATETIME_FORMATTER);
                        }
                    }
                } catch (Exception e) {
                    log.warn("日期[{}]格式[{}]转换错误: {}", source, NORM_DATETIME_FORMATTER, e.getMessage());
                }
                return date;
            }
        };
    }

    @Bean
    public Converter<String, LocalTime> localTimeConvert() {
        return new Converter<String, LocalTime>() {
            @Override
            public LocalTime convert(String source) {
                LocalTime date = null;
                try {
                    if(StrUtil.isNotBlank(source) && NORM_TIME_PATTERN.length() == source.length()) {
                        date = LocalTime.parse(source, ISO_LOCAL_TIME );
                    }
                } catch (Exception e) {
                    log.warn("时间[{}]格式[{}]转换错误: {}", source, NORM_TIME_PATTERN, e.getMessage());
                }
                return date;
            }
        };
    }
}
