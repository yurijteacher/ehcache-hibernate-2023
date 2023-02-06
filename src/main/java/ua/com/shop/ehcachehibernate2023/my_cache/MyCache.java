package ua.com.shop.ehcachehibernate2023.my_cache;

public interface MyCache <K,V>{
    V getCache(K key);
    V putCache(K key, V value);
}
