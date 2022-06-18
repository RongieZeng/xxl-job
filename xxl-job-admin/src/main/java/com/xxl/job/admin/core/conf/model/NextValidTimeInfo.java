package com.xxl.job.admin.core.conf.model;

import java.util.Date;

/**
 * 下一次有效时间信息
 */
public class NextValidTimeInfo {

    /**
     * 下一次有效时间
     */
    private Date nextValidTime;

    /**
     * 下一次有效时间所属时区
     */
    private String nextValidTimeZoneId;

    public Date getNextValidTime() {
        return nextValidTime;
    }

    public void setNextValidTime(Date nextValidTime) {
        this.nextValidTime = nextValidTime;
    }

    public String getNextValidTimeZoneId() {
        return nextValidTimeZoneId;
    }

    public void setNextValidTimeZoneId(String nextValidTimeZoneId) {
        this.nextValidTimeZoneId = nextValidTimeZoneId;
    }
}
