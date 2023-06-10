#define _CRT_SECURE_NO_WARNINGS
#include<stdio.h>
#include <stdlib.h>
void sign()
{
	printf("学号");
	printf("          ");
	printf("姓名");
	printf("       ");
	printf("性别");
	printf("   \n");
	printf("密码：");

}
void menu()
{
	printf("-----------------" );
	printf("欢迎进入学生选修课系统");
	printf("------------------\n\n\n");
	printf("		1. 注册\n");
	printf("		2,.登录\n");
	printf("		0. 退出\n");
}
void ex()
{
	printf("\n");
	printf("感谢使用学生选修课系统!\n");
	printf("-----------------------");
	printf("\n");
}
int main()
{
	int input = 0;
	do 
	{
		menu();
		printf("请选择>:");
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
			printf("选择错误\n");
			break;
		}
	} while (input);
}