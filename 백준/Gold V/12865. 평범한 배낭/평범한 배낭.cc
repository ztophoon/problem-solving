#include <stdio.h>
#include <algorithm>
using namespace std;

int W[101], V[101], check[101][100001], dt[101][100001];

int dp(int n, int m) {
	if (check[n][m]) return dt[n][m];
	if (n == 1) {
		if (W[n] <= m) return V[n];
		else return 0;
	}

	check[n][m] = 1;
	if(m - W[n] >= 0) return dt[n][m] = max(dp(n - 1, m), dp(n - 1, m - W[n]) + V[n]);
	else return dt[n][m] = dp(n - 1, m);
}

int main() {
	int n, k;
	scanf("%d %d", &n, &k);

	for (int i = 1; i <= n; i++)
		scanf("%d %d", &W[i], &V[i]);

	printf("%d\n", dp(n, k));
	
	return 0;
}