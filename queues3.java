import java.util.*;

class Solution {
    static class PrintJob {
        String id; int p;
        PrintJob(String id, int p) { this.id = id; this.p = p; }
    }

    static final int MAX_SIZE = 100;
    static Queue<PrintJob> q = new LinkedList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());

        while (N-- > 0) {
            String cmd = sc.next();
            if (cmd.equals("add_job")) {
                String id = sc.next();
                int p = sc.nextInt();
                addJob(id, p);
            } else if (cmd.equals("process_jobs")) {
                processJobs();
            } else if (cmd.equals("queue_size")) {
                System.out.println("Current queue size: " + q.size());
            }
        }
        sc.close();
    }

    static void addJob(String id, int p) {
        if (q.size() == MAX_SIZE) {
            PrintJob low = null;
            for (PrintJob j : q)
                if (low == null || j.p < low.p) low = j;
            q.remove(low);
        }
        q.add(new PrintJob(id, p));
        System.out.println("Added: Job ID: " + id + ", Priority: " + p);
    }

    static void processJobs() {
        System.out.println("Processing print jobs:");
        while (!q.isEmpty()) {
            PrintJob j = q.poll();
            System.out.println("Processing Job ID: " + j.id + ", Priority: " + j.p);
        }
    }
}
