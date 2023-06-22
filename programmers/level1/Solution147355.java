package programmers.level1;


/**
 * [문제명] 크기가 작은 부분문자열
 * [풀이시간] 10분 / 6분
 * [한줄평] 쉬운 문제였다. substring() 으로 풀면 너무 효율이 떨어지지 않을까 싶어 고민했었는데, 다른 풀이를 보니 다 substring 으로 풀었다.
 * 1_v1. 문자열(성공)
 * [풀이] substring()
 * 2_v1. 문자열(성공)
 * @See <a href="https://school.programmers.co.kr/learn/courses/30/lessons/147355">문제</a>
 */
class Solution147355 {
    public static void main(String[] args) {
        //
        System.out.println();
    }

    // 1_v1, 2_v1
    /**
     * @param t 숫자로 이루어진 문자열
     * @param p 숫자로 이루어진 문자열
     * @return t에서 p와 길이가 같은 부분문자열 중에서, 이 부분문자열이 나타내는 수가 p가 나타내는 수보다 작거나 같은 것이 나오는 횟수
     */
    public int solution(String t, String p) {
        int answer = 0;
        int i = 0;
        while(i + p.length() - 1 < t.length()) {
            if(t.substring(i, i + p.length()).compareTo(p) <= 0) answer++;
            i++;
        }
        return answer;
    }
}