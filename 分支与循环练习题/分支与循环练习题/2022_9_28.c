#define _CRT_SECURE_NO_WARNINGS
#include<stdio.h>
//int main()
//{
//	int a = 0;
//	int b = 0;
//	int c = 0;
//	scanf("%d%d%d", &a, &b, &c);//2 1 3
//	//�㷨ʵ��
//	//a�з����ֵ
//	// b��֮
//	// c�з���Сֵ
//	if (a < b)
//	{
//		int tmp = a;
//		a = b;
//		b = tmp; 
//	}
//	if (a < c)
//	{
//		int tmp = a;
//		a = c;
//		c = tmp;
//	}
//	if (b < c)
//	{
//		int tmp = b;
//		b = c;
//		c = tmp;
//	}
//	printf("%d %d %d\n", a, b, c);
//
//
//}
//int main()
//{
//	int i = 0;
//	for(i = 1; i <= 100;i++)
//	{
//		if (i % 3 == 0)
//			printf("%d ", i);
//	}
//	return 0;
//}
//int main()
//{
//	int m = 24;
//	int n = 18;
//	int r = 0;
//	/*for (; m % n;)
//	{
//		r = m % n;
//		m = n;
//		n = r;
//	}*/
//	while (m % n)//���=0,���н����0Ϊ������ѭ��
//	{
//		r = m % n;
//		m = n;
//		n = r;
//
//	}
//	printf("%d\n", n);
//	return 0;
//}
//int main()
//{
//	int year = 0;
//	int count = 0;
//	for (year = 1000; year <= 2000; year++)
//	{
//		//�ж�year�Ƿ�Ϊ����
//		//1.�ܱ�4�������Ҳ��ܱ�100������������
//		//2.�ܱ�400������������
//		if (year % 4 == 0 && year % 100 != 0)
//		{
//			printf("%d ", year);
//			count++;
//		}
//		else if (year % 400 == 0)
//		{
//			printf("%d ", year);
//			count++;
//		}
//	}
//	printf("\n count=%d\n", count);
//	return 0;
//}
//int main()
//{
//	int year = 0;
//	int count = 0;
//	for (year = 1000; year <= 2000; year++)
//	{
//		if ((year % 4 == 0) && (year % 100 != 0) || (year % 400 == 0))
//		{
//			printf("%d ", year);
//			count++;
//		}
//	}
//	printf("\n%d\n", count);
//	return 0;
//}
//int main()
//{
//	int i = 0;
//	int count = 0;
//	for (i = 100; i <= 200; i++)
//	{
//		//�ж�i�Ƿ�Ϊ����
//		//�����жϵĹ���
//		//1.�Գ���
//		//13 2-12
//		// ����2->i-1
//		// 
//		//
//		int j = 0;
//		for (j = 2; j < i; j++)
//		{
//			if (i % j == 0)
//				break;
//		}
//		if (j == i)
//		{
//			count++;
//			printf("%d ", i);
//		}
//	}
//	printf("\n%d", count);
//	return 0;
//}
#include<math.h>
//int main()
//{
//	int i = 0;
//	int count = 0;
//	for (i = 100; i <= 200; i++)
//	{
//		�ж�i�Ƿ�Ϊ����
//		�����жϵĹ���
//		1.�Գ���
//		13 2-12
//		 ����2->i-1
//		 
//		
//		int j = 0;
//		for (j = 2; j < sqrt(i); j++)
//		{
//			if (i % j == 0)
//				break;
//		}
//		if (j >sqrt (i))
//		{
//			count++;
//			printf("%d ", i);
//		}
//	}
//	printf("\n%d", count);
//	return 0;
//}
//int main()
//{
//	int i = 0;
//	int count = 0;
//	for (i = 101; i <= 200; i+=2)
//	{
//		/*�ж�i�Ƿ�Ϊ����
//			�����жϵĹ���
//			1.�Գ���
//			13 2 - 12
//			����2->i - 1*/
//
//
//			int j = 0;
//		for (j = 2; j < sqrt(i); j++)
//		{
//			if (i % j == 0)
//				break;
//		}
//		if (j > sqrt(i))
//		{
//			count++;
//			printf("%d ", i);
//		}
//	}
//	printf("\n%d", count);
//	return 0;
//}
//#include <stdio.h>
//
//int main()
//
//{
//    int i, j, k, n = 0, x = 0, y = 50;
//
//
//    printf("\n\n\n\n\n");
//    printf("         lovelove                   lovelove\n");
//    printf("       lovelovelove               lovelovelove\n");
//    printf("     lovelovelovelove           lovelovelovelove\n");
//    printf("   lovelovelovelovelove       lovelovelovelovelove\n");
//    printf("  lovelovelovelovelovelo     lovelovelovelovelovelo\n");
//    printf(" lovelovelovelovelovelove   lovelovelovelovelovelov\n");
//    for (i = 0; i < 2; i++)
//    {
//        printf("lovelovelovelovelovelovelovelovelovelovelovelovelove\n");
//
//    }
//
//    for (i = 0; i < 5; i++)
//    {
//        y = 50;
//        y = y - i * 2;
//        n++;
//        for (k = 0; k < n; k++)
//        {
//            printf(" ");
//        }
//        while (1)
//        {
//            if (x < y)
//            {
//                printf("l");
//                y--;
//            }
//            else
//                break;
//            if (x < y)
//            {
//                printf("o");
//                y--;
//            }
//            else
//                break; if (x < y)
//            {
//                printf("v");
//                y--;
//            }
//                else
//                break; if (x < y)
//            {
//                printf("e");
//                y--;
//            }
//                else
//                break;
//        }
//        printf("\n");
//    }
//
//
//
//    for (i = 0, n = 3; i < 10; i++)
//    {
//        y = 37;
//        y = y - i * 4;
//        n++;
//        for (k = 0; k < n; k++)
//        {
//            printf("  ");
//        }
//        while (1)
//        {
//            if (x < y)
//            {
//                printf("l");
//                y--;
//            }
//            else
//                break;
//            if (x < y)
//            {
//                printf("o");
//                y--;
//            }
//            else
//                break; if (x < y)
//            {
//                printf("v");
//                y--;
//            }
//                else
//                break; if (x < y)
//            {
//                printf("e");
//                y--;
//            }
//                else
//                break;
//        }
//        printf("\n");
//    }
//
//    printf("\n\n\n\n\n\n\n\n\n\n\n\n");
//    return 0;
//}
//int main()
//{
//	int i = 0;
//	int count = 0;
//	for (i = 1; i <= 100; i++)
//	{
//		if (i % 10 == 9)
//			count++;
//		if (i / 10 == 9)
//		count++;
//
//	}
//	printf("count=%d\n", count);
//
//
//	return 0;
//}
int main()
{
	int i = 0;
	double sum = 0;
	for (i = 1; i <= 100; i ++ )
	{
		sum += 1.0 / i;//�������˱�����һ����С��������ȷ����
	}
	//1/1+1/2+1/3..
	//1+0+0+0...=1
	printf("%lf\n", sum);
	return 0;
}