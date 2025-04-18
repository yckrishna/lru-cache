package com.yck.api.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LRUCacheTest {

    private LRUCache<String,Integer> lruCache;

    @BeforeEach
    public void  setUp(){
        lruCache = new LRUCache<>(3);
        lruCache.put("ram",10000);
        lruCache.put("laxman",20000);
        lruCache.put("bharath",30000);
    }

    @Test
    void put() {
        Integer salary =  lruCache.get("ram");
        assertEquals(10000,salary);
        lruCache.put("shatrugnh",40000);
        salary =  lruCache.get("shatrugnh");
        assertEquals(40000,salary);
        salary =  lruCache.get("laxman");
        assertNull(salary);
    }

    @Test
    void delete() {
        lruCache.delete("bharath");
        lruCache.put("shatrugnh",40000);
        Integer salary =  lruCache.get("shatrugnh");
        assertEquals(40000,salary);
        salary =  lruCache.get("laxman");
        assertEquals(20000,salary);
        salary =  lruCache.get("bharath");
        assertNull(salary);
    }
}