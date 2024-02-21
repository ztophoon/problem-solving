#include <vector>
#include <stdio.h>
#include <stdlib.h>
#include <algorithm>
using namespace std;

int l, c;
int sol[20];
vector<int> v;

int isOK() { //leaf까지 갔을 때 1이 l개인 경우
	int cnt = 0, mo = 0, ja = 0;

	for (int i = 0; i < c; i++)
		if (sol[i]) {
			cnt++;
			if (v[i] == 'a' || v[i] == 'e' || v[i] == 'i' || v[i] == 'o' || v[i] == 'u') mo++;
			else ja++;
		}
	
	if (cnt == l && mo >=1 && ja >= 2) return 1;
	else return 0;
}

void doSTH() {
	for (int i = 0; i < c; i++)
		if (sol[i] == 1) printf("%c", v[i]);
	printf("\n");
	return;
}

void Backtracking(int depth) {
	if (depth == c) {
		if (isOK()) doSTH();
		return;
	}
	for (int i = 1; i >= 0; i--) {
		sol[depth] = i;
		Backtracking(depth + 1);
	}
}

int main() {
	scanf("%d %d", &l, &c);
	
	getchar();
	for (int i = 0; i < c; i++) {
		char tmp;
		scanf("%c", &tmp); getchar();
		v.push_back((int)tmp);
	}
	sort(v.begin(), v.end());

	Backtracking(0);

	return 0;
}