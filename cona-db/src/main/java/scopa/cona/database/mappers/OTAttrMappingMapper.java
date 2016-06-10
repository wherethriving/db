package scopa.cona.database.mappers;

import scopa.cona.database.model.OTAttrMapping;
import scopa.cona.database.model.OTTableMapping;
import scopa.cona.database.model.OriginTable;

import java.util.List;

/**
 * Created by panda on 5/10/16.
 */
public interface OTAttrMappingMapper {
    OTAttrMapping selectOTAttrMappingById(int otAttrMappingId);
    void insertOTAttrMapping(OTAttrMapping otAttrMapping);
    void updateOTAttrMapping(OTAttrMapping otAttrMapping);
    void deleteOTAttrMapping(int otAttrMappingId);
    List<OTAttrMapping> selectOTAttrMappingByTAttrId(List<Integer> targetAttrId);
    List<OTAttrMapping> selectOTAttrMappingByOAttrId(List<Integer> originAttrIds);
}
