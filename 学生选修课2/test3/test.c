#define _CRT_SECURE_NO_WARNINGS
#include<stdio.h>
#include<string.h>
#include<stdlib.h>
#include<conio.h>
#include<dos.h>

#define LEN sizeof(struct student)
#define FORMAT "%-12d%-12s%-12s%-12s%-12s%-12d\n"
#define DATA stu[i].num,stu[i].name, stu[i].sex,stu[i].spe,stu[i].course,stu[i].tim
#define DATAS stu[i].nums
#define LENS sizeof(struct students)

void del();
void ex();
void input();
void inputs();
void menu();
void menus();
void signin();
void search();

struct students
{
	int nums;
};
struct students stus[5];
struct student
{
	int num;			/*选课专业代码*/
	char name[15];		/*姓名*/
	char sex[12];		/*性别*/
	char spe[12];		/*专业*/
	char course[12];		/*选课*/
	int tim;			//学分
};
struct student stu[50];		/*定义全局结构体数组*/
int main()
{
	menu();
	int in = 0;
	scanf("%d", &in);
	do
	{
		switch (in)
		{
		case 1:
			inputs();
			break;
		case 2:
			signin();
			break;
		case 0:
			ex();
			break;
		default:
			printf("输入错误请重新输入");
			scanf("%d", &in);
			break;
		}
	} while (in);
	return 0;

}
void menu()
{
	printf("----------------------");
	printf("欢迎进入学生选课系统");
	printf("----------------------\n\n\n");
	printf("      1. 注册");
	printf("      2. 登录");
	printf("      0. 退出");
}


void search()
{
	FILE* fp;
	int snum, i, m = 0;
	char ch[2];
	if ((fp = fopen("stuData.txt", "rb")) == NULL)
	{
		printf("打开文件失败\n");
		return;
	}
	while (!feof(fp))
	{
		if (fread(&stu[m], LEN, 1, fp) == 1)
			m++;
	}
	fclose(fp);
	if (m == 0)
	{
		printf("文件无记录!\n");
		return;
	}
	printf("请输入需要查找的学分:");
	scanf("%d", &snum);
	for (i = 0; i < m; i++)
	{
		if (snum == stu[i].tim)		               /*查找输入的学号是否在记录中*/
		{

			printf("选课专业代码  姓名        性别        专业        选课     学分\t\n");
			printf(FORMAT, DATA);	/*将查找出的结果按指定格式输出*/
			

		}
	}
	if (i == m)
		printf("无记录!\n");			/*未找到要查找的信息*/
}
void show()
{
	FILE* fp;
	int i, m = 0;
	fp = fopen("stuData.txt", "rb");
	while (!feof(fp))
	{
		if (fread(&stu[m], LEN, 1, fp) == 1)
			m++;
	}
	fclose(fp);
	printf("选课专业代码  姓名        性别        专业        选课     学分\t\n");
	for (i = 0; i < m; i++)
	{
		printf(FORMAT, DATA);		/*将学生信息按指定格式打印*/
	}
	return 0;
}
void input()
{
	int i, m = 0;						/*变量m表示记录的条数*/
	char ch[2];
	FILE* fp;	/*定义文件指针*/
	if ((fp = fopen("stuData.txt", "a+")) == NULL)	                            /*打开指定文件*/
	{
		printf("打开文件失败\n");
		return;
	}
	while (!feof(fp))
	{
		if (fread(&stu[m], LEN, 1, fp) == 1)
			m++;				/*统计当前记录条数*/
	}
	fclose(fp);
	if (m == 0)
		printf("没有数据!\n");
	else
	{
		system("cls");
		show();					/*调用show函数，显示原有信息*/
	}
	if ((fp = fopen("stuData.txt", "wb")) == NULL)
	{
		printf("打开文件失败\n");
		return;
	}
	for (i = 0; i < m; i++)
	{
		fwrite(&stu[i], LEN, 1, fp);			/*向指定的磁盘文件写入信息*/
	}

	printf("请确认(y/n):");
	scanf("%s", ch);
	while (strcmp(ch, "Y") == 0 || strcmp(ch, "y") == 0)                /*判断是否要录入新信息*/
	{
		printf("选课专业代码:");
		scanf("%d", &stu[m].num);			/*输入学生选课专业代码*/
		for (i = 0; i < m; i++)
			if (stu[i].num == stu[m].num)
			{
				printf("此选课专业代码已存在！");
				_getch();
				fclose(fp);
				return;
			}
		/*如果选课专业代码可用，则继续输入其它数据*/
		printf("姓名:");
		scanf("%s", stu[m].name);			    /*输入学生姓名*/
		printf("性别:");
		scanf("%s", &stu[m].sex);		    /*输入性别*/
		printf("专业:");
		scanf("%s", &stu[m].spe);			    /*输入专业*/
		printf("选课:");
		scanf("%s", &stu[m].course);		    /*输入选课*/
		printf("学分:");
		scanf("%d", &stu[m].tim);            //输入学分
		if (fwrite(&stu[m], LEN, 1, fp) != 1)	/*将新录入的信息写入指定的磁盘文件*/
		{
			printf("保存失败!");
			_getch();
		}
		else
		{
			printf("%s 已保存!\n", stu[m].name);
			m++;
		}
		printf("是否继续?(y/n):");			/*询问是否继续*/
		scanf("%s", ch);
	}
	fclose(fp);
	printf("操作成功!\n");
}


void inputs()//注册学号
{
	int i, m = 0;						/*变量m表示记录的条数*/
	char ch[2];
	FILE* fp;	/*定义文件指针*/
	if ((fp = fopen("stuDatas.txt", "a+")) == NULL)	                            /*打开指定文件*/
	{
		printf("打开文件失败\n");
		return;
	}
	while (!feof(fp))
	{
		if (fread(&stus[m], LENS, 1, fp) == 1)
			m++;				/*统计当前记录条数*/
	}
	fclose(fp);
	if (m == 0)
		printf("没有数据!\n");
	if ((fp = fopen("stuDatas.txt", "wb")) == NULL)
	{
		printf("打开文件失败\n");
		return;
	}


	printf("请确认(y/n):");
	scanf("%s", ch);
	while (strcmp(ch, "Y") == 0 || strcmp(ch, "y") == 0)                /*判断是否要录入新信息*/
	{
		printf("学号:");
		scanf("%d", &stus[m].nums);			/*输入学号*/
		if (fwrite(&stus[m], LENS, 1, fp) != 1)	/*将新录入的信息写入指定的磁盘文件*/
		{
			printf("保存失败!");
			_getch();
		}
		for (i = 0; i < m; i++)
			if (stus[i].nums == stus[m].nums)
			{
				printf("此学号已存在！");
				_getch();
				fclose(fp);
				return;
			}
		/*如果学号可用，则继续输入其它数据*/
		fclose(fp);
		printf("操作成功!\n");
		menus();
	}
	if (strcmp(ch, "N") == 0 || strcmp(ch, "n") == 0)
		main();
}

void signin()
{
	int i, m = 0;					/*变量m表示记录的条数*/
	char ch[2];
	FILE* fp;	/*定义文件指针*/
	if ((fp = fopen("stuDatas.txt", "a+")) == NULL)	                            /*打开指定文件*/
	{
		printf("打开文件失败\n");
		return;
	}
	while (!feof(fp))
	{
		if (fread(&stu[m], LENS, 1, fp) == 1)
			m++;				/*统计当前记录条数*/
	}
	fclose(fp);
	if (m == 0)
	{
		printf("没有数据,请注册!\n");
		printf("是否注册(y/n):");
		scanf("%s", ch);
		if (strcmp(ch, "Y") == 0 || strcmp(ch, "y") == 0)
		{
			inputs();
		}
		else
		{
			menu();
		}

	}


	if ((fp = fopen("stuDatas.txt", "rb")) == NULL)
	{
		printf("打开文件失败\n");
		return;
	}
	printf("请输入学号：");
	scanf("%d", &stus[m].nums);
	for (i = 0; i < m; i++)
	{
		if (stus[i].nums == stus[m].nums)
		{
			menus();
		}
	}
	if (stus[i].nums != stus[m].nums)
	{
		printf("未找到数据，请重新注册:");
		inputs();
	}


}



void del()
{
	FILE* fp;
	int  snum, i, j, m = 0;
	char ch[2];
	if ((fp = fopen("stuData.txt", "r+")) == NULL)
	{
		printf("打开文件失败\n"); return;
	}
	while (!feof(fp))
		if (fread(&stu[m], LEN, 1, fp) == 1)
			m++;
	fclose(fp);
	if (m == 0)
	{
		printf("文件无记录!\n");
		return;
	}
	show();						/*显示已有数据*/
	printf("请输入需要删除的选课号:");
	scanf("%d", &snum);
	for (i = 0; i < m; i++)
	{
		if (snum == stu[i].num)				/*查找到输入的学号*/
		{
			printf("数据已找到，是否确认删除?(y/n)");
			scanf("%s", ch);
			if (strcmp(ch, "Y") == 0 || strcmp(ch, "y") == 0)	                /*判断是否要进行删除*/
			{
				for (j = i; j < m; j++)
					stu[j] = stu[j + 1];		                              /*将记录依次移到前面的位置*/
				m--;						         /*记录的总个数减1*/
				if ((fp = fopen("stuData.txt", "wb")) == NULL)
				{
					printf("打开文件失败\n");
					return;
				}
				for (j = 0; j < m; j++)/*将更改后的记录重新写入指定的磁盘文件中*/
					if (fwrite(&stu[j], LEN, 1, fp) != 1)
					{
						printf("对不起，保存失败!\n");
						_getch();			                        /*程序暂停*/
					}
				fclose(fp);
				printf("删除成功!\n");
				return;
			}
			else			                   /*用户输入的字符不是y或Y，表示取消删除*/
			{
				printf("取消删除!\n");
				return;
			}
		}
	}
	printf("没有找到要删除的信息！\n");
}
void menus()
{
	printf("----------------------");
	printf("欢迎进入学生选课系统");
	printf("----------------------\n\n\n");
	printf("      1. 选课");
	printf("      2. 展示");
	printf("      3. 查询");
	printf("      4. 删除");
	printf("      0. 退出");
	int in = 0;
	scanf("%d", &in);
	do
	{
		switch (in)
		{
		case 1:
			input();
			menus();
			scanf("%d", &in);
			break;
		case 2:
			show();
			menus();
			scanf("%d", &in);
			break;
		case 3:
			search();
			menus();
			scanf("%d", &in);
			break;
		case 4:
			del();
			menus();
			scanf("%d", &in);
		case 0:
			main();
		default:
			printf("输入错误请重新输入");
			scanf("%d", &in);
			break;
		}
	} while (in);

}
void ex()
{
	printf("----------------------\n");
	printf("         退出           ");
}


