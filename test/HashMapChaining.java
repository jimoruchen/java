package test;

import java.util.ArrayList;
import java.util.List;

public class HashMapChaining {
    int size;
    int capacity;
    double loadThres;
    int extendRatio;
    List<List<Pair>> buckets;

    public HashMapChaining() {
        size = 0;
        capacity = 4;
        loadThres = 2.0 / 3.0;
        extendRatio = 2;
        buckets = new ArrayList<>(capacity);
        for (int i = 0; i < capacity; i++)
            buckets.add(new ArrayList<>());
    }

    int hashFunc(int key) {
        return key % capacity;
    }

    double loadFactor() {
        return (double) size / capacity;
    }

    String get(int key) {
        int index = hashFunc(key);
        List<Pair> bucket = buckets.get(index);
        for (Pair pair : bucket) {
            if (pair.key == index)
                return pair.val;
        }
        return null;
    }

    void put(int key, String val) {
        if (loadFactor() > loadThres)
            extend();
        int index = hashFunc(key);
        List<Pair> bucket = buckets.get(index);
        for (Pair pair : bucket) {
            if (pair.key == key) {
                pair.val = val;
                return;
            }
        }
        Pair pair = new Pair(key, val);
        bucket.add(pair);
        size++;
    }

    void remove(int key) {
        int index = hashFunc(key);
        List<Pair> bucket = buckets.get(index);
        for (Pair pair : bucket) {
            if (pair.key == key) {
                bucket.remove(pair);
                size--;
                break;
            }
        }
    }

    void extend() {
        List<List<Pair>> bucketsTmp = buckets;
        capacity *= extendRatio;
        buckets = new ArrayList<>(capacity);
        for (int i = 0; i < capacity; i++)
            buckets.add(new ArrayList<>());
        size = 0;
        for (List<Pair> bucket : bucketsTmp) {
            for (Pair pair : bucket)
                put(pair.key, pair.val);
        }
    }

    void print() {
        for (List<Pair> bucket : buckets) {
            List<String> res = new ArrayList<>();
            for (Pair pair : bucket)
                res.add(pair.val + "->" + pair.val);
            System.out.println(res);
        }
    }
}
