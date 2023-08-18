#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
//int main()
//{
//	int i = 0, a = 0, b = 2, c = 3, d = 4;
//	i = a++ && ++b && d++;
//	printf("a=%d\nb=%d\nc=%d\nd=%d\n", a, b, c, d);
//	return 0;
//}
//int main()
//{
//	int a = 3;
//	int b = 5;
//	a = a ^ b;
//	b = a ^ b;
//	a = a ^ b;
//	printf("a=%d,b=%d\n", a, b);
//	return 0;
//}
//int main()
//{
//	int num = 0;
//	int count = 0;
//	scanf("%d", &num);
//	//统计num的补码中1的个数
//	/*while (num)
//	{
//		if (num % 2 == 1)
//			count++;
//		num = num / 2;
//	}*/
//	int i = 0;
//	for (i = 0; i < 32; i++)
//	{
//		if (1 == ((num >> i) & 1))
//			count++;
//	}
//	printf("%d\n", count);
//	return 0;
//}
//int main()
//{
//	int a = 0;
//	//按二进制位取反
//	//00000000000000000000000000000000
//	//11111111111111111111111111111111-补码
//	//10000000000000000000000000000001-原码	//
//	printf("%d\n", ~a);
//}
//int main()
//{
//	int a = 11;
//	a = a | (1 << 2);
//	printf("%d\n", a);
//	a=a& (~(1 << 2));
//	printf("%d\n", a);
//	//00000000000000000000000000001011
//	//00000000000000000000000000000100按位或
//	// 1<<2
//	//00000000000000000000000000001111
//	
//	//还原
//	//00000000000000000000000000001111
//	//11111111111111111111111111111011按位与
//	//00000000000000000000000000000100
//	//1<<2
//	//00000000000000000000000000001011
//}
//int main()
//{
//	int a = (int)3.14;
//
//}
//int main()
//{
//	int a = 3;
//	int b = 5;
//	int c = a && b;
//	printf("%d\n", c);
//	return 0;
//}
//int main()
//{
//	int a = 0;
//	int b = 0;
//	if (a > 5)
//		b = 3;
//	else
//		b = -3;
//	b = (a > 5 ? 3 : -3);
//	return 0;
//}
//int main()
//{
//	int a = 1;
//	int b = 2;
//	int c = (a > b, a = b + 10, a, b = a + 1);
//	printf("%d", c);
//	return 0;
//}
//创建了一个结构体类型——struct Stu
//struct Stu
//{
//	//成员变量
//	char name[20];
//	int age;
//	char id[20];
//};
//int main()
//{
//	//使用struct Stu这个类型创建了一个学生对象s1，并初始化
//	struct Stu s1 = { "张三",20,"2019010305" };
//
//	struct Stu* ps = &s1;
//	printf("%s\n", (*ps).name);
//	printf("%s\n", ps->name);
//
//	printf("%s\n", s1.name);
//	printf("%d\n", s1.age);
//	printf("%s\n", s1.id);
//	//结构体变量.成员名
//	return 0;
//}
