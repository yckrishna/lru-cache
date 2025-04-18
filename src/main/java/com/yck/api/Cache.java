package com.yck.api;

public interface Cache<K,V> {

	boolean put(K key, V value);
	
	V get(K key);
	
	boolean delete(K key);
}
