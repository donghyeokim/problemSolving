package LeetCode.medium;
import java.util.*;
public class P731 {
    class MyCalendarTwo {
        public class Book implements Comparable<Book>{
            int s, e;

            public Book(int s, int e) {
                this.s = s;
                this.e = e;
            }

            // (s, e) 오름차순 정렬
            @Override
            public int compareTo(Book o) {
                if (this.s > o.s) return 1;
                else if (this.s < o.s) return -1;
                else return this.e - o.e;
            }
        }

        List<Book> arr = new ArrayList<>();

        public MyCalendarTwo() {

        }

        public boolean book(int s, int e) {
            // 구간별 겹치는 구간 확인
            Book before = null;
            for (Book book : arr) {
                // 더이상 탐색 불필요
                if (book.s >= e) break;

                // 이전 예약과 겹치는 구간 확인
                if (before != null && book.s < before.e && (book.s < e && Math.min(before.e, book.e) > s)) {
                    return false;
                }

                if (before == null) before = book;
                else before = before.e > book.e ? before : book;
            }

            //삽입 성공
            Book target = new Book(s, e);
            arr.add(target);
            Collections.sort(arr);
            return true;
        }
    }
/**
 - 14:16
 - 캘린더처럼 쓸 수 있는 프로그램
 - tripple booking : 3개의 이벤트가 교집합으로 특정 시간을 가짐
 - 트리플 부킹이 아니면 true, 트리플 부킹이면 false

 - 시간 범위 <= 10억
 - 특정 시간 구간에 몇개가 겹치는지 파악이 되어야함
 - book은 최대 1000번 호출
 - 모든 이벤트를 순회하며 해당 시간 구간에 몇개나 있는지 파악
 */

}
