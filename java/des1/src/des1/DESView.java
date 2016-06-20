package des1;

import java.util.*;

/**
 * 就当做是界面类吧，用来测试结果。
 * @author the5fire
 * blog:http://www.the5fire.net
 *
 */
public class DESView {
	
	/**
	 * @param args
	 */
	@SuppressWarnings("null")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DES des = new DES();
		int data10;
		Scanner reader=new Scanner(System.in);
		data10=reader.nextInt();
		String data2=Integer.toBinaryString(data10);
        String[] data =null;
        for(int i=0;i<data2.length();i=i+64){
			
			data[i] = data2.substring(i,i+64);	
		}
		int[] data1 = new int[]{
				0,0,0,0,0,0,0,1,
				0,0,1,0,0,0,1,1,
				0,1,0,0,0,1,0,1,
				0,1,1,0,0,1,1,1,
				1,0,0,0,1,0,0,1,
				1,0,1,0,1,0,1,1,
				1,1,0,0,1,1,0,1,
				1,1,1,0,1,1,1,1
		};
		int[] key = new int[]{
				0,0,0,1,0,0,1,1,
				0,0,1,1,0,1,0,0,
				0,1,0,1,0,1,1,1,
				0,1,1,1,1,0,0,1,
				1,0,0,1,1,0,1,1,
				1,0,1,1,1,1,0,0,
				1,1,0,1,1,1,1,1,
				1,1,1,1,0,0,0,1
		};
		
		System.out.println("明文为：");
		for (int i = 0; i < data1.length; i++) {
			System.out.print(data1[i]);
			if ((i+1) % 8 == 0) {
				System.out.print("    ");
			}
		}
		System.out.println("");
		
		int[] result = des.encrypt(data1, key);
		System.out.println("加密后的结果为：");
		for (int i = 0; i < result.length; i++) {
			System.out.print(result[i]);
			if ((i+1) % 8 == 0) {
				System.out.print("    ");
			}
		}
		System.out.println("");
		
		int[] M = des.decryption(result, key);
		
		System.out.println("解密后的结果为：");
		for (int i = 0; i < M.length; i++) {
			System.out.print(M[i]);
			if ((i+1) % 8 == 0) {
				System.out.print("    ");
			}
		}
		
		
	}

}
