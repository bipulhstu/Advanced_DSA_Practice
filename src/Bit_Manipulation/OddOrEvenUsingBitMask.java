package Bit_Manipulation;

public class OddOrEvenUsingBitMask {

    public static void oddOrEven(int number){
        int bitMask = 1;

        if( (number & bitMask) == 0){
            System.out.println(number + " is even");
        }else{
            System.out.println(number + " is odd");
        }

    }

    public static void main(String[] args) {
        oddOrEven(3);
        oddOrEven(6);
        oddOrEven(7);

        //Output:
        //3 is odd
        //6 is even
        //7 is odd
    }
}
