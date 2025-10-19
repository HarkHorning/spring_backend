package hark.ecom.validators;

public class ValidPassword {

    public static boolean validPassword(String password){
        return password.length() > 12 & password.length() < 20;
    }
}
