#include <iostream>
using namespace std;
template<class Type> class Queue
{
	public:
		Queue(int=10);
		~Queue(){delete []elements;}
		void EnQueue(const Type&item);
		Type DeQueue();
		Type GetFront();
		void MakeEmpty(){front=rear=0;}
		int IsEmpty() const{return front==rear;}
		int IsFull() const{return (rear+1)%maxSize==front;}
		int Length() const{return (rear-front+maxSize)%maxSize;}
	private:
		int rear,front;
		Type *elements;
		int maxSize;
};
//////   输入  循环队列构造函数Queue
template<class Type>Queue<Type>::Queue(int sz):front(0),rear(0),maxSize(sz)
{
	elements=new Type[maxSize];
	if(elements==NULL)exit(1);
}
//////

//////   输入  入队算法EnQueue
template<class Type>void Queue<Type>::EnQueue(const Type&item)
{
	//assert(!IsFull());
	if(!IsFull())
	{
		rear=(rear+1)%maxSize;
		elements[rear]=item;
	}
	else
		cout<<"队满"<<endl;
}
//////

//////   输入  出队算法DeQueue
template<class Type>Type Queue<Type>::DeQueue()
{
	//assert(!IsEmpty());
	if(!IsEmpty())
	{
		front=(front+1)%maxSize;
		return elements[front];
	}
	else
		cout<<"队空"<<endl;
}
//////

//////   输入  获得对头元素GetFront
template<class Type>Type Queue<Type>::GetFront()
{
	//assert(!IsEmpty());
	if(!IsEmpty())
		return elements[(front+1)%maxSize];
	else
		cout<<"队空"<<endl;
}
//////

int main(void)
{   
    int size,number,select=5,i;
    char s;
	cout<<"\n请输入队列的大小:"<<endl;
	cin>>size;
	Queue<char> queue(size);
    while(select!=4)
	 {
		cout<<"\n\t\t\t************操作菜单*****************\n";
	    cout<<"\t\t\t\t 1 入队"<<endl;
	    cout<<"\t\t\t\t 2 出队"<<endl;
	    cout<<"\t\t\t\t 3 取队头元素"<<endl;
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
		      queue.EnQueue(s);
		      cin>>s;
	         }
			break;
		 case 2:
			 cout<<"请输入出队字符数:";
			 cin>>number;
			 cout<<"\n出队元素依次为:";
             for(i=0;i<number;i++)
			   if (!queue.IsEmpty()) cout<<queue.DeQueue()<<"  ";
			 break;
		 case 3:
			 if (queue.IsEmpty()){cout<<"队空"<<endl;break;}
			 cout<<"队头元素为:"<<queue.GetFront();
			 break;
		 case 4:
			 break;
		}
	 }
	   cout<<"谢谢使用"<<endl;
	   return 0;
}
