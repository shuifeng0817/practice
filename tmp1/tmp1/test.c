#define _CRT_SECURE_NO_WARNINGS
#include<stdio.h>
int main()
{
	char ch;
	long n,nx = 0;
	long m = 0;
	while ((ch = getchar()) != '\n')
	{
		if (ch >= '0' && ch <= '9')
			m = m * 10 + ch - '0';
		else
			putchar(ch);
	}
	n = m;
	while (m != 0)
	{
		nx = nx * 10 + m % 10;
		m = m / 10;
	}
	printf("\n%ld reverse number id %ld\n", n, nx);
	return 0;
}