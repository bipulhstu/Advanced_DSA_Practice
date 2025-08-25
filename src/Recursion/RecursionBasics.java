package Recursion;

public class RecursionBasics {

    public  static void printDec(int n){
        if (n == 1){ //base case
            System.out.print(n);
            return;
        }

        System.out.print(n + " ");
        printDec(n-1);
    }

    public static void printInc(int n){
        if (n == 1){ //base case
            System.out.print(n + " ");
            return;
        }

        printInc(n-1);
        System.out.print(n + " ");
    }

    public static int factorial(int n){

        if (n == 1){ //base case
            return 1;
        }

        int fnm1 = factorial(n-1);
        int fn = n * fnm1;
        return fn;
    }

    public static int calculateSum(int n){
        if(n == 1){ //base case
            return 1;
        }

        int Snm1 = calculateSum(n-1);
        int sum = n + Snm1;
        return sum;
    }

    public static int fib(int n){
        if(n == 0 || n == 1){ //base case
            return n;
        }
        int fnm1 = fib(n-1);
        int fnm2 = fib(n-2);
        int fn = fnm1 + fnm2;
        return fn;
    }

    public static boolean isSorted(int arr[], int i){

        if(i == arr.length - 1){
            return true;
        }

        if (arr[i] > arr[i+1]){
            return false;
        }

        return isSorted(arr, i + 1);
    }

    public static void main(String[] args) {
        int n = 10;
        printDec(n);
        //Output: 10 9 8 7 6 5 4 3 2 1

        System.out.println();

        printInc(n);
        //Output: 1 2 3 4 5 6 7 8 9 10

        System.out.println();

        System.out.println("Factorial of " + n + " is " + factorial(n));

        System.out.println("Sum of " + n + " is " + calculateSum(n));

        System.out.println("Fibonacci of " + n + "th number is " + fib(n));

        int arr[] = {4, 2, 3, 4, 5};
        System.out.println("Is Sorted: " + isSorted(arr, 0));
    }
}
