#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include<string.h>
#include<windows.h>
#include<stdlib.h>
//int main()
//{
//	int a = 1;
//	int i = 1;
//	int b = 0;
//	int n = 0;
//	scanf("%d", &n);
//	for (b=0;b<n;b++)
//	{
//		a = i * a;
//		i++;
//	}
//	printf("%d", a);
//	return 0;
//}
//int main()
//{
//	int i = 0;
//	int n = 0;
//	int ret = 1;
//	scanf("%d", &n);
//	for (i=1;i<=n;i++)
//	{
//		ret = ret * i;
//	}
//	printf("ret=%d", ret);
//	return 0;
//}
//int main()
//{
//	int i = 0;
//	int n = 0;
//	int ret = 1;
//	int a = 0;
//	int b = 0;
//	scanf("%d", &n);
//	for (;; n--)
//	{
//
//		for (i = 1; i <= n; i++)
//		{
//			ret = ret * i;
//		}
//		if (n == 0)
//			break;
//		b = ret + b;
//		ret = 1;
//		
//	}
//	printf("%d", b);
//	return 0;
//}
// 
//int main()
//{
//	int i = 0;
//	int n = 0;
//	int ret = 1;
//	int sum = 0;
//	for (n = 1; n <= 3; n++)
//	{
//		ret = ret * n;
//		sum = sum + ret;
//	}
//	printf("sum=%d\n", sum);
//	return 0;
//}
//int main()
//{
//	int arr[] = { 1,2,3,4,5,6,7,8,9,10 };
//	int k = 7;
//	//дһ�����룬��arr���飨����ģ����ҵ�7
//	int i=0;
//	int sz = sizeof(arr) / sizeof(arr[0]);
//	for (i = 0; i < sz; i++)
//	{
//		if (k == arr[i])
//		{
//			printf("�ҵ��ˣ��±��ǣ�%d\n", i);
//			break;
//		}
//	}
//	if (i == sz)
//		printf("�Ҳ���\n");
//	return 0;
//}
//int main()
//{
//	int arr[] = { 1,2,3,4,5,6,7,8,9,10 };
//	int sz = sizeof(arr) / sizeof(arr[0]);//����Ԫ��
//	int left  = 0;//���±�
//	int right = sz - 1;//���±�
//	int k = 7;
//	while (left <=right)
//	{
//		int mid = (left + right) / 2;
//		if (arr[mid] > k)
//		{
//			right = mid - 1;
//		}
//		else if (arr[mid]< k)
//		{
//			left = mid + 1;
//		}
//		else
//		{
//			printf("�ҵ��ˣ��±��ǣ�%d\n", mid);
//			break;
//		}
//	}
//	if (left > right)
//	{
//		printf("�Ҳ���\n");
//	}
//	 return 0;
//	
//}
//int main()
//{
//	int arr[] = { 1,2,3,4,5,6,7,8,9,10 };
//	int k = 0;
//	int i = 0;
//	int sz = sizeof (arr) / sizeof (arr[0]);
//	printf("����1-10֮�������");
//	scanf("%d", &k);
//	for (i = 0; i < sz ; i++)
//	{
//		if (k == arr[i])
//		{
//			printf("%d\n", i);
//			break;
//		}
//	}
//	if (sz == i)
//	{
//		printf("�Ҳ���\n");
//	}
//	return 0;
//}
//int main()
//{
//	//welcome to bit!!!!!
//	//###################
//	//w#################!
//	//we###############!!
//	//char arr[]="abc";
//	//Ԫ��[a b c \0]
//	//     0  1 2 3
//	//4-2����c���±�
//	char arr1[] = "welcome to bit!!!!!!";
//	char arr2[] = "####################";
//	int left = 0;
//	//int right = sizeof(arr1) / sizeof(arr1[0]) - 2;
//	int right = strlen(arr1)-1;
//
//	while (left <=right)
//	{
//		arr2[left] = arr1[left];
//		arr2[right] = arr1[right];
//		printf("%s\n", arr2);
//		//�й��̣�ͣ��һ��
//		Sleep(1000);
//		system("cls");//ִ��ϵͳ����ĺ��� cls�������Ļ
//		left++;
//		right--;
//	}
//	printf("%s", arr2);
//	return 0;
//}
int main()
{
	int i = 0;
	char password[20] = { 0 };
	for (i = 0; i < 3; i++)
	{
		printf("����������:>");
		scanf("%s", password);
		if (strcmp(password,"123456")==0)//==���������Ƚ������ַ�����ȣ�Ӧ��ʹ��һ���⺯��-strcmp
		{
			printf("��½�ɹ�\n");
			break;
		}
		else
		{
			printf("�������\n");
		}
	}
	if (i == 3)
	{
		printf("��������������˳�����\n");
	}
	return 0;
}
