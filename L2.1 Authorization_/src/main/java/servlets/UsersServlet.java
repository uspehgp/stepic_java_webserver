package servlets;

import accounts.AccountService;
import accounts.UserProfile;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author v.chibrikov
 *         <p>
 *         Пример кода для курса на https://stepic.org/
 *         <p>
 *         Описание курса и лицензия: https://github.com/vitaly-chibrikov/stepic_java_webserver
 */
public class UsersServlet extends HttpServlet {
    //@SuppressWarnings({"FieldCanBeLocal", "UnusedDeclaration"}) //todo: remove after module 2 home work
    private final AccountService accountService;

    public UsersServlet(AccountService accountService) {
        this.accountService = accountService;
    }

    //get public user profile
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response) throws ServletException, IOException {
        //todo: module 2 home work
    }

    //sign up
    public void doPost(HttpServletRequest request,
                       HttpServletResponse response) throws ServletException, IOException {
			String login = request.getParameter("login");
			String pass = request.getParameter("pass");

			if (login.equals(null) || pass.equals(null)) {
					response.setContentType("text/html;charset=utf-8");
					response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
					return;
				}

			UserProfile profile = accountService.getUserByLogin(login);
            System.out.println(profile);
			if (profile == null) {
                //AccountService accountService = new AccountService();
                accountService.addNewUser(new UserProfile(login, pass));
                //accountService.addSession(String sessionId, UserProfile userProfile);
                profile = accountService.getUserByLogin(login);
                System.out.println(profile);
                //response.setContentType("text/html;charset=utf-8");
                //response.setStatus(HttpServletResponse.SC_OK);
                //return;
                accountService.addSession(request.getSession().getId(), profile);
                Gson gson = new Gson();
                String json = gson.toJson(profile);
                response.setContentType("text/html;charset=utf-8");
                response.getWriter().println(json);
                response.setStatus(HttpServletResponse.SC_OK);
            }
    }

    //change profile
    public void doPut(HttpServletRequest request,
                      HttpServletResponse response) throws ServletException, IOException {
        //todo: module 2 home work
    }

    //unregister
    public void doDelete(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {
        //todo: module 2 home work
    }
}
