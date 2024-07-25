class Solution {
    public String solution(String s) {
         char[] charArray = s.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            char ch = charArray[i];
            if ((i == 0 || charArray[i - 1] == ' ' ) && Character.isAlphabetic(ch)) {
                charArray[i] = Character.toUpperCase(ch);
            } else  {
                charArray[i] = Character.toLowerCase(ch);
            }
        }
        return String.copyValueOf(charArray);
    }
}