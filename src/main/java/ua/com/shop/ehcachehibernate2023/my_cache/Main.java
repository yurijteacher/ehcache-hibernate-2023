package ua.com.shop.ehcachehibernate2023.my_cache;

import ua.com.shop.ehcachehibernate2023.entity.Category;

public class Main {

    public static void main(String[] args) {
        Category category1 = new Category();
        category1.setId(1L);
        category1.setName("apple");
        category1.setDescription("asd asd asd fjj fjj");

        Category category2 = new Category();
        category2.setId(2L);
        category2.setName("beer");
        category2.setDescription("dsf dsf dsf dsf");

        CategoryCache cache = new CategoryCache();

        cache.getCache().put(1L, category1);
        cache.getCache().put(2L, category2);

        cache.print();

        cache.getCache().clear();

        cache.print();



    }
}
