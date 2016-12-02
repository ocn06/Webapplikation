package models;

/**
 * Created by fede0004@stud.kea.dk on 22-10-2016.
 */
public class ContentModel {
	private String content;
	
	public ContentModel() {
	}
	
	public ContentModel(String content) {
		this.content = content;
	}
	
	public String getContent() {
		return content;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
	
	@Override
	public String toString() {
		return "ContentModel{" +
				"content='" + content + '\'' +
				'}';
	}
}
