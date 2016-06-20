package moveexzamp;
import java.awt.*;
import java.awt.event.*;
public class MoveExample
{
 public static void main(String args[])
 {
  new Hua_Rong_Road();
 }
}
 class Person extends Button implements FocusListener{
 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
int number;
 Color c=new Color(255,245,170);
 public Person(final int number,final String s)
 {
  super(s);
  setBackground(c);
  this.number=number;
  c=getBackground();
  addFocusListener(this);
 }
 public void focusGained(final FocusEvent e)
 {
  setBackground(Color.red);
 }
 public void focusLost(final FocusEvent e)
 {
  setBackground(c);
 }
}
 class Hua_Rong_Road extends Frame implements  MouseListener,KeyListener,ActionListener
 {
  Person person[]=new Person[10];
  Button left,right,above,below;
  Button restart=new Button("ÖØÐÂ¿ªÊ¼");
  public Hua_Rong_Road()
  {
	init();
	setBounds(100,100,320,360);
	setVisible(true);
	validate();
	addWindowListener(new WindowAdapter()
	{public void windowClosing(WindowEvent e)
	{
	 System.out.println(0);
	}});
  }
  public void init()
  {
	setLayout(null);
	add(restart);
	restart.setBounds(100,320,120,25);
	restart.addActionListener(this);
	String name[]={"²Ü²Ù","¹ØÓð","ÕÅ·É","Áõ±¸","ÕÔÔÆ","»ÆÖÒ","±ø","±ø","±ø","±ø"};
	for(int k=0;k<name.length;k++)
	{
	 person[k]=new Person(k,name[k]);
	 person[k].addMouseListener(this);
	 person[k].addKeyListener(this);
	 add(person[k]);
	}
	person[0].setBounds(104,54,100,100);
	person[1].setBounds(104,154,100,50);
	person[2].setBounds(54,154,50,100);
	person[3].setBounds(204,154,50,100);
	person[4].setBounds(54,54,50,100);
	person[5].setBounds(204,54,50,100);
	person[6].setBounds(54,254,50,50);
	person[7].setBounds(204,254,50,50);
	person[8].setBounds(104,204,50,50);
	person[9].setBounds(154,204,50,50);
	person[9].requestFocus();
	left=new Button();right=new Button();
	above=new Button();below=new Button();
	add(left);add(right);add(above);add(below);
	left.setBounds(49,49,5,260);
	right.setBounds(254,49,5,260);
	above.setBounds(49,49,210,5);
	below.setBounds(49,304,210,5);
	validate();
  }
  public void keyTyped(KeyEvent e){}
  public void KeyReleased(KeyEvent e){}
  public void KeyPressed(KeyEvent e)
  {
	Person man=(Person)e.getSource();
	if(e.getKeyCode()==KeyEvent.VK_DOWN)
	{
	 go(man,below);
	}
	if(e.getKeyCode()==KeyEvent.VK_UP)
	{
	 go(man,above);
	}
	if(e.getKeyCode()==KeyEvent.VK_LEFT)
	{
	 go(man,left);
	}
	if(e.getKeyCode()==KeyEvent.VK_RIGHT)
	{
	 go(man,right);
	}
  }
  public void mousePressed(MouseEvent e)
  {
	Person man=(Person)e.getSource();
	int x=-1,y=-1;
	x=e.getX();
	y=e.getY();
	int w=man.getBounds().width;
	int h=man.getBounds().height;
	if(y>h/2)
	{
	 go(man,below);
	}
	if(y<h/2)
	{
	 go(man,above);
	}
	if(x<w/2)
	{
	 go(man,left);
	}
	if(x>w/2)
	{
	 go(man,right);
	}
  }
  public void mouseReleased(MouseEvent e){}
  public void mouseEntered(MouseEvent e){}
  public void mouseExited(MouseEvent e){}
  public void mouseClicked(MouseEvent e){}
  public void go(Person man,Button direction)
  {
	boolean move=true;
	Rectangle manRect=man.getBounds();
	int x=man.getBounds().x;
	int y=man.getBounds().y;
	if(direction==below)
	 y=y+50;
	else if(direction==above)
	 y=y-50;
	else if(direction==left)
	 x=x-50;
	else if(direction==right)
	 x=x+50;
	manRect.setLocation(x,y);
	Rectangle directionRect=direction.getBounds();
	for(int k=0;k<10;k++)
	{
	 Rectangle personRect=person[k].getBounds();
	 if((manRect.intersects(personRect))&&(man.number!=k))
	 {
	  move=false;
	 }
	}
	if(manRect.intersects(directionRect))
	{
	 move=false;
	}
	if(move==true)
	{
	 man.setLocation(x,y);
	}
  }
  public void actionPerformed(ActionEvent e)
  {
	dispose();
	new Hua_Rong_Road();
  }
  public void keyPressed(KeyEvent arg0) { 
  }
  public void keyReleased(KeyEvent arg0) {
	 
  }
 }