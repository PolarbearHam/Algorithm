
public class Main_99599 {
	public static void main(String[] args) {
        int n = 4; // 격자의 크기 (예: n=3)
        int result = countSquares(n);
        System.out.println("정사각형의 개수: " + result);
    }

    public static int countSquares(int n) {
        // 서로 다른 네 점을 이어 만들 수 있는 정사각형의 개수를 계산
        // n x n 격자에서 대각선 방향을 포함한 정사각형의 개수는 (n-1)^2 + n^2 입니다.
        int diagonalSquares = (n - 1) * (n - 1) + n * n;

        return diagonalSquares;
    }
}
