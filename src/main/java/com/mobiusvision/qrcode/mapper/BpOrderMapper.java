package com.mobiusvision.qrcode.mapper;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.mobiusvision.qrcode.entity.BP_DIST_LINE;
import com.mobiusvision.qrcode.entity.BP_ORDER_BARCODE;
import com.mobiusvision.qrcode.entity.BP_ORDER_INFO;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;
@DS("sqlserver")
public interface BpOrderMapper {
    @Select("SELECT * FROM BP_ORDER_BARCODE WHERE OB_BCIG_BARCODE = #{OB_BCIG_BARCODE} ")
    BP_ORDER_BARCODE selectBP_ORDER_BARCODE(String OB_BCIG_BARCODE );
    @Select("select * from  bp_order_info where  oi_uuid = 'd6f0c712-9eff-4347-8da2-7c03e4bfda45'")
    BP_ORDER_INFO selectBP_ORDER_INFO(String oi_uuid);

    @Select(" select * FROM bp_dist_line WHERE  dl_uuid = #{dl_uuid}")
    BP_DIST_LINE selectBP_DIST_LINE(String dl_uuid );

    @Select("  select * from  bp_order_cig_info WHERE oci_uuid=#{oi_uuid}")
    List<Map> selectyanBP_ORDER_INFO(String oi_uuid );
}
