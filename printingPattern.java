public class printingPattern {
    static void p1(){
        int n = 5;
        for(int row = 1; row <= n; row++){
            for(int col = 1; col <= n; col++){
                if(col <= row){
                    System.out.print("* ");
                }
                
            }
            System.out.println();
        }
    }

    static void p2(){
        int n = 5;
        for(int row = 1; row <= n; row++){
            for(int col = 1; col <= n; col++){
                if(col <= n - row +1){
                    System.out.print("* ");
                }
                
            }
            System.out.println();
        }
    }

    static void p3(){
        int n = 5;
        for(int row = 1; row <= n; row++){
            for(int col = 1; col <= n; col++){
                if(col <= n -row){
                    System.out.print(" ");
                }
                else{
                    System.out.print("*");
                }
                
            }
            System.out.println();
        }
    }

    static void p4(){
        int n = 5;
        for(int row = 1; row <= n; row++){
            for(int col = 1; col <= n; col++){
                if(col <= n -row){
                    System.out.print(" ");
                }
                else{
                    System.out.print(" *");
                }
                
            }
            System.out.println();
        }
    }

    static void pascal() {
    int n = 5;
    long num = 1;   // use long to avoid early overflow

    for (int row = 1; row <= n; row++) {

        // spacing
        for (int space = 1; space <= n - row; space++) {
            System.out.print(" ");
        }

        long temp = num;

        // print digits using modulus
        while (temp > 0) {
            System.out.print((temp % 10) + " ");
            temp = temp / 10;
        }

        System.out.println();

        // multiply by 11 for next row
        num = num * 11;
    }
}

    

    

    static void p5(){
        int n = 5;

        for(int row = 1; row <= n; row++){
            for(int col = 1; col <= n; col++){
                if(col >= row ){
                    System.out.print("*");
                }
                else{
                    System.out.print(" ");
                }
                
            }
            System.out.println();
        }
    }

    static void p6(){
        int n = 5;

        for(int row = 1; row <= n; row++){
            for(int col = 1; col <= n; col++){
                if(row == 1 || row == n || col == 1 || col == n){
                    System.out.print("*");
                }
                else{
                    System.out.print(" ");
                }
                
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        pascal();
         


    }
}
