package com.example.distributedlockdemo.config.mybatis;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * 自定义一个公共的MyMapper继承一些tkmybatis的现有的mapper
 * 注意这个类不能被spring扫描到,否则会出现java.lang.NoSuchMethodException: tk.mybatis.mapper.provider.base.BaseSelectProvider.异常.
 * @author qzz
 * @date 2023/3/13
 */
public interface MyMapper<T> extends Mapper<T>,MySqlMapper<T> {

    /**
     * MySqlMapper：mysql独有的一些通用的方法
     * Mapper：主要的方法来源，包含BaseMapper<T>, ExampleMapper<T>, RowBoundsMapper<T>, Marker
     * ConditionMapper：按照自定义的条件查询
     * IdsMapper：按照ids查询，比较鸡肋,要求id是自增的.
     */
}
