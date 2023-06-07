

import java.util.*;


 class TrieNode {
    boolean isLast;
    Character data;
    TrieNode array[];
    TrieNode(Character ch){
        data = ch;
        array = new TrieNode[26];
        isLast = false;
    }
}




public class Trie {

        static TrieNode root;
        //Initialize your data structure here

        Trie() {
            root = new TrieNode(null);
        }


        //Inserts a word into the trie

        public static void inserUtil(TrieNode root, String word){
            if(word.length() == 0){
                root.isLast = true;
                return;
            }
            int index = word.charAt(0) - 'a';
            Character ch = word.charAt(0);
            TrieNode child;
            if(root.array[index] != null){
                child = root.array[index];
            }else{
                 child = new TrieNode(ch);
                root.array[index] = child;
            }
            inserUtil(child,word.substring(1));
        }


        public static void insert(String word) {
            inserUtil(root,word);
        }


        //Returns if the word is in the trie
        public  static boolean searchUtil(TrieNode root, String word){
            if(word.length() == 0){
                if(root.isLast) return true;
                return false;
            }
            if(root.array[word.charAt(0) - 'a'] == null) return false;
            return searchUtil(root.array[word.charAt(0) - 'a'],word.substring(1));
        }
        public static boolean search(String word) {
            return searchUtil(root,word);
        }


        //Returns if there is any word in the trie that starts with the given prefix
        public static boolean startUtil(TrieNode root , String prefix){
            if(prefix.length() == 0) return true;
            if(root.array[prefix.charAt(0) - 'a'] == null) return false;
            return startUtil(root.array[prefix.charAt(0) - 'a'] , prefix.substring(1));
        }
        public static boolean startsWith(String prefix) {
            return startUtil(root,prefix);
        }
    }
