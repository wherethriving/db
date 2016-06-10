package scopa.cona.database.manager.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import scopa.cona.database.field.SortableFieldValue;
import scopa.cona.database.manager.DataVersionManager;
import scopa.cona.database.mappers.DataVersionMapper;
import scopa.cona.database.model.ConsumerDataVersion;
import scopa.cona.database.model.ProducerDataVersion;

import java.util.Date;
import java.util.List;

/**
 * Created by zhangdekun on 16-5-9.
 */
@Service("dataVersionManager")
public class DataVersionManagerImpl implements DataVersionManager {
    @Autowired
    private DataVersionMapper dataVersionMapper;

    public void addDataVersionProducer(Integer sourceId,Integer tableId,Integer version,Object start,Object end){


        ProducerDataVersion pv = new ProducerDataVersion();
        pv.setSourceId(sourceId);
        pv.setTableId(tableId);
        pv.setVersion(version);
        pv.setStart(new SortableFieldValue(start).serialize());
        pv.setEnd(new SortableFieldValue(end).serialize());
        dataVersionMapper.insertDataVersionProducer(pv);
    }

    @Override
    public ProducerDataVersion getOldlastProducerVersion(Integer sourceId, Integer tableId, Boolean completed) {
        ProducerDataVersion pd = new ProducerDataVersion();
        pd.setSourceId(sourceId);
        pd.setTableId(tableId);
        pd.setCompleted(completed);
        List<ProducerDataVersion> list = dataVersionMapper.selectDataVersionProduceBySourceAndTable(pd);
        if(list!=null && list.size()>0){
            return list.get(0);//根据id降序排列，取第一个就是最新的关于这个source和table的版本
        }
        return null;
    }

    @Override
    public void updateDataVersionProducer(Integer id, Integer version, Object start, Object end, Boolean completed, Date completedTime) {
        ProducerDataVersion pd = new ProducerDataVersion();
        pd.setId(id); // id must not null
        pd.setVersion(version);
        pd.setStart(new SortableFieldValue(start).serialize());
        pd.setEnd(new SortableFieldValue(end).serialize());
        pd.setCompleted(completed);
        pd.setCompletedTime(completedTime);
        dataVersionMapper.updateDataVersionProduce(pd);
    }

    @Override
    public void addDataVersionConsumer(Integer sourceId, Integer tableId, String consumerName, Integer versionProduerId, Integer version) {
        ConsumerDataVersion cv = new ConsumerDataVersion();
        cv.setConsumerName(consumerName);
        cv.setOrigId(sourceId+"_"+tableId);
        cv.setVersion(version);
        cv.setVersionProducerId(versionProduerId);
        dataVersionMapper.insertDataVersionConsumer(cv);
    }

    @Override
    public void updateDataVersionConsumer(Integer id,String consumerName, Integer versionProduerId, Integer version, Boolean consumered, Date consumeredTime) {
        ConsumerDataVersion cv = new ConsumerDataVersion();
        cv.setConsumered(consumered);
        cv.setConsumeredTime(consumeredTime);
        cv.setConsumerName(consumerName);
        cv.setId(id);//id must not null
        cv.setVersion(version);
        cv.setVersionProducerId(versionProduerId);
        dataVersionMapper.updateDataVersionConsumer(cv);
    }

    @Override
    public List<ConsumerDataVersion> consumeredList(Integer sourceId, Integer tableId, String consumerName, Boolean consumered) {
        ConsumerDataVersion cv = new ConsumerDataVersion();
        if(consumered !=null){
            cv.setConsumered(consumered);
        }
        cv.setOrigId(sourceId+"_"+tableId);
        cv.setConsumerName(consumerName);
        return dataVersionMapper.selectDataVersionConsumerByNameAndOrigId(cv);
    }

    @Override
    public List<ProducerDataVersion> producerList(Integer sourceId, Integer tableId, Boolean completed) {
        ProducerDataVersion pd = new ProducerDataVersion();
        if(completed !=null){
            pd.setCompleted(completed);
        }
        pd.setSourceId(sourceId);
        pd.setTableId(tableId);
        return dataVersionMapper.selectDataVersionProduceBySourceAndTable(pd);
    }
}
