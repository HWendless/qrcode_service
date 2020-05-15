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
@TableName("VI_PRODUCTMSG")
public class ViProductmsg implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableField("BIGBOX_BAR")
    private String bigboxBar;

    @TableField("PACK_BAR")
    private String packBar;

    @TableField("BOX_BAR")
    private String boxBar;

    @TableField("ITEM_NAME")
    private String itemName;

    @TableField("PACK_KIND")
    private String packKind;


}
