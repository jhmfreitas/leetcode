package blind75.medium;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.PriorityQueue;

public class TaskScheduler {
    // More efficient
    // Review
    public int leastInterval(char[] tasks, int n) {
        int[] taskCounter = new int[26];
        // Maximum frequency among the tasks
        int maxFrequency = 0;

        for (char c : tasks) {
            int index = c - 'A';
            taskCounter[index]++;
            maxFrequency = Math.max(maxFrequency, taskCounter[index]);
        }

        // Count how many tasks have the maximum frequency
        int maxFrequencyTasks = 0;
        for (int count : taskCounter) {
            if (count == maxFrequency) {
                maxFrequencyTasks++;
            }
        }

        // Calculate the minimum length of the task schedule
        // Each block of tasks includes the cooldown period followed by the most frequent task itself
        // Then, add the number of tasks with maximum frequency to cover the last one without tailing idle time
        int minScheduleLength = Math.max(tasks.length, (maxFrequency - 1) * (n + 1) + maxFrequencyTasks);

        return minScheduleLength;
    }

    //Less efficient
    public int leastInterval(char[] tasks, int n) {
        HashMap<Character, Integer> taskCounter = new HashMap<>();
        HashMap<Character, Integer> timeout = new HashMap<>();

        int tasksLeft = tasks.length;
        for (char c : tasks) {
            taskCounter.put(c, taskCounter.getOrDefault(c, 0) + 1);
            timeout.put(c, 0);
        }

        PriorityQueue<Character> priorityQueue = new PriorityQueue<>((a, b) -> taskCounter.get(b) - taskCounter.get(a));
        int iterations = 0;
        while (tasksLeft != 0) {
            iterations++;
            timeout.forEach((key, value) -> {
                if (timeout.get(key) == 0 && taskCounter.get(key) > 0 && !priorityQueue.contains(key)) {
                    priorityQueue.offer(key);
                } else if (timeout.get(key) > 0) {
                    timeout.put(key, timeout.get(key) - 1);
                }
            });

            if(!priorityQueue.isEmpty()) {
                Character c = priorityQueue.poll();
                taskCounter.put(c, taskCounter.get(c) - 1);
                timeout.put(c, n);
                tasksLeft--;
            }

        }

        return iterations;
    }

}
