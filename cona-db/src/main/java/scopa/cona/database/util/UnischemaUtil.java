package scopa.cona.database.util;

import scopa.cona.database.manager.RuleMappingManager;
import scopa.cona.database.manager.TargetAttrManager;
import scopa.cona.database.manager.TargetTableManager;
import scopa.cona.database.model.RuleDef;
import scopa.cona.database.model.TargetAttr;
import scopa.cona.database.model.TargetTable;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by zhangdekun on 16-5-13.
 */
public class UnischemaUtil {
    public static List<String> getAttrName(Integer unischemaId){
        List<TargetAttr> targetAttrs = DBeans.bean(TargetAttrManager.class).getTargetAttrByTargetTableId(unischemaId);
        List<String> attrNames = new ArrayList<>();
        if(targetAttrs !=null){
            for(TargetAttr targetAttr:targetAttrs){
                attrNames.add(targetAttr.getAttrNameEn());
            }
        }
        return attrNames;
    }
    public Map<String,List<RuleDef>> getAttr2Rule(Integer unischemaId){
        TargetTable targetTable = DBeans.bean(TargetTableManager.class).selectTargetTableById(unischemaId);
        DBeans.bean(RuleMappingManager.class).selectRuleMappingById(1);
        return null;//todo
    }
}
