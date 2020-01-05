import java.util.Stack;

/**
 * Created by Sharath Nagendra on 7/18/2018.
 */
public class StackNextGreaterElement {


    static void nextGreaterElement(int[] arr) {
//

        Stack<Integer> stack = new Stack<>();
        stack.push(arr[0]);
        int next, element;
        for (int i = 1; i < arr.length; i++) {

            next = arr[i];
            if (!stack.isEmpty()) {

                element = stack.pop();

                while (element < next) {
                    System.out.println(element + "==>" + next);
                    if (stack.isEmpty())
                        break;
                    element = stack.pop();

                }
                if (element > next)
                    stack.push(element);

            }
            stack.push(next);

        }

        while (!stack.isEmpty()) {
            element = stack.pop();
            next = -1;
            System.out.println(element + " -- " + next);
        }


    }

    // 9
// 3
// 1
// 4
// 2
// 5
    Stack<Integer> mainStack = new Stack<>();
    Stack<Integer> supportStack = new Stack<>();


    void push(int val) {

        mainStack.push(val);

        if(supportStack.isEmpty())
            supportStack.push(val);

        else {
            if (mainStack.peek() <= supportStack.peek()) {

                supportStack.push(val);
            }
        }


    }

    void pop() {
        int poppedElement = 0;
        if (!mainStack.isEmpty())
            poppedElement = mainStack.pop();

        if (!supportStack.isEmpty())
            if (poppedElement == supportStack.peek()) {
                supportStack.pop();

            }
    }

    void getMin() {
        System.out.println("Min value in stack is " + supportStack.peek());

    }
    void peek(){
        System.out.println(mainStack.peek());
    }

    public static void main(String[] args) {
        int[] arr = {4, 5, 2, 25};
        nextGreaterElement(arr);
        StackNextGreaterElement s = new StackNextGreaterElement();
        s.push(5);
        s.push(2);
        s.push(4);
        s.push(1);
        s.push(3);
        s.push(9);
        s.pop();
        s.pop();
        s.pop();

       // s.peek();
        //s.getMin();
    }
}
