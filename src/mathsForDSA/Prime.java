package mathsForDSA;

public class Prime {
    public static void main(String[] args) {
        int n = 9;
        boolean[] prime = new boolean[n + 1];
        modifiedPrime(n, prime);
    }
    static void modifiedPrime(int n, boolean[] prime){
        for (int i = 2; i <= n ; i++) {
            if (!prime[i]){
                for (int j = i*2; j <= n ; j+=i) {
                    prime[j] = true;
                }
            }
        }
        for (int i = 2; i <= n ; i++) {
            if (!prime[i]){
                System.out.print(i + " ");
            }
        }
    }
    static boolean isPrime(int n){
        if (n <= 1){
            return false;
        }
        int c  = 2;
        while (c <= Math.sqrt(n)){
            if (n % c == 0){
                return false;
            }
            c++;
        }
        return true;
    }
}
