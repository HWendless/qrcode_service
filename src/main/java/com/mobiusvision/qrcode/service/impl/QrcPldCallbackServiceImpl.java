package com.mobiusvision.qrcode.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.mobiusvision.qrcode.entity.QrcPldCallback;
import com.mobiusvision.qrcode.entity.QrcodeCheck;
import com.mobiusvision.qrcode.entity.ViCustmsg;
import com.mobiusvision.qrcode.entity.ViProductmsg;
import com.mobiusvision.qrcode.mapper.QrcPldCallbackMapper;
import com.mobiusvision.qrcode.mapper.ViCustmsgMapper;
import com.mobiusvision.qrcode.mapper.ViProductmsgMapper;
import com.mobiusvision.qrcode.service.IQrcPldCallbackService;
import com.mobiusvision.qrcode.utils.PredictableException;
import com.mysql.jdbc.PacketTooBigException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author chengkai.mao
 * @since 2019-12-16
 */
@Service
public class QrcPldCallbackServiceImpl extends ServiceImpl<QrcPldCallbackMapper, QrcPldCallback> implements IQrcPldCallbackService {

    @Autowired
    private QrcPldCallbackMapper qrcPldCallbackMapper;

    @Autowired
    private ViCustmsgMapper viCustmsgMapper;

    @Override
    public QrcodeCheck checkQrcode(String qrcode) throws Exception {

        QueryWrapper<QrcPldCallback> wrapper = new QueryWrapper<>();
        wrapper.eq("QRCODE", qrcode);
        List<QrcPldCallback> qrcPldCallbacks = qrcPldCallbackMapper.selectList(wrapper);
        if(qrcPldCallbacks.size() < 1){
            throw new PredictableException("没有查询出相关条烟信息");
        }
        QrcPldCallback qrcPldCallback = qrcPldCallbacks.get(0);
        String cusCode = qrcode.substring(20,32);
        QueryWrapper<ViCustmsg> wrapper1 = new QueryWrapper<>();
        wrapper1.eq("LICENSE_CODE", cusCode);
        List<ViCustmsg> viCustmsgs = viCustmsgMapper.selectList(wrapper1);

        QrcodeCheck qrcodeCheck = new QrcodeCheck();
        qrcodeCheck.setCheckTimes(qrcPldCallback.getCheckTimes());
        qrcodeCheck.setQrcode(qrcode);
        qrcodeCheck.setViCustmsg(viCustmsgs.get(0));

        qrcPldCallbackMapper.updateCheckTimes(qrcPldCallback.getId());
        return qrcodeCheck;
    }
}
