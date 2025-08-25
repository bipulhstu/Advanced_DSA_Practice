package Recursion;

public class FirstAndLastOccurrence {

    public static int firstOccurrence(int[] arr, int key, int i){

        if(i == arr.length - 1){ //base case: no occurrence found
            return -1;
        }

        if(arr[i] == key){
            return i;
        }

        return firstOccurrence(arr, key, i+1);
    }

    public static int lastOccurrence(int[] arr, int key, int i){
        if(i == arr.length){ //base case: no occurrence found
            return -1;
        }

        int isFound = lastOccurrence(arr, key, i+1);
        if(isFound == -1 && arr[i] == key){
            return i;
        }

        return isFound;
    }

    public static void main(String[] args) {

        int arr[] = {8, 3, 6, 9, 5, 10, 2, 5, 3};
        System.out.println(firstOccurrence(arr, 5, 0));

        System.out.println(lastOccurrence(arr, 5, 0));
    }
}
