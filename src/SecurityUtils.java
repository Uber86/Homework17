import java.util.regex.Pattern;

public class SecurityUtils {

    private static final Pattern PATTERN = Pattern.compile("[A-Za-z0-9_]+");
    private static final String PATTERN2 = String.valueOf(Pattern.compile("[A-Za-z0-9_]"));

    public static void check(String login, String password, String confirmPassword) {
        if (login.length() >= 20 || !PATTERN.matcher(login).matches()) {
            try {
                throw new WrongLoginException();
            } catch (WrongLoginException e) {
                throw new RuntimeException("Неправильный логин.");
            }

        }
        if (password.length() > 20 || !password.equals(confirmPassword) || checkPassword(password)) {
            try {
                throw new WrongPasswordException();
            } catch (WrongPasswordException e) {
                throw new RuntimeException("Неправельный пароль.");
            }
        }
    }

    private static boolean checkPassword(String password) {
        for (int i = 0; i < password.length(); i++) {
            if (!PATTERN2.contains(String.valueOf(password.charAt(i)))) {
                return false;
            }
            
        }
        return true;
    }
}
