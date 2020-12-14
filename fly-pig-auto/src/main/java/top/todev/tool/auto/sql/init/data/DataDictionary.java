package top.todev.tool.auto.sql.init.data;

import cn.hutool.core.util.IdUtil;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

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
public class DataDictionary implements Serializable {

	private static final long serialVersionUID = -8654412383206233109L;
	private String uid;
	
	private String code;
	
	private String name;
	
	private String desc;
	
	private String sys;

	private String del;
	
	private int order;
	
	private String remark;
	
	private List<StaticData> datas;

	public DataDictionary() {
		super();
		this.uid = IdUtil.simpleUUID();
		this.sys = "1";
		this.del = "0";
		this.datas = new ArrayList<StaticData>();
	}
	
	public DataDictionary(String code, String name, String desc) {
		this();
		this.code = code;
		this.name = name;
		this.desc = desc;
	}

	public DataDictionary(String code, String name, String desc, String remark) {
		this();
		this.code = code;
		this.name = name;
		this.desc = desc;
		this.remark = remark;
	}

	public DataDictionary addData(StaticData data){
		if(data!=null) {
			data.setParent(this);
			data.setOrder(datas.size()+1);
			datas.add(data);
		}
		return this;
	}

}
