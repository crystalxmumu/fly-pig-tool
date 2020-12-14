package top.todev.tool.auto.redux;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.StrUtil;
import lombok.extern.slf4j.Slf4j;
import top.todev.tool.model.constant.IStaticDataEnum;
import top.todev.tool.util.core.FreeMarkerUtil;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static cn.hutool.core.util.StrUtil.toCamelCase;
import static cn.hutool.core.util.StrUtil.upperFirst;

/**
 * 自动生成Redux的Action、Reducer和ReactNative的Container、Component抽象实现类
 * @author 小飞猪
 */
@Slf4j
public abstract class AbstractAutoGenerateForRedux {

	public final static String JS = ".js";
	public final static String ENCODING = "UTF-8";
	public final static String SPLIT = "/";
	
	protected Map<String, Object> map = new HashMap<>();
	/** 模板文件名称 */
	protected String generateTemplate;
	/** 目标文件夹 */
	protected String generateTargetPackage;

	public void generateSingleFile(JsonResultTypeForPage resultType, boolean append) throws IOException, URISyntaxException {
        IStaticDataEnum<String>[] values = resultType.getTypes();
		List<Map<String, Object>> datas = new ArrayList<>();
		for(IStaticDataEnum<String> dic : values) {
			log.debug("处理:"+dic.getCnName());
			HashMap<String, Object> dicMap = new HashMap<>();
			dicMap.put("dic", dic);
			dicMap.put("lowerCode", dic.getCode().toLowerCase());
			dicMap.put("lowerCodeAction", dic.getCode().toLowerCase()+"_action");
			dicMap.put("firstUpperCode", upperFirst(toCamelCase(dic.getCode().toLowerCase())));
			dicMap.put("firstUpperContainer", upperFirst(toCamelCase(dic.getCode().toLowerCase()))+"Container");
			dicMap.put("firstLowerCode", toCamelCase(dic.getCode().toLowerCase()));
			dicMap.put("firstLowerAction", toCamelCase(dic.getCode().toLowerCase())+"Action");
			dicMap.put("firstLowerEpic", toCamelCase(dic.getCode().toLowerCase())+"Epic");
			datas.add(dicMap);
		}
		log.debug("个数："+datas.size());
		map.put("datas", datas);
		map.put("path", resultType.getPath());
		map.put("spritNum", StrUtil.count(resultType.getPath(), SPLIT));
        map.put("firstUpperContainer", upperFirst(toCamelCase(resultType.getCode().toLowerCase()))+"Container");
        map.put("firstUpperPage", upperFirst(toCamelCase(resultType.getCode().toLowerCase())));
		map.put("actionFileName", resultType.getCode().toLowerCase() + "_action");
		map.put("epicFileName", resultType.getCode().toLowerCase() + "_epic");
		map.put("reducerFileName", resultType.getCode().toLowerCase());
        map.put("pageNameDesc", resultType.getName());
        File file = new File(AbstractAutoGenerateForRedux.class.getResource("/").toURI()).getParentFile().getParentFile();
		File listFile = new File(file.getCanonicalPath() + File.separator + "target/redux" + File.separator+  getGenerateTargetPackage() + resultType.getPath() + File.separator + getGenerateFileName(resultType.getCode()));
		//noinspection ResultOfMethodCallIgnored
		listFile.getParentFile().mkdirs();
		log.info("path:"+listFile.getCanonicalPath());
		String result = null;
		try {
			result = FreeMarkerUtil.processTemplate(AbstractAutoGenerateForRedux.class, this.generateTemplate, ENCODING, map);
			log.debug(result);
		} catch (Exception e) {
			log.warn("处理模板发生错误",e);
		}
		if(listFile.exists() && append) {
			FileUtil.appendUtf8String(result, listFile);
		}
		else {
			FileUtil.writeUtf8String(result, listFile);
		}
	}
	
	private void writeFile(String fileName, String templateName) throws IOException {
		File listFile = new File("." + File.separator + "doc/redux" + File.separator+  getGenerateTargetPackage()  + File.separator + fileName);
		//noinspection ResultOfMethodCallIgnored
		listFile.getParentFile().mkdirs();
		if(!listFile.exists()) {
			log.info("文件[{}]不存在,自动创建!", listFile.getCanonicalPath());
			String result = null;
			try {
				result = FreeMarkerUtil.processTemplate(AbstractAutoGenerateForRedux.class, templateName, ENCODING, map);
				log.debug(result);
			} catch (Exception e) {
				log.warn("处理模板发生错误",e);
			}
			FileUtil.writeUtf8String(result, listFile);
		}else {
			log.info("文件[{}]已存在,跳过!", listFile.getCanonicalPath());
		}
	}

	protected String getGenerateFileName(String code) {
		return upperFirst(toCamelCase(code.toLowerCase())) + JS;
	}
	
	public String getGenerateTemplate() {
		return generateTemplate;
	}

	public void setGenerateTemplate(String generateTemplate) {
		this.generateTemplate = generateTemplate;
	}

	public String getGenerateTargetPackage() {
		return generateTargetPackage;
	}
	public void setGenerateTargetPackage(String generateTargetPackage) {
		this.generateTargetPackage = generateTargetPackage;
	}
	
	public Object put(String key, Object value){
		return map.put(key, value);
	}

	public static void main(String[] args) throws URISyntaxException, IOException {
		File listFile = new File("." + File.separator + "doc/redux" + File.separator+  "pages"  + File.separator + "hello.js");
		System.out.println(listFile.getAbsolutePath());

		File file = new File(AbstractAutoGenerateForRedux.class.getResource("/").toURI());
		System.out.println(file.getParentFile().getParentFile().getCanonicalPath());
	}
}
