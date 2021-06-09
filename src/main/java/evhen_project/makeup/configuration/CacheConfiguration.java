package evhen_project.makeup.configuration;

import org.springframework.context.annotation.Configuration;

@Configuration
public class CacheConfiguration {

//    @Bean
//    public RedissonClient redisson(){
//        var config = new Config();
//        config.useSingleServer().setAddress("redis://127.0.0.1:6379");
//        return Redisson.create(config);
//    }
//
//
//    @Bean("redisCacheManager")
//    public CacheManager cacheManager(RedissonClient redisson){
//        var config = new HashMap<String, CacheConfig>();
//        config.put("currencies", new CacheConfig(2*60*1000, 30*1000));
//        return (CacheManager) new RedissonSpringCacheManager(redisson, config);
//    }
}
