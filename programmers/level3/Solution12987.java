package programmers.level3;


import java.util.Arrays;

/**
 * [문제명] 숫자 게임
 * [풀이시간] 20분(15분 + 5분)
 * [한줄평] 입력값의 범위를 보고 정렬로 풀어야겠다고 쉽게 떠올렸다. 다만 반례 힌트를 보지 않았으면 알아차리가까지 조금 시간이 걸렸을 것 같다.
 * v1. 정렬(실패 - 정확성 테스트 17 실패)
 * @See <a href="https://school.programmers.co.kr/learn/courses/30/lessons/12987">문제</a>
 * @See <a href="https://https://school.programmers.co.kr/questions/41838">반례</a>
 */
class Solution12987 {
    public static void main(String[] args) {
        // 3
        int[] A1 = {5,1,3,7};
        int[] B1 = {2,2,6,8};
        System.out.println(solution(A1, B1));

        // 0
        int[] A2 = {2,2,2,2};
        int[] B2 = {1,1,1,1};
        System.out.println(solution(A2, B2));
    }

    /**
     * @param A A 팀원들이 부여받은 수가 출전 순서대로 나열되어있는 배열
     * @param B i번째 원소가 B팀의 i번 팀원이 부여받은 수를 의미하는 배열
     * @return B 팀원들이 얻을 수 있는 최대 승점
     */
    public static int solution(int[] A, int[] B) {
        int answer = 0;
        int i = 0;  // A 포인터
        int j = 0;  // B 포인터
        // 1. A, B 오름차순 정렬
        Arrays.sort(A);
        Arrays.sort(B);
        // 2. B의 모든 원소 탐색하면서 A와 매칭시키기
        while(j < B.length) {
            if(A[i] < B[j]) {
                i++;
                answer++;
            } else if(A[i] == B[j]) {
                i++;
            }
            j++;
        }
        return answer;
    }
}