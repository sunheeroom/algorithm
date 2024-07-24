class Solution {
    public static String[] solution(String[] strings, int n) {
    
	java.util.Arrays.sort(strings, new java.util.Comparator<String>() {
        @Override
        public int compare(String o1, String o2){
    		if (o1.charAt(n) == o2.charAt(n)) {
                return o1.compareTo(o2);
            }        
            return o1.charAt(n) - o2.charAt(n);
        }    
    });
            
    return strings;
    }
}