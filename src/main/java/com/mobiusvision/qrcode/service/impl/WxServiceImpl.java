package com.mobiusvision.qrcode.service.impl;


import com.mobiusvision.qrcode.entity.WxSignVo;
import com.mobiusvision.qrcode.service.IWxService;
import com.mobiusvision.qrcode.utils.JsonUtils;
import com.mobiusvision.qrcode.utils.PredictableException;
import com.mobiusvision.qrcode.utils.SecretUtil;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class WxServiceImpl implements IWxService {

    // 获取公众号平台token(jsapi签名用)
    private String getWxTokenUrl = "https://api.weixin.qq.com/cgi-bin/token";
    // 获取公众号平台token(用来获取userinfo)
    private String getAccessTokenUrl = "https://api.weixin.qq.com/sns/oauth2/access_token";
    // 获取授权页面调用jsapi的ticket
    private String getWxTicketUrl = "https://api.weixin.qq.com/cgi-bin/ticket/getticket";
    // 获取用户信息
    private String getUserInfoUrl = "https://api.weixin.qq.com/sns/userinfo";

    @Value("${wx.public.appid}")
    private String appid;
    @Value("${wx.public.secret}")
    private String secret;

    @Autowired
    private HttpClient httpClient;

    @Override
    public WxSignVo getWxSign(String url) throws Exception {
        String token = getToken();
        String ticket = getTicket(token, "jsapi");
        String noncestr = SecretUtil.uuid();
        long timestamp = LocalDateTime.now().toEpochSecond(ZoneOffset.of("+8"));

        String str1 = "jsapi_ticket="+ticket + "&noncestr=" + noncestr + "&timestamp=" + timestamp + "&url=" + url;
        String sign = SecretUtil.shaEncode(str1);
        return new WxSignVo(appid,timestamp,noncestr,sign,ticket);

    }

    /*@Override
    public String authRedirec(String code) throws Exception {
        String tokenResult = this.getAccessToken(code);
        Map map = JsonUtils.jsonToPojo(tokenResult, Map.class);
        String access_token = (String)map.get("access_token");
        String openId = (String)map.get("openid");
        String userInfo = this.getUserInfo(access_token, openId);
        String sign = JwtUtil.sign(
                SecretUtil.uuid(),
                "mobiusvision",
                userInfo,
                DateUtil.localTimeToDate(LocalDateTime.now()),
                DateUtil.localTimeToDate(LocalDateTime.ofInstant(Instant.ofEpochMilli(System.currentTimeMillis() + 1800000), ZoneId.systemDefault())),
                DateUtil.localTimeToDate(LocalDateTime.now()),
                userInfo,
                "qrcode"
        );
        System.out.println(sign);
        return "redirect:https://qrcode.mobius-vision.com/#/home?token="+sign;
    }
    */

    private String getToken()throws Exception{
        StringBuffer out = new StringBuffer();
        BufferedReader in = null;
        try{
            List<BasicNameValuePair> list = new ArrayList<BasicNameValuePair>();
            list.add(new BasicNameValuePair("appid", appid));
            list.add(new BasicNameValuePair("secret", secret));
            list.add(new BasicNameValuePair("grant_type", "client_credential"));
            String params = EntityUtils.toString(new UrlEncodedFormEntity(list, Consts.UTF_8));
            HttpGet httpGet = new HttpGet(getWxTokenUrl + "?" + params);
            HttpEntity entity = httpClient.execute(httpGet).getEntity();
            InputStream content = entity.getContent();
            in = new BufferedReader(new InputStreamReader(content, Charset.forName("UTF-8")));
            String line;
            while ((line = in.readLine()) != null) {
                out.append(line);
            }
            in.close();

            Map map = JsonUtils.jsonToPojo(out.toString(), Map.class);
            String access_token = (String)map.get("access_token");
            if(StringUtils.isBlank(access_token)){
                throw new PredictableException(out.toString());
            }
            return access_token;
        }catch (Exception e){
            e.printStackTrace();
            throw e;
        }finally {
            if(null != in)
             in.close();
        }
    }

    private String getTicket(String token, String type) throws IOException {
        StringBuffer out = new StringBuffer();
        BufferedReader in = null;
        try{
            List<BasicNameValuePair> list = new ArrayList<BasicNameValuePair>();
            list.add(new BasicNameValuePair("access_token", token));
            list.add(new BasicNameValuePair("type", type));
            String params = EntityUtils.toString(new UrlEncodedFormEntity(list, Consts.UTF_8));
            HttpGet httpGet = new HttpGet(getWxTicketUrl + "?" + params);
            HttpEntity entity = httpClient.execute(httpGet).getEntity();
            InputStream content = entity.getContent();
            in = new BufferedReader(new InputStreamReader(content, Charset.forName("UTF-8")));
            String line;
            while ((line = in.readLine()) != null) {
                out.append(line);
            }
            in.close();

            Map map = JsonUtils.jsonToPojo(out.toString(), Map.class);
            String ticket = (String)map.get("ticket");
            if(StringUtils.isBlank(ticket)){
                throw new PredictableException(out.toString());
            }
            return ticket;
        }catch (Exception e){
            e.printStackTrace();
            throw e;
        }finally {
            if (null != in)
                in.close();
        }

    }

    private String getAccessToken(String code) throws IOException {
        StringBuffer out = new StringBuffer();
        BufferedReader in = null;
        try{
            List<BasicNameValuePair> list = new ArrayList<BasicNameValuePair>();
            list.add(new BasicNameValuePair("appid", appid));
            list.add(new BasicNameValuePair("secret", secret));
            list.add(new BasicNameValuePair("code", code));
            list.add(new BasicNameValuePair("grant_type", "authorization_code"));
            String params = EntityUtils.toString(new UrlEncodedFormEntity(list, Consts.UTF_8));
            HttpGet httpGet = new HttpGet(getAccessTokenUrl + "?" + params);
            HttpEntity entity = httpClient.execute(httpGet).getEntity();
            InputStream content = entity.getContent();
            in = new BufferedReader(new InputStreamReader(content, Charset.forName("UTF-8")));
            String line;
            while ((line = in.readLine()) != null) {
                out.append(line);
            }
            in.close();
            String result = out.toString();
            Map map = JsonUtils.jsonToPojo(result, Map.class);
            String token = (String)map.get("access_token");
            if(StringUtils.isBlank(token)){
                throw new PredictableException(out.toString());
            }
            return result;
        }catch (Exception e){
            e.printStackTrace();
            throw e;
        }finally {
            if (null != in)
                in.close();
        }
    }

    private String getUserInfo(String accessToken, String openId) throws IOException {
        StringBuffer out = new StringBuffer();
        BufferedReader in = null;
        try{
            List<BasicNameValuePair> list = new ArrayList<BasicNameValuePair>();
            list.add(new BasicNameValuePair("access_token", accessToken));
            list.add(new BasicNameValuePair("openid", openId));
            list.add(new BasicNameValuePair("lang", "zh_CN"));
            String params = EntityUtils.toString(new UrlEncodedFormEntity(list, Consts.UTF_8));
            HttpGet httpGet = new HttpGet(getUserInfoUrl + "?" + params);
            HttpEntity entity = httpClient.execute(httpGet).getEntity();
            InputStream content = entity.getContent();
            in = new BufferedReader(new InputStreamReader(content, Charset.forName("UTF-8")));
            String line;
            while ((line = in.readLine()) != null) {
                out.append(line);
            }
            in.close();
            String result = out.toString();
            Map map = JsonUtils.jsonToPojo(result, Map.class);
            String errcode = (String)map.get("errcode");
            if(StringUtils.isNotBlank(errcode)){
                throw new PredictableException(out.toString());
            }
            return result;
        }catch (Exception e){
            e.printStackTrace();
            throw e;
        }finally {
            if (null != in)
                in.close();
        }
    }
}
