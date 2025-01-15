package LeetCode.medium;

import java.util.*;
public class P211 {
    public class Trie {
        public boolean isEnd;
        public Map<Character, Trie> children;

        public Trie() {
            isEnd = false;
            children = new HashMap<>();
        }

        public void insert(String word) {
            Trie node = this;

            for (char cur : word.toCharArray()) {
                node = node.children.computeIfAbsent(cur, k -> new Trie());
            }

            node.isEnd = true;
        }

        public boolean search(String word, int ind) {
            if (ind == word.length()) return this.isEnd ? true : false;

            boolean result = false;
            char target = word.charAt(ind);

            // 모든 하위 노드 탐색
            if (target == '.') {
                for (Character child : this.children.keySet()) {
                    result = result || this.children.get(child).search(word, ind+1);
                }
            }
            // 해당 노드가 있다면 탐색
            else if (this.children.containsKey(target)) {
                result = this.children.get(target).search(word, ind+1);
            }
            return result;
        }
    }

    public Trie root;

    public P211() {
        root = new Trie();
    }

    public void addWord(String word) {
        root.insert(word);
    }

    public boolean search(String word) {
        return root.search(word, 0);
    }
}
