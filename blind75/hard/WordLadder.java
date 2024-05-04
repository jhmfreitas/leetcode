package blind75.hard;

import java.util.*;

public class WordLadder {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(beginWord.equals(endWord) || !wordList.contains(endWord) || beginWord.length() != endWord.length()) {
            return 0;
        }

        Map<String, List<String>> adjList = new HashMap<>();
        wordList.add(beginWord);

        // Time Complexity: O(N*m^2) where m is the number of characters and N number of words
        // By creating an adjacency we are able to improve the performance of the search vs changing a character
        // in the word and look for that word in the list which is the approach below
        for (String word : wordList) {
            for (int i = 0; i < word.length(); i++) {
                String pattern = word.substring(0, i) + "*" + word.substring(i + 1);
                adjList.computeIfAbsent(pattern, k -> new ArrayList<>()).add(word);
            }
        }

        Set<String> wordSet = new HashSet<>();
        wordSet.add(beginWord);

        int level = 1;
        ArrayDeque<String> deque = new ArrayDeque<>();
        deque.offer(beginWord);

        while(!deque.isEmpty()) {
            int size = deque.size();
            for(int i = 0; i < size; i++) {
                String word = deque.poll();
                if(endWord.equals(word)) {
                    return level;
                }

                for(int j = 0; j < word.length(); j++) {
                    String pattern = word.substring(0, j) + "*" + word.substring(j + 1);
                    for(String w : adjList.get(pattern)) {
                        if(!wordSet.contains(w)) {
                            deque.offer(w);
                            wordSet.add(w);
                        }
                    }
                }

            }
            level++;
        }

        return 0;
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(beginWord.equals(endWord)) {
            return 0;
        }

        // Searches in a hashset are O(1) so we use a set here
        Set<String> wordSet = new HashSet<>(wordList);

        if(!wordSet.contains(endWord) || beginWord.length() != endWord.length()) {
            return 0;
        }

        int level = 1;
        ArrayDeque<String> deque = new ArrayDeque<>();
        deque.offer(beginWord);

        while(!deque.isEmpty()) {
            int size = deque.size();
            for(int i = 0; i < size; i++) {
                char[] wordLetters = deque.poll().toCharArray();
                for(int j = 0; j < wordLetters.length; j++) {
                    char originalCharacter = wordLetters[j];
                    for (char c = 'a'; c <= 'z'; c++) {
                        if(c == originalCharacter) {
                            continue;
                        }

                        wordLetters[j] = c;
                        String newWord = new String(wordLetters);
                        if(newWord.equals(endWord)) {
                            return level + 1;
                        }

                        if(wordSet.contains(newWord)) {
                            wordSet.remove(newWord);
                            deque.offer(newWord);
                        }

                        wordLetters[j] = originalCharacter;
                    }
                }
            }
            level++;
        }

        return 0;
    }
}
