public class Knapsack {
    static int max(int a, int b) { return (a > b) ? a : b; }

    // Returns the maximum value that
    // can be put in a knapsack of
    // capacity W
    static int knapSackRecursion(int W, int wt[], int val[], int n)
    {
        // Base Case
        if (n == 0 || W == 0)
            return 0;

        // If weight of the index item is more than Knapsack capacity W, then this item cannot be included in the optimal solution
        if (wt[n - 1] > W)
            return knapSackRecursion(W, wt, val, n - 1);

            // Return the maximum of two cases:
            // (1) nth item included
            // (2) not included
        else
            return max(val[n-1] + knapSackRecursion(W - wt[n-1], wt, val, n - 1),
                    knapSackRecursion(W, wt, val, n - 1));
    }

    // Returns the maximum value that can
    // be put in a knapsack of capacity W
    static int knapSackBottomUp(int W, int wt[], int val[], int n)
    {
        int i, w;
        int K[][] = new int[n + 1][W + 1];

        // Build table K[][] in bottom up manner
        for (i = 0; i <= n; i++) {
            for (w = 0; w <= W; w++) {
                if (i == 0 || w == 0)
                    K[i][w] = 0;
                else if (wt[i - 1] <= w)
                    K[i][w]
                            = max(val[i - 1]
                                    + K[i - 1][w - wt[i - 1]],
                            K[i - 1][w]);
                else
                    K[i][w] = K[i - 1][w];
            }
        }

        return K[n][W];
    }
    public static void main(String args[])
    {
        int profit[] = new int[] { 60, 100, 120 };
        int weight[] = new int[] { 10, 20, 30 };
        int W = 50;
        int index = profit.length;
        System.out.println(knapSackRecursion(W, weight, profit, index));
        System.out.println(knapSackBottomUp(W, weight, profit, index));
    }
}
