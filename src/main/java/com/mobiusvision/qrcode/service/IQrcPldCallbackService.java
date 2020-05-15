package com.mobiusvision.qrcode.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.mobiusvision.qrcode.entity.QrcPldCallback;
import com.mobiusvision.qrcode.entity.QrcodeCheck;
import com.mobiusvision.qrcode.mapper.QrcPldCallbackMapper;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * <p>
 *  服务类
 * </p>
 *
 * @author chengkai.mao
 * @since 2019-12-16
 */
public interface IQrcPldCallbackService extends IService<QrcPldCallback> {

    QrcodeCheck checkQrcode(String qrcode) throws Exception;
}
