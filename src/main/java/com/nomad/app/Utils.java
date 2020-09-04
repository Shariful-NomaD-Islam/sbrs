package com.nomad.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;


public class Utils {
    private static final Logger logger = LoggerFactory.getLogger(Utils.class);

    public static String toCSV(Collection<String> collection) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String s : collection) {
            stringBuilder.append(s).append(",");
        }

        if (stringBuilder.length() > 0) {
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }

        return stringBuilder.toString();
    }

    public static List<String> asList(String csv) {
        if (csv == null) {
            return new ArrayList<String>();
        }

        return Arrays.asList(csv
                .replaceAll("^[,\\s]+", "")
                .replaceAll("[,\\s]+$", "")
                .replaceAll("[,\\s]+", ";").split(";"));
    }

    public static Date parseDateFromString(String dateInString) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        try {
            return formatter.parse(dateInString);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void logMemoryStatus() {
        logMemoryStatus("");
    }

    public static void logMemoryStatus(String prefix) {
        DecimalFormat formatter = new DecimalFormat("#0000.0000");
        long total = Runtime.getRuntime().totalMemory();
        double totald = ((total * 1.0) / 1024) / 1024;
        long free = Runtime.getRuntime().freeMemory();
        double freed = ((free * 1.0) / 1024) / 1024;
        logger.info("{}, memory stats: total {} MB, used {} MB", prefix, formatter.format(totald), formatter.format(totald - freed));
    }

}
