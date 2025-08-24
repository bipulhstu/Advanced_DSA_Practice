package Bit_Manipulation;

public class BinaryRightShift {
    public static void main(String[] args) {
        System.out.println(5 >> 2);
        //Output: 1

        System.out.println(6 >> 1);
        //Output: 3

        //Rules: a >> b = a / 2^b

        //Using Rules:
        //5 >> 2 = 5 / 4 = 1
        //6 >> 1 = 6 / 2 = 3
    }
}
