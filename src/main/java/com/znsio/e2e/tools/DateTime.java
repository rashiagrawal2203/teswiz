package com.znsio.e2e.tools;

import java.time.*;
import java.time.format.*;

public class DateTime {
    public synchronized static String getFormattedMeetingTime(int minutes) {
        ZonedDateTime now = ZonedDateTime.parse(ZonedDateTime.now(ZoneOffset.UTC).format(DateTimeFormatter.ISO_INSTANT));
        ZonedDateTime updated = now.plusMinutes(minutes);
        return updated.toString();
    }
}
