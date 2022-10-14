#define _CRT_SECURE_NO_WARNINGS
#include<stdio.h>
#include <stdlib.h>
#include<time.h>
void menu()
{
	printf("******************************************\n");
	printf("*********     1.play   0.exit   **********\n");
	printf("******************************************\n");

}
void game()
{
	int ret = 0;
	int guess = 0;
	//unsigned是无符号的变量 NULL是空指针
	//用时间戳
	//拿时间戳来设置随机数的生成起始点
	//time_t time(time_t *timer)
	ret = rand() % 100 + 1;//生成0—100之间的随机数
	printf("开始游戏\n");
	//printf("%d\n", ret);
	//猜数字
	while (1)
	{
		printf("猜数字:>");
		scanf("%d", &guess);
		if (guess > ret)
		{
			printf("猜大了\n");
		}
		else if (guess < ret)
		{
			printf("猜小了\n");
		}
		else
		{
			printf("恭喜你，猜对了\n");
			break;
		}
	}

}

int main()
{
	int input = 0;
	srand((unsigned int)time(NULL));
	do
	{
		menu();
		printf("请选择>:");
		scanf("%d", &input);

		switch (input)
		{
		case 1:
			game();
			break;//猜数字游戏
		case 0:
			printf("退出游戏\n");
			break;
		default:
			printf("选择错误\n");
			break;
		}

	} while (input);
	return 0;
}
