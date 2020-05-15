package com.mobiusvision.qrcode.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.mobiusvision.qrcode.entity.Tobacco;
import com.mobiusvision.qrcode.mapper.TobaccoMapper;
import com.mobiusvision.qrcode.service.TobaccoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/****
 * @Author:hanwei
 * @Description:Tobacco业务层接口实现类
 * @Date 2019/6/14 0:16
 *****/
@Service
public class TobaccoServiceImpl extends ServiceImpl<TobaccoMapper, Tobacco> implements TobaccoService {

    @Autowired
    private TobaccoMapper tobaccoMapper;


    /**
     * Tobacco条件+分页查询
     * @param tobacco 查询条件
     * @param pages 页码
     * @param limit 页大小
     * @return 分页结果
     */
    @Override
    public IPage<Tobacco> findPage(Tobacco tobacco,int pages, int limit){

        IPage<Tobacco> page = new Page(pages, limit);
        //构建查询条件
        QueryWrapper queryWrapper = createWrapper(tobacco);
        page = this.page(page, queryWrapper);
        return page;

    }

    /**
     * Tobacco分页查询
     * @param pages
     * @param limit
     * @return
     */
    @Override
    public IPage<Tobacco> findPage(int pages, int limit){

        IPage<Tobacco> page = new Page(pages, limit);
        QueryWrapper<Tobacco> queryWrapper = new QueryWrapper<>();
        page = this.page(page, queryWrapper);
        return page;
    }

    /**
     * Tobacco条件查询
     * @param tobacco
     * @return
     */
    @Override
    public List<Tobacco> findList(Tobacco tobacco){
        //构建查询条件
        QueryWrapper queryWrapper = createWrapper(tobacco);
        //根据构建的条件查询数据
        return tobaccoMapper.selectList(queryWrapper);
    }


    /**
     * Tobacco构建查询对象
     * @param tobacco
     * @return
     */
    public QueryWrapper createWrapper(Tobacco tobacco){
        QueryWrapper<Tobacco> queryWrapper = new QueryWrapper<>();

        if(tobacco!=null){
            // id
            if(!StringUtils.isEmpty(tobacco.getId())){


                    queryWrapper.eq("id",tobacco.getId());
            }
            // 包装
            if(!StringUtils.isEmpty(tobacco.getPacking())){


                    queryWrapper.eq("packing",tobacco.getPacking());
            }

        }
        return   queryWrapper;
    }



    /**
     * 修改Tobacco
     * @param tobacco
     */
    @Override
    public void update(Tobacco tobacco){
        tobaccoMapper.updateById(tobacco);
    }

    /**
     * 增加Tobacco
     * @param tobacco
     */
    @Override
    public void add(Tobacco tobacco){


        tobaccoMapper.insert(tobacco);
    }

    /**
     * 根据ID查询Tobacco
     * @param id
     * @return
     */
    @Override
    public Tobacco findById(Integer id){
        return tobaccoMapper.selectById(id);
    }

    /**
     * 查询Tobacco全部数据
     * @return
     */
    @Override
    public List<Tobacco> findAll() {
        QueryWrapper<Tobacco> queryWrapper = new QueryWrapper<>();
        return tobaccoMapper.selectList(queryWrapper);
    }
}
