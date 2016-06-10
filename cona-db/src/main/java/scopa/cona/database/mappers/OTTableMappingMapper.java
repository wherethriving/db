package scopa.cona.database.mappers;

import scopa.cona.database.model.OTAttrMapping;
import scopa.cona.database.model.OTTableMapping;

import java.util.List;

/**
 * Created by panda on 5/10/16.
 */
public interface OTTableMappingMapper {
    OTTableMapping selectOTTableMappingById(int otTableMappingId);
    void insertOTTableMapping(OTTableMapping otTableMapping);
    void updateOTTableMapping(OTTableMapping otTableMapping);
    void deleteOTTableMapping(int otTableMappingId);

}
