package com.xxl.job.admin.core.model;

import org.springframework.util.StringUtils;

/**
 * @author zengrongzhi 2022-06-18 20:20:00
 */
public class XxlJobTimeZone {
	
	private int id;
	private String zoneId;		// 时区id
	private String name;		// 时区名称

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

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
