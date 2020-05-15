package com.mobiusvision.qrcode.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.mobiusvision.qrcode.entity.*;
import com.mobiusvision.qrcode.mapper.BpOrderMapper;
import com.mobiusvision.qrcode.mapper.TobaccoMapper;
import com.mobiusvision.qrcode.mapper.ViCustmsgMapper;
import com.mobiusvision.qrcode.service.BpOrderService;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BpOrderServiceimpl  implements BpOrderService {
    @Autowired
    BpOrderMapper bpOrderMapper;

    @Autowired
    ViCustmsgMapper viCustmsgMapper;

    @Autowired
    TobaccoMapper tobaccoMapper;
    @Override
    public Map selectBdOrder(String OB_BCIG_BARCODE ,String OCI_CIG_BRAND ) {
        Map map = new HashMap();

        /*
        先检查有没有条码
        SELECT * FROM BP_ORDER_BARCODE WHERE OB_BCIG_BARCODE = '0051321132308922YLYC610802102367'

         */
        BP_ORDER_BARCODE bp_order_barcode = bpOrderMapper.selectBP_ORDER_BARCODE(OB_BCIG_BARCODE);
        if (bp_order_barcode == null) {
            map.put("500", "32位码不存在");
            return map;
        }
        /*

        然后拿到订单
        d6f0c712-9eff-4347-8da2-7c03e4bfda45

        查询订单基本信息表
        select * from  bp_order_info where  oi_uuid = 'd6f0c712-9eff-4347-8da2-7c03e4bfda45'
        */
        BP_ORDER_INFO bp_order_info = bpOrderMapper.selectBP_ORDER_INFO(bp_order_barcode.getOB_UUID());
        map.put("bp_order_info", bp_order_info);
        /*
        1.拿到线路  分拣线
        oi_sline_code分拣线编号
        oi_sline_name 分拣线名称
        */

        /*
        oi_code 订单号
        oi_retaller_code 零售户代码
        oi_retailer_name 零售户名称
        */
//        map.put("oi_retaller_code",bp_order_info.getOI_RETAILER_NAME());

        /*

        拿线路
            oi_dl_uuid线路唯一标识
        oi_dl_code 线路编号  814400093898
        oi_dl_name线路名称

        select * FROM bp_dist_line WHERE  dl_uuid = '819a53eb-2e6b-4038-8226-4f78b0c76e88'
        */
        BP_DIST_LINE bp_dist_line = bpOrderMapper.selectBP_DIST_LINE(bp_order_info.getOI_DL_UUID());
        map.put("bp_dist_line", bp_dist_line);
        /*

        拿烟的信息
        select * from  bp_order_cig_info WHERE oci_uuid='d6f0c712-9eff-4347-8da2-7c03e4bfda45'
        拿到  oci_cig_brand= 6901028186377
        */
        if(OCI_CIG_BRAND!=null)
        {
//            map.put("bar",);
            QueryWrapper queryWrapper = new QueryWrapper();
            queryWrapper.eq("bar_code",OCI_CIG_BRAND);
            Tobacco tobacco = tobaccoMapper.selectOne(queryWrapper);
            map.put("bar",tobaccoMapper.selectOne(queryWrapper));

        }
        else{
            List<Map> list = bpOrderMapper.selectyanBP_ORDER_INFO(bp_order_info.getOI_UUID());
            map.put("bar",list);
        }

        /*
        select oi_dl_uuid from  bp_order_info where  oi_uuid = 'd6f0c712-9eff-4347-8da2-7c03e4bfda45'
                * */
        QueryWrapper<ViCustmsg> wrapper1 = new QueryWrapper<>();
        wrapper1.eq("LICENSE_CODE", bp_order_barcode.getOB_RETAILER_CODE());

        List<ViCustmsg> viCustmsgs = viCustmsgMapper.selectList(wrapper1);
        if (viCustmsgs.size()==0) {
            Map map1 = new HashMap();
            map1.put("licenseCode",bp_order_info.getOI_RETAILER_CODE());
            map1.put("custName",bp_order_info.getOI_RETAILER_NAME());
            map.put("viCustmsgs",map1);
        } else
        {
            map.put("viCustmsgs",viCustmsgs);
        }
//      select * from  bp_order_cig_info WHERE OCI_CIG_BRAND = '6901028092838' and  oci_uuid='d6f0c712-9eff-4347-8da2-7c03e4bfda45'

        return map;
    }
}
