
package UserManagerClients;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "UserManagerService", targetNamespace = "http://Controller/", wsdlLocation = "http://localhost:8282/CloudChatUserManager?wsdl")
public class UserManagerService
    extends Service
{

    private final static URL USERMANAGERSERVICE_WSDL_LOCATION;
    private final static WebServiceException USERMANAGERSERVICE_EXCEPTION;
    private final static QName USERMANAGERSERVICE_QNAME = new QName("http://Controller/", "UserManagerService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:8282/CloudChatUserManager?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        USERMANAGERSERVICE_WSDL_LOCATION = url;
        USERMANAGERSERVICE_EXCEPTION = e;
    }

    public UserManagerService() {
        super(__getWsdlLocation(), USERMANAGERSERVICE_QNAME);
    }

    public UserManagerService(WebServiceFeature... features) {
        super(__getWsdlLocation(), USERMANAGERSERVICE_QNAME, features);
    }

    public UserManagerService(URL wsdlLocation) {
        super(wsdlLocation, USERMANAGERSERVICE_QNAME);
    }

    public UserManagerService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, USERMANAGERSERVICE_QNAME, features);
    }

    public UserManagerService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public UserManagerService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns UserManager
     */
    @WebEndpoint(name = "UserManagerPort")
    public UserManager getUserManagerPort() {
        return super.getPort(new QName("http://Controller/", "UserManagerPort"), UserManager.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns UserManager
     */
    @WebEndpoint(name = "UserManagerPort")
    public UserManager getUserManagerPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://Controller/", "UserManagerPort"), UserManager.class, features);
    }

    private static URL __getWsdlLocation() {
        if (USERMANAGERSERVICE_EXCEPTION!= null) {
            throw USERMANAGERSERVICE_EXCEPTION;
        }
        return USERMANAGERSERVICE_WSDL_LOCATION;
    }

}
