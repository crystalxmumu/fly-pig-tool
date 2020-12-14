package top.todev.tool.util.core;

import freemarker.cache.StringTemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.StringWriter;
import java.util.Hashtable;
import java.util.Locale;
import java.util.Map;

/**
 * <p>
 * FreeMarker工具类
 * </p>
 * @author 小飞猪
 * @version 0.0.2
 * @date 2020/12/14 11:24
 * @since 0.0.2
 */
@Slf4j
public class FreeMarkerUtil {

	private final static String TEMPLATE_NAME = "_TEMPLATE_NAME";
	public final static String ENCODING_UTF8 = "UTF-8";
	public final static String ENCODING_GBK = "GBK";

	/**
	 * 处理字符串模板后获得模板内容。
	 * @param map 数据对象
	 * @param templateContent 模板字符串
	 * @return 处理结果内容
	 * @throws IOException IO异常
	 * @throws TemplateException 模板异常
	 */
	public static String processTemplate(Map<String, Object> map,String templateContent) throws IOException, TemplateException {
		return processTemplate(map, templateContent, Locale.CHINA, ENCODING_GBK);
	}

	/**
	 * 处理字符串模板后获得模板内容。
	 * @param map 数据对象
	 * @param templateContent  模板字符串
	 * @param locale 时区
	 * @param encoding 字符编码
	 * @return 模板结果内容
	 * @throws IOException IO异常
	 * @throws TemplateException 模板异常
	 */
	public static String processTemplate(Map<String, Object> map,String templateContent,Locale locale,String encoding) throws IOException, TemplateException {
		Configuration cfg = new Configuration(Configuration.getVersion());
		cfg.setEncoding(locale, encoding);
		cfg.setWhitespaceStripping(true);
		cfg.setTagSyntax(Configuration.AUTO_DETECT_TAG_SYNTAX);
		StringTemplateLoader stringLoader = new StringTemplateLoader();
		stringLoader.putTemplate(TEMPLATE_NAME, templateContent);
		cfg.setTemplateLoader(stringLoader);
		Template template = cfg.getTemplate(TEMPLATE_NAME, locale, encoding);
		StringWriter sw = new StringWriter();
		template.process(map, sw);
		return sw.toString();
	}

	/**
	 * 获取模板处理后的字符串
	 * @param clazz 模板所在位置类
	 * @param templateName 模板名称
	 * @param encoding 字符编码
	 * @param map 数据对象
	 * @return 模板结果内容
	 * @throws IOException IO异常
	 * @throws TemplateException 模板异常
	 */
	public static String processTemplate(Class<?> clazz, String templateName, String encoding, Map<String, Object> map) throws IOException, TemplateException {
		//log.info("获取Freemarker的Configuration");
		log.debug("获取Freemarker的Configuration：class:"+clazz.getName()+",pathPrefix:"+"ftl"+",locale:"+Locale.CHINA.getDisplayCountry()+",encoding:"+encoding);
		Configuration cfg = new Configuration(Configuration.getVersion());
		cfg.setClassForTemplateLoading(clazz, "ftl");
		cfg.setEncoding(Locale.CHINA, encoding);
		cfg.setWhitespaceStripping(true);
		Template template = cfg.getTemplate(templateName);
		StringWriter sw = new StringWriter();
		template.process(map, sw);
		return sw.toString();
	}

	/**
	 * 获取模板处理后的字符串
	 * @param clazz 模板所在位置类
	 * @param templateName 模板名称
	 * @param map 数据对象
	 * @return 模板结果内容
	 * @throws IOException IO异常
	 * @throws TemplateException 模板异常
	 */
	public static String processTemplate(Class<?> clazz,String templateName,Map<String, Object> map) throws IOException, TemplateException {
		StringWriter sw = new StringWriter();
		Template template = getTemplate(clazz, templateName);
		template.process(map, sw);
		log.debug("FreeMarker处理后信息:"+sw.toString());
		return sw.toString();
	}

	/**
	 * 获取Freemarker的模板
	 * @param clazz 模板所在位置类
	 * @param templateName 模板名称
	 * @return 模板实例
	 * @throws IOException IO异常
	 */
	public static Template getTemplate(Class<?> clazz, String templateName) throws IOException{
		log.info("加载FreeMarker的Template");
		log.debug("加载FreeMarker的Template:class"+clazz.getName()+",templateName:"+templateName);
		return getConfiguration(clazz).getTemplate(templateName);
	}


	/**
	 * 获取Freemarker的配置对象
	 * @param clazz 模板所在位置类
	 * @return 模板配置类
	 */
	public static Configuration getConfiguration(Class<?> clazz){
		return getConfiguration(clazz, "ftl", Locale.CHINA, ENCODING_GBK);
	}

	/**
	 * 获取Freemarker的配置对象
	 * @param clazz 模板所在位置类
	 * @param pathPrefix 模板路径前缀
	 * @return 模板配置类
	 */
	public static Configuration getConfiguration(Class<?> clazz, String pathPrefix){
		return getConfiguration(clazz, pathPrefix, Locale.CHINA, ENCODING_GBK);
	}

	/**
	 * 获取Freemarker的配置对象
	 * @param clazz 模板所在位置类
	 * @param pathPrefix 模板路径前缀
	 * @param encoding 编码
	 * @return 模板配置类
	 */
	public static Configuration getConfiguration(Class<?> clazz, String pathPrefix, String encoding){
		return getConfiguration(clazz, pathPrefix, Locale.CHINA, encoding);
	}

	/**
	 * 获取Freemarker的配置对象
	 * @param clazz 模板所在位置类
	 * @param pathPrefix 模板路径前缀
	 * @param encoding 编码
	 * @return 模板配置类
	 */
	public static Configuration getConfiguration(Class<?> clazz, String pathPrefix, Locale locale, String encoding) {

		log.info("获取Freemarker的Configuration");
		log.debug("获取Freemarker的Configuration：class:"+clazz.getName()+",pathPrefix:"+pathPrefix+",locale:"+locale.getDisplayCountry()+",encoding:"+encoding);
		Configuration cfg = new Configuration(Configuration.getVersion());
		cfg.setClassForTemplateLoading(clazz, pathPrefix);
		cfg.setEncoding(locale, encoding);
		cfg.setWhitespaceStripping(true);
		return cfg;
	}

	public static void main(String[] args) throws IOException, TemplateException {
		String content = "[#if 1==1]hello,${user}[/#if]";
		Map<String, Object> map = new Hashtable<String, Object>();
		map.put("user", "world");
		System.out.println(FreeMarkerUtil.processTemplate(map, content));
	}
}
