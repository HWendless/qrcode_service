package com.mobiusvision.qrcode.controller;


import com.mobiusvision.qrcode.service.IWxService;
import com.mobiusvision.qrcode.utils.ResultInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/wx")
@Api(tags = "微信公众号")
public class WxController {

    @Autowired
    private IWxService wxService;


    @GetMapping("jssdk-sign")
    @ApiOperation("获取微信公众号签名")
    @ResponseBody
    public ResultInfo getSdkSign(@RequestParam("url")String url) throws Exception {
        return ResultInfo.success(200,null, wxService.getWxSign(url));
    }

    /*@GetMapping("auth-redirec")
    @ApiOperation("公众号授权回调")
    public String authRedirec(HttpServletRequest request) throws Exception {
        String code = request.getParameter("code");
        return wxService.authRedirec(code);
    }*/
}
