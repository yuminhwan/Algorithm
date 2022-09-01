#define _CRT_SECURE_NO_WARNINGS
#include <iostream>
#include <cstdio>
#include <stack>
#include <string>
using namespace std;


int num;
char a[50];
stack <char>stk;

int main() {
	
	scanf("%d", &num);
	
	while (num--) {
		int i = 0;
		while (!stk.empty()) stk.pop();
		scanf("%s", &a);

		while (a[i]) {
			if (a[i] == '(') {
				stk.push(a[i]);
			}
			else {
				if (stk.size() != 0) {
					stk.pop();
				}
				else {
					stk.push(a[i]);
					break;
				}
			}
			i++;
		}

		if (stk.size() != 0) {
			printf("NO\n");
		}
		else {
			printf("YES\n");
		}
	}
	

	return 0;
}