
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.HttpServletRequestUtil;
import dao.CrudDAO;
import exceptions.UserAlreadyExistsException;
import java.sql.Time;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.annotation.WebServlet;
import model.User;
import model.Message;
import util.Crypto;

@WebServlet(urlPatterns = {"/"})
public class CloudChatDAO extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private CrudDAO dao;

    public CloudChatDAO() {
        dao = new CrudDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        switch (action) {
            case "register":
                String username = request.getParameter("username");
                String password = request.getParameter("password");

                String[] keys1 = {username, password};
                //if (!HttpServletRequestUtil.requestContainsKeys(request, keys1)) {
                //    System.out.println("Request does not contain all required params.");
                //    return;
                //}

                String salt = UUID.randomUUID().toString();
                password = Crypto.sha1(password + salt);

                User user = new User(username, password, salt, new Time(System.currentTimeMillis()));

                try {
                    dao.addUser(user);
                } catch (UserAlreadyExistsException ex) {
                    //TODO: Send error that the user already exists
                    Logger.getLogger(CloudChatDAO.class.getName()).log(Level.SEVERE, null, ex);
                }

                break;

            case "message":
                String msgText = request.getParameter("message");
                String userId = request.getParameter("userId");
                String roomId = request.getParameter("roomId");

                String[] keys2 = {msgText, userId, roomId};
                //if (!HttpServletRequestUtil.requestContainsKeys(request, keys2)) {
                //    System.out.println("Request does not contain all required params.");
                //    return;
                //}

                int roomIdInt;
                int userIdInt = roomIdInt = -1;

                try {
                    userIdInt = Integer.parseInt(userId);
                    roomIdInt = Integer.parseInt(roomId);
                } catch (NumberFormatException e) {
                    System.out.println("Error parsing userId or roomId in action 'message': " + e);
                    return;
                }

                Message message = new Message(msgText, userIdInt, roomIdInt, new Time(System.currentTimeMillis()));

                dao.addMessage(message);
                break;
        }
    }
}
