#define _CRT_SECURE_NO_WARNINGS
#include <iostream>
#include <queue>
using namespace std;



int main() {
	int num, person;
	queue<int> q;
	cin >> person;
	cin >> num;
	for (int i = 1; i < person + 1; i++) {
		q.push(i);
	}
	cout << "<";
	for (int j = 0; j < person-1; j++) {
		for (int z = 0; z < num - 1; z++) {
			q.push(q.front());
			q.pop();
		}
		cout << q.front() << ", ";
		q.pop();
	}

	cout <<q.front()<<">\n";
	return 0;
}