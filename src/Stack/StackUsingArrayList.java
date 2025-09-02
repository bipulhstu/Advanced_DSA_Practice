package Stack;
import java.util.ArrayList;

public class StackUsingArrayList {

    static class Stack{
        static ArrayList<Integer> list = new ArrayList<>();

        public static boolean isEmpty(){
            return list.size() == 0;
        }

        //push -> O(1)
        public static void push(int data){
            list.add(data);
        }

        //pop - O(1)
        public static int pop(){
            //corner case
            if(isEmpty()){
                return -1;
            }

            int top = list.get(list.size() - 1);
            list.remove(list.size() - 1);
            return top;
        }

        //peek - O(1)
        public static int peek(){
            //corner case
            if(isEmpty()){
                return -1;
            }

            return list.get(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        Stack stack = new Stack();
        Stack.push(1);
        stack.push(2);
        stack.push(3);

        while(!stack.isEmpty()){
            System.out.println(stack.peek());
            stack.pop();
        }
    }
}
