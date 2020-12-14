package top.todev.tool.auto.redux;

/**
 * @author 小飞猪
 *
 */
public class AutoGeneratePage extends AbstractAutoGenerateForRedux {

	public AutoGeneratePage() {
		this("page");
	}
	
	public AutoGeneratePage(String generateTargetPackage) {
		this.generateTargetPackage = generateTargetPackage;
		this.generateTemplate = "page.ftl";
	}
}
