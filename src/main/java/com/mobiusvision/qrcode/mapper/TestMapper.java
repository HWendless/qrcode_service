package com.mobiusvision.qrcode.mapper;


import com.baomidou.dynamic.datasource.annotation.DS;
import com.mobiusvision.qrcode.entity.TestBean;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@DS("sqlserver")
public interface TestMapper {

    @Select("select * from BP_ORDER_CIG_INFO")
    List<TestBean> test();

}
