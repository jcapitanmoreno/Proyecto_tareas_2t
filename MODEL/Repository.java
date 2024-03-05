package MODEL;

import Serializator.Serializator;

import java.io.Serializable;
import java.util.Collection;

public abstract class Repository<T, K> implements Serializable {

    public static Repository load(String filename){
        return Serializator.desearize(filename);
    }
    public boolean save (String filename){
        return Serializator.serialize(this,filename);
    }
    public abstract T add(T data);
    public abstract T getByName(K p);
    public abstract Collection<T> getAll();
    public abstract T update(T p);
    public abstract boolean delete(K p);

}
