package models;

/**
 * Created by fede0004@stud.kea.dk on 22-10-2016.
 */
public class CredModel {
	private String username;
	private String password;
	private String role;
	
	public CredModel() {
	}
	
	public CredModel(String username, String password, String role) {
		this.username = username;
		this.password = password;
		this.role = role;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getRole() {
		return role;
	}
	
	public void setRole(String role) {
		this.role = role;
	}
	
	@Override
	public String toString() {
		return "CredModel{" +
				"username='" + username + '\'' +
				", password='" + password + '\'' +
				", role='" + role + '\'' +
				'}';
	}
}
