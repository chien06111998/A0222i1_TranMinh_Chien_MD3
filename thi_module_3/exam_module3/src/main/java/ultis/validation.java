package ultis;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class validation {
    public static boolean checkId(String id) {
        String regIdGround = "^HD-[0-9]{2}$"; // = HD-12
        return id.matches(regIdGround);
    }
    //Check id trung
    public static boolean checkIdExists(String id) {
//        iMatBangRp matBangRp = new matBangRpImpl();
//        List<MatBang> list = new ArrayList<>();
//        list = matBangRp.selectAll();
//        for (int i = 0; i < list.size(); i++) {
//            if (id.equals(list.get(i).getId())) {
//                return false;
//            }
//        }
        return true;
    }

    public static boolean checkArea(int areaGround) {
        return areaGround > 20;
    }

    public static boolean checkPrice(Double price) {
        return price > 1000000;
    }

    public static Date formatDate(String date) {
        DateTimeFormatter formatterStart = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter formatterEnd = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return Date.valueOf(LocalDateTime.parse(date, formatterStart).format(formatterEnd));
    }

//     chuyển dd/mm/yyyy thành yyyy/mm/dd để chuyển qua cho mySQL

    public static String dateSql(String dateOfSql) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        return LocalDate.parse(dateOfSql, formatter).format(formatter2);
    }

    public static final String REGDATE = "^(?:(?:31(/)(?:0?[13578]|1[02]))\\1|(?:(?:29|30)(/)(?:0?[13-9]|1[0-2])\\2))(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$|^(?:29(/)0?2\\3(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\\d|2[0-8])(/)(?:(?:0?[1-9])|(?:1[0-2]))\\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$";

    public static boolean checkDate(String startDate, String endDate) {
        if (Pattern.matches(REGDATE, startDate) && Pattern.matches(REGDATE, endDate)) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate startDay = LocalDate.parse(startDate, formatter);
            LocalDate endDay = LocalDate.parse(endDate, formatter);
            long current = ChronoUnit.DAYS.between(startDay, endDay);
            if (current >= 180) {
                return true;
            }
        }
        return false;
    }
}
