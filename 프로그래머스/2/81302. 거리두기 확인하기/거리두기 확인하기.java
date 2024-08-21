import java.util.*;

class Solution {
    int[] x = {-1, 0, 1, 0};
    int[] y = {0, 1, 0, -1};

    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];

        // 각 장소에 대한 검사
        for (int i = 0; i < places.length; i++) {
            int result = 1; // 기본 값은 1로 설정 (거리두기 잘 지킴)
            place: for (int j = 0; j < places[i].length; j++) {
                for (int k = 0; k < places[i][j].length(); k++) {
                    if (places[i][j].charAt(k) == 'P') {
                        // 'P' 위치에서 거리두기 규칙 검사
                        result = dfs(places[i], j, k);
                        if (result == 0) {
                            break place; // 거리두기 규칙 위반 시 바로 종료
                        }
                    }
                }
            }
            answer[i] = result;
        }
        return answer;
    }

    // 주어진 위치에서 거리두기 규칙을 검사하는 함수
    public int dfs(String[] place, int j, int k) {
        Stack<int[]> stack = new Stack<>();
        stack.add(new int[]{j, k, 0});
        boolean[][] visited = new boolean[5][5];

        while (!stack.isEmpty()) {
            int[] current = stack.pop();
            visited[current[0]][current[1]] = true;

            // 현재 거리가 1을 초과하면 더 이상 검사하지 않음
            if (current[2] > 1) {
                continue;
            }

            // 상하좌우 방향으로 탐색
            for (int i = 0; i < 4; i++) {
                int newX = current[0] + x[i];
                int newY = current[1] + y[i];

                if (newX >= 0 && newX < 5 && newY >= 0 && newY < 5) {
                    if (visited[newX][newY]) {
                        continue;
                    }
                    char position = place[newX].charAt(newY);
                    if (position == 'P') { 
                        // 다른 사람이 가까운 령역에 앉아있음
                        return 0;
                    } else if (position == 'O') { 
                        // 빈 테이블, 계속 탐색
                        stack.add(new int[]{newX, newY, current[2] + 1});
                    }
                }
            }
        }
        return 1;
    }
}