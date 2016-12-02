package businesslogic;

import dataaccessobject.LoginDAO;
import dataaccessobject.LoginDAOImplementation;
import models.ContentModel;
import models.CredModel;

import java.util.List;

/**
 * Created by fede0004@stud.kea.dk on 22-10-2016.
 */
public class LoginImplementation implements Login {
	
	public CredModel fetchUser(String username, String password) {
		LoginDAO loginDAO = new LoginDAOImplementation();
		return loginDAO.fetchUser(username, password);
	}
	
	public List<ContentModel> fetchContent() {
		LoginDAO loginDAO = new LoginDAOImplementation();
		return loginDAO.fetchContent();
	}
	
	public boolean addContent(ContentModel content) {
		LoginDAO loginDAO = new LoginDAOImplementation();
		return loginDAO.addContent(content);
	}
}
