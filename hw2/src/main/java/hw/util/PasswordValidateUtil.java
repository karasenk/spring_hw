package hw.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordValidateUtil {
    private static final String PASSWORD_REGEX =
            "^(?=.*[0-9])" + // содержит цифры
                    "(?=.*[a-z])" + // содержит маленькие буквы
                    "(?=.*[A-Z])" + // содержит большие буквы
                    "(?=\\S+$)" + // не содержит пробел
                    ".{8,32}$"; // от 8 до 32 символов
    private static final Pattern PASSWORD_PATTERN = Pattern.compile(PASSWORD_REGEX);

    public static boolean validate(String password) {
        if (password == null){
            return false;
        }
        Matcher matcher = PASSWORD_PATTERN.matcher(password);
        return matcher.matches();
    }
}
