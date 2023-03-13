public class Triangle {
    public static void print_triangle(int N){
        int[][] pascal = new int[N+1][N+1];

        if (N >= 0) {
            pascal[0][0] = 1;
        }
        if (N >= 1) {
            pascal[1][0] = 1;
            pascal[1][1] = 1;
        }
        if (N >= 2) {
            for (int i = 2; i <= N; i++) {
                for (int j = i; j >= 0; j--) {
                    if (j == i || j == 0) {
                        pascal[i][j] = 1;
                    } else {
                        pascal[i][j] = pascal[i-1][j]+pascal[i-1][j-1];
                    }
                }
            }
        }

        for (int i = 0; i <= N; i++) {
            for (int j = N-i; j >= 0; j--) {
                System.out.print("\t");
            }

            for (int j = 0; j <= i; j++) {
                System.out.printf("%d\t", pascal[i][j]);
                if (j != i){
                    System.out.print("0\t");
                }
            }

            System.out.print("\n");
        }
    }

    public static void main(String[] args) {
        print_triangle(10);
    }
}
