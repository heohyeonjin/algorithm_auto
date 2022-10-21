
import java.util.*;

class Solution {
    ArrayList<ArrayList<Edge>> graph;
    class Edge implements Comparable<Edge>{
        int next;
        int cost;
        Edge(int next, int cost){
            this.next = next;
            this.cost = cost;
        }
        @Override
        public int compareTo(Edge e){
            return this.cost - e.cost;
        }
    }
    int[] dijkstra(int start, int[] costs){
        PriorityQueue<Edge> pq = new PriorityQueue<>(graph.get(start));
        for(Edge e : graph.get(start)) costs[e.next] = e.cost;
        costs[start] = 0;
        while(!pq.isEmpty()){
            Edge e = pq.poll();
            if(costs[e.next] < e.cost) continue;
            for(Edge ne : graph.get(e.next)){
                if(costs[ne.next] > e.cost + ne.cost){
                    costs[ne.next] = e.cost + ne.cost;
                    pq.add(new Edge(ne.next, e.cost + ne.cost));
                }
            }
        }
        return costs;
    }
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = Integer.MAX_VALUE;

        graph = new ArrayList<>();
        for(int i = 0 ; i < n ; i ++) graph.add(new ArrayList<>());
        for(int[] i : fares){
            graph.get(i[0] - 1).add(new Edge(i[1] - 1, i[2]));
            graph.get(i[1] - 1).add(new Edge(i[0] - 1, i[2]));
        }
        int[] startA = new int[n];
        int[] startB = new int[n];
        int[] start = new int[n];

        Arrays.fill(startA, 100000 * n);
        Arrays.fill(startB, 100000 * n);
        Arrays.fill(start, 100000 * n);

        startA = dijkstra(a - 1, startA);
        startB = dijkstra(b - 1, startB);
        start = dijkstra(s - 1, start);

        for(int i = 0 ; i < n ; i ++) answer = Math.min(answer, startA[i] + startB[i] + start[i]);
        return answer;
    }
}