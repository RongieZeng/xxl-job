package com.xxl.job.admin.util;

import com.xxl.job.admin.core.conf.model.NextValidTimeInfo;
import com.xxl.job.admin.core.model.XxlJobInfo;
import com.xxl.job.admin.core.scheduler.ScheduleTypeEnum;
import com.xxl.job.admin.core.thread.JobScheduleHelper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * JobScheduleHelper test
 *
 * @author xuxueli 2022-06-12 17:00:00
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class JobScheduleHelperTest {

    @Test
    public void generateNextValidTime() throws Exception {

        XxlJobInfo xxlJobInfo = new XxlJobInfo();
        xxlJobInfo.setScheduleType(ScheduleTypeEnum.CRON.name());
        xxlJobInfo.setScheduleConf("0 5/5 1-2 * * ?");
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date fromDate = df.parse("2022-06-12 17:00:00");

        NextValidTimeInfo nextValidTimeInfo;
        nextValidTimeInfo = JobScheduleHelper.generateNextValidTime(xxlJobInfo, fromDate);
        assertNotNull(nextValidTimeInfo);
        assertEquals(df.parse("2022-06-13 01:05:00"), nextValidTimeInfo.getNextValidTime());

        xxlJobInfo.setScheduleTimeZoneId("Asia/Jakarta");
        nextValidTimeInfo = JobScheduleHelper.generateNextValidTime(xxlJobInfo, fromDate);
        assertNotNull(nextValidTimeInfo);
        assertEquals(df.parse("2022-06-13 02:05:00"), nextValidTimeInfo.getNextValidTime());
        assertEquals("Asia/Jakarta", nextValidTimeInfo.getNextValidTimeZoneId());

        // 多时区，且不存在与世界时差距一样的时区
        xxlJobInfo.setScheduleTimeZoneId("Asia/Jakarta,Asia/Shanghai");
        nextValidTimeInfo = JobScheduleHelper.generateNextValidTime(xxlJobInfo, fromDate);
        assertNotNull(nextValidTimeInfo);
        assertEquals(df.parse("2022-06-13 01:05:00"), nextValidTimeInfo.getNextValidTime());
        assertEquals("Asia/Shanghai", nextValidTimeInfo.getNextValidTimeZoneId());

        // 多时区，且存在两个与世界时差距一样的时区
        xxlJobInfo.setScheduleTimeZoneId("Asia/Jakarta,Asia/Shanghai,Asia/Singapore");
        nextValidTimeInfo = JobScheduleHelper.generateNextValidTime(xxlJobInfo, fromDate);
        assertNotNull(nextValidTimeInfo);
        assertEquals(df.parse("2022-06-13 01:05:00"), nextValidTimeInfo.getNextValidTime());
        assertEquals("Asia/Shanghai,Asia/Singapore", nextValidTimeInfo.getNextValidTimeZoneId());
    }
}
