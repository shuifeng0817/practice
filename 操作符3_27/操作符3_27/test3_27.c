#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
//int main()
//{
//	double a = 5.0 / 2;//商2余1
//	printf("%lf\n", a);
//	return 0;
//}
//int main()
//{
//	int a = 16;
//	//>>右移操作符
//	//移动的是二进制位
//	//0000000000000000000000010000
//	//
//	int b=a >> 1;
//	//return 0;
//}
//int main()
//{
//	& -按位与，按二进制位与
//	int a = 3;
//	int b = 5;
//	int c = a & b;
//	011
//	101
//	001
//	左方补零，共32位
//	printf("%d\n", c);
//
//	return 0;
//}
//int main()
//{
	//int a = 3;
	//int b = 5;
	//int c = a | b;
	//printf("%d\n", c);
	////00000000000000000000000000000011
	////00000000000000000000000000000101
	////00000000000000000000000000000111
	//return 0;
//}
//int main()
//{
//	int a = 3;
//	int b = 5;
//	int c = a ^ b;//相同为0，相异为1
//	printf("%d\n", c);
//	//00000000000000000000000000000011
//	//00000000000000000000000000000101
//	//00000000000000000000000000000110
//	return 0;
//}
int main()
{
	int a = 3;
	int b = 5;
	printf("before: a=%d b=%d\n", a, b);
	a = a + b;
	b = a - b;
	a = a - b;
	printf("after: a=%d b=%d\n", a, b);

}