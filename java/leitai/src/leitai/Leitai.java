package leitai;
class wujiang{
	int WL;
	int TS;
	int ZL;
	int NZ;
	int Score=0;
	String name;
	public wujiang(String na,int w,int t,int z,int n){
		ZL=z;
		WL=w;
		TS=t;
		NZ=n;
		name=na;
	}
	public void pk(int W,int T,int Z,int N,int S){
		if(W>WL){
			S=S+2;
		}
		else if(W==WL){
			S=S+1;
			Score=Score+1;
		}
		else{
			Score=Score+2;
		}
		if(T>TS){
			S=S+2;
		}
		else if(T==TS){
			S=S+1;
			Score=Score+1;
		}
		else{
			Score=Score+2;
		}
		if(Z>ZL){
			S=S+2;
		}
		else if(Z==ZL){
			S=S+1;
			Score=Score+1;
		}
		else{
			Score=Score+2;
		}
		if(N>NZ){
			S=S+2;
		}
		else if(N==NZ){
			S=S+1;
			Score=Score+1;
		}
		else{
			Score=Score+2;
		}
	}
}
public class Leitai {
	public static void main(String[] args) {
		wujiang[] wj;
		wj=new wujiang[5];
		wj[0]=new wujiang("关羽",97,96,73,62);
		wj[1]=new wujiang("张飞",98,90,30,22);
		wj[2]=new wujiang("赵云",96,92,75,65);
		wj[3]=new wujiang("马超",96,91,44,26);
		wj[4]=new wujiang("黄忠",95,89,66,52);
		for(int i=0;i<5;i++){
			for(int j=1;j>i&&j<5;j++){
				wj[i].pk(wj[j].WL,wj[j].TS,wj[j].ZL,wj[j].NZ,wj[j].Score);
			}
		}
		int max=wj[0].Score;
		int num = 0;
		for(int u=1;u<5;u++){
			if(wj[u].Score>max){
				max=wj[u].Score;
				num=u;
			}
		}
		
		System.out.println("超级武将是"+wj[num].name+"分数是"+wj[num].Score);
	}

}
