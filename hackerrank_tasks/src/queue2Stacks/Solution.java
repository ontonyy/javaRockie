package queue2Stacks;

import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);

        Queue queue = new Queue();

        for (int i = 0; i < sc.nextInt(); i++) {
            int type = sc.nextInt();
            if (type == 1) {
                queue.push(sc.nextInt());
            } else if (type == 2) {
                queue.pop();
            } else if (type == 3) {
                System.out.println(queue.get());
            }
        }
    }
}

class Queue {
    Stack<Integer> enqueue;
    Stack<Integer> dequeue;

    public Queue() {
        this.enqueue = new Stack<Integer>();
        this.dequeue = new Stack<Integer>();
    }

    public void push(Integer num) {
        enqueue.push(num);
    }

    public int pop() {
        useDequeue();
        return dequeue.pop();
    }

    public int get() {
        useDequeue();
        return dequeue.peek();
    }

    public void useDequeue() {
        if (dequeue.isEmpty()) {
            while (!enqueue.isEmpty()) {
                dequeue.push(enqueue.pop());
            }
        }
    }
}