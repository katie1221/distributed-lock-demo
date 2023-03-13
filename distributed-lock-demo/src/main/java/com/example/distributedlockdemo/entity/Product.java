package com.example.distributedlockdemo.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import javax.persistence.*;
import java.util.Date;

/**
 * 商品
 * @author qzz
 * @date 2023/3/10
 */
@Data
@Table(name="t_product")
public class Product {

    /**
     * 商品id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 商品名称
     */
    @Column
    private String productName;

    /**
     * 商品图片
     */
    @Column
    private String productImg;

    /**
     * 商品单价
     */
    @Column
    private Double productPrice;

    /**
     * 商品库存
     */
    @Column
    private Integer stock;

    /**
     * 创建者id
     */
    @Column
    private Long createBy;

    /**
     * 创建时间
     */
    @Column
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    /**
     * 修改者id
     */
    @Column
    private Long updateBy;

    /**
     * 修改时间
     */
    @Column
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;

}
