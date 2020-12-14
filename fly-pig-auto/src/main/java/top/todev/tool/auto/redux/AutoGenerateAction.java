package top.todev.tool.auto.redux;

/**
 * @author 小飞猪
 */
public class AutoGenerateAction extends AbstractAutoGenerateForRedux {

	public AutoGenerateAction() {
		this("action");
	}
	
	public AutoGenerateAction(String generateTargetPackage) {
		this.generateTargetPackage = generateTargetPackage;
		this.generateTemplate = "action.ftl";
	}
	
	@Override
	protected String getGenerateFileName(String code) {
		return new StringBuffer(code.toLowerCase()).append("_action").append(AbstractAutoGenerateForRedux.JS).toString();
	}
}
