class Solution {
    public long[] solution(int n, long left, long right) {

        long[] temp = new long[(int)(right - left) + 1];	// 3
        int index = 0;
        
        // 2 , 5
        for (long i=left; i <= right; i++){
            if ( i % n == 0) { // 2
				temp[index++] = ((i / n) + 1L);
            } else {
                temp[index++] = Math.max(((i % n) + 1L), (i/ n) + 1L); 
            }        
        }
        return temp;
    }
}