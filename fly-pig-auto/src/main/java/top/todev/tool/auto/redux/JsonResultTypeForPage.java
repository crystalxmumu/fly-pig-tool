package top.todev.tool.auto.redux;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import top.todev.tool.model.constant.IStaticDataEnum;

/**
 * Created by hk on 2017/7/18.
 * @author 小飞猪
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class JsonResultTypeForPage {

    private String name;
    private String code;
    private String path;
    private IStaticDataEnum<String>[] types;
}
