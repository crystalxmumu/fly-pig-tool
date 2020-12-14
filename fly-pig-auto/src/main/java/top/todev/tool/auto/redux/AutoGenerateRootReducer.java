package top.todev.tool.auto.redux;

/**
 * @author 小飞猪
 *
 */
public class AutoGenerateRootReducer extends AbstractAutoGenerateForRedux {

	public AutoGenerateRootReducer() {
		this("reducer");
	}

	public AutoGenerateRootReducer(String generateTargetPackage) {
		this.generateTargetPackage = generateTargetPackage;
		this.generateTemplate = "root_reducer.ftl";
	}

	@Override
	protected String getGenerateFileName(String code) {
		return "index" + AbstractAutoGenerateForRedux.JS;
	}
}
