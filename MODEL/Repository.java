package MODEL;

import Serializator.Serializator;

import java.io.Serializable;
import java.util.Collection;

public abstract class Repository<T, K> implements Serializable {
    /**
     * Carga un repositorio de proyectos desde un archivo.
     * Utiliza el deserializador para cargar el repositorio desde el archivo especificado.
     *
     * @return El repositorio de proyectos cargado desde el archivo.
     */
    public static Repository load(String filename) {
        return Serializator.desearize(filename);
    }

    public boolean save(String filename) {
        return Serializator.serialize(this, filename);
    }

    public abstract T add(T data);

    public abstract T getByName(K p);

    public abstract Collection<T> getAll();

    public abstract T update(T p);

    public abstract boolean delete(K p);

}
