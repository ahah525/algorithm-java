package programmers.level1;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * [문제명] 실패율
 * [풀이시간] 40분(30분 + 10분)
 * [한줄평] 30분 내에 충분히 풀 수 있는 문제였는데, 생각보다 시간이 걸렸다. 문제 조건을 잘 확인하자!!
 * v1. 정렬(실패 - 7, 9, 13 테스트 실패)
 * - 각 stage 번호별로 실패율을 모두 계산한 후에 정렬을 하는 방식으로 구현했는데, 3개의 테스트에서 실패했다.
 * v2. 정렬(성공)
 * - "스테이지에 도달한 유저가 없는 경우 해당 스테이지의 실패율은 0 으로 정의한다." 라는 조건에 따라
 * @See <a href="https://school.programmers.co.kr/learn/courses/30/lessons42889/">문제</a>
 */
class Solution42889 {
    public static void main(String[] args) {
        // [3,4,2,1,5]
        int[] stages1 = {2, 1, 2, 6, 2, 4, 3, 3};
        System.out.println(solution(5, stages1));

        // [4,1,2,3]
        int[] stages2 = {4,4,4,4,4};
        System.out.println(solution(4, stages2));
    }

    static class Stage {
        int num;        // 번호
        double fail;   // 실패율

        public Stage(int num, double fail) {
            this.num = num;
            this.fail = fail;
        }
    }

    /**
     * @param N 전체 스테이지의 개수
     * @param stages 게임을 이용하는 사용자가 현재 멈춰있는 스테이지의 번호가 담긴 배열
     * @return 실패율이 높은 스테이지부터 내림차순으로 스테이지의 번호가 담겨있는 배열
     */
    public static List<Integer> solution(int N, int[] stages) {
        List<Integer> answer = new ArrayList<>();
        // 1. 각 스테이지 번호별 실패율 계산
        List<Stage> list = new ArrayList<>();
        for(int i = 1; i <= N; i++) {
            int a = 0;  // i번 스테이지에 있는 사람수
            int b = 0;  // i번 이상의 스테이지에 있는 사람수
            double c = 0; // 실패율 = 스테이지에 도달했으나 아직 클리어하지 못한 플레이어의 수 / 스테이지에 도달한 플레이어 수 = a / b
            for(int n : stages) {
                if(i == n) {
                    a++;
                    b++;
                } else if(i < n) {
                    b++;
                }
            }
            // b 가 0이 아닐 때만 연산해야함(b가 0일때는 런타임 오류)
            if(b != 0)
                c = (double) a / b;
            list.add(new Stage(i, c));
        }
        // 2. 정렬
        Collections.sort(list, (o1, o2) -> {
            // 2. 번호 오름차순
            if(o1.fail == o2.fail) {
                return o1.num - o2.num;
            }
            // 1. 실패율 내림차순
            return (o1.fail > o2.fail) ? -1 : 1;
        });
        // 3. 정렬된 스테이지 번호 리턴
        for(Stage stage : list) {
            answer.add(stage.num);
        }
        return answer;
    }
}