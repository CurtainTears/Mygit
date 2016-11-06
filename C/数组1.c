#include "stdio.h"
int main(int argc, char const *argv[])
{
	int i;
	int f[20]={1,1};
	for (int i = 2; i < 20; i++)
	{
		f[i]=f[i-2]+f[i-1];
	}
	for (int i = 0; i < 20; i++)
	{
		/* code */
		if(i%5==0) printf("\n");
		printf("%12d", f[i]);
	}
	printf("\n");
	return 0;
}