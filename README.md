# 🚀 LRU Cache Implementation

A high-performance, Least Recently Used (LRU) cache implementation in Java using `ConcurrentHashMap` and a `Doubly Linked List`. All operations (`get`, `put`, `delete`) run in **O(1)** time complexity.

## 🌟 Features
- **O(1)** time complexity for all core operations
- **Thread-safe** design (with improvements needed)
- **Fixed capacity** with eviction of least recently used items
- **Doubly linked list** for O(1) reordering
- **ConcurrentHashMap** for O(1) lookups

## 🛠️ Implementation Details

### Core Data Structures
```java
ConcurrentHashMap<K, DLNode<K,V>> map;  // Thread-safe key-node mapping
DoublyLinkedList<K,V> list;           // Eviction ordering

## 💻 Usage Example

### Basic Operations
```java
// Initialize cache with capacity 3
LRUCache<String, Integer> cache = new LRUCache<>(3);

// Insert elements
cache.put("a", 1);  // Cache: [(a,1)]
cache.put("b", 2);  // Cache: [(b,2), (a,1)]
cache.put("c", 3);  // Cache: [(c,3), (b,2), (a,1)]

// Access element (promotes to head)
System.out.println(cache.get("a"));  // Output: 1 
// Cache becomes: [(a,1), (c,3), (b,2)]

// Insert beyond capacity (evicts LRU item)
cache.put("d", 4);  // Evicts "b", Cache: [(d,4), (a,1), (c,3)]

// Delete operation
cache.delete("a");  // Cache: [(d,4), (c,3)]
