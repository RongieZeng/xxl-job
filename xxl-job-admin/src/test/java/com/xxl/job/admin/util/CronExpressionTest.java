package com.xxl.job.admin.util;

import com.xxl.job.admin.core.cron.CronExpression;
import org.junit.jupiter.api.Test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.util.Date;
import java.util.TimeZone;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * CronExpression test
 *
 * @author xuxueli 2022-06-12 17:00:00
 */
public class CronExpressionTest {

    @Test
    public void getNextValidTimeAfter() throws ParseException {

        CronExpression cronExpression = new CronExpression("0 5/5 1-2 * * ?");
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date fromDate = df.parse("2022-06-12 17:00:00");

        Date nextValidTime = cronExpression.getNextValidTimeAfter(fromDate);
        assertEquals(df.parse("2022-06-13 01:05:00"), nextValidTime);

        cronExpression.setTimeZone(TimeZone.getTimeZone(ZoneId.of("Asia/Jakarta")));
        nextValidTime = cronExpression.getNextValidTimeAfter(fromDate);
        assertEquals(df.parse("2022-06-13 02:05:00"), nextValidTime);
    }
}
