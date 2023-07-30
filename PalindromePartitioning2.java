#include <iostream>
#include <vector>

using namespace std;

int palindromePartitioning(string str) {
    int n = str.length();
    vector<vector<bool>> isPalindrome(n, vector<bool>(n, false));
    vector<int> dp(n, INT_MAX);
    for (int len = 1; len <= n; ++len) {
        for (int i = 0; i + len - 1 < n; ++i) {
            int j = i + len - 1;
            if (len == 1)
                isPalindrome[i][j] = true;
            else if (len == 2)
                isPalindrome[i][j] = (str[i] == str[j]);
            else
                isPalindrome[i][j] = (str[i] == str[j] && isPalindrome[i + 1][j - 1]);
        }
    }

    dp[0] = 0;

    for (int i = 1; i < n; ++i) {
        if (isPalindrome[0][i]) {
            dp[i] = 0;
        } else {
            for (int j = 0; j < i; ++j) {
                if (isPalindrome[j + 1][i]) {
                    dp[i] = min(dp[i], dp[j] + 1);
                }
            }
        }
    }

    return dp[n - 1];
}
