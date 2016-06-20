package qiantang;
import java.awt.*;
import java.applet.*;
import java.awt.event.*;
class lump extends Button implements FocusListener  //浅塘中块的类。
{  
    private static final long serialVersionUID = 1L;
    Rectangle rect=null;
    int left_x,left_y;//按扭的左上角坐标.
    int width,height; //按扭的宽和高.
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
{  //画出华容道的边界:
   g.setColor(Color.cyan);
   g.fillRect(50,50,5,610);//left.
   g.fillRect(655,50,5,610);//right.
   g.fillRect(50,50,610,5); //above.
   g.fillRect(50,655,610,5);//below.
   //提示出口位置和按键规则:
   g.drawString("点击相应木块,然后按键盘上的上下左右箭头移动",100,20);
   g.setColor(Color.red);
   g.drawString("出口",660,155);
}
public void keyPressed(KeyEvent e)
{  lump man=(lump)e.getSource();//获取事件源.
    man.rect.setLocation(man.getBounds().x, man.getBounds().y);
    if(e.getKeyCode()==KeyEvent.VK_DOWN)
      {  man.left_y=man.left_y+50;     //向下前进50个单位。
         man.setLocation(man.left_x,man.left_y);
         man.rect.setLocation(man.left_x,man.left_y);
           //判断是否和其它人物或下边界出现重叠,如果出现重叠就退回50个单位距离。
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
     {  man.left_y=man.left_y-50;     //向上前进50个单位。
        man.setLocation(man.left_x,man.left_y);
        man.rect.setLocation(man.left_x,man.left_y);
        //判断是否和其它人物或上边界出现重叠,如果出现重叠就退回50个单位距离。
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
     {  man.left_x=man.left_x-50;     //向左前进50个单位。
        man.setLocation(man.left_x,man.left_y);
        man.rect.setLocation(man.left_x,man.left_y);
        //判断是否和其它人物或左边界出现重叠,如果出现重叠就退回50个单位距离。
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
    {  man.left_x=man.left_x+50;     //向右前进50个单位。
       man.setLocation(man.left_x,man.left_y);
       man.rect.setLocation(man.left_x,man.left_y);
      //判断是否和其它人物或右边界出现重叠,如果出现重叠就退回50个单位距离。
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
