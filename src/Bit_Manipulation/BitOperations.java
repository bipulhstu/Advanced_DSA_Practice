package Bit_Manipulation;

public class BitOperations {

    public static int getIthBit(int number, int i){
        int bitMask = 1 << i;

        if((number & bitMask) == 0){
            return 0;
        }else{
            return 1;
        }
    }

    public static int setIthBit(int number, int i){
        int bitMask = 1 << i;
        return number | bitMask;
    }

    public static int clearIthBit(int number, int i){
        int bitMask = ~(1 << i);
        return number & bitMask;
    }

    public static int updateIthBit(int number, int i, int newBit){
        /*if(newBit == 0){
            return clearIthBit(number, i);
        }else{
            return setIthBit(number, i);
        }*/

        //2nd way
        number = clearIthBit(number, i);
        int bitMask = newBit << i;
        return number | bitMask;
    }

    public static int clearIBits(int n, int i){
        int bitMask = (~0) << i; //or (-1) << i
        return n & bitMask;
    }

    public static int clearBitsInRange(int n, int i, int j){
        int a = ((~0) << (j+1));
        int b = (1 << i) - 1;
        int bitMask = a | b;
        return n & bitMask;
    }

    public static void isPowerOfTwo(int n){
        if((n & (n-1)) == 0){
            System.out.println(n + " is a power of two");
        }else{
            System.out.println(n + " is not a power of two");
        }
    }

    public static int countSetBits(int n){
        int count = 0;
        while(n > 0){
            if ((n & 1) != 0){ //check our LSB (Least Significant Bit)
                count++;
            }
            n = n >> 1; //right shift by 1 bit
        }
        return count;
    }

    public static void main(String[] args) {
        //Get ith bit
        System.out.println( getIthBit(10, 3));
        //Binary of 10 is 1010
        //Output: 1

        //Set ith bit
        System.out.println( setIthBit(10, 2));
        //Output: 1110 = 14
        //Explanation: 1010 with the 2nd bit set to 1
        //Decimal of 1110 is 14


        //Clear ith bit
        System.out.println(clearIthBit(10, 1));
        //Output is 8
        //(1<<1) is 0010
        //~(1<<1) is 1101
        //1010 & ~1101 = 1000
        //Decimal of 1000 is 8

        System.out.println( updateIthBit(10, 2, 1));
        //Update 2nd bit of 10 to 1
        //Decimal of 1110 is 14


        System.out.println( clearIBits(15, 2));
        //Clear last 2 bits of 15
        //Decimal of 1111 is 15
        //So, we have to clear the last 2 bits of 15 and the output will be 1100
        // (~0) << 2 is 11111100
        //00001111 & 11111100 = 00001100
        //Decimal of 1100 is 12

        System.out.println( clearBitsInRange(10, 2, 4));
        //Binary of 10 is 1010
        //Clear bits from 2 to 4 and that will be 0010
        //Decimal of 0010 is 2


        isPowerOfTwo(16); // Output: 16 is a power of two
        isPowerOfTwo(17); // Output: 17 is not a power of two

        System.out.println(countSetBits(10));
        //Output: 2
        //Binary of 10 is 1010
        //So, count set bits of 10 is 2
    }
}
