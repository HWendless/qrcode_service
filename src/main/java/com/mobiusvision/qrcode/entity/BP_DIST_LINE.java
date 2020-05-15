package com.mobiusvision.qrcode.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.math.BigInteger;
import java.time.LocalDateTime;


@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
public class BP_DIST_LINE {

//     [DL_ID] bigint  IDENTITY(1,1) NOT NULL,
    private BigInteger DL_ID; //主键
//  [DL_UUID] varchar(64) COLLATE Chinese_PRC_CI_AS  NOT NULL, 订单唯一标识
    private String DL_UUID;
//  [DL_SORT_DATE] datetime  NOT NULL,
    private LocalDateTime DL_SORT_DATE;
//            [DL_B_UUID] varchar(64) COLLATE Chinese_PRC_CI_AS  NOT NULL,
//  [DL_B_CODE] varchar(20) COLLATE Chinese_PRC_CI_AS  NOT NULL,
    private String  DL_B_CODE;
//  [DL_B_TYPE] char(1) COLLATE Chinese_PRC_CI_AS  NOT NULL,
    private String DL_B_TYPE;
//  [DL_CODE] varchar(20) COLLATE Chinese_PRC_CI_AS  NOT NULL,
    private String  DL_CODE;
//  [DL_NAME] nvarchar(150) COLLATE Chinese_PRC_CI_AS  NOT NULL,
    private String DL_NAME;
//  [DL_SEQUENCE] int DEFAULT (0) NOT NULL,
    private int DL_SEQUENCE;
//  [DL_ORDER_NUM] int DEFAULT (0) NOT NULL,
    private int DL_ORDER_NUM;
//  [DL_PRINT_NUM] int DEFAULT (0) NOT NULL,
    private int DL_PRINT_NUM;
//  [DL_START_TIME] datetime  NULL,
    private LocalDateTime DL_START_TIME;
//  [DL_END_TIME] datetime  NULL,
    private LocalDateTime DL_END_TIME;
//  [DL_STATE] varchar(2) COLLATE Chinese_PRC_CI_AS  NOT NULL,
    private String DL_STATE;
//  [DL_SEND_STATE] char(1) COLLATE Chinese_PRC_CI_AS  NOT NULL,
    private String DL_SEND_STATE;
//  [DL_SELF_UPDATE_TIME] datetime  NOT NULL,
    private LocalDateTime  DL_SELF_UPDATE_TIME;
//            [DL_SUB_UPDATE_TIME] datetime  NOT NULL,
    private LocalDateTime  DL_SUB_UPDATE_TIME;
//    CONSTRAINT [PK_BP_DIST_LINE] PRIMARY KEY CLUSTERED ([DL_ID])
}
