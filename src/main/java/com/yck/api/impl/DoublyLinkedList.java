package com.yck.api.impl;

public class DoublyLinkedList<K,V> {

	private DLNode<K,V> head;
	
	private DLNode<K,V> tail;
	
	public  DLNode<K,V> insertAtBegin(K key, V value) {
		 DLNode<K,V> newNode = new DLNode<>(key,value);
		if(this.head == null) {
			this.head = newNode;
			this.tail = newNode;
		}
		else {
			newNode.next = this.head;
			this.head.prev = newNode;
			this.head = newNode;
		}
		return newNode;
	}
	
	public DLNode<K, V> removeFirst() {
		DLNode<K, V> temp = this.head;
		if(this.head != null) {
			this.head = this.head.next;
		}
		if(this.head != null) {
			this.head.prev = null;
		}
		return temp;
	}
	
	public DLNode<K,V> removeLast() {
		DLNode<K, V> temp = this.tail;
		if(this.tail != null) {
			this.tail = this.tail.prev;
		}
		if(this.tail != null) {
			this.tail.next = null;
		}
		return temp;
	}
	
	public DLNode<K,V> remove(DLNode<K,V> node) {
		if(node == head) {
			return removeFirst();
		}
		else if(node == tail) {
			return removeLast();
		}
		else {
			DLNode<K,V> prev = node.prev;
			DLNode<K,V> next = node.next;
			prev.next = next;
			next.prev = prev;
		}
		return node;
	}

	public boolean moveToHead(DLNode<K,V> node) {
		if(node == head) {
			return true;
		}
		else{
			remove(node);
		}
		return makeHead(node);
	}

	private  boolean makeHead(DLNode<K,V> node){
		node.next = this.head;
		this.head.prev = node;
		node.prev = null;
		this.head = node;
		return true;
	}
	
}
