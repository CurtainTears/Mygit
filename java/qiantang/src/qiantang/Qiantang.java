package qiantang;
import java.awt.*;
import java.applet.*;
import java.awt.event.*;
class lump extends Button implements FocusListener  //ǳ���п���ࡣ
{  
    private static final long serialVersionUID = 1L;
    Rectangle rect=null;
    int left_x,left_y;//��Ť�����Ͻ�����.
    int width,height; //��Ť�Ŀ�͸�.
    String name; 
    int number;
    lump(int number,String s,int x,int y,int w,int h,Qiantang road){
    	super(s);
        name=s;
        this.number=number;
        left_x=x;
        left_y=y;
        width=w;
        height=h;
        setBackground(Color.orange);
        road.add(this);
        addKeyListener((road);
        setBounds(x,y,w,h);
        addFocusListener(this);
        rect=new Rectangle(x,y,w,h);
   }
    public void focusGained(FocusEvent e){  
    	setBackground(Color.red);
   }
    public void focusLost(FocusEvent e){   
    	setBackground(Color.orange);
   }

public void paint(Graphics g)
{  //�������ݵ��ı߽�:
   g.setColor(Color.cyan);
   g.fillRect(50,50,5,610);//left.
   g.fillRect(655,50,5,610);//right.
   g.fillRect(50,50,610,5); //above.
   g.fillRect(50,655,610,5);//below.
   //��ʾ����λ�úͰ�������:
   g.drawString("�����Ӧľ��,Ȼ�󰴼����ϵ��������Ҽ�ͷ�ƶ�",100,20);
   g.setColor(Color.red);
   g.drawString("����",660,155);
}
public void keyPressed(KeyEvent e)
{  lump man=(lump)e.getSource();//��ȡ�¼�Դ.
    man.rect.setLocation(man.getBounds().x, man.getBounds().y);
    if(e.getKeyCode()==KeyEvent.VK_DOWN)
      {  man.left_y=man.left_y+50;     //����ǰ��50����λ��
         man.setLocation(man.left_x,man.left_y);
         man.rect.setLocation(man.left_x,man.left_y);
           //�ж��Ƿ������������±߽�����ص�,��������ص����˻�50����λ���롣
         for(int i=0;i<10;i++)
             {if((man.rect.intersects(lump[i].rect))&&(man.number!=i))
                 {  man.left_y=man.left_y-50;
                    man.setLocation(man.left_x,man.left_y);
                    man.rect.setLocation(man.left_x,man.left_y);
                 }
              }
          if(man.rect.intersects(below))
              {  man.left_y=man.left_y-50;
                 man.setLocation(man.left_x,man.left_y);
                 man.rect.setLocation(man.left_x,man.left_y);
              }
      }
    if(e.getKeyCode()==KeyEvent.VK_UP)
     {  man.left_y=man.left_y-50;     //����ǰ��50����λ��
        man.setLocation(man.left_x,man.left_y);
        man.rect.setLocation(man.left_x,man.left_y);
        //�ж��Ƿ������������ϱ߽�����ص�,��������ص����˻�50����λ���롣
        for(int i=0;i<10;i++)
            {  if((man.rect.intersects(lump[i].rect))&&(man.number!=i))
                   {  man.left_y=man.left_y+50;
                      man.setLocation(man.left_x,man.left_y);
                       man.rect.setLocation(man.left_x,man.left_y);
                    }
            }
         if(man.rect.intersects(above))
            {  man.left_y=man.left_y+50;
               man.setLocation(man.left_x,man.left_y);
               man.rect.setLocation(man.left_x,man.left_y);
            }
     }
   if(e.getKeyCode()==KeyEvent.VK_LEFT)
     {  man.left_x=man.left_x-50;     //����ǰ��50����λ��
        man.setLocation(man.left_x,man.left_y);
        man.rect.setLocation(man.left_x,man.left_y);
        //�ж��Ƿ�������������߽�����ص�,��������ص����˻�50����λ���롣
       for(int i=0;i<10;i++)
            {  if((man.rect.intersects(lump[i].rect))&&(man.number!=i))
                 { man.left_x=man.left_x+50;
                   man.setLocation(man.left_x,man.left_y);
                   man.rect.setLocation(man.left_x,man.left_y);
                  }
            }
       if(man.rect.intersects(left))
           {  man.left_x=man.left_x+50;
              man.setLocation(man.left_x,man.left_y);
              man.rect.setLocation(man.left_x,man.left_y);
            }
     }
   if(e.getKeyCode()==KeyEvent.VK_RIGHT)
    {  man.left_x=man.left_x+50;     //����ǰ��50����λ��
       man.setLocation(man.left_x,man.left_y);
       man.rect.setLocation(man.left_x,man.left_y);
      //�ж��Ƿ������������ұ߽�����ص�,��������ص����˻�50����λ���롣
       for(int i=0;i<10;i++)
           {  if((man.rect.intersects(lump[i].rect))&&(man.number!=i))
                 { man.left_x=man.left_x-50;
                   man.setLocation(man.left_x,man.left_y);
                   man.rect.setLocation(man.left_x,man.left_y);
                  }
            }
        if(man.rect.intersects(right))
            {  man.left_x=man.left_x-50;
               man.setLocation(man.left_x,man.left_y);
               man.rect.setLocation(man.left_x,man.left_y);
             }
      }
}

public class Qiantang {

}
