#include <stdio.h>


int a[1000000];

int main() {

	int num,max,min;


	scanf("%d", &num);
	for (int i = 0; i < num; i++) {
		scanf("%d", &a[i]);
	}

	max = a[0];
	min = a[0];

	for (int i = 1; i < num; i++) {
		if (max < a[i]) {
			max = a[i];
		}

		if (min > a[i]) {
			min = a[i];
		}
	}

	printf("%d %d", min, max);

	return 0;
}
