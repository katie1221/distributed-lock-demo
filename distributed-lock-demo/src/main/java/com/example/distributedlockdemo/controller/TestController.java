package com.example.distributedlockdemo.controller;

import com.example.distributedlockdemo.dao.OrderMapper;
import com.example.distributedlockdemo.dao.ProductMapper;
import com.example.distributedlockdemo.entity.Order;
import com.example.distributedlockdemo.entity.Product;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.Date;

/**
 * @author qzz
 * @date 2023/3/10
 */
@RestController
public class TestController {

    @Autowired
    private RedissonClient redissonClient;
    @Autowired
    private ProductMapper productMapper;
    @Autowired
    private OrderMapper orderMapper;

    /**
     * 下单，减库存
     * @param order
     * @return
     */
    @PostMapping("/order/add")
    public String createOrderTest(@RequestBody Order order){
        //1.判断库存
        if(!decProductStore(order.getProductId(),order.getProductNum())){
            return "库存不足！";
        }
        //2.商品下单
        //订单状态 0：未支付 1：已支付 2：已发货 3：已取消
        order.setStatus(0);
        order.setCreateTime(new Date());
        Integer result = orderMapper.insert(order);
        if(result>0){
            //3.减商品库存
            productMapper.updateProductStock(order.getProductId(),order.getProductNum());
        }
        return "下单成功";
    }

    /**
     * 判断库存
     * @param productId 商品id
     * @param productNum 购买数量
     * @return
     */
    public boolean decProductStore(Long productId, Integer productNum){
        String key="decrease_stock_lock:" + productId;
        RLock lock = redissonClient.getLock(key);
        //1.加锁
        lock.lock();
        try {//2.执行业务
            //根据商品id和购买数量判断商品剩余库存
            Product product = productMapper.selectByPrimaryKey(productId);
            //如果库存为空或库存不足
            if (product.getStock() == 0 || product.getStock()-productNum <0) {
                return false;
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }finally {
            //解锁
            lock.unlock();
        }
        return true;
    }
}
