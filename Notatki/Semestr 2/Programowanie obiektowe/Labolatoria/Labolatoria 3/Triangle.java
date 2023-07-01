public class Triangle {
    public static void print_triangle(int N) {
        Integer[][] pascal = new Integer[N+1][N+1];
        int widest = 1;


        if (N >= 0) {
            pascal[0][0] = 1;
        }

        if (N >= 1) {
            pascal[1][0] = 1;
            pascal[1][1] = 1;
        }

        for (int i = 2; i <= N; i++){
            for (int j = i; j >= 0; j--){
                if (j==0 || j==i){
                    pascal[i][j] = 1;
                } else {
                    pascal[i][j]=pascal[i-1][j]+pascal[i-1][j-1];
                }

                if(pascal[i][j].toString().length() >= widest) {
                    widest = pascal[i][j].toString().length();
                }
            }
        }

        for (int i = 0; i <= N; i++) {
            for (int j = N-i; j > 0; j--) {
                for (int k = widest; k > 0; k--){
                    System.out.print(" ");
                }
                System.out.print("0");
            }

            for (int j = 0; j <= i; j++) {
                for (int k = widest - pascal[i][j].toString().length(); k >= 0; k--){
                    System.out.print(" ");
                }
                System.out.printf("%d", pascal[i][j]);
                for (int k = widest; k > 0; k--){
                    System.out.print(" ");
                }
                System.out.print("0");
            }

            for (int j = N-i; j >= 0; j--) {
                for (int k = widest; k > 0; k--){
                    System.out.print(" ");
                }
                System.out.print("0");
            }

            System.out.print("\n");
        }
    }

    public static void print_triangle_but_better(int N) {
        Integer[][] pascal = new Integer[N+1][N+1];
        int widest = 1;


        if (N >= 0) {
            pascal[0][0] = 1;
        }

        if (N >= 1) {
            pascal[1][0] = 1;
            pascal[1][1] = 1;
        }

        for (int i = 2; i <= N; i++){
            for (int j = i; j >= 0; j--){
                if (j==0 || j==i){
                    pascal[i][j] = 1;
                } else {
                    pascal[i][j]=pascal[i-1][j]+pascal[i-1][j-1];
                }

                if(pascal[i][j].toString().length() >= widest) {
                    widest = pascal[i][j].toString().length();
                }
            }
        }

        for (int i = 0; i <= N; i++) {
            for (int j = N-i; j > 0; j--) {
                for (int k = widest; k >= 0; k--){
                    System.out.print(" ");
                }
            }

            for (int j = 0; j <= i; j++) {
                for (int k = widest - pascal[i][j].toString().length(); k >= 0; k--){
                    System.out.print(" ");
                }
                System.out.printf("%d", pascal[i][j]);
                for (int k = widest; k >= 0; k--){
                    System.out.print(" ");
                }
            }

            for (int k = widest; k >= 0; k--){
                System.out.print(" ");
            }

            System.out.print("\n");
        }
    }



    public static void main(String[] args) {
        print_triangle(21);

        System.out.print("\n\n\n\n\n\n");

        print_triangle_but_better(21);


    }
}