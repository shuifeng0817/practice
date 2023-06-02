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
	int num;			/*ѡ��רҵ����*/
	char name[15];		/*����*/
	char sex[12];		/*�Ա�*/
	char spe[12];		/*רҵ*/
	char course[12];		/*ѡ��*/
	int tim;			//ѧ��
};
struct student stu[50];		/*����ȫ�ֽṹ������*/
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
			printf("�����������������");
			scanf("%d", &in);
			break;
		}
	} while (in);
	return 0;

}
void menu()
{
	printf("----------------------");
	printf("��ӭ����ѧ��ѡ��ϵͳ");
	printf("----------------------\n\n\n");
	printf("      1. ע��");
	printf("      2. ��¼");
	printf("      0. �˳�");
}


void search()
{
	FILE* fp;
	int snum, i, m = 0;
	char ch[2];
	if ((fp = fopen("stuData.txt", "rb")) == NULL)
	{
		printf("���ļ�ʧ��\n");
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
		printf("�ļ��޼�¼!\n");
		return;
	}
	printf("��������Ҫ���ҵ�ѧ��:");
	scanf("%d", &snum);
	for (i = 0; i < m; i++)
	{
		if (snum == stu[i].tim)		               /*���������ѧ���Ƿ��ڼ�¼��*/
		{

			printf("ѡ��רҵ����  ����        �Ա�        רҵ        ѡ��     ѧ��\t\n");
			printf(FORMAT, DATA);	/*�����ҳ��Ľ����ָ����ʽ���*/
			

		}
	}
	if (i == m)
		printf("�޼�¼!\n");			/*δ�ҵ�Ҫ���ҵ���Ϣ*/
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
	printf("ѡ��רҵ����  ����        �Ա�        רҵ        ѡ��     ѧ��\t\n");
	for (i = 0; i < m; i++)
	{
		printf(FORMAT, DATA);		/*��ѧ����Ϣ��ָ����ʽ��ӡ*/
	}
	return 0;
}
void input()
{
	int i, m = 0;						/*����m��ʾ��¼������*/
	char ch[2];
	FILE* fp;	/*�����ļ�ָ��*/
	if ((fp = fopen("stuData.txt", "a+")) == NULL)	                            /*��ָ���ļ�*/
	{
		printf("���ļ�ʧ��\n");
		return;
	}
	while (!feof(fp))
	{
		if (fread(&stu[m], LEN, 1, fp) == 1)
			m++;				/*ͳ�Ƶ�ǰ��¼����*/
	}
	fclose(fp);
	if (m == 0)
		printf("û������!\n");
	else
	{
		system("cls");
		show();					/*����show��������ʾԭ����Ϣ*/
	}
	if ((fp = fopen("stuData.txt", "wb")) == NULL)
	{
		printf("���ļ�ʧ��\n");
		return;
	}
	for (i = 0; i < m; i++)
	{
		fwrite(&stu[i], LEN, 1, fp);			/*��ָ���Ĵ����ļ�д����Ϣ*/
	}

	printf("��ȷ��(y/n):");
	scanf("%s", ch);
	while (strcmp(ch, "Y") == 0 || strcmp(ch, "y") == 0)                /*�ж��Ƿ�Ҫ¼������Ϣ*/
	{
		printf("ѡ��רҵ����:");
		scanf("%d", &stu[m].num);			/*����ѧ��ѡ��רҵ����*/
		for (i = 0; i < m; i++)
			if (stu[i].num == stu[m].num)
			{
				printf("��ѡ��רҵ�����Ѵ��ڣ�");
				_getch();
				fclose(fp);
				return;
			}
		/*���ѡ��רҵ������ã������������������*/
		printf("����:");
		scanf("%s", stu[m].name);			    /*����ѧ������*/
		printf("�Ա�:");
		scanf("%s", &stu[m].sex);		    /*�����Ա�*/
		printf("רҵ:");
		scanf("%s", &stu[m].spe);			    /*����רҵ*/
		printf("ѡ��:");
		scanf("%s", &stu[m].course);		    /*����ѡ��*/
		printf("ѧ��:");
		scanf("%d", &stu[m].tim);            //����ѧ��
		if (fwrite(&stu[m], LEN, 1, fp) != 1)	/*����¼�����Ϣд��ָ���Ĵ����ļ�*/
		{
			printf("����ʧ��!");
			_getch();
		}
		else
		{
			printf("%s �ѱ���!\n", stu[m].name);
			m++;
		}
		printf("�Ƿ����?(y/n):");			/*ѯ���Ƿ����*/
		scanf("%s", ch);
	}
	fclose(fp);
	printf("�����ɹ�!\n");
}


void inputs()//ע��ѧ��
{
	int i, m = 0;						/*����m��ʾ��¼������*/
	char ch[2];
	FILE* fp;	/*�����ļ�ָ��*/
	if ((fp = fopen("stuDatas.txt", "a+")) == NULL)	                            /*��ָ���ļ�*/
	{
		printf("���ļ�ʧ��\n");
		return;
	}
	while (!feof(fp))
	{
		if (fread(&stus[m], LENS, 1, fp) == 1)
			m++;				/*ͳ�Ƶ�ǰ��¼����*/
	}
	fclose(fp);
	if (m == 0)
		printf("û������!\n");
	if ((fp = fopen("stuDatas.txt", "wb")) == NULL)
	{
		printf("���ļ�ʧ��\n");
		return;
	}


	printf("��ȷ��(y/n):");
	scanf("%s", ch);
	while (strcmp(ch, "Y") == 0 || strcmp(ch, "y") == 0)                /*�ж��Ƿ�Ҫ¼������Ϣ*/
	{
		printf("ѧ��:");
		scanf("%d", &stus[m].nums);			/*����ѧ��*/
		if (fwrite(&stus[m], LENS, 1, fp) != 1)	/*����¼�����Ϣд��ָ���Ĵ����ļ�*/
		{
			printf("����ʧ��!");
			_getch();
		}
		for (i = 0; i < m; i++)
			if (stus[i].nums == stus[m].nums)
			{
				printf("��ѧ���Ѵ��ڣ�");
				_getch();
				fclose(fp);
				return;
			}
		/*���ѧ�ſ��ã������������������*/
		fclose(fp);
		printf("�����ɹ�!\n");
		menus();
	}
	if (strcmp(ch, "N") == 0 || strcmp(ch, "n") == 0)
		main();
}

void signin()
{
	int i, m = 0;					/*����m��ʾ��¼������*/
	char ch[2];
	FILE* fp;	/*�����ļ�ָ��*/
	if ((fp = fopen("stuDatas.txt", "a+")) == NULL)	                            /*��ָ���ļ�*/
	{
		printf("���ļ�ʧ��\n");
		return;
	}
	while (!feof(fp))
	{
		if (fread(&stu[m], LENS, 1, fp) == 1)
			m++;				/*ͳ�Ƶ�ǰ��¼����*/
	}
	fclose(fp);
	if (m == 0)
	{
		printf("û������,��ע��!\n");
		printf("�Ƿ�ע��(y/n):");
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
		printf("���ļ�ʧ��\n");
		return;
	}
	printf("������ѧ�ţ�");
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
		printf("δ�ҵ����ݣ�������ע��:");
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
		printf("���ļ�ʧ��\n"); return;
	}
	while (!feof(fp))
		if (fread(&stu[m], LEN, 1, fp) == 1)
			m++;
	fclose(fp);
	if (m == 0)
	{
		printf("�ļ��޼�¼!\n");
		return;
	}
	show();						/*��ʾ��������*/
	printf("��������Ҫɾ����ѡ�κ�:");
	scanf("%d", &snum);
	for (i = 0; i < m; i++)
	{
		if (snum == stu[i].num)				/*���ҵ������ѧ��*/
		{
			printf("�������ҵ����Ƿ�ȷ��ɾ��?(y/n)");
			scanf("%s", ch);
			if (strcmp(ch, "Y") == 0 || strcmp(ch, "y") == 0)	                /*�ж��Ƿ�Ҫ����ɾ��*/
			{
				for (j = i; j < m; j++)
					stu[j] = stu[j + 1];		                              /*����¼�����Ƶ�ǰ���λ��*/
				m--;						         /*��¼���ܸ�����1*/
				if ((fp = fopen("stuData.txt", "wb")) == NULL)
				{
					printf("���ļ�ʧ��\n");
					return;
				}
				for (j = 0; j < m; j++)/*�����ĺ�ļ�¼����д��ָ���Ĵ����ļ���*/
					if (fwrite(&stu[j], LEN, 1, fp) != 1)
					{
						printf("�Բ��𣬱���ʧ��!\n");
						_getch();			                        /*������ͣ*/
					}
				fclose(fp);
				printf("ɾ���ɹ�!\n");
				return;
			}
			else			                   /*�û�������ַ�����y��Y����ʾȡ��ɾ��*/
			{
				printf("ȡ��ɾ��!\n");
				return;
			}
		}
	}
	printf("û���ҵ�Ҫɾ������Ϣ��\n");
}
void menus()
{
	printf("----------------------");
	printf("��ӭ����ѧ��ѡ��ϵͳ");
	printf("----------------------\n\n\n");
	printf("      1. ѡ��");
	printf("      2. չʾ");
	printf("      3. ��ѯ");
	printf("      4. ɾ��");
	printf("      0. �˳�");
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
			printf("�����������������");
			scanf("%d", &in);
			break;
		}
	} while (in);

}
void ex()
{
	printf("----------------------\n");
	printf("         �˳�           ");
}


