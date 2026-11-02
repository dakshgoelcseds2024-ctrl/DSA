class Solution {
    public boolean isMatch(String s, String p) {

        int i = 0;          // Pointer for string s
        int j = 0;          // Pointer for pattern p

        int star = -1;       // Position of last *
        int match = 0;       // Position in s matched by *

        while (i < s.length()) {

            // Characters match or pattern contains ?
            if (j < p.length() &&
                (p.charAt(j) == s.charAt(i) || p.charAt(j) == '?')) {

                i++;
                j++;
            }

            // If pattern contains *
            else if (j < p.length() && p.charAt(j) == '*') {

                star = j;
                match = i;
                j++;
            }

            // If mismatch occurs, use previous *
            else if (star != -1) {

                j = star + 1;
                match++;
                i = match;
            }

            // No * available to handle mismatch
            else {
                return false;
            }
        }

        // Ignore remaining * characters
        while (j < p.length() && p.charAt(j) == '*') {
            j++;
        }

        return j == p.length();
    }
}
