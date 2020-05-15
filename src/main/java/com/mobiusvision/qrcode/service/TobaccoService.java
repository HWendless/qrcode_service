package com.mobiusvision.qrcode.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.mobiusvision.qrcode.entity.Tobacco;


import java.util.List;

/****
 * @Author:hanwei
 * @Description:Tobacco业务层接口
 * @Date 2019/6/14 0:16
 *****/
public interface TobaccoService extends IService<Tobacco> {

    /***
     * Tobacco多条件分页查询
     * @param tobacco
     * @param pages
     * @param limit
     * @return
     */
    IPage<Tobacco> findPage(Tobacco tobacco, int pages, int limit);

    /***
     * Tobacco分页查询
     * @param pages
     * @param limit
     * @return
     */
    IPage<Tobacco> findPage(int pages, int limit);

    /***
     * Tobacco多条件搜索方法
     * @param tobacco
     * @return
     */
    List<Tobacco> findList(Tobacco tobacco);

    /***
     * 删除Tobacco
     * @param ids
     */


    /***
     * 修改Tobacco数据
     * @param tobacco
     */
    void update(Tobacco tobacco);

    /***
     * 新增Tobacco
     * @param tobacco
     */
    void add(Tobacco tobacco);

    /**
     * 根据ID查询Tobacco
     * @param id
     * @return
     */
     Tobacco findById(Integer id);

    /***
     * 查询所有Tobacco
     * @return
     */
    List<Tobacco> findAll();
}
