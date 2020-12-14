package top.todev.tool.auto.sql.init.data;

import cn.hutool.core.util.IdUtil;
import lombok.Data;

import java.io.Serializable;
import java.util.UUID;

/**
 * <p>
 * 静态数据实体
 * </p>
 * @author 小飞猪
 * @version 0.0.2
 * @date 2020/12/14 11:24
 * @since 0.0.2
 */
@Data
public class StaticData implements Serializable {

	private static final long serialVersionUID = 4382482097000888021L;
	private String uid;
	
	private DataDictionary parent;
	
	private String code;
	
	private String name;
	
	private String value;

	private String ext1;
	private String ext2;
	private String ext3;

	private String desc;

	private String del;
	
	private int order;
	
	private String remark;
	
	public StaticData() {
		super();
		this.uid = IdUtil.simpleUUID();
		this.del = "0";
	}
	
	public StaticData(String code, String name, String value) {
		this();
		this.code = code;
		this.name = name;
		this.value = value;
	}

	public StaticData(String code, String name, String value, String desc) {
		this(code, name, value);
		this.desc = desc;
	}

	public StaticData(String code, String name, String value, String ext1, String ext2, String ext3, String desc, String remark) {
		this(code, name, value, desc, remark);
		this.ext1 = ext1;
		this.ext2 = ext2;
		this.ext3 = ext3;
	}

	public StaticData(String code, String name, String value, String desc, String remark) {
		this(code, name, value, desc);
		this.remark = remark;
	}
	
}
