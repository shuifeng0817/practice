#define _CRT_SECURE_NO_WARNINGS
#include<stdio.h>
//int Add(int x, int y)
//{
//	int z = 0;
//	z = x + y;
//	return z;
//
//}
//int main()
//{
//	int a = 10;
//	int b = 20;
//	int sum = Add(a, b);
//	printf("%d", sum);
//	return 0;
//}
//int main()
//{
//	//strlen—string length-字符串长度有关
//	//strcpy—string copy-字符串拷贝
//	char arr1[] = { "bit" };
//	char arr2[20] = { "############" };
//	strcpy(arr2, arr1);
//	printf("%s\n", arr2);
//	return 0;
//}
//int main()
//{
//	char arr[] = { "hello world" };
//	memset (arr,'*',5);
//	printf("%s\n", arr);
//	return 0;
//}
//int max(int x, int y)
//{
//	if (x > y)
//	{
//		printf("%d", x);
//	}
//	else
//		printf("%d",y);
//
//
//}
//int main()
//{
//	int a = 0;
//	int b = 0;
//	scanf("%d%d", &a, &b);
//	max(a, b);
//	return 0;
//
//}//我
//get_max(int x, int y)
//{
//	if (x > y)
//	{
//		return x;
//	}
//	else if(y < x)
//	{
//		return y;
//	}
//		
//}
//	
//int main()
//{
//	int a = 10;
//	int b = 20;
//	int max = get_max(a, b);
//	printf("max=%d\n", max);
//	return 0;
//}
//当实参传给形参的时候
// 形参其实是实参的一份临时拷贝
// 对形参的修改是不会改变实参的
//
//void Swap2(int* pa, int* pb)//void是空没有返回值
//{
//	int tmp = 0;
//	tmp=*pa;
//	*pa=*pb;
//	*pb = tmp;
//}
//int main()
//{
//	int a = 10;
//	int b = 20;
//	int tmp = 0;
//	printf("a=%d b=%d\n", a, b);
//	Swap2(&a, &b);
//
//	printf("a=%d b=%d\n",a,b);
//	return 0;
//}
//int main()
//{
//	int a = 10;
//	int* pa= &a;//pa指针变量
//	*pa = 20;//解引用操作
//	return 0;
//}
//是素数返回1；不是素数返回0
//int is_prime(int n)
//{
//	int j = 0;
//	for (j = 2; j < n; j++)
//	{
//		if(n%j==0)
//		{
//			break;
//		}
//	}
//	if (j == n)
//	{
//		return 1;
//	}
//}
//int main()
//{
//	//打印100-200之间的素数
//	int i = 0;
//	int count = 0;
//	for (i = 100; i <= 200; i++)
//	{
//		//判断i是否是素数
//		if (is_prime(i) == 1)
//		{
//			printf("%d ", i);
//			count++;
//		}
//	}
//	printf("\n%d", count);
//	return 0;
//}
int is_prime(int n)
{
	int j = 0;
	for (j = 2; j < n; j++)
	{
		if (n % j == 0)
		{
			break;
		}
	}
	if (j == n)
	{
		return 1;
	}
}
int main()
{
	//打印100-200之间的素数
	int i = 0;
	int count = 0;
	for (i = 100; i <= 200; i++)
	{
		//判断i是否是素数
		if (is_prime(i) == 1)
		{
			printf("%d ", i);
			count++;
		}
	}
	printf("\n%d", count);
	return 0;
}