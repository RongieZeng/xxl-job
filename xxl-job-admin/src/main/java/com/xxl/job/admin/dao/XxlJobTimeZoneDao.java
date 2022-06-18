package com.xxl.job.admin.dao;

import com.xxl.job.admin.core.model.XxlJobGroup;
import com.xxl.job.admin.core.model.XxlJobTimeZone;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by zengrongzhi on 2022/6/18.
 */
@Mapper
public interface XxlJobTimeZoneDao {

    public List<XxlJobTimeZone> findAll();

}
