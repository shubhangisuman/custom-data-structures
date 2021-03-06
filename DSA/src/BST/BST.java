/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class BST<Key extends Comparable<Key>,Value>{
    class Node{
        Node left;
        Node right;
        Key key;
        Value value;
        int count;
        Node(Node left,Node right,Key key,Value value){
            this.left = left;
            this.right = right;
            this.key = key;
            this.value = value;
            count=1;
        }
        Node(Key key,Value value){
            this(null,null,key,value);
        }
    }
    private Node root;
    BST(){
        this.root = null;
    }
    public Value get(Key key){
        return get(root,key);
    }
    private Value get(Node root, Key key){
        if(root!=null){
            int compareTo = root.key.compareTo(key);
            if(compareTo==0)
                return root.value;
            else if(compareTo>0)
                return get(root.left,key);
            else
                return get(root.right,key);
        }
        return null;
    }
    public void put(Key key, Value value){
        root = put(root,key,value);
    }
    private Node put(Node root, Key key,Value value){
        if(root!=null){
            int compareTo = root.key.compareTo(key);
            if(compareTo>0)
                root.left = put(root.left,key,value);
            else if(compareTo<0)
                root.right = put(root.right,key,value);
            else
                root.value = value;
            root.count = 1+size(root.left)+size(root.right);
            return root;
        } 
        else{
            Node node = new Node(key,value);
            return node;
        }
    }
    public boolean containsKey(Key key){
        return get(root,key)!=null;
    }
    public int size(){
        return size(root);
    }
    private int size(Node root){
        if(root==null)
            return 0;
        else
            return root.count;
    } 
    public Key getMinimum(){
        if(root==null)
            return null;
        Node head = root;
        while(head.left!=null)
            head=head.left;
        return head.key;
    }
    public Key getMaximum(){
        if(root==null)
            return null;
        Node head = root;
        while(head.right!=null)
            head=head.right;
        return head.key;
    }
    public Key floor(Key key){
        if(root!=null){
            int compareTo = root.key.compareTo(key);
            if(compareTo==0)
                return root.key;
            else if(compareTo>0){
                return floor(root.left,key);
            }
            else{
                Node node = floor(root.right,key);
                if(node==null)
                    return root.key;
                else
                    return node.key;
            }
        }
        return null;
    }
    public Key ceil(Key key){
        if(root!=null){
            int compareTo = root.key.compareTo(key);
            if(compareTo==0)
                return root.key;
            else if(compareTo>0){
                Node node = ceil(root.left,key);
                if(node==null)
                    return root.key;
                else
                    return node.key;
            }
            else{
                return ceil(root.right,key);
            }
        }
        return null;
    }
}
class Solution {
	public static void main (String[] args) {
// 		BST<Integer,Integer> bst = new BST<>();
		HashMap<Integer,Integer> map = new HashMap<>();
		map.put(2,3);
		map.put(4,3);
		map.put(2,5);
        System.out.println(map);
	}
}

