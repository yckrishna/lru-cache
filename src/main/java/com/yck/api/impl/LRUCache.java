package com.yck.api.impl;

import com.yck.api.Cache;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class LRUCache<K,V> implements Cache<K, V> {
	
	private final Map<K,DLNode<K,V>> map;
	
	private final DoublyLinkedList<K,V> doublyLinkedList;
	
	private final int capacity;
	
	private int size;
	
	
	public LRUCache(int capacity) {
		this.capacity = capacity;
		this.map = new ConcurrentHashMap<>(capacity);
		this.doublyLinkedList = new DoublyLinkedList<>();
		this.size = 0;
	}


	public boolean put(K key, V value) {
		if(size == capacity) {
			DLNode<K,V> lastNode = doublyLinkedList.removeLast();
			map.remove(lastNode.key);
			size--;
		}
		DLNode<K, V> newNode = doublyLinkedList.insertAtBegin(key, value);
		map.put(key, newNode);
		size++;
		return true;
	}

	public V get(K key) {
		DLNode<K, V> node = map.get(key);
		if(node != null) {
			doublyLinkedList.moveToHead(node);
			return node.value;
		}
		return null;
	}

	public boolean delete(K key) {
		DLNode<K, V> node = map.remove(key);
		if(node != null) {
			doublyLinkedList.remove(node);
			size--;
			return true;
		}
		return false;
	}

}
