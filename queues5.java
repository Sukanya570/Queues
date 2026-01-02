import java.util.Scanner;

class CircularQueue {
    private int[] arr;
    private int front;
    private int rear;
    private int count;
    private int capacity;

    public CircularQueue(int capacity) {
        this.capacity = capacity;
        arr = new int[capacity];
        front = 0;
        rear = -1;
        count = 0;
    }

    public boolean isFull() {
        return count == capacity;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public void enqueue(int value) {
        if (isFull()) {
            System.out.println("Queue is full");
            return;
        }
        rear = (rear + 1) % capacity;
        arr[rear] = value;
        count++;
        System.out.println("Enqueued request ID: " + value);
    }

    public void dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return;
        }
        System.out.println("Processed request ID: " + arr[front]);
        front = (front + 1) % capacity;
        count--;
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return;
        }
        System.out.print("Queue elements: ");
        for (int i = 0; i < count; i++) {
            int index = (front + i) % capacity;
            System.out.print(arr[index] + " ");
        }
        System.out.println();
    }

    public void size() {
        System.out.println("Current queue size: " + count);
    }
}

public class TaskSchedulerQueue {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();         // number of operations
        int capacity = sc.nextInt();  // queue capacity
        sc.nextLine(); // consume remaining newline

        CircularQueue queue = new CircularQueue(capacity);

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine().trim();
            String[] parts = line.split(" ");

            switch (parts[0]) {
                case "enqueue":
                    int value = Integer.parseInt(parts[1]);
                    queue.enqueue(value);
                    break;
                case "dequeue":
                    queue.dequeue();
                    break;
                case "display":
                    queue.display();
                    break;
                case "size":
                    queue.size();
                    break;
            }
        }

        sc.close();
    }
}
