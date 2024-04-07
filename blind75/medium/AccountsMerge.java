package blind75.medium;

import java.util.*;
import java.util.stream.Collectors;

public class AccountsMerge {

    public static class UserEmailPair implements Comparable<UserEmailPair>{
        private String name;
        private String email;

        public UserEmailPair(String name, String email) {
            this.name = name;
            this.email = email;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            UserEmailPair that = (UserEmailPair) o;
            return Objects.equals(name, that.name) && Objects.equals(email, that.email);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, email);
        }

        @Override
        public int compareTo(UserEmailPair o) {
            if(!name.equals(o.name)){
                return name.compareTo(o.name);
            }
            return email.compareTo(o.email);
        }
    }

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        UnionFind<UserEmailPair> dsu = new UnionFind<UserEmailPair>();
        List<UserEmailPair> allEmails = new ArrayList<>();

        for (List<String> accountDetails : accounts) {
            String username = accountDetails.get(0);
            UserEmailPair emailParent = null;
            for (int i = 1; i < accountDetails.size(); i++) {
                UserEmailPair userEmailPair = new UserEmailPair(username, accountDetails.get(i));
                allEmails.add(userEmailPair);
                if (emailParent == null) {
                    emailParent = userEmailPair;
                } else {
                    dsu.union(emailParent, userEmailPair);
                }
            }
        }

        Map<UserEmailPair, Set<String>> accountAssociations = new HashMap<>();
        for (UserEmailPair pair : allEmails) {
            UserEmailPair parent = dsu.find(pair);
            Set<String> emails;
            if (accountAssociations.containsKey(parent)) {
                emails = accountAssociations.get(parent);
            } else {
                emails = new TreeSet<>();
            }

            emails.add(pair.email);
            accountAssociations.put(parent, emails);
        }

        List<List<String>> res = new ArrayList<>();
        for (Map.Entry<UserEmailPair, Set<String>> entry : accountAssociations.entrySet()) {
            List<String> user  = new ArrayList<>();
            user.add(entry.getKey().name);
            user.addAll(entry.getValue());
            res.add(user);
        }

        return res;
    }

    public static class UnionFind<T> {

        Map<T, T> id = new HashMap<>();

        public T find(T x) {
            // Get the value associated with key x, if it's not in the map return x
            T y = id.getOrDefault(x, x);

            // check if the current node is a Set ID node
            if (x != y) {
                // set the value to Set ID node of node y
                y = find(y);
                // change the hash value of node x to Set ID value of node y
                // compresses graphs to set a direct link from child to parent
                id.put(x, y);
            }

            return y;
        }

        // union two different sets setting one Set's parent to the other parent
        public void union(T x, T y) {
            id.put(find(x), find(y));
        }
    }
}
