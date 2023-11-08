class Solution {
    public int solution(int[] A) {
        int N = A.length;
        int[] rowCounts = new int[N];
        int[] colCounts = new int[N];
        int maxSideLength = 0;

        for (int i = 0; i < N; i++) {
            int row = A[i] - 1;
            rowCounts[row]++;
            int currentCol = i;
            colCounts[currentCol]++;

            // Check for a potential square.
            int sideLength = Math.min(rowCounts[row], colCounts[currentCol]);
            while (sideLength > maxSideLength) {
                if (rowCounts[row - sideLength + 1] >= sideLength && colCounts[currentCol - sideLength + 1] >= sideLength) {
                    maxSideLength = sideLength;
                }
                sideLength--;
            }
        }

        return maxSideLength;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] A1 = {1, 2, 5, 3, 1, 3};
        int result1 = solution.solution(A1);
        System.out.println("For A = [1, 2, 5, 3, 1, 3], the side length is: " + result1);

        int[] A2 = {3, 3, 3, 5, 4};
        int result2 = solution.solution(A2);
        System.out.println("For A = [3, 3, 3, 5, 4], the side length is: " + result2);

        int[] A3 = {6, 5, 5, 6, 2, 2};
        int result3 = solution.solution(A3);
        System.out.println("For A = [6, 5, 5, 6, 2, 2], the side length is: " + result3);
    }
}
