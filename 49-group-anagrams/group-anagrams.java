
import java.util.*;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {

            // Convert string into character array
            char[] chars = str.toCharArray();

            // Sort characters
            Arrays.sort(chars);

            // Create sorted string as key
            String key = new String(chars);

            // Add original string to its group
            map.computeIfAbsent(key, k -> new ArrayList<>())
               .add(str);
        }

        return new ArrayList<>(map.values());
    }
}
