package scopa.cona.database.mappers;

import org.apache.ibatis.annotations.Param;
import scopa.cona.database.model.DataSourceInfo;
import scopa.cona.database.model.OriginAttr;

import java.util.List;

/**
 * Created by panda on 5/10/16.
 */
public interface OriginAttrMapper {
    OriginAttr selectOriginAttrById(int originAttrId);
    void insertOriginAttr(OriginAttr originAttr);
    void updateOriginAttr(OriginAttr originAttr);
    void deleteOriginAttr(int originAttrId);
    List<OriginAttr> getOAttrByOTableName(List<Integer> originTableName);
    void insertBatchOriginAttrs(List<OriginAttr> originAttrs);
}
