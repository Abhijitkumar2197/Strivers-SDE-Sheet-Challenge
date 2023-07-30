import java.util.*;

public class Solution {
    public static int[] jobScheduling(int [][]jobs) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        int[] res = {0, 0};

        int n = jobs.length;

        Arrays.sort(jobs, (a, b) -> Integer.compare(a[1], b[1]));

        for (int i = n - 1; i >= 0; i--) {

            int slot = (i == 0) ? jobs[i][1] : jobs[i][1] - jobs[i - 1][1];

            pq.offer(jobs[i][2]);

            while (slot > 0 && !pq.isEmpty()) {

                slot--;

                res[1] += pq.poll();

                res[0]++;

            }

        }

        return res;
    }
}
