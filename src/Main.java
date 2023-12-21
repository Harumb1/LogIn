public class Main {
    public static void main(String args[]) {
        IDandPasswords idandpasswords = new IDandPasswords();


        LoginPage loginPage = new LoginPage(IDandPasswords.getLoginInfo());

    }
}