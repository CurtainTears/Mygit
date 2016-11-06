#include "stdio.h"
//主函数
int main(int argc, char const *argv[])
{
	int max(int x,int y);
	int a,b,c;
	scanf("%d,%d",&a,&b);
	c=max(a,b);
	printf("max=%d\n",c);
	return 0;
}
//max函数
int max(int x,int y)
{
	int z;
	if (x>y) z=x;
	else z=y;
	return(z);
}