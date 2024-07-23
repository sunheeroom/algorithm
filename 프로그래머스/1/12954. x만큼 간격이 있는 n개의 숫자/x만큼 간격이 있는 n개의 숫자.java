class Solution {
    public long[] solution(int x, int n) {
        long[] answer = new long[n];

        long prev = 0L;

        for (int i = 0; i < n; i++) {
            prev += x;
            answer[i] = prev;
        }
        
        return answer;
    }
}