package com.mobiusvision.qrcode.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDateTime;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor

//执行订单基本信息表
public class BP_ORDER_INFO {
//
//     [OI_ID] bigint  IDENTITY(1,1) NOT NULL,  主键
    private BigInteger OI_ID;
//  [OI_UUID] varchar(64) COLLATE Chinese_PRC_CI_AS  NOT NULL, 订单唯一标识
    private String OI_UUID;
//  [OI_B_CODE] varchar(20) COLLATE Chinese_PRC_CI_AS  NOT NULL,批次编号
    private String OI_B_CODE;
//  [OI_B_TYPE] char(1) COLLATE Chinese_PRC_CI_AS  NOT NULL,  批次类型  （0-正常批次，1-换货批次）
    private String OI_B_TYPE;
//  [OI_ISCHANGE_SLINE] char(1) COLLATE Chinese_PRC_CI_AS  NOT NULL, 是否换分拣线 （0-是，否）
    private String OI_ISCHANGE_SLINE;
//  [OI_DL_CODE] varchar(20) COLLATE Chinese_PRC_CI_AS  NOT NULL,  线路编号
    private String OI_DL_CODE;
//  [OI_DL_NAME] nvarchar(150) COLLATE Chinese_PRC_CI_AS  NOT NULL, oi_dl_name线路名称
    private String OI_DL_NAME;
//  [OI_SLINE_CODE] varchar(20) COLLATE Chinese_PRC_CI_AS  NOT NULL, 分拣线编号
    private String OI_SLINE_CODE;
//  [OI_SLINE_NAME] varchar(100) COLLATE Chinese_PRC_CI_AS  NOT NULL,  分拣线名称
    private String OI_SLINE_NAME;
//  [OI_SEQUENCE] int DEFAULT (0) NOT NULL, 订单顺序号
    private int OI_SEQUENCE;
//  [OI_CODE] varchar(20) COLLATE Chinese_PRC_CI_AS  NOT NULL,  订单号
    private String OI_CODE;
//  [OI_RETAILER_CODE] char(12) COLLATE Chinese_PRC_CI_AS  NOT NULL, 零售户代码
    private String OI_RETAILER_CODE;
//  [OI_RETAILER_NAME] nvarchar(200) COLLATE Chinese_PRC_CI_AS  NOT NULL,  零售户名称
    private String OI_RETAILER_NAME;
//  [OI_DATE] datetime  NOT NULL, 订单日期
    private LocalDateTime OI_DATE;
//            [OI_SORT_DATE] datetime  NOT OI_ALL_NUMNULL, 分拣日期
    private LocalDateTime OI_SORT_DATE ;
//            [OI_CIG_FLAG] char(1) COLLATE Chinese_PRC_CI_AS  NOT NULL, 整件 标识 （0是，1否）
    private String  OI_CIG_FLAG;
//  [OI_ALL_NUM] int DEFAULT (0) NOT NULL,  订单量（条）
    private int OI_ALL_NUM;
//  [OI_NORMAL_NUM] int DEFAULT (0) NOT NULL,  正常包装条烟数量     非异性烟数量
    private int OI_NORMAL_NUM;
//  [OI_CUSTOM_INFO] char(4) COLLATE Chinese_PRC_CI_AS  NOT NULL,  条烟码段自定义信息    由分拣中心控制机确定
    private String OI_CUSTOM_INFO;
//  [OI_CHECK_NUM] int DEFAULT (0) NULL,  实物检测量
    private int OI_CHECK_NUM;
//  [OI_SEND_NUM] int DEFAULT (0) NULL,  条码发送量
    private int OI_SEND_NUM;
//  [OI_PRINT_NUM] int DEFAULT (0) NULL,  成功打码量
    private int OI_PRINT_NUM;
//  [OI_RESEL_ORDER_NUM] int DEFAULT (0) NULL,   定位打码次数
    private int OI_RESEL_ORDER_NUM;
//  [OI_START_TIME] datetime  NULL,   订单启动时间
    private LocalDateTime OI_START_TIME;
//  [OI_END_TIME] datetime  NULL,  批量完成时间
    private LocalDateTime OI_END_TIME;
//  [OI_STATE] varchar(2) COLLATE Chinese_PRC_CI_AS  NULL,  状态 （0未开始，1-正打印，2.订单已切换3批次已完成）
    private String OI_STATE;
//  [OI_SEND_STATE] char(1) COLLATE Chinese_PRC_CI_AS  NOT NULL,  回送状态 （0未回送，1已回送）
    private String OI_SEND_STATE;
//  [OI_SELF_UPDATE_TIME] datetime  NOT NULL,   本地更新时间
    private LocalDateTime OI_SELF_UPDATE_TIME;
//            [OI_SUB_UPDATE_TIME] datetime  NOT NULL,  下级更新时间
    private LocalDateTime OI_SUB_UPDATE_TIME;
//            [OI_B_UUID] varchar(64) COLLATE Chinese_PRC_CI_AS  NOT NULL, 批次唯一标识
    private String OI_B_UUID;
//  [OI_DL_UUID] varchar(64) COLLATE Chinese_PRC_CI_AS  NOT NULL,  线路唯一标识
    private String OI_DL_UUID;
//  [OI_SELF_SEQUENCE] int DEFAULT (0) NOT NULL,  自定义订单顺序号  （默认0，按照批次从1开始）
    private int OI_SELF_SEQUENCE;
//  [OI_ALL_NUM1] decimal(16,4) DEFAULT (0) NULL, 订单量（万支）
    private BigDecimal  OI_ALL_NUM1;
//            [OI_SELF_BATCH_SEQUENCE] int DEFAULT (0) NOT NULL, 自定义订单顺序号  （默认0，按照批次从1开始）
    private int OI_SELF_BATCH_SEQUENCE;
//  [OI_TOTAL_SEQUENCE] bigint DEFAULT (0) NULL,
    private BigInteger OI_TOTAL_SEQUENCE;
//  [OI_ILLEGALITY_NUM] int DEFAULT (0) NULL,
    private int OI_ILLEGALITY_NUM;
//  [OI_SECOND_NUM] int DEFAULT (0) NULL,
    private int OI_SECOND_NUM;
//  [OI_COMMERCE_CODE] varchar(8) COLLATE Chinese_PRC_CI_AS  NULL,
    private String  OI_COMMERCE_CODE;
//  [OI_COMMERCE_NAME] varchar(100) COLLATE Chinese_PRC_CI_AS  NULL,
    private String  OI_COMMERCE_NAME;
//  [OI_LOCAL_START_TIME] datetime DEFAULT ('1900-01-01 00:00:00') NOT NULL,
    private LocalDateTime OI_LOCAL_START_TIME;
//  [OI_STANDARD_START_TIME] datetime DEFAULT ('1900-01-01 00:00:00') NOT NULL,
    private LocalDateTime OI_STANDARD_START_TIME;
//  [OI_MONITOR_STATUS] varchar(20) COLLATE Chinese_PRC_CI_AS DEFAULT ('0') NOT NULL,
    private String OI_MONITOR_STATUS;
//  [OI_TIME_MONITOR_STATUS] varchar(20) COLLATE Chinese_PRC_CI_AS DEFAULT ('0') NOT NULL,
    private String OI_TIME_MONITOR_STATUS;
//  [OI_STANDARD_TIME_TYPE] varchar(1) COLLATE Chinese_PRC_CI_AS DEFAULT ('1') NOT NULL,
    private String OI_STANDARD_TIME_TYPE;
//    CONSTRAINT [PK_BP_ORDER_INFO] PRIMARY KEY CLUSTERED ([OI_ID])
}
