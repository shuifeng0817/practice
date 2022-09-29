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
//	//写一个代码，在arr数组（有序的）中找到7
//	int i=0;
//	int sz = sizeof(arr) / sizeof(arr[0]);
//	for (i = 0; i < sz; i++)
//	{
//		if (k == arr[i])
//		{
//			printf("找到了，下标是：%d\n", i);
//			break;
//		}
//	}
//	if (i == sz)
//		printf("找不到\n");
//	return 0;
//}
//int main()
//{
//	int arr[] = { 1,2,3,4,5,6,7,8,9,10 };
//	int sz = sizeof(arr) / sizeof(arr[0]);//计算元素
//	int left  = 0;//左下标
//	int right = sz - 1;//右下标
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
//			printf("找到了，下标是：%d\n", mid);
//			break;
//		}
//	}
//	if (left > right)
//	{
//		printf("找不到\n");
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
//	printf("输入1-10之间的整数");
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
//		printf("找不到\n");
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
//	//元素[a b c \0]
//	//     0  1 2 3
//	//4-2才是c的下标
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
//		//有过程，停留一秒
//		Sleep(1000);
//		system("cls");//执行系统命令的函数 cls是清空屏幕
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
		printf("请输入密码:>");
		scanf("%s", password);
		if (strcmp(password,"123456")==0)//==不能用来比较两个字符串相等，应该使用一个库函数-strcmp
		{
			printf("登陆成功\n");
			break;
		}
		else
		{
			printf("密码错误\n");
		}
	}
	if (i == 3)
	{
		printf("三次密码均错误，退出程序\n");
	}
	return 0;
}
