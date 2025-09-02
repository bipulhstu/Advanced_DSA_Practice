package Stack;

import java.util.Stack;

public class ReverseAStack {

    public static void pushAtTheBottom(Stack<Integer> stack, int data){
        //base case
        if(stack.isEmpty()){
            stack.push(data);
            return;
        }

        //recursive call
        int top = stack.pop();
        pushAtTheBottom(stack, data);
        stack.push(top);
    }

    public static void reverseStak(Stack<Integer> stack){
        //base call
        if(stack.isEmpty()){
            return;
        }

        //recursive call
        int top = stack.pop();
        reverseStak(stack);
        pushAtTheBottom(stack, top);
    }

    public static void printStack(Stack<Integer> stack){
        while (!stack.isEmpty()){
            System.out.println(stack.pop());
        }
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        //printStack(stack); //3, 2, 1
        reverseStak(stack);
        printStack(stack); //1, 2, 3
    }
}
