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
public class BP_BATCH {
    private BigInteger B_ID; //主键
    private String B_UUID; //批次唯一标识
    private LocalDateTime B_SORTDATE;//分拣日期

    private String  B_CODE; //批次类型（0，正常批次，1，换货批次）
    private int B_SEQUENCE; //批次顺序号
    private String  B_TYPE; //批次类型
    private String B_ISCHANGE; //是否换分拣线
    private String B_SLINECODE; //分拣线编号
    private int B_ORDERNUM; //订单数量（个）
    private int B_SHOULDSENDNUM; //应发送订单数量（个）
    private int B_THISSENDNUM; //本次发送订单数量（个）
    private int B_ALLRECYNUM; //订单接受数量
    private int B_PRINTNUM; // 订单打码数量（个）
    private LocalDateTime B_STARTTIME; //批次启动时间
    private LocalDateTime B_ENDTIME; //批次完成时间
    private String B_STATE; // 0 导入中  1导入完成  2 执行中  3 执行完成
    private String B_SENDSTATE; //回送状态  0-未回送 1-已回送
    private LocalDateTime B_SELFUPDATETIME; // 本地更新时间
    private LocalDateTime B_SUBUPDATETIME; //下级更新时间
}
