package common;

public class validation {
//    private static String regexEmail ="(^[a-z]\\w{2,}@gmail.com)$";
    public static boolean checkEmail(String email){
        String regexEmail ="(^[a-z]\\w{2,}@gmail.com)$";
        return email.matches(regexEmail);
    }
    public static boolean checkPhoneNumber(String phone) {
        String regPhone = "^090(\\d{7})||091(\\d{7})||\\(84\\)\\+90(\\d{7})||\\(84\\)\\+91(\\d{7})$";
        return phone.matches(regPhone);
    }
    public static boolean checkIdCard(String phone) {
        String regIdCard = "(^\\d{10}||\\d{12})$";
        return phone.matches(regIdCard);
    }
    // them
    public static boolean checkCustomeTypeId(String idGround) {
        String regIdGround = "^CT-[0-9]{4}$"; // = CT-1234
        return idGround.matches(regIdGround);
    }
}
