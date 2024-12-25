package LeetCode.hard;
import java.util.*;
public class P332 {
    private Map<String, List<String>> map = new HashMap<>();
    private List<String> result = new ArrayList<>();

    // 오일러 경로 만들기
    private void dfs(String cur) {
        List<String> nextList = map.get(cur);

        // 사전순으로 빠른 노드부터 방문
        while(nextList != null && !nextList.isEmpty()) {
            String next = nextList.remove(nextList.size() - 1);
            dfs(next);
        }

        // 현재 노드 결과 배열에 추가
        result.add(cur);
    }

    public List<String> findItinerary(List<List<String>> tickets) {
        for (List<String> ticket : tickets)
            map.computeIfAbsent(ticket.get(0), k -> new ArrayList<>()).add(ticket.get(1));

        // 사전 역순으로 정렬
        for (List<String> value : map.values())
            value.sort(Collections.reverseOrder());

        dfs("JFK");
        Collections.reverse(result);
        return result;
    }
}
