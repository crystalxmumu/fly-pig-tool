package top.todev.tool.auto.redux;

/**
 * @author 小飞猪
 *
 */
public class AutoGenerateEpic extends AbstractAutoGenerateForRedux {

	public AutoGenerateEpic() {
		this("epic");
	}

	public AutoGenerateEpic(String generateTargetPackage) {
		this.generateTargetPackage = generateTargetPackage;
		this.generateTemplate = "epic.ftl";
	}
	
	@Override
	protected String getGenerateFileName(String code) {
		return code.toLowerCase() + "_epic" + AbstractAutoGenerateForRedux.JS;
	}
}
