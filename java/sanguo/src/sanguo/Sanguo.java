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
			System.out.println("���ǻ����ֵ��¼����°ɣ�");
			if(w>=wl){
				System.out.println(name+"�����"+n+"ն�����£�");
				
			}
			else{
				System.out.println("���"+n+"��"+name+"ն�����£�");
				pkjg=0;
			}
		}
		else if(z>=zl){
			System.out.println(name+"�����"+n+"����������Ķ�����");
			
		}
		else{
			System.out.println("���"+n+"��"+name+"����������Ķ�����");
			pkjg=0;
		}
		return pkjg;
	}
}
public class Sanguo {
	public static void main(String[] args) {
		wujiang wanjia;
		wanjia=new wujiang(90,90,"����С����");
		wujiang[] wj;
		wj=new wujiang[5];
		wj[0]=new wujiang(60,90,"�ŷ�");
		wj[1]=new wujiang(90,40,"�����");
		wj[2]=new wujiang(82,80,"�ܲ�");
		wj[3]=new wujiang(70,60,"����");
		wj[4]=new wujiang(80,88,"˾��ܲ");
		for (int i = 0; i < wj.length; i++) {
			System.out.println("���"+wanjia.name+"��ʼ��"+wj[i].name+"���о�����");
			int t=wj[i].pk(wanjia.zl, wanjia.wl, wanjia.name);
			if(t==0){
				break;	
				}
		    }
		}
}
