#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
//int main()
//{
//	int a = 0x11223344;
//	/*int* pa = &a;
//	*pa = 0;*/
//
//	char* pc = &a;
//	*pc = 0;
//
//	/*printf("%p\n", pa);
//	printf("%p\n", pc);*/
//	return 0;
//}
//int main()
//{
//	int a = 0x11223344;
//	int* pa = &a;
//	char* pc = &a;
//	printf("%p\n", pa);
//	printf("%p\n", pa+1);
//
//	printf("%p\n", pc);
//	printf("%p\n", pc+1);
//	return 0;
//}
//int main()
//{
//	int arr[10] = { 0 };
//	//int* p = arr;//������-��Ԫ�صĵ�ַ
//	char* p = arr;
//	int i = 0;
//	for (i = 0; i < 10; i++)
//	{
//		*(p + i) = 1;
//	}
//	return 0;
//}

int main()
{
	//int a = 0;//�ֲ���������ʼ����Ĭ�������ֵ
	int* p;//�ֲ���ָ��������ͱ���ʼ�����ֵ
	*p = 20;
	return 0;
}
int main()
{
	int arr[10] = { 0 };
	int* p = arr;
	int i = 0;
	for (i = 0; i < 12; i++);
	{
		p++;
	}
	return 0;
}