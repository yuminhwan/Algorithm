#define _CRT_SECURE_NO_WARNINGS
#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;
int map[100][100],visit[100][100];
int dx[4] = { 1, -1, 0, 0 };
int dy[4] = { 0,0,1,-1 };

int n,cnt;
char check;

  bool range_check(int x, int y) {
	if (x >= 0 && x <n && y >= 0 && y < n)
		return true;
	else
		return false;
}

bool color_check(int x, int y, int num) {
	if (map[x][y] == num)
		return true;
	else
		return false;
}

bool visit_check(int x, int y) {
	if (visit[x][y] == 0)
		return true;
	else
		return false;
}

void dfs(int x, int y , int num) {
	visit[x][y] = 1;
	for (int i = 0; i < 4; i++) {
		int tx = x + dx[i];
		int ty = y + dy[i];
		if (range_check(tx, ty) && visit_check(tx, ty) && color_check(tx, ty, num)) {
			dfs(tx, ty, num);
		}
		
	}
	
}



int main() {

	cin >> n;
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			cin >> check;

			if (check == 'R') {
				map[i][j] = 1;
			}
			else if (check == 'G') {
				map[i][j] = 2;
			}
			else if(check =='B')
				map[i][j]=3;
		}
	}
	
	for (int x = 0; x < n; x++) {
		for (int y = 0; y < n; y++) {
			if (map[x][y] == 1 && visit[x][y] == 0) {
				dfs(x, y, 1);
				cnt++;
			}
			else if (map[x][y] == 2 && visit[x][y] == 0) {
				dfs(x, y, 2);
				cnt++;
			}
			else if(map[x][y]==3 && visit[x][y]==0){
				dfs(x, y, 3);
				cnt++;
			}
		}
	}

	cout << cnt << " ";
	cnt = 0;

	for (int x = 0; x < n; x++) {
		for (int y = 0; y < n; y++) {
			if (map[x][y] == 2) {
				map[x][y] = 1;
			}
			visit[x][y] = 0;
		}
	}

	for (int x = 0; x < n; x++) {
		for (int y = 0; y < n; y++) {
			if (map[x][y] == 1 && visit[x][y] == 0) {
				dfs(x, y, 1);
				cnt++;
			}
			else if (map[x][y] == 3 && visit[x][y] == 0) {
				dfs(x, y, 3);
				cnt++;
			}
		}
	}
	

	cout << cnt;

	return 0;
}