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
//	//ͳ��num�Ĳ�����1�ĸ���
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
//	//��������λȡ��
//	//00000000000000000000000000000000
//	//11111111111111111111111111111111-����
//	//10000000000000000000000000000001-ԭ��	//
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
//	//00000000000000000000000000000100��λ��
//	// 1<<2
//	//00000000000000000000000000001111
//	
//	//��ԭ
//	//00000000000000000000000000001111
//	//11111111111111111111111111111011��λ��
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
//������һ���ṹ�����͡���struct Stu
//struct Stu
//{
//	//��Ա����
//	char name[20];
//	int age;
//	char id[20];
//};
//int main()
//{
//	//ʹ��struct Stu������ʹ�����һ��ѧ������s1������ʼ��
//	struct Stu s1 = { "����",20,"2019010305" };
//
//	struct Stu* ps = &s1;
//	printf("%s\n", (*ps).name);
//	printf("%s\n", ps->name);
//
//	printf("%s\n", s1.name);
//	printf("%d\n", s1.age);
//	printf("%s\n", s1.id);
//	//�ṹ�����.��Ա��
//	return 0;
//}
