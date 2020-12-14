package top.todev.tool.auto.sql.init.data;


import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import top.todev.tool.util.core.FreeMarkerUtil;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 数据字典实体
 * </p>
 * @author 小飞猪
 * @version 0.0.2
 * @date 2020/12/14 11:24
 * @since 0.0.2
 */
@Data
@Slf4j
public class AllDictionary implements Serializable {

	/** 数据字典key */
	private final static String DATA_DIC = "dics";
	/** 数据字典模板名称 */
	private final static String TEMPLATE_NAME = "dics.ftl";

	/** 数据字典列表 */
	private List<DataDictionary> dics;
	/** 数据字典顺序 */
	private int order = 1;
	
	public AllDictionary() {
		super();
		this.dics = new ArrayList<DataDictionary>();
}
	
	public AllDictionary(int order) {
		this();
		this.order = order;
	}

	public AllDictionary addDic(DataDictionary dic){
		if(dic!=null) {
			dic.setOrder(dics.size() + order);
			dics.add(dic);
		}
		return this;
	}

	/**
	 * <p>生成字典数据SQL</p>
	 * @return 字典数据SQL
	 * @author 小飞猪
	 * @date 2020/12/14 10:21
	 * @since 0.0.1
	 */
	public String generateSql(){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put(DATA_DIC, dics);
		String result = null;
		try {
			result = FreeMarkerUtil.processTemplate(AllDictionary.class, TEMPLATE_NAME, map);
		} catch (Exception e) {
			log.warn("生成字典数据SQL发生错误", e);
		}
		return result;
	}

}
