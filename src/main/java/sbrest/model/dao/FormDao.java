package sbrest.model.dao;

import java.util.List;
import sbrest.model.Form;

public interface FormDao {
	Form getForm(Integer id);

    List<Form> getForms();

    Form saveForm(Form form);
    
    void deleteForm(Integer id);
}
