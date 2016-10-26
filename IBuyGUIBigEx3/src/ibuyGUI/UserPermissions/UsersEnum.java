/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ibuyGUI.UserPermissions;

/**
 *
 * @author Basiljhs
 */
public enum UsersEnum {
    Admin("Admin","Admin"),
    Buyer("Buyer","Buyer"),
    Coordinator("Coordinator","Coordinator");

	/**
	 * password
	 */
	private final String password;

	/**
	 * username
	 */
	private final String username;

	//-------------------------------------------------------------Constructor------------------------------------------------------------------
	UsersEnum(String username, String password){
		this.username = username;
		this.password = password;
	}

	//-------------------------------------------------------------Methods----------------------------------------------------------------------
	public String getPassword() { 
		return password; 
	}
	public String getUsername() { 
		return username; 
	}
}
