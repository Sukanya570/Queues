#include <stdio.h>
#include <string.h>

struct Request {
    int id;
    int priority;
};

struct Queue {
    struct Request arr[1000];
    int front, rear, size;
};

void initQueue(struct Queue *q) {
    q->front = -1;
    q->rear = -1;
    q->size = 1000;
}

int isFull(struct Queue *q) {
    return ((q->rear + 1) % q->size) == q->front;
}

int isEmpty(struct Queue *q) {
    return q->front == -1;
}

void enqueue(struct Queue *q, int id, int priority) {
    if (isFull(q)) {
        printf("Queue is full\n");
        return;
    }

    if (isEmpty(q)) {
        q->front = q->rear = 0;
    } else {
        q->rear = (q->rear + 1) % q->size;
    }

    q->arr[q->rear].id = id;
    q->arr[q->rear].priority = priority;

    printf("Enqueued request ID: %d with priority: %d\n", id, priority);
}

void dequeue(struct Queue *q) {
    if (isEmpty(q)) {
        printf("Queue is empty\n");
        return;
    }

    printf("Processed request ID: %d with priority: %d\n",
           q->arr[q->front].id, q->arr[q->front].priority);

    if (q->front == q->rear) {
        q->front = q->rear = -1;
    } else {
        q->front = (q->front + 1) % q->size;
    }
}

void peek(struct Queue *q) {
    if (isEmpty(q)) {
        printf("Queue is empty\n");
    } else {
        printf("Front request ID: %d with priority: %d\n",
               q->arr[q->front].id, q->arr[q->front].priority);
    }
}

int main() {
    int n;
    scanf("%d", &n);

    struct Queue q;
    initQueue(&q);

    while (n--) {
        char command[20];
        scanf("%s", command);

        if (strcmp(command, "enqueue") == 0) {
            int id, priority;
            scanf("%d %d", &id, &priority);
            enqueue(&q, id, priority);
        }
        else if (strcmp(command, "dequeue") == 0) {
            dequeue(&q);
        }
        else if (strcmp(command, "peek") == 0) {
            peek(&q);
        }
    }

    return 0;
}

