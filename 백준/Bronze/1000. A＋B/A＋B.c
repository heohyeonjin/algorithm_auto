#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>
int main() {
	int A, B;
	scanf("%d %d", &A, &B);
	if (A > 0 && B < 10)
		printf("%d", A + B);
	else
		exit(1);
    return 0;
}