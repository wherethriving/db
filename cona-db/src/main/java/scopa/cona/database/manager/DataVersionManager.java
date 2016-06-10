package scopa.cona.database.manager;

import scopa.cona.database.model.ConsumerDataVersion;
import scopa.cona.database.model.ProducerDataVersion;

import java.util.Date;
import java.util.List;

/**
 * Created by zhangdekun on 16-5-9.
 */
public interface DataVersionManager {
    public void addDataVersionProducer(Integer sourceId,Integer tableId,Integer version,Object start,Object end);
    public ProducerDataVersion getOldlastProducerVersion(Integer sourceId,Integer tableId,Boolean completed);
    public void updateDataVersionProducer(Integer id,Integer version,Object start,Object end,Boolean completed,Date completedTime);
    public void addDataVersionConsumer(Integer sourceId,Integer tableId,String consumerName,Integer versionProduerId,Integer version);
    public void updateDataVersionConsumer(Integer id,String consumerName,Integer versionProduerId,Integer version,Boolean consumered,Date consumeredTime);
    public List<ConsumerDataVersion> consumeredList(Integer sourceId,Integer tableId,String consumerName,Boolean consumered);
    public List<ProducerDataVersion> producerList(Integer sourceId,Integer tableId,Boolean completed);
}
