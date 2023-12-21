import java.util.HashMap;

public class IDandPasswords {

    static HashMap<String, String> logininfo = new HashMap<>();

    IDandPasswords() {

        logininfo.put("Mike", "123abc");
        logininfo.put("Nicole", "password");
        logininfo.put("Dummy", "abc123");

        System.out.println(logininfo);
        //Printing them out to copy and paste later
    }

    protected static HashMap getLoginInfo() {
        return logininfo;
    }
}

