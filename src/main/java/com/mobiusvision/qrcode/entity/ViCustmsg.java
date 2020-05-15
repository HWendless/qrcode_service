package com.mobiusvision.qrcode.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author chengkai.mao
 * @since 2019-12-19
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("VI_CUSTMSG")
public class ViCustmsg implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableField("BUSI_ADDR")
    private String busiAddr;

    @TableField("MANAGER")
    private String manager;

    @TableField("LICENSE_CODE")
    private String licenseCode;

    @TableField("CUST_NAME")
    private String custName;

    @TableField("ORDER_TEL")
    private String orderTel;


}
