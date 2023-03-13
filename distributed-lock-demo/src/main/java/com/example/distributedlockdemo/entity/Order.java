package com.example.distributedlockdemo.entity;

import lombok.Data;
import javax.persistence.*;
import java.util.Date;

/**
 * 订单
 * @author qzz
 * @date 2023/3/10
 */
@Data
@Table(name="t_order")
public class Order {

    /**
     * 订单id
     */
    /**
     * IDENTITY：主键由数据库自动生成（主要是自动增长型，这个用的比较多）
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 订单金额
     */
    @Column
    private Double orderAmount;

    /**
     * 商品id
     */
    @Column
    private Long productId;

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
     * 商品购买数量
     */
    @Column
    private Integer productNum;

    /**
     * 订单状态 0：未支付 1：已支付 2：已发货 3：已取消
     */
    @Column
    private Integer status;

    /**
     * 下单用户id
     */
    @Column
    private Long createBy;

    /**
     * 下单时间
     */
    @Column
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
    private Date updateTime;

}
