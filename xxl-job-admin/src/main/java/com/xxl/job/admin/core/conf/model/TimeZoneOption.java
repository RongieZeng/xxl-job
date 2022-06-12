package com.xxl.job.admin.core.conf.model;

/**
 * 时区配置选项
 *
 * @author zengrongzhi 2022-06-06 17:00:00
 */
public class TimeZoneOption {

    /**
     * 时区id
     */
    private String zoneId;

    /**
     * 显示名称
     */
    private String name;

    public String getZoneId() {
        return zoneId;
    }

    public void setZoneId(String zoneId) {
        this.zoneId = zoneId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
