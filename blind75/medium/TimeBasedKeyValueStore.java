package blind75.medium;

import java.util.*;

public class TimeBasedKeyValueStore {

    class Pair {
        int timestamp;
        String val;

        Pair(int timestamp, String val) {
            this.timestamp = timestamp;
            this.val = val;
        }
    }


    class TimeMap {

        private Map<String, List<Pair>> keyTimeValueMap = new HashMap<>();

        public TimeMap() {
        }

        public void set(String key, String value, int timestamp) {
            Pair pair = new Pair(timestamp, value);
            keyTimeValueMap.computeIfAbsent(key, k -> new ArrayList<>()).add(pair);
        }

        public String get(String key, int timestamp) {
            if (!keyTimeValueMap.containsKey(key)) {
                return "";
            }

            // Doing binary search through the timestamps allows us to have an efficient search for the closest timestamp
            List<Pair> pairs = keyTimeValueMap.get(key);
            int left = 0;
            int right = pairs.size() - 1;
            String value = "";
            while (left <= right) {
                int mid = left + (right - left)/2;
                if (pairs.get(mid).timestamp <= timestamp) {
                    value = pairs.get(mid).val;
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }

            return value;
        }
    }

}
