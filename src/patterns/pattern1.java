package patterns;

import javax.imageio.ImageTranscoder;

public class pattern1 {
    public static void main(String[] args) {
        int r = 6;
        for (int i = 0; i < r ; i++) {
            for (int j = r - i - 1; j >= 1; j--) {
                System.out.print(" ");
            }

            for (int j = 0; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
    static void patternPyramid(int n) {
        for (int i = 1; i <= n; i++) {
            // Print spaces for alignment
            for (int space = 0; space < n - i; space++) {
                System.out.print("  ");
            }

            for (int j = 1; j <= (2 * i - 1); j++) {
                System.out.print("* ");
            }

            System.out.println();
        }
    }

    static void patternCustom(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // Conditions to print the stars based on the pattern
                if (i == j || i + j == n - 1 || i == 0 || i == n - 1 || j == 0 || j == n - 1) {
                    System.out.print("* ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }
    static void pattern(int n){
        for (int i = 1; i <= n ; i++) {
            for (int j = 1; j <= i ; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    static void pattern31(int n){
        int OriginalN = n;
        n = 2 * n;
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                int EveryIndex = OriginalN - Math.min(Math.min(i, j),Math.min(n - i,n - j));
                System.out.print(EveryIndex + " ");
            }
            System.out.println( );
        }
    }

    static void pattern17(int n){

        for (int i = 1; i <= 2*n ; i++) {
            int c = i > n ? 2 * n - i : i;
            for (int space = 0; space < n - c; space++) {
                System.out.print("  ");
            }
            for (int j = c; j >= 1 ; j--) {
                System.out.print(j +" ");
            }
            for (int j = 2; j <= c ; j++) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }

    static void pattern30(int n){
        for (int i = 1; i <= n ; i++) {
            for (int space = 0; space < n - i; space++) {
                System.out.print("  ");
            }
            for (int j = i; j >= 1 ; j--) {
                System.out.print(j +" ");
            }
            for (int j = 2; j <= i ; j++) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }

    static void pattern28(int n){
        for (int i = 0; i < 2*n  ; i++) {
            int totalColsInRow = i > n ? 2 * n - i : i;
            int noOfSpaces = n - totalColsInRow;
            for (int s = 0; s < noOfSpaces; s++) {
                System.out.print(" ");
            }
            for (int j = 0; j < totalColsInRow ; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    static void pattern4(int n){
        for (int i = 0; i < 2*n  ; i++) {
            int totalColsInRow = i > n ? 2 * n - i : i;
            for (int j = 0; j < totalColsInRow ; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    static void pattern3(int n){
        for (int i = 1; i <= n ; i++) {
            for (int j = 1; j <= i ; j++) {
                System.out.print(j+" ");
            }
            System.out.println();
        }
    }

    static void pattern2(int n){
        for (int i = 1; i <= n ; i++) {
            for (int j = 1; j <= n-i+1 ; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    static void pattern1(int n){
        for (int i = 1; i <= n ; i++) {
            for (int j = 1; j <= n ; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
