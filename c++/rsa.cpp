#include <stdio.h>
#include "math.h"
long ExponentiationAndMod(int m, int n,int t,long long dvalue=1)
{
	if (m < 0 || t < 1 || n < 0)
		return-1;
	else if (n < 2)
		return (long)pow(m,n)*dvalue%t;
	if (m == 1)
		return dvalue%t;
	else if (m == 0)
		return 0;
	if (n % 2 != 0)
	{
		dvalue = (dvalue*m)%t;
		n--;
	}
	if (m >= t)
		m %= t;
	long long t_m = m;
	t_m *= t_m;
	n /= 2;
	return ExponentiationAndMod(t_m, n, t, dvalue);
}
int main(int argc, char const *argv[])
{
	long x=ExponentiationAndMod(160,1217,2773);
	printf("%ld\n",x);
	return 0;
}