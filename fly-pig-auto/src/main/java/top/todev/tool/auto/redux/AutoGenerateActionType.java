package top.todev.tool.auto.redux;

/**
 * @author 小飞猪
 *
 */
public class AutoGenerateActionType extends AbstractAutoGenerateForRedux {

	public AutoGenerateActionType() {
		this("constant");
	}

	public AutoGenerateActionType(String generateTargetPackage) {
		this.generateTargetPackage = generateTargetPackage;
		this.generateTemplate = "action_type.ftl";
	}

	@Override
	protected String getGenerateFileName(String code) {
		return new StringBuffer("ActionType").append(AbstractAutoGenerateForRedux.JS).toString();
	}
}
