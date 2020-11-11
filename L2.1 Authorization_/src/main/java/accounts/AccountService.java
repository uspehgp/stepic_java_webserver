package accounts;

import java.util.HashMap;
import java.util.Map;

/**
 * @author v.chibrikov
 *         <p>
 *         Пример кода для курса на https://stepic.org/
 *         <p>
 *         Описание курса и лицензия: https://github.com/vitaly-chibrikov/stepic_java_webserver
 */
public class AccountService {
    private final Map<String, UserProfile> loginToProfile;
    private final Map<String, UserProfile> sessionIdToProfile;

    public AccountService() {
        System.out.println("AccountService constructor");
        loginToProfile = new HashMap<>();
        sessionIdToProfile = new HashMap<>();
    }

    public void addNewUser(UserProfile userProfile) {
        System.out.println("addNewUser");
        loginToProfile.put(userProfile.getLogin(), userProfile);
        //System.out.println(loginToProfile.put(userProfile.getLogin(), userProfile));
        System.out.println(loginToProfile.size());
    }

    public UserProfile getUserByLogin(String login) {
        System.out.println("getUserByLogin "+loginToProfile.get(login));
        return loginToProfile.get(login);
    }

    public UserProfile getUserBySessionId(String sessionId) {

        return sessionIdToProfile.get(sessionId);
    }

    public void addSession(String sessionId, UserProfile userProfile) {
        sessionIdToProfile.put(sessionId, userProfile);
    }

    public void deleteSession(String sessionId) {
        sessionIdToProfile.remove(sessionId);
    }
}
