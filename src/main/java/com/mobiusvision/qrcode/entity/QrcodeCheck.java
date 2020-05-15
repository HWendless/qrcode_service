package com.mobiusvision.qrcode.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
public class QrcodeCheck {

    private Integer checkTimes;

    private String qrcode;

    private Tobacco tobacco;

    private ViCustmsg viCustmsg;

}
