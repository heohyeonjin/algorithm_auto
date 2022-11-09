import java.util.*;
class Solution {
    static boolean visited[];
    static String course[];
    static ArrayList<String> allCourse = new ArrayList<>();
    public String[] solution(String[][] tickets) {
        String[] answer;
        visited = new boolean[tickets.length+1];
        course = new String[tickets.length+1];
        course[0] = "ICN";
        dfs(tickets,1,"ICN");
        Collections.sort(allCourse);
        answer = allCourse.get(0).split(" ");
        return answer;
    }
    public static void dfs(String [][] tickets, int depth, String v){
        if(depth==tickets.length+1){
            StringBuffer sb = new StringBuffer();
            for(String x : course){
                sb.append(x);
                sb.append(" ");
            }
            allCourse.add(sb.toString());
        }
        
        for(int i=0;i<tickets.length;i++){
            if(tickets[i][0].equals(v) && !visited[i]){
                visited[i] = true;
                course[depth] = tickets[i][1];
                dfs(tickets,depth+1,tickets[i][1]);
                visited[i] = false;        
            }
        }
    }
}