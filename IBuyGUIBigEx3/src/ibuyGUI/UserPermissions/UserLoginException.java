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
public class UserLoginException extends Exception {
    private final String msg;
    public UserLoginException(){
        msg="The username or password is incorrect";
    }
    @Override
    public String toString(){
        return msg;
    }
}
