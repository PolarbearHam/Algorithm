 import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_나무의키 {

    static int N, max, sum, evenCnt, ans;
    static int[] heights, diffHeights;
    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine());
        
        for (int tc = 1; tc <= T; tc++) {
            sb.append("#").append(tc).append(" ");
            
            N = Integer.parseInt(br.readLine());
            heights = new int[N];
            diffHeights = new int[N];
            
            max = 0;
            st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < N; i++) {
                heights[i] = Integer.parseInt(st.nextToken());
                max = Math.max(max, heights[i]);
            }
            
            
            // 모든 나무가 채워야 하는 높이의 합 : sum 계산
            sum = 0;
            for (int i = 0; i < N; i++) {
                diffHeights[i] = max - heights[i];
                sum += diffHeights[i];
            }
            
            // evenCnt 계산
            evenCnt = 0;
            ans = 0;
            
            // 문제 핵심의 중요 판단
            // eventCnt의 의미: 2자리는 (2개 높이를 한꺼번에 채울 수 있는 경우의 수)
            // eventCnt가 만약 3이면 3번 1+2, 1+2, 1+2 6일을 계속 물을 줄 수 있다.
            // eventCnt로 어떤 계산을 해서 그 결과 값이 채워야 하는 전체 sum과 비교해서
            // 만약 sum이 더 크면 1+2를 계속 할 수 없는 상황(evenCnt를 모두 다 소진하고 1만 남는)이 발생, 남은 1에 대한 별도 처리
            // 만약 sum이 더 작거나 같으면 계속 1+2 끝까지 갈 수 있는 상황 > 단순 계산 (남은 1에 대한 처리 필요 X)
            
            // 어떤 계산 sum > eventCnt * 3
            for (int h: diffHeights) {
                evenCnt += h / 2;
            }
            
            if (sum > evenCnt * 3) {
                // ans 계산 처리
                // evenCnt를 이용해서 날짜 계산 1+2 모두 사용했을 때 걸리는 일수 계산
                // 남은 (sum - evenCnt * 3) 것은 1만 남으니까 그것을 처리하기 위한 일수 계산 추가적으로 하고 ans에 더해준다.
                ans = evenCnt * 2;
                int remain = sum - evenCnt * 3; // 전부 나무의 차이가 1만 남은 것들 => 1 쓰고 하루 보내고 1 쓰고
                // remain 3이면
                // 1 - 1 - 1 => 3*2 - 1
                ans += remain * 2 - 1;
            } else {
                // ans 계산 처리
                // evenCnt를 사용해서 1이 남지 않는 상황
                // ans = sum을 3(1+2)으로 나누고 *2 (1+2: 2일)
                // 3으로 나눌 때 버려지는 것에 대한 (1, 2만 남는 상황이면 그것에 대한 추가 일수 계산 ans 더해준다)
                ans = sum / 3 * 2; // 3할 때 
                if (sum % 3 == 1) ans++;
                else if (sum % 3 == 2) ans += 2;
            }
            
            sb.append(ans).append("\n");
        }
        System.out.println(sb);
    }

}