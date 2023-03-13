package com.example.distributedlockdemo.dao;

import com.example.distributedlockdemo.config.mybatis.MyMapper;
import com.example.distributedlockdemo.entity.Product;
import org.apache.ibatis.annotations.Param;

/**
 * @author qzz
 * @date 2023/3/13
 */
public interface ProductMapper extends MyMapper<Product> {

    /**
     * 修改商品库存
     * @param productId
     * @param productId
     * @return
     */
    Integer updateProductStock(@Param("productId") Long productId, @Param("productNum")  Integer productNum);
}
