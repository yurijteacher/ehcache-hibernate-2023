package ua.com.shop.ehcachehibernate2023.configuration;


import org.ehcache.config.CacheConfiguration;
import org.ehcache.config.builders.CacheConfigurationBuilder;
import org.ehcache.config.builders.ExpiryPolicyBuilder;
import org.ehcache.config.builders.ResourcePoolsBuilder;
import org.ehcache.config.units.MemoryUnit;
import org.ehcache.jsr107.Eh107Configuration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import ua.com.shop.ehcachehibernate2023.entity.Category;

import javax.cache.CacheManager;
import javax.cache.Caching;
import java.time.Duration;
import java.util.ArrayList;

@Configuration
@EnableJpaRepositories(basePackages = "ua.com.shop")
public class MyCacheConfiguration {

    @Bean
    public CacheManager getCacheManager(){

        CacheConfiguration<Long, Category> cacheConfig = CacheConfigurationBuilder
                .newCacheConfigurationBuilder(
                        Long.class,
                        Category.class,
                        ResourcePoolsBuilder.newResourcePoolsBuilder()
                                .offheap(10, MemoryUnit.MB)
                                .build())
                .withExpiry(ExpiryPolicyBuilder.timeToIdleExpiration(Duration.ofSeconds(60)))
                .build();

        var cacheProvider = Caching.getCachingProvider();
        CacheManager cacheManager =  cacheProvider.getCacheManager();

        var configuration = Eh107Configuration.fromEhcacheCacheConfiguration(cacheConfig);
        cacheManager.createCache("category", configuration);


        CacheConfiguration<String, ArrayList> cacheConfig2 = CacheConfigurationBuilder
                .newCacheConfigurationBuilder(
                        String.class,
                        ArrayList.class,
                        ResourcePoolsBuilder.newResourcePoolsBuilder()
                                .offheap(5, MemoryUnit.MB)
                                .build())
                .withExpiry(ExpiryPolicyBuilder.timeToIdleExpiration(Duration.ofSeconds(120)))
                .build();

        var configuration2 = Eh107Configuration.fromEhcacheCacheConfiguration(cacheConfig2);
        cacheManager.createCache("cat", configuration2);

    return cacheManager;
    }




}
