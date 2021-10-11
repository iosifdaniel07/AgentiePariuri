package agency;

public class AdminAgency {

    private static AdminAgency instance;

    private String _username;
    private String _password;

    private AdminAgency(String _username, String _password){
        this._username = _username;
        this._password = _password;
    }

    public static AdminAgency getInstance(String _username, String _password){
        if(null == instance){
            instance = new AdminAgency(_username,_password);
        }
        return instance;
    }

    public void changePassword(String newPassword){
        _password = newPassword;
    }

}
