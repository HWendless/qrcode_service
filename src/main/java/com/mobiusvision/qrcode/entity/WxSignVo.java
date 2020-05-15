package com.mobiusvision.qrcode.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
public class WxSignVo implements Serializable {

    private String appId;
    private Long timestamp;
    private String nonceStr;
    private String signature;
    private String ticket;
}
