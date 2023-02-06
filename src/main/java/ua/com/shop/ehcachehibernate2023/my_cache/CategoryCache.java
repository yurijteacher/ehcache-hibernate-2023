package ua.com.shop.ehcachehibernate2023.my_cache;

import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.com.shop.ehcachehibernate2023.entity.Category;

import java.util.HashMap;
import java.util.Map;

@Data

public class CategoryCache implements MyCache<Long, Category>{

    private static final Logger logger = LoggerFactory.getLogger(CategoryCache.class);
    private Map<Long, Category> cache = new HashMap<>();

    @Override
    public Category getCache(Long key) {
        logger.info("category from cache", cache.get(key).toString());
        return cache.get(key);
    }

    @Override
    public Category putCache(Long key, Category value) {
        cache.put(key, value);
        Category c = cache.get(key);
        logger.info("value from cache", c);
        return c;
    }

    public void print(){

        for (Map.Entry<Long, Category> el :
             cache.entrySet()) {
        logger.info(el.getKey() +" :" + el.getValue() + ",");
        }
    }


}
