import java.math.BigDecimal;

class Solution {
    private static BigDecimal[] f = new BigDecimal[100001];
    
    public int solution(int n) {
        int answer = 0;
		answer = fibo(n).remainder(BigDecimal.valueOf(1234567)).intValue();
        
        return answer;
        
    }
    
    public BigDecimal fibo(int n) {

        f[0] = BigDecimal.valueOf(0);
        f[1] = BigDecimal.valueOf(1);
        
        for(int i = 2; i <= n; i++ ){ // 3
			f[i] = f[i-2].add(f[i-1]) ;	
        }
        
        return f[n];    
    }
}