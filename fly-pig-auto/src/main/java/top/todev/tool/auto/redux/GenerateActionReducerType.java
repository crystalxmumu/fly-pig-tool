package top.todev.tool.auto.redux;

import java.io.IOException;
import java.net.URISyntaxException;

/**
 * @author 小飞猪
 */
public class GenerateActionReducerType {

	/**
	 * 通过Json静态数据定义生成redux数据
	 * @param resultType Json静态数据定义
	 * @throws IOException IO异常
	 * @throws URISyntaxException 解析异常
	 */
	public static void generate(JsonResultTypeForPage resultType) throws IOException, URISyntaxException {
		AutoGenerateAction action = new AutoGenerateAction();
		action.generateSingleFile(resultType, false);

		AutoGenerateEpic epic = new AutoGenerateEpic();
		epic.generateSingleFile(resultType, false);

		AutoGenerateRootEpic rootEpic = new AutoGenerateRootEpic();
		rootEpic.generateSingleFile(resultType, false);

		AutoGenerateActionType actionType = new AutoGenerateActionType();
		actionType.generateSingleFile(resultType, false);
		
		AutoGenerateContainer container = new AutoGenerateContainer();
		container.generateSingleFile(resultType, false);
		
		AutoGeneratePage page = new AutoGeneratePage();
		page.generateSingleFile(resultType, false);
		
		AutoGenerateReducer reducer = new AutoGenerateReducer();
		reducer.generateSingleFile(resultType, false);
		
		AutoGenerateRootReducer rootReducer = new AutoGenerateRootReducer();
		rootReducer.generateSingleFile(resultType, false);
	}

}
