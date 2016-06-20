package sanguo;

class wujiang{
	int zl;
	int wl;
	String name;
	public wujiang(int z,int w,String n){
		zl=z;
		wl=w;
		name=n;
	}
	public int pk(int z,int w,String n){
		int pkjg = 1;
		if (zl<=70|z<=70){
			System.out.println("我们还是手底下见真章吧！");
			if(w>=wl){
				System.out.println(name+"被玩家"+n+"斩于马下！");
				
			}
			else{
				System.out.println("玩家"+n+"被"+name+"斩于马下！");
				pkjg=0;
			}
		}
		else if(z>=zl){
			System.out.println(name+"被玩家"+n+"骂的气急攻心而死。");
			
		}
		else{
			System.out.println("玩家"+n+"被"+name+"骂的气急攻心而死。");
			pkjg=0;
		}
		return pkjg;
	}
}
public class Sanguo {
	public static void main(String[] args) {
		wujiang wanjia;
		wanjia=new wujiang(90,90,"火星小王子");
		wujiang[] wj;
		wj=new wujiang[5];
		wj[0]=new wujiang(60,90,"张飞");
		wj[1]=new wujiang(90,40,"诸葛亮");
		wj[2]=new wujiang(82,80,"曹操");
		wj[3]=new wujiang(70,60,"刘备");
		wj[4]=new wujiang(80,88,"司马懿");
		for (int i = 0; i < wj.length; i++) {
			System.out.println("玩家"+wanjia.name+"开始和"+wj[i].name+"进行决斗！");
			int t=wj[i].pk(wanjia.zl, wanjia.wl, wanjia.name);
			if(t==0){
				break;	
				}
		    }
		}
}
