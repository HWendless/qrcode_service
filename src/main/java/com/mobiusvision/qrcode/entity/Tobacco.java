package com.mobiusvision.qrcode.entity;

import com.baomidou.mybatisplus.annotation.TableId;
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
public class Tobacco {

//    private String packing;
//    private String fullName;
//    private String imageUrl;
//    private String barCode;
//    private Integer pack1;
//    private Integer pack2;

    @TableId
    private Integer id;//id

    private String packing;//包装

    private String strip_packing;//条装(多少盒)

    private String box_packing;//盒装(多少只)

    private String tobacco_brand;//烟草品牌

    private String tobacco_model;//烟草型号

    private String tobacco_img;//图片

    private String bar_code;//条盒条码

}
