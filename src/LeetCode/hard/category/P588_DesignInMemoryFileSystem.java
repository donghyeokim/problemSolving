package LeetCode.hard.category;

import java.util.*;

/**
 * Description
 * - 인메모리 파일시스템처럼 동작하도록 디자인해라
 * 1. 처음엔 어떤 디렉토리나 파일도 없다
 * 2. ls : 해당 디렉토리 파일에 있는 파일 및 디렉토리를 사전순으로 출력
 * 3. mkdir : 현재 노드에 새로운 디렉토리 생성, 필요하다면 입력된 경로에 따라 디렉토리 생성
 * 4. addContentToFile : 해당 path에 있는 파일에 데이터 추가, 없으면 새로운 파일 생성
 * 5. readContentFromFile : 해당 path에 있는 파일의 내용 출력
 */
public class P588_DesignInMemoryFileSystem {
    class TrieNode {
        String name;
        boolean isFile;
        StringBuilder content = new StringBuilder();
        Map<String, TrieNode> children = new HashMap<>();

        TrieNode insert(String path, boolean isFile) {
            TrieNode node = this;
            String[] parts = path.split("/");

            for (int i = 1; i < parts.length; i++) {
                String part = parts[i];
                if (!node.children.containsKey(part))
                    node.children.put(part, new TrieNode());
                node = node.children.get(part);
            }

            node.isFile = isFile;
            if (isFile) node.name = parts[parts.length - 1];

            return node;
        }

        TrieNode search(String path) {
            TrieNode node = this;
            String[] parts = path.split("/");

            for (int i = 1; i < parts.length; i++) {
                String part = parts[i];
                if (!node.children.containsKey(part))
                    return null;
                node = node.children.get(part);
            }

            return node;
        }
    }

    private TrieNode root = new TrieNode();

    public P588_DesignInMemoryFileSystem() {
        // The root does not need any initial setup.
    }

    // List the contents in a directory or return the file if it's just a single file.
    public List<String> ls(String path) {
        List<String> result = new ArrayList<>();
        TrieNode node = root.search(path);

        // 없으면 null 리턴
        if (node == null) return null;

        // 파일이면 파일 이름 리턴
        if (node.isFile) result.add(node.name);
        // 디렉토리면 모든 하위 디렉토리 및 파일 넣어줌
        else result.addAll(node.children.keySet());

        Collections.sort(result);
        return result;
    }

    // Make a directory given a path.
    public void mkdir(String path) {
        root.insert(path, false);
    }

    // Add content to the file, create the file if it does not exist.
    public void addContentToFile(String filePath, String content) {
        // 찾거나 만들어줌
        TrieNode node = root.insert(filePath, true);

        // 컨텐츠 추가
        node.content.append(content);
    }

    // Read content from a file.
    public String readContentFromFile(String filePath) {
        TrieNode node = root.search(filePath);
        // 파일일 경우
        if (node != null && node.isFile)
            return node.content.toString();
        // 디렉토리이거나 없는 경우
        return "";
    }
}
