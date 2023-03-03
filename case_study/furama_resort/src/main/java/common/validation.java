package common;

import model.Contract;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.regex.Pattern;

public class validation{
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
    public static boolean checkIdContract(String idContract) {
        String regIdGround = "^HD-[0-9]{2}$"; // = HD-12
        return idContract.matches(regIdGround);
    }

    public static final String REGDATE = "^(?:(?:31(/)(?:0?[13578]|1[02]))\\1|(?:(?:29|30)(/)(?:0?[13-9]|1[0-2])\\2))(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$|^(?:29(/)0?2\\3(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\\d|2[0-8])(/)(?:(?:0?[1-9])|(?:1[0-2]))\\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$";

    public static boolean checkDate(String startDate, String endDate) {
        if (Pattern.matches(REGDATE, startDate) && Pattern.matches(REGDATE, endDate)) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate startDay = LocalDate.parse(startDate, formatter);
            LocalDate endDay = LocalDate.parse(endDate, formatter);
            long current = ChronoUnit.DAYS.between(startDay, endDay);
            if (current < 0) {
                return true;
            }
        }
        return false;
    }
}
