#define _CRT_SECURE_NO_WARNINGS
#include "game.h"

void menu()
{
	printf("******************************\n");
	printf("**********  1.play  **********\n");
	printf("**********  0.exit  **********\n");
	printf("******************************\n");
}
void game()
{
	//�׵���Ϣ�洢
	// 1.���úõ��׵���Ϣ
	char mine[ROWS][COLS] = { 0 };
	
	// 2.�Ų�����׵���Ϣ
	char show[ROWS][COLS] = { 0 };
	//��ʼ��
	InitBoard(mine ,ROWS,COLS,'0');
	InitBoard(show, ROWS, COLS, '*');
	//��ӡ����
	
	DisplayBoard(show, ROW, COL);
	//������
	SetMine(mine ,ROW,COL);
	// ɨ��
	FindMine(mine, show, ROW, COL);
	
}
void test()
{
	int intput = 0;
	srand((unsigned int)time(NULL));
	do
	{
		menu();
		printf("��ѡ��:>");
		scanf("%d", &intput);
		switch (intput)
		{
		case 1:
			game();
			break;
		case 0:
			printf("�˳���Ϸ");
			break;
		default:
			printf("ѡ�����������ѡ��\n");
			break;
		}
	} while (intput);
}

int main()
{
	test();
	return 0;
}