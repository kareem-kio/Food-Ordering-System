package com.example.foodordersystem.SearchFiltering;

public class SearchPair<K,V> {
    // would be used to put two arraylists in it one for list of probable dishes
    // and list of probable restaurants
    private K key;
    private V value;
    public SearchPair(K key, V value) {
        this.key = key;
        this.value = value;
    }
    public K first() {
        return key;
    }
    public V second() {
        return value;
    }
    public void setFirst(K key) {
        this.key = key;
    }
    public void setSecond(V value) {
        this.value = value;
    }
}
