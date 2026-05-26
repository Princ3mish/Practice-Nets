class Solution {
    public int numberOfSpecialChars(String word) {
        HashSet<Character> lower = new HashSet<>();
        HashSet<Character> upper = new HashSet<>();
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (Character.isLowerCase(ch)) {
                lower.add(ch);
            } else if (Character.isUpperCase(ch)) {
                upper.add(ch);
            }
        }
        
        int specialCount = 0;
        for (char ch : lower) {
            if (upper.contains(Character.toUpperCase(ch))) {
                specialCount++;
            }
        }
        
        return specialCount;
    }
}