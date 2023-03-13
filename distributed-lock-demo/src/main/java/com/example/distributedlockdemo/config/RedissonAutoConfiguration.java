package com.example.distributedlockdemo.config;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * redisson配置类
 * @author qzz
 * @date 2023/3/10
 */
@Configuration
public class RedissonAutoConfiguration {

    /**
     * redis 链接地址
     */
    @Value("${redisson.address}")
    private String addressUrl;

    /**
     * 密码
     */
    @Value("${redisson.password}")
    private String password;

    /**
     * 单机模式配置
     * @return
     */
    @Bean
    public RedissonClient getRedisson(){
        Config config = new Config();
        //单机模式
        config.useSingleServer()
                .setAddress(addressUrl)
                //如果redis没有设置密码，则需要注释掉 setPassword(password)
                //.setPassword(password)
                .setRetryInterval(5000)
                .setTimeout(10000)
                .setConnectTimeout(10000);
        return Redisson.create(config);
    }

    /**
     * 主从模式配置
     * @return
     */
//    @Bean
//    public RedissonClient getRedisson(){
//        Config config = new Config();
//        //主从模式
//        config.useMasterSlaveServers()
//                .setMasterAddress("redis://***(主服务器IP):6379").setPassword(password)
//                .addSlaveAddress("redis://***(从服务器IP):6379")
//                .setRetryInterval(5000)
//                .setTimeout(10000)
//                //连接超时，单位：毫秒 默认值：3000
//                .setConnectTimeout(10000);
//        return Redisson.create(config);
//    }

    /**
     * 哨兵模式配置
     * @return
     */
//    @Bean
//    public RedissonClient getRedisson(){
//        Config config = new Config();
//        //哨兵模式
//        config.useSentinelServers()
//                .setMasterName("myMaster").setPassword(password)
//                .addSentinelAddress("***(哨兵IP):26379","***(哨兵IP):26379");
//        return Redisson.create(config);
//    }
}
