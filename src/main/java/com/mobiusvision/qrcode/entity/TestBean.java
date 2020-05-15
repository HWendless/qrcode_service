package com.mobiusvision.qrcode.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.math.BigInteger;


@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
public class TestBean {
    /*

    [OCI_ID] bigint  IDENTITY(1,1) NOT NULL,
  [OCI_UUID] varchar(64) COLLATE Chinese_PRC_CI_AS  NOT NULL,
  [OCI_CIG_BRAND] varchar(13) COLLATE Chinese_PRC_CI_AS  NOT NULL,
  [OCI_CIG_TRADEMARK] varchar(100) COLLATE Chinese_PRC_CI_AS  NOT NULL,
  [OCI_IS_ABNORMAL] char(1) COLLATE Chinese_PRC_CI_AS  NOT NULL,
  [OCI_IS_PRINT] char(1) COLLATE Chinese_PRC_CI_AS DEFAULT (0) NOT NULL,
  [OCI_ORDER_NUM] int DEFAULT (0) NOT NULL,
  [OCI_ORDER_NUM1] decimal(16,4) DEFAULT (0) NOT NULL,
  [OCI_ACTUAL_PRICE] decimal(18,6) DEFAULT (0) NULL,
  [OCI_STANDERD_PRICE] decimal(18,6) DEFAULT (0) NULL,
  [OCI_LOCK_STEP] char(1) COLLATE Chinese_PRC_CI_AS DEFAULT ('0') NULL,
  [OCI_LOCK_STATUS] char(1) COLLATE Chinese_PRC_CI_AS DEFAULT ('0') NULL,
  [OCI_CUSTOM_INFO] char(4) COLLATE Chinese_PRC_CI_AS DEFAULT ('ZGYC')
     */

    private BigInteger OCIID;
    private String  OCIUUID;

}
