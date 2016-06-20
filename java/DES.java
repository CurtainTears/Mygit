package des;
import java.security.SecureRandom;
import java.util.Scanner;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
public class Des {
    public static String encryptBasedDes(String data,String password) {  
        String encryptedData = null;  
        try {   
            SecureRandom sr = new SecureRandom();  
            DESKeySpec deskey = new DESKeySpec(password.getBytes());  
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");  
            SecretKey key = keyFactory.generateSecret(deskey);  
            Cipher cipher = Cipher.getInstance("DES");  
            cipher.init(Cipher.ENCRYPT_MODE, key, sr);  
            encryptedData = new sun.misc.BASE64Encoder().encode(cipher.doFinal(data.getBytes()));  
        } 
        catch (Throwable e) {    
            e.printStackTrace();  
        }  
        return encryptedData;  
    } 
    public static String decryptBasedDes(String cryptData,String password) throws Exception {  
            String decryptedData = null;   
            SecureRandom sr = new SecureRandom();  
            DESKeySpec deskey = new DESKeySpec(password.getBytes());   
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");  
            SecretKey key = keyFactory.generateSecret(deskey);  
            Cipher cipher = Cipher.getInstance("DES");  
            cipher.init(Cipher.DECRYPT_MODE, key, sr);  
            decryptedData = new String(cipher.doFinal(new sun.misc.BASE64Decoder().decodeBuffer(cryptData)));     
            return decryptedData;  
    }  
    public static void main(String[] args) throws Exception {    
        int x;
        for(int a=0;a>=0;a++){
        System.out.println("请选择：1.加密  2.解密");
        Scanner reader1 =new Scanner(System.in);
        x=reader1.nextInt();
        if(x==1){
        	System.out.println("请输入密码");
        	Scanner pass =new Scanner(System.in);
        	String pw=pass.nextLine();
        	int i=pw.length();
        	if(i<8){
        		for(int t=0;t<8-i;t++){
        			pw="0"+pw;
        		}
        	}
        	else if(i>8){
        		pw=pw.substring(0, 8);
        	}
        	System.out.println("请输入需要加密的数据：");
        	Scanner reader =new Scanner(System.in);
        	String str=reader.nextLine();
    	    String s1=encryptBasedDes(str,pw);    
            System.out.println("密文："+s1); 
            String s2=decryptBasedDes(s1,pw);        
            System.out.println("明文："+s2);
        }
        else if(x==2){
        	System.out.println("请输入密码");
        	Scanner pass =new Scanner(System.in);
        	String pw=pass.nextLine();
        	int i=pw.length();
        	if(i<8){
        		for(int t=0;t<8-i;t++){
        			pw="0"+pw;
        		}
        	}
        	else if(i>8){
        		pw=pw.substring(0, 8);
        	}
        	System.out.println("请输入需要解密的数据：");
        	Scanner reader =new Scanner(System.in);
        	String str=reader.nextLine();
        	String s2=decryptBasedDes(str,pw);        
            System.out.println("明文："+s2); 
        }
        else{
        	System.out.println("输入错误，请重新输入1或者2.");
        }
    }  
  }	 
}