package com.yck.api.impl;

public class DLNode<K,V> {
	
	public DLNode<K,V> prev;
	public K key;
	public V value;
	public DLNode<K,V> next;
	
	public DLNode(K key, V value) {
		this.key = key;
		this.value = value;
	}
	
}
