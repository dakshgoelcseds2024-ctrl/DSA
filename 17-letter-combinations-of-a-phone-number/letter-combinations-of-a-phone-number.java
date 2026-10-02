import java.util.*;

class Solution {

    public List<String> letterCombinations(String digits) {

        List<String> result = new ArrayList<>();

        if (digits.length() == 0)
            return result;

        String[] phone = {
            "", "", "abc", "def", "ghi",
            "jkl", "mno", "pqrs", "tuv", "wxyz"
        };

        solve(digits, 0, "", phone, result);

        return result;
    }

    void solve(String digits, int index, String str,
               String[] phone, List<String> result) {

        if (index == digits.length()) {
            result.add(str);
            return;
        }

        String letters = phone[digits.charAt(index) - '0'];

        for (char c : letters.toCharArray()) {
            solve(digits, index + 1, str + c, phone, result);
        }
    }
}