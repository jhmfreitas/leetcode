package blind75.medium;

import java.util.HashMap;

public class Trie {

    HashMap<Character, Trie> children = new HashMap<>();
    boolean isTerminal;

    public Trie() {

    }

    public void insert(String word) {
        Trie node = this;
        for (char c : word.toCharArray()) {
            node.children.putIfAbsent(c, new Trie());
            node = node.children.get(c);
        }
        node.isTerminal = true;
    }

    public boolean search(String word) {
        Trie node = this;
        for (char c : word.toCharArray()) {
            if (!node.children.containsKey(c))
                return false;

            node = node.children.get(c);
        }

        return node.isTerminal;
    }

    public boolean startsWith(String prefix) {
        Trie node = this;
        for (char c : prefix.toCharArray()) {
            if (!node.children.containsKey(c))
                return false;

            node = node.children.get(c);
        }

        return true;
    }
}
