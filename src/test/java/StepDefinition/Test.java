package StepDefinition;

public class Test {
    // Online Java Compiler
// Use this editor to write, compile and run
//        public static void main(String[] args) {
//            int a, b, c, d;
//            for (a = 0; a < 5; a++) {
//                for (b = a; b < 5; b++) {
//                    System.out.print("*");
//                }
//                for (c = 0; c < a*2; c++) {
//                    System.out.print(" ");
//                }
//                for(d=a;d<5;d++){
//                    System.out.print("*");
//                }
//                System.out.println();
//            }
//            for(a=0;a<5;a++){
//                for(b=0;b<=a;b++){
//                    System.out.print("*");
//                }
//                for(c=8;c>a*2;c--){
//                    System.out.print(" ");
//                }
//                for(d=0;d<=a;d++){
//                    System.out.print("*");
//                }
//                System.out.println();
//            }
//        }
        public static void main(String args[]) {
            int a, square=64;
            long rice=1;
            for(a=1;a<=square;a++){
                rice=rice*2;
                System.out.println(rice);
            }
            //System.out.println("Totol rice is"+rice);
    }
}
