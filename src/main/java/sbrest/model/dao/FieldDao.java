package sbrest.model.dao;

import java.util.List;

import sbrest.model.Field;

public interface FieldDao {
	Field getField(Integer id);

    List<Field> getFields();

    Field saveField(Field field);
    
    void deleteField(Integer id);
}
