package LeetCode.medium.category;

import java.sql.SQLOutput;
import java.util.*;
public class P355_Design_Twitter {
    public int timeStamp = 0;

    public class Twit implements Comparable<Twit>{
        int id, time;

        public Twit(int id, int time) {
            this.id = id;
            this.time = time;
        }

        // 내림차순 정렬
        @Override
        public int compareTo(Twit o) {
            return o.time - this.time;
        }
    }

    Map<Integer, List<Twit>> userTwitMap;  // 각 유저의 트윗 리스트 저장
    Set<Integer>[] map;                    // map[i]의 팔로우 리스트

    public P355_Design_Twitter() {
        userTwitMap = new HashMap<>();
        map = new Set[501];
        for (int i = 1; i <= 500; i++) {
            map[i] = new HashSet<>();
            map[i].add(i);
        };
    }

    public void postTweet(int userId, int tweetId) {
        Twit twit = new Twit(tweetId, timeStamp++);
        userTwitMap.computeIfAbsent(userId, key -> new ArrayList<>()).add(twit);
    }

    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<Twit> pq = new PriorityQueue<>();
        for (Integer cur : map[userId]) {
            if (userTwitMap.containsKey(cur)) {
                List<Twit> list = userTwitMap.get(cur);
                for (Twit twit : list) pq.add(twit);
            }
        }
        int cnt = 10;
        List<Integer> result = new ArrayList<>();
        while(--cnt >= 0 && !pq.isEmpty())
            result.add(pq.poll().id);
        return result;
    }

    public void follow(int followerId, int followeeId) {
        if (followerId == followeeId) return;
        map[followerId].add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        if (followerId == followeeId) return;
        map[followerId].remove(Integer.valueOf(followeeId));
    }

    public static void main(String[] args) {
        P355_Design_Twitter twitter = new P355_Design_Twitter();
        twitter.postTweet(1, 2);
        System.out.println(twitter.getNewsFeed(1));
        twitter.follow(2, 1);
        System.out.println(twitter.getNewsFeed(2));
        twitter.postTweet(2, 3);
        System.out.println(twitter.getNewsFeed(1));
        System.out.println(twitter.getNewsFeed(2));
    }
}
