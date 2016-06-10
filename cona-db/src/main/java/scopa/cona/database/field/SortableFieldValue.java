package scopa.cona.database.field;


import java.io.*;

/**
 * Created by zhangdekun on 16-5-9.
 */
public class SortableFieldValue implements Sortable {
    private  Object value;
    public SortableFieldValue(){

    }
    public SortableFieldValue(Object value){
        this.value = value;
    }
    @Override
    public Object getValue() {
        return value;
    }
    public  byte[] serialize(){
        try(ByteArrayOutputStream byteArrayOutputStream =new ByteArrayOutputStream();ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream)) {
            objectOutputStream.writeObject(this);
            return byteArrayOutputStream.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    public void deserialize(byte[] bytes){
        try(ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream)) {
            value= ((SortableFieldValue)objectInputStream.readObject()).getValue();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
