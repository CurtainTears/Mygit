#include <iostream>
#include"assert.h"
using namespace std;
//输入栈类
template<class Type>class Stack
{
 public:
  Stack(int=20);
  ~Stack(){delete []elements;}
  void Push(const Type&item);
  Type Pop();
  Type GetTop();
  void MakeEmpty(){top=1;}
  void overflowProcess();
  int IsEmpty()const{return top==-1;}
  int IsFull()const{return top==maxSize-1;}
 private:
  int top;
  Type *elements;
  int maxSize;
};


//输入栈的构造函数
template<class Type>Stack<Type>::Stack(int s):top(-1),maxSize(s)
{
 elements=new Type[maxSize];
 if(elements==NULL)exit(1);
}
//输入入栈算法Push
template<class Type>void Stack<Type>::Push(const Type&item)
{
 assert(!IsFull());
 elements[++top]=item;
}

 

//////   输入  查找算法Pop
template<class Type>Type Stack<Type>::Pop()
{
 assert(!IsEmpty());
    return elements[top--];
}


//////   输入  取栈顶元素算法GetTop
template<class Type>Type Stack<Type>::GetTop()
{
 assert(!IsEmpty());
 return elements[top];
}

////溢出处理
/*template<class Type>
void Stack<Type>::overflowProcess()
{
Type *newarry=new Type[maxSize];
Type *newarry=new Type[stackIncreament];

 if(newarry==NULL)
 {
  cerr<<"Storge error."<<endl;
  exit(1);
 }
 for(int i=0;i<=top;i++)newarry[i]=elements[i];
 maxSize=maxSize+stackIncreament;
 delete []elements;
 elements=newarry;
}*/


int main()
{   
    int size,number,select=5,i;
    char s;
 cout<<"\n请输入栈的大小:"<<endl;
 cin>>size;
 Stack<char> stack(size);
    while(select!=4)
  {
  cout<<"\n\t\t\t************操作菜单*****************\n";
     cout<<"\t\t\t\t 1 入栈"<<endl;
     cout<<"\t\t\t\t 2 出栈"<<endl;
  cout<<"\t\t\t\t 3 取栈顶元素"<<endl;
     cout<<"\t\t\t\t 4 退出"<<endl;
        cout<<"\t\t\t************请选择序号*****************\n";
  cin>>select;
  switch(select)
  {
   case 1:
         cout<<"请输入一个字符串并以.结束"<<endl;
         cin>>s;
         while(s!='.')
         {
        stack.Push(s);
        cin>>s;
          }
   break;
   case 2:
    cout<<"请输入出栈字符数:";
    cin>>number;
    cout<<"\n出栈元素依次为:";
             for(i=0;i<number;i++)
      if (!stack.IsEmpty()) cout<<stack.Pop()<<"  ";
    break;
   case 3:
    if (stack.IsEmpty()){cout<<"栈空"<<endl;break;}
    cout<<"栈顶元素为:"<<stack.GetTop();
    break;
   case 4:
    break;
  }
  }
    cout<<"谢谢使用"<<endl;
}