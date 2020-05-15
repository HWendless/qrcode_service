package com.mobiusvision.qrcode.mapper;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import com.mobiusvision.qrcode.entity.Tobacco;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/****
 * @Author:hanwei
 * @Description:Tobacco的Dao
 * @Date 2019/6/14 0:12
 *****/
@DS("bar")
public interface TobaccoMapper extends BaseMapper<Tobacco> {

}
