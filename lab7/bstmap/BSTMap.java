package bstmap;

import org.w3c.dom.Node;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class BSTMap<K extends Comparable<K>, V> implements Map61B<K, V>{
    private Node root;
    private int size;

    public void clear(){
        root = null;
        size = 0;
    }

    public boolean containsKey(K key){
       return containskey(key, root);
    }

    private boolean containskey(K key, Node root){
        if(root == null ) return false;

        int cmp = key.compareTo(root.key);
        if(cmp == 0) return true;
        if(cmp < 0) return containskey(key, root.left);
        return containskey(key, root.right);
    }

    public V get(K key){
        return get(key, root);
    }
    private V get(K key, Node root){
        if(root == null ) return null;
        int cmp = key.compareTo(root.key);
        if(cmp < 0) return get(key, root.left);
        if(cmp > 0) return get(key, root.right);
        return root.value;
    }

    public int size(){
        return size;
    }

    public void put(K key, V value) {
        root = put(root, key, value);
        size += 1;
    }

    private Node put(Node node, K key, V value) {
        if (node == null) {
            return new Node(key, value);
        }
        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            node.left = put(node.left, key, value);
        } else if (cmp > 0) {
            node.right = put(node.right, key, value);
        } else {
            node.value = value;
        }
        return node;
    }

    public Set<K> keySet(){
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public V remove(K key){
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public V remove(K key, V value){
        throw new UnsupportedOperationException("Not supported yet.");
    }


    @Override
    public Iterator<K> iterator() {
        return null;
    }

    private class Node {
        public final K key;
        public V value;
        public Node left;
        public Node right;

        public Node(K k, V v) {
            key = k;
            value = v;
        }
    }

}
