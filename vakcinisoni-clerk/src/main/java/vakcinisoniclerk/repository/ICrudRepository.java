package vakcinisoniclerk.repository;

import org.xmldb.api.base.XMLDBException;

import java.io.File;
import java.util.Collection;

public interface ICrudRepository<T> {

    public Collection<T> findAll(String xpathExp) throws XMLDBException, ClassNotFoundException, InstantiationException, IllegalAccessException;

    public T save(T entity) throws XMLDBException, ClassNotFoundException, InstantiationException, IllegalAccessException;

    public boolean update(String documentId, String xPathSelector, String newValue) throws XMLDBException, ClassNotFoundException, InstantiationException, IllegalAccessException;

    public void delete(Long id) throws XMLDBException, ClassNotFoundException, InstantiationException, IllegalAccessException;

    public T findOne(String documentId) throws XMLDBException, ClassNotFoundException, InstantiationException, IllegalAccessException;

    File getXml(String documentId) throws XMLDBException, ClassNotFoundException, InstantiationException, IllegalAccessException;
}
