package com.charles.mybatisplus.config;

import com.baomidou.mybatisplus.core.injector.ISqlInjector;
import com.baomidou.mybatisplus.extension.injector.LogicSqlInjector;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class mybatisPlusConfigration {
    /*
    第一步  开启yml 里面的逻辑删除标识
    第二步  开启逻辑删除的配置类
    第三步  在实体类中表明逻辑删除的字段  delete
    * 3.1.1 版本以下可以使用此方法来配置逻辑删除
    */
    @Bean
    public ISqlInjector sqlInjector() {
        return new LogicSqlInjector();
    }
}
