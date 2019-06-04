package pl.coderslab.collection;

import java.util.regex.Pattern;

public class Main3 {

    public static void main(String[] args) {
        System.out.println(verifyLogin("check123_456-789"));
    }

    static boolean verifyLogin(String email) {
        return Pattern.matches("^[\\D][\\d\\w_-]{4,}$", email);
    }

}
