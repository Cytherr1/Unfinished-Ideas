
public class admin {

private String adminusername;
private String adminpass;
	
public admin (String admin, String password) {
	adminusername = admin;
	adminpass = password;
}

public String getUsername() {
	return adminusername;
}

public void setUsername(String username) {
	adminusername = username;
}

public String getPass() {
	return adminpass;
}

public void setPass(String pass) {
	adminpass = pass;
}


}
