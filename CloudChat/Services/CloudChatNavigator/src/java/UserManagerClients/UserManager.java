
package UserManagerClients;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "UserManager", targetNamespace = "http://Controller/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface UserManager {


    /**
     * 
     * @param arg1
     * @param arg0
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "userLogin", targetNamespace = "http://Controller/", className = "UserManagerClients.UserLogin")
    @ResponseWrapper(localName = "userLoginResponse", targetNamespace = "http://Controller/", className = "UserManagerClients.UserLoginResponse")
    @Action(input = "http://Controller/UserManager/userLoginRequest", output = "http://Controller/UserManager/userLoginResponse")
    public String userLogin(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        String arg1);

    /**
     * 
     * @param arg1
     * @param arg0
     * @return
     *     returns boolean
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "registerUser", targetNamespace = "http://Controller/", className = "UserManagerClients.RegisterUser")
    @ResponseWrapper(localName = "registerUserResponse", targetNamespace = "http://Controller/", className = "UserManagerClients.RegisterUserResponse")
    @Action(input = "http://Controller/UserManager/registerUserRequest", output = "http://Controller/UserManager/registerUserResponse")
    public boolean registerUser(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        String arg1);

    /**
     * 
     * @param arg0
     * @return
     *     returns boolean
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "userLogout", targetNamespace = "http://Controller/", className = "UserManagerClients.UserLogout")
    @ResponseWrapper(localName = "userLogoutResponse", targetNamespace = "http://Controller/", className = "UserManagerClients.UserLogoutResponse")
    @Action(input = "http://Controller/UserManager/userLogoutRequest", output = "http://Controller/UserManager/userLogoutResponse")
    public boolean userLogout(
        @WebParam(name = "arg0", targetNamespace = "")
        int arg0);

}
