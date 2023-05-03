#define _CRT_SECURE_NO_WARNINGS
//int main()
//{
//	char ch;
//	long n,nx = 0;
//	long m = 0;
//	while ((ch = getchar()) != '\n')
//	{
//		if (ch >= '0' && ch <= '9')
//			m = m * 10 + ch - '0';
//		else
//			putchar(ch);
//	}
//	n = m;
//	while (m != 0)
//	{
//		nx = nx * 10 + m % 10;
//		m = m / 10;
//	}
//	printf("\n%ld reverse number id %ld\n", n, nx);
//	return 0;
//}
//#include<stdio.h>
//#include<math.h>
//int main()
//{
//	int i, j = 0, n, m, k, flag;
//	for (n = 100; n < 1000; n++)
//	{
//		flag = 0;
//		k = sqrt(n);
//		for (i = 2; i <= k; i++)
//			if (n % i == 0)
//			{
//				flag = 1;
//				break;
//			}
//		if (flag)
//			continue;
//		k = n;
//		m = 0;
//		while (k > 0)
//		{
//			m = m * 10 + k % 10;
//			k=k / 10;
//		}
//		if (m == n)
//		{
//			printf("%d\t", n);
//			if (++j % 5 == 0)
//				printf("\n");
//		}
//	}
//	return 0;
//}
//#include<stdio.h>
//int main()
//{
//	long n, m, sum, p;
//	int i, j = 0, k;
//	for (n = 1; n < 200000; n++)
//	{
//		m = n;
//		sum = 0;
//		while (m)
//		{
//			k = m % 10;
//			p = 1;
//			for (i = 2; i <= k; i++)
//				p = p * i;
//			sum += p;
//			m =m/10;
//		}
//		if (sum == n)
//		{
//			printf("%ld\t", n);
//			if (++j % 2 == 0)
//				printf("\n");
//		}
//	}
//	return 0;
//}
#include<stdio.h>
int main()
{
	int i, j, n, m, t;
	for (i = 10; i < 100; i++)
	{
		j = 0;
		t = i;
		while (i > 0)
		{
			j = j * 10 + i % 10;//该数的反序数
			i /= 10;
		}
		i = t;
		m = i * i;//该数的平方数
		n = j * j;//反序数的平方数
		t = 0;
		while (n)//平方数的反序数
		{
			t = t * 10 + n % 10;
			n /= 10;
		}
		if (m == t)
		{
			printf("(%d,%d)\n", i, j);
		}
	}
	return 0;
}