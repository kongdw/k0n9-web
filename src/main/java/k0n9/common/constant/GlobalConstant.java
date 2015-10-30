package k0n9.common.constant;

import com.google.common.collect.Maps;
import k0n9.common.annotation.MetaData;

import java.util.Map;

/**
 * 系统全局常量
 */
public abstract class GlobalConstant {

    public static final Map<Boolean, String> booleanLabelMap = Maps.newLinkedHashMap();

    static {
        booleanLabelMap.put(Boolean.TRUE, "是");
        booleanLabelMap.put(Boolean.FALSE, "否");
    }

    //性别  
    public static enum GenderEnum {
        @MetaData(value = "男")
        M,

        @MetaData(value = "女")
        F
    }

}
