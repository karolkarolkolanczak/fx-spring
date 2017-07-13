import javax.faces.bean.ManagedBean;

/**
 * Created by a on 13/07/2017.
 */
@ManagedBean
public class Controller {
    private String userLogin;
    private String userPassword;

    public Controller() {
    }

    public String getUserLogin() {
        return userLogin;
    }

    public void setUserLogin(String userLogin) {
        this.userLogin = userLogin;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }
}
