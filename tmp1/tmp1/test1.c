#define _CRT_SECURE_NO_WARNINGS
#include<stdio.h>
int main()
{
	char ch;
	long m, n, nx = 0;//定义变量并赋初值
	while ((ch = getchar()) != '\n')
	{
		if (ch >= '0' && ch <= '9')//判断是否是数字
			m = m * 10 + ch - '0';//生成数字
		else
			putchar(ch);//输出非数字
	}
	n = m;
	while (m!= 0)//数字逆序
	{
		nx = nx * 10 + m % 10;
		m = m / 10;
	}
	printf("\n%ld reverse number is %ld\n", n, nx);
	return 0;
}