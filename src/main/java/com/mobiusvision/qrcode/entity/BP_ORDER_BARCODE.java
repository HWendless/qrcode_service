package com.mobiusvision.qrcode.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;


@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
public class BP_ORDER_BARCODE {
//     [OB_ID] bigint  IDENTITY(1,1) NOT NULL, 主键
    private int OB_ID;
//  [OB_UUID] varchar(64) COLLATE Chinese_PRC_CI_AS  NOT NULL, 订单唯一标识
    private String  OB_UUID;
//  [OB_SEQUENCE] int  NOT NULL, 条码顺序号
    private int OB_SEQUENCE;
//            [OB_SORT_DATE] datetime  NOT NULL,  分拣日期
    private LocalDateTime OB_SORT_DATE;
//            [OB_CIG_DERIVE_CODE] char(11) COLLATE Chinese_PRC_CI_AS  NOT NULL,  件烟派生码
    private String  OB_CIG_DERIVE_CODE;
//  [OB_CUSTOM_INFO] char(4) COLLATE Chinese_PRC_CI_AS  NOT NULL, 条烟码段自定义信息
    private String  OB_CUSTOM_INFO;
//  [OB_RETAILER_CODE] char(12) COLLATE Chinese_PRC_CI_AS  NOT NULL, 零售户代码
    private String  OB_RETAILER_CODE;
//  [OB_BCIG_BARCODE] char(32) COLLATE Chinese_PRC_CI_AS  NOT NULL, 条烟码段
    private String  OB_BCIG_BARCODE;
//  [OB_TOTAL_SEQUENCE] bigint  NULL,
    private int OB_TOTAL_SEQUENCE;
//  [OB_LOCK_STEP] char(1) COLLATE Chinese_PRC_CI_AS DEFAULT ('0') NULL,
    private String  OB_LOCK_STEP;
//            [OB_LOCK_STATUS] char(1) COLLATE Chinese_PRC_CI_AS DEFAULT ('0') NULL,
    private String  OB_LOCK_STATUS;
//    CONSTRAINT [PK_BP_ORDER_BARCODE] PRIMARY KEY CLUSTERED ([OB_ID])
}
