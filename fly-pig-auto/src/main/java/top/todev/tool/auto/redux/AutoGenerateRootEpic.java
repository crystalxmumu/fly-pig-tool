package top.todev.tool.auto.redux;

/**
 * @author 小飞猪
 *
 */
public class AutoGenerateRootEpic extends AbstractAutoGenerateForRedux {

	public AutoGenerateRootEpic() {
		this("epic");
	}

	public AutoGenerateRootEpic(String generateTargetPackage) {
		this.generateTargetPackage = generateTargetPackage;
		this.generateTemplate = "root_epic.ftl";
	}

	@Override
	protected String getGenerateFileName(String code) {
		return "index" + AbstractAutoGenerateForRedux.JS;
	}
}
