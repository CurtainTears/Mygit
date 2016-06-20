package DF;
import java.util.*;
class tiqu{
	private int d1,f1,m1,d2,f2,m2;
	private String str;
	public tiqu(String s){
		str=s;
	}
	void a(){
	 String a[]=str.split("°„");
	 d1=Integer.parseInt(a[0]);
	 String b[]=a[1].split("\'");
	 String c[]=a[2].split("\'");
	 f1=Integer.parseInt(b[0]);
	 f2=Integer.parseInt(c[0]);
	 String d[]=b[1].split("\"");
	 String e[]=c[1].split("\"");
	 m1=Integer.parseInt(d[0]);
	 m2=Integer.parseInt(e[0]);
	 String f=d[1].substring(1);
	 d2=Integer.parseInt(f);
	 }
	void b(){
		int d,f,m;
		int x=str.indexOf("+");
		if(x==-1){
		d=d1-d2;
		f=f1-f2;
		m=m1-m2;
		if(f<0){
			d=d-1;
			f=f+60;
		}
		if(m<0){
			f=f-1;
			m=m+60;
		}
		}
		else{
			d=d1+d2;
			f=f1+f2;
			m=m1+m2;
			if(m>=60){
				f=f+1;
				m=m-60;
			}
			if(f>=60){
				d=d+1;
				f=f-60;
			}
		}
		System.out.println(d+"°„"+f+"\'"+m+"\"");
	}
}

public class DF {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
String a;
System.out.println("«Î ‰»Î£∫");
Scanner reader=new Scanner(System.in);
a = reader.nextLine();
tiqu lei=new tiqu(a);
lei.a();
lei.b();

	}

}