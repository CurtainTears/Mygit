#include <iostream>

using namespace std;
int arrs[] = { 12, 5, 223, 23, 8, 6, 335, 40, 31, 35, 44, 111 };
int arrLen = sizeof(arrs) / sizeof(arrs[0]);
int partition(int *arrs,int low,int high)
{
 int pivotpos=low;
 int pivot=arrs[low];
 for(int i=low+1;i<=high;i++)
 {
  if(arrs[i]<pivot)
   {pivotpos++;
   if(pivotpos!=i)
    {swap(arrs[pivotpos],arrs[i]);}
    }
  }
 
 arrs[low]=arrs[pivotpos];
   arrs[pivotpos]=pivot;
   cout<<"输出结果为："<<endl;
    for (int j = 0; j < arrLen; j++)
 cout<<arrs[j] << ",";
 cout<<endl;
 return pivotpos; 
}
void swap(int &p,int &q){
 int temp=p;
 p=q;
 q=temp;
}
void quickSort(int * arrs, int left, int right){
 if(left<right){
  int pivotpos;
  pivotpos=partition(arrs,left,right);
  quickSort(arrs,left,pivotpos-1);
  quickSort(arrs,pivotpos+1,right);
  }
}

int main()
{
    quickSort(arrs, 0, arrLen - 1);
    
    return 0;
}