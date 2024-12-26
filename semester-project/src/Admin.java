
class Admin {
    static final String USERNAME = "admin";
    static final String PASSWORD = "admin123";

    public static boolean authenticate(String username, String password) {
        return USERNAME.equals(username) && PASSWORD.equals(password);
    }
}

