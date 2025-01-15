package LeetCode.medium;

class P2296 {
    StringBuilder target;
    int cursor;

    public P2296() {
        target = new StringBuilder();
        cursor = 0;
    }

    // 커서 위치에 문자열 넣음
    // 커서 위치 변경
    public void addText(String text) {
        target.insert(cursor, text);
        cursor += text.length();
    }

    // 커서 왼쪽 k개 삭제
    // 커서 위치 변경
    // 삭제된 실제 개수 리턴
    public int deleteText(int k) {
        int cnt = Math.min(cursor, k);
        target.delete(cursor - cnt, cursor);
        cursor -= cnt;
        return cnt;
    }

    // 커서를 왼쪽으로 k번 이동시킴
    // min(10, len)만큼커서 왼쪽편 출력
    public String cursorLeft(int k) {
        int cnt = Math.min(cursor, k);
        cursor -= cnt;

        return target.substring(Math.max(0, cursor - 10), cursor);
    }

    // 커서를 오른쪽으로 k번 이동시킴
    // min(10, len)만큼 커서 왼쪽편 출력
    public String cursorRight(int k) {
        int cnt = Math.min(target.length() - cursor, k);
        cursor += cnt;
        return target.substring(Math.max(0, cursor - 10), cursor);
    }
}

/**
 - 18:22
 - Add : 현재 커서 위치에 문자열 추가 + 커서 text 마지막으로 이동
 - Delete : 백스페이스, 커서 왼쪽 문자 제거
 - Move : 커서 왼쪽 or 오른쪽 이동

 - 커서는 실제 문자열 위치를 벗어난 곳에 위치할 수 없음
 - 0 <= cursor.position <= text.length;
 */
