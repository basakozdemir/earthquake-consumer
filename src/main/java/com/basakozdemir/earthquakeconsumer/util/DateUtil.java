package com.basakozdemir.earthquakeconsumer.util;

import java.time.LocalDate;

public class DateUtil {

    public static LocalDate getDateXDaysAgo(int days){

        LocalDate endDate = LocalDate.now();
        LocalDate startDate = endDate.minusDays(days);
        return startDate;

    }
}
