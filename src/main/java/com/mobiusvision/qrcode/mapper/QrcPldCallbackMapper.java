package com.mobiusvision.qrcode.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mobiusvision.qrcode.entity.QrcPldCallback;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author chengkai.mao
 * @since 2019-12-16
 */
public interface QrcPldCallbackMapper extends BaseMapper<QrcPldCallback> {

    Integer selectCountByQrcode(@Param("qrcode") String qrcode, @Param("begin") String begin, @Param("end") String end);

    Integer updateCheckTimes (@Param("id") String id);
}
