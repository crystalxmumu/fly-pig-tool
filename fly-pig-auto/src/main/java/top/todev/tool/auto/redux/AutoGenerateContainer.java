package top.todev.tool.auto.redux;


import static cn.hutool.core.util.StrUtil.toCamelCase;
import static cn.hutool.core.util.StrUtil.upperFirst;

/**
 * @author 小飞猪
 *
 */
public class AutoGenerateContainer extends AbstractAutoGenerateForRedux {

	public AutoGenerateContainer() {
		this("container");
	}

	public AutoGenerateContainer(String generateTargetPackage) {
		this.generateTargetPackage = generateTargetPackage;
		this.generateTemplate = "container.ftl";
	}

	@Override
	protected String getGenerateFileName(String code) {
		return upperFirst(toCamelCase(code.toLowerCase())) + "Container" + AbstractAutoGenerateForRedux.JS;
	}
}
