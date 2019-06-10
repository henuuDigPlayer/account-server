package com.lindj.boot.config.redisson;

import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyFastJsonConfig {

    @Bean
    public FastJsonConfig getFastJsonConfig(){
        FastJsonConfig fastJsonConfig = new FastJsonConfig();
        fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat);
        ParserConfig.getGlobalInstance().addAccept("com.lindj.boot.");
        ParserConfig.getGlobalInstance().addAccept("org.apache.shiro.");
        return fastJsonConfig;
    }
}
