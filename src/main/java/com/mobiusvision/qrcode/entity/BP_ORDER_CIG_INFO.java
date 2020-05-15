package com.mobiusvision.qrcode.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.math.BigDecimal;
import java.math.BigInteger;


@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
//执行订单明细信息表
public class BP_ORDER_CIG_INFO {

//     [OCI_ID] bigint  IDENTITY(1,1) NOT NULL,
    private BigInteger OCI_ID;
//  [OCI_UUID] varchar(64) COLLATE Chinese_PRC_CI_AS  NOT NULL,
    private String OCI_UUID;
//  [OCI_CIG_BRAND] varchar(13) COLLATE Chinese_PRC_CI_AS  NOT NULL,
    private String OCI_CIG_BRAND;
//  [OCI_CIG_TRADEMARK] varchar(100) COLLATE Chinese_PRC_CI_AS  NOT NULL,
    private String OCI_CIG_TRADEMARK;
//  [OCI_IS_ABNORMAL] char(1) COLLATE Chinese_PRC_CI_AS  NOT NULL,
    private String OCI_IS_ABNORMAL;
//  [OCI_IS_PRINT] char(1) COLLATE Chinese_PRC_CI_AS DEFAULT (0) NOT NULL,
    private String OCI_IS_PRINT;
//  [OCI_ORDER_NUM] int DEFAULT (0) NOT NULL,
    private int OCI_ORDER_NUM;
//  [OCI_ORDER_NUM1] decimal(16,4) DEFAULT (0) NOT NULL,
    private BigDecimal  OCI_ORDER_NUM1;
//  [OCI_ACTUAL_PRICE] decimal(18,6) DEFAULT (0) NULL,
    private  BigDecimal OCI_ACTUAL_PRICE;
//            [OCI_STANDERD_PRICE] decimal(18,6) DEFAULT (0) NULL,
    private  BigDecimal OCI_STANDERD_PRICE;
//            [OCI_LOCK_STEP] char(1) COLLATE Chinese_PRC_CI_AS DEFAULT ('0') NULL,
    private String OCI_LOCK_STEP;
//            [OCI_LOCK_STATUS] char(1) COLLATE Chinese_PRC_CI_AS DEFAULT ('0') NULL,
    private String OCI_LOCK_STATUS;
//            [OCI_CUSTOM_INFO] char(4) COLLATE Chinese_PRC_CI_AS DEFAULT ('ZGYC') NULL,
    private String  OCI_CUSTOM_INFO;
//    CONSTRAINT [PK_BP_ORDER_CIG_INFO] PRIMARY KEY CLUSTERED ([OCI_ID
}
