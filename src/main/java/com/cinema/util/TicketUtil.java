package com.cinema.util;

import java.security.SecureRandom;

public class TicketUtil {

    static SecureRandom ng = null;


    public static String createUniqueNumber() {
        if (TicketUtil.ng == null) {
            ng = new SecureRandom();
        }
        long ngLong = ng.nextLong();
        ngLong = Math.abs(ngLong);
        return String.valueOf(ngLong);
    }
}
