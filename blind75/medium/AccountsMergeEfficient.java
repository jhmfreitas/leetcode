package blind75.medium;

import java.util.*;

public class AccountsMergeEfficient {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        UnionFind dsu = new UnionFind(accounts.size());

        Map<String, Integer> mapEmailToAccount = new HashMap<>();
        for(int i = 0; i < accounts.size(); i++){
            List<String> account = accounts.get(i);
            for(int j = 1; j < account.size(); j++){
                String email = account.get(j);
                if (!mapEmailToAccount.containsKey(email)){
                    // Here we associate the account id (i) to the email
                    // This adds the first entry in the map for the email accounts to allow the union for the next emails
                    // in the same account
                    mapEmailToAccount.put(email, i);
                } else{
                    dsu.union(mapEmailToAccount.get(email), i);
                }
            }
        }

        Map<Integer, Set<String>> groupEmail = new HashMap<>();
        for(Map.Entry<String, Integer> entry : mapEmailToAccount.entrySet()){
            String email = entry.getKey();
            int index = entry.getValue();
            int groupIndex = dsu.find(index);
            if(!groupEmail.containsKey(groupIndex)){
                groupEmail.put(groupIndex, new TreeSet<>());
            }
            // here the account id is used to group the accounts
            groupEmail.get(groupIndex).add(email);
        }

        List<List<String>> res = new ArrayList<>();
        for (Map.Entry<Integer, Set<String>> entry : groupEmail.entrySet()) {
            List<String> user  = new ArrayList<>();
            String username = accounts.get(entry.getKey()).get(0);
            user.add(username);
            user.addAll(entry.getValue());
            res.add(user);
        }

        return res;
    }

    public static class UnionFind {

        int[] parent;

        public UnionFind(int n) {
            parent = new int[n];
            for(int i = 0; i < n; i++){
                // initalizes array with different i for each entry
                parent[i] = i;
            }
        }

        public int find(int x) {
            int y = parent[x];
            if(x != y) {
                y = find(y);
                // compress tree and add direct link from child to parent
                parent[x] = y;
            }
            return y;
        }

        public void union(int x, int y) {
            parent[find(x)] = find(y);
        }
    }

}
