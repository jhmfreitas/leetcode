package blind75.medium;

import java.util.*;

public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        int[] inDegrees = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] preReq : prerequisites) {
            int course = preReq[0];
            int dep = preReq[1];
            graph.get(dep).add(course);
            inDegrees[preReq[0]]++;
        }

        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < numCourses; i++) {
            if(inDegrees[i] == 0) {
                deque.offer(i);
            }
        }

        if (deque.isEmpty())
            return false;

        int processedNodes = 0;
        while (!deque.isEmpty()) {
            Integer node = deque.poll();
            processedNodes++;
            for (Integer dep : graph.get(node)) {
                inDegrees[dep]--;
                if (inDegrees[dep] == 0){
                    deque.offer(dep);
                }
            }
        }

        return processedNodes == numCourses;
    }
}
