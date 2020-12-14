package top.todev.tool.auto.redux;

/**
 * @author 小飞猪
 *
 */
public class AutoGenerateReducer extends AbstractAutoGenerateForRedux {

	public AutoGenerateReducer() {
		this("reducer");
	}
	
	public AutoGenerateReducer(String generateTargetPackage) {
		this.generateTargetPackage = generateTargetPackage;
		this.generateTemplate = "reducer.ftl";
	}
	
	@Override
	protected String getGenerateFileName(String code) {
		return code.toLowerCase() + AbstractAutoGenerateForRedux.JS;
	}
}
