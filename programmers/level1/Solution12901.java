package programmers.level1;


/**
 * [문제명] 2016년
 * [풀이시간] 20분 / 20분
 * [한줄평] 쉬운 문제였는데, 윤년이라는 조건을 생각을 못하고 풀어서 생각보다 오래걸렸던 문제였다. / 2번째 풀 때도 윤년을 28일로 착각해서 오래걸렸던 문제였다.
 * 1_v1. 수학(성공)
 * 2_v1. 수학(성공)
 * @See <a href="https://school.programmers.co.kr/learn/courses/30/lessons/12901">문제</a>
 */
class Solution12901 {
    public static void main(String[] args) {
        // "TUE"
        int a = 5;
        int b = 24;
        System.out.println(solution(a, b));
    }

    /**
     * 추천
     * @param a 월
     * @param b 일
     * @return 2016년 a월 b일이 무슨 요일인지 리턴
     */
    public static String solution(int a, int b) {
        // 2016년은 윤년입니다. -> 2월은 29일까지
        int[] month = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        // 2016년 1월 1일은 금요일입니다. -> (날짜수%7)이 1인 날짜 = 금요일
        String[] day = {"THU", "FRI", "SAT", "SUN", "MON", "TUE", "WED"};
        // a월 b일 -> 1월 1일기준 ?일인지 환산
        int days = 0;
        for(int i = 0; i < a - 1; i++) {
            days += month[i];
        }
        days += b;

        return day[days % 7];
    }

    public String solution2(int a, int b) {
        String[] day = {"THU", "FRI", "SAT", "SUN", "MON", "TUE", "WED"};
        int days = b;
        for(int i = 1; i < a; i++) {
            switch(i) {
                case 1: case 3: case 5: case 7: case 8: case 10: case 12:
                    days += 31;
                    break;
                case 4: case 6: case 9: case 11:
                    days += 30;
                    break;
                default:
                    days += 29;
                    break;
            }
        }
        return day[days % 7];
    }
}