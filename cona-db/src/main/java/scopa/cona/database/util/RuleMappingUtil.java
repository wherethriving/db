package scopa.cona.database.util;

import scopa.cona.database.manager.RuleMappingManager;
import scopa.cona.database.model.RuleAttrMapping;
import scopa.cona.database.model.RuleEntity;

import java.util.List;
import java.util.Map;

/**
 * Created by zhangdekun on 16-5-17.
 */
public class RuleMappingUtil {
    public static Map<String, RuleAttrMapping> ruleMappings(Integer unischemaId){
        return DBeans.bean(RuleMappingManager.class).getRuleEntityByTargetTableId(unischemaId);
    }
}
