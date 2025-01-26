package LeetCode.medium;
import java.util.*;
public class P208 {
    class Trie {
        private Map<Character, Trie> map;
        private boolean isEnd;

        public Trie() {
            map = new HashMap<>();
            isEnd = false;
        }

        public void insert(String word) {
            Trie node = this;

            for (Character cur : word.toCharArray()) {
                node = node.map.computeIfAbsent(cur, key -> new Trie());
            }

            node.isEnd = true;
        }

        public boolean search(String word) {
            Trie node = this;

            for (Character cur : word.toCharArray()) {
                node = node.map.getOrDefault(cur, null);

                if (node == null)
                    return false;
            }

            if (node.isEnd) return true;
            else return false;
        }

        public boolean startsWith(String prefix) {
            Trie node = this;

            for (Character cur : prefix.toCharArray()) {
                node = node.map.getOrDefault(cur, null);

                if (node == null)
                    return false;
            }
            return true;
        }
    }

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
}
