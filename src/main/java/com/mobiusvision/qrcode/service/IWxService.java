package com.mobiusvision.qrcode.service;

import com.mobiusvision.qrcode.entity.WxSignVo;

public interface IWxService {

    WxSignVo getWxSign(String url) throws Exception;

    //String authRedirec(String code) throws Exception;
}
