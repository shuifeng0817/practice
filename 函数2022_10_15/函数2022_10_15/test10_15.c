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
//	//strlen��string length-�ַ��������й�
//	//strcpy��string copy-�ַ�������
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
//}//��
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
//��ʵ�δ����βε�ʱ��
// �β���ʵ��ʵ�ε�һ����ʱ����
// ���βε��޸��ǲ���ı�ʵ�ε�
//
//void Swap2(int* pa, int* pb)//void�ǿ�û�з���ֵ
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
//	int* pa= &a;//paָ�����
//	*pa = 20;//�����ò���
//	return 0;
//}
//����������1��������������0
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
//	//��ӡ100-200֮�������
//	int i = 0;
//	int count = 0;
//	for (i = 100; i <= 200; i++)
//	{
//		//�ж�i�Ƿ�������
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
	//��ӡ100-200֮�������
	int i = 0;
	int count = 0;
	for (i = 100; i <= 200; i++)
	{
		//�ж�i�Ƿ�������
		if (is_prime(i) == 1)
		{
			printf("%d ", i);
			count++;
		}
	}
	printf("\n%d", count);
	return 0;
}