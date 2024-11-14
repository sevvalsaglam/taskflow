package com.workintech.taskflow.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateUtil {

    public static boolean isBeforeToday(LocalDate date) {
        return date.isBefore(LocalDate.now());
    }

    public static String formatDate(LocalDate date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return date.format(formatter);
    }
}
