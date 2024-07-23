class Solution {
    public int[] solution(int n, long left, long right) {
        int[] temp = new int[(int) (right - left) + 1 ];
        int index = 0;
        
        for (long i=left; i <= right; i++){
            int div = (int)(i / n) + 1;
            if ( i % n == 0) {
				temp[index++] = div;
            } else {
                int mod = (int) (i % n) + 1;
                temp[index++] = Math.max(mod, div); 
            }        
        }
        return temp;
    }
}