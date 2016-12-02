package dataaccessobject;

import models.ContentModel;
import models.CredModel;

import java.util.List;

/**
 * Created by fede0004@stud.kea.dk on 22-10-2016.
 */
public interface LoginDAO {
	public CredModel fetchUser(String username, String password);
	public List<ContentModel> fetchContent();
	public boolean addContent(ContentModel content);
}
