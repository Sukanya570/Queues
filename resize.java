import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class DynamicQueue {
    private int[] arr;
    private int front;
    private int rear;
    private int size;
    private int capacity;

    public DynamicQueue(int capacity) {
        this.capacity = capacity;
        arr = new int[capacity];
        front = 0;
        rear = -1;
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void enqueue(int value) {
        if (size == capacity) {
            resize();
        }
        rear++;
        arr[rear] = value;
        size++;
    }

    public int dequeue() {
        if (isEmpty()) return -1;
        int value = arr[front];
        front++;
        size--;
        return value;
    }

    public int peek() {
        if (isEmpty()) return -1;
        return arr[front];
    }

    private void resize() {
        int newCapacity = capacity * 2;
        int[] newArr = new int[newCapacity];
        for (int i = 0; i < size; i++) {
            newArr[i] = arr[front + i];
        }
        arr = newArr;
        front = 0;
        rear = size - 1;
        capacity = newCapacity;
    }

    public List<Integer> getQueue() {
        List<Integer> list = new ArrayList<>();
        for (int i = front; i <= rear; i++) {
            list.add(arr[i]);
        }
        return list;
    }
}

public class DynamicQueueDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> numbers = new ArrayList<>();

        while (sc.hasNextInt()) {
            numbers.add(sc.nextInt());
        }
        sc.close();

        if (numbers.size() < 2) return; // invalid input

        int n = numbers.get(0);          // total inputs
        DynamicQueue q = new DynamicQueue(n);

        // Enqueue all elements
        for (int i = 1; i < numbers.size(); i++) {
            q.enqueue(numbers.get(i));
        }

        // First output: dequeue first element
        int firstOutput = q.dequeue();
        System.out.println(firstOutput);

        // Second output: peek next element
        int secondOutput = q.peek();
        System.out.println(secondOutput);

        // Third output: remaining queue
        List<Integer> remainingQueue = q.getQueue();
        for (int i = 0; i < remainingQueue.size(); i++) {
            System.out.print(remainingQueue.get(i));
            if (i != remainingQueue.size() - 1) System.out.print(",");
        }
        System.out.println();
    }
}
