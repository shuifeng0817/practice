#define _CRT_SECURE_NO_WARNINGS
#include<stdio.h>
#include <stdlib.h>
void sign()
{
	printf("ѧ��");
	printf("          ");
	printf("����");
	printf("       ");
	printf("�Ա�");
	printf("   \n");
	printf("���룺");

}
void menu()
{
	printf("-----------------" );
	printf("��ӭ����ѧ��ѡ�޿�ϵͳ");
	printf("------------------\n\n\n");
	printf("		1. ע��\n");
	printf("		2,.��¼\n");
	printf("		0. �˳�\n");
}
void ex()
{
	printf("\n");
	printf("��лʹ��ѧ��ѡ�޿�ϵͳ!\n");
	printf("-----------------------");
	printf("\n");
}
int main()
{
	int input = 0;
	do 
	{
		menu();
		printf("��ѡ��>:");
		scanf("%d", &input);
		system("cls");
		switch (input)
		{
		case 1:
			sign();
		case 2:
			//login();
			break;
		case 0:
			ex();
			break;
		default:
			printf("ѡ�����\n");
			break;
		}
	} while (input);
}