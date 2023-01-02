package me.parkjun5.date;

import java.text.SimpleDateFormat;
import java.time.*;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class App {
    public static void main(String[] args) {
//        사람용TIMEAPI();
        기계용TIMEAPI();

    }

    private static void 사람용TIMEAPI() {
        int year = 2022;
        LocalDateTime of = LocalDateTime.of(year, 12, 2, 0, 0);
        System.out.println("of = " + of);

        ZonedDateTime zonedDateTime = of.atZone(
                ZoneId.of(ZoneId.getAvailableZoneIds().stream().findFirst().get()));
        System.out.println("zonedDateTime = " + zonedDateTime);

        LocalDateTime localDateTime = of.plusMonths(2);
        LocalDate localDate1 = of.toLocalDate();
        LocalDate localDate2= localDateTime.toLocalDate();
        Period between = Period.between(localDate1, localDate2);
        System.out.println("between = " + between.get(ChronoUnit.MONTHS));
    }

    private static void 기계용TIMEAPI() {
        Instant now = Instant.now();
        System.out.println("now = " + now);//기준시 UTC, GMT
        Instant plus = now.plus(10, ChronoUnit.SECONDS);


        ZoneId zone = ZoneId.systemDefault();
        System.out.println("zone = " + zone);
        ZonedDateTime zonedDateTime = now.atZone(zone);
        System.out.println("zonedDateTime = " + zonedDateTime);

        Duration between = Duration.between(now, plus);
        System.out.println("between = " + between);
        System.out.println("between.get(ChronoUnit.SECONDS) = " + between.get(ChronoUnit.SECONDS));
    }

    private void pastTime() {
        Date date = new Date();
        long time = date.getTime();
        System.out.println("time = " + time);

        Calendar calendar = new GregorianCalendar(1995, 12, 2);

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
    }
}
