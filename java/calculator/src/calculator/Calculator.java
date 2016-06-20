package calculator;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JTextField;

public class Calculator extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField tf;
	private JPanel panel1, panel2, panel3, panel4;
	private JMenuBar myBar;
	private JMenu menu1, menu2, menu3;
	private JMenuItem editItem1, editItem2, help1, help2;
	private JRadioButtonMenuItem seeItem1, seeItem2;//单选框
	private JCheckBoxMenuItem seeItem3;//复选框
	private boolean IfResult = true, flag = false;
	private String oper = "=";
	private double result = 0;
	private Num numActionListener;
	private DecimalFormat df;

	public Calculator(){
		super("科学计算器");//设置标题栏

		df = new DecimalFormat("#.####");//保留四位小数

		this.setLayout(new BorderLayout(10, 5));
		panel1 = new JPanel(new GridLayout(1, 3, 10, 10));
		panel2 = new JPanel(new GridLayout(5, 6, 5, 5));//5行6列
		panel3 = new JPanel(new GridLayout(5, 1, 5, 5));
		panel4 = new JPanel(new BorderLayout(5, 5));

		/**
		 * 菜单栏
		 */
		myBar = new JMenuBar();
		menu1 = new JMenu("编辑(E)");
		menu2 = new JMenu("查看(V)");
		menu3 = new JMenu("帮助(H)");

		menu1.setFont(new Font("宋体", Font.PLAIN, 12));
		menu2.setFont(new Font("宋体", Font.PLAIN, 12));
		menu3.setFont(new Font("宋体", Font.PLAIN, 12));

		/**
		 * 编辑栏
		 */
		editItem1 = new JMenuItem("复制(C) Ctrl+C");
		editItem2 = new JMenuItem("粘贴(P) Ctrl+V");

		editItem1.setFont(new Font("宋体",Font.PLAIN,12));
		editItem2.setFont(new Font("宋体",Font.PLAIN,12));

		/**
		 * 查看栏
		 */
		seeItem1 = new JRadioButtonMenuItem("科学型(T)");
		seeItem2 = new JRadioButtonMenuItem("标准型(S)");
		seeItem3 = new JCheckBoxMenuItem("数字分组(I)");
		seeItem1.setFont(new Font("宋体",Font.PLAIN,12));
		seeItem2.setFont(new Font("宋体",Font.PLAIN,12));
		seeItem3.setFont(new Font("宋体",Font.PLAIN,12));

		/**
		 * 帮助栏
		 */
		help1 = new JMenuItem("帮助主题(H)");
		help2 = new JMenuItem("关于计算器(A)");

		help1.setFont(new Font("宋体",Font.PLAIN,12));
		help2.setFont(new Font("宋体",Font.PLAIN,12));
		new ButtonGroup();
		menu1.add(editItem1);
		menu1.add(editItem2);
        menu2.add(seeItem1);
		menu2.add(seeItem2);
		menu2.addSeparator();//添加一条分割线
		menu2.add(seeItem3);

		menu3.add(help1);
		menu3.addSeparator();//添加一条分割线
		menu3.add(help2);

		myBar.add(menu1);
		myBar.add(menu2);
		myBar.add(menu3);

		this.setJMenuBar(myBar);

		numActionListener = new Num();//实现数字监听

		/**
		 * 文本域，即为计算器的屏幕显示区域
		 */
		tf = new JTextField();
		tf.setEditable(false);//文本区域不可编辑
		tf.setBackground(Color.white);//文本区域的背景色
		tf.setHorizontalAlignment(JTextField.RIGHT);//文字右对齐
		tf.setText("0");
		tf.setBorder(BorderFactory.createLoweredBevelBorder());
		init();//对计算器进行初始化

	}
	/**
	 * 初始化操作
	 * 添加按钮
	 */
	private void init(){
		addButton(panel1, "Backspace", new Clear(), Color.red);
		addButton(panel1, "CE", new Clear(), Color.red);
		addButton(panel1, "C", new Clear(), Color.red);
		addButton(panel2, "1/x", new Signs(), Color.magenta);
		addButton(panel2, "log", new Signs(), Color.magenta);
		addButton(panel2, "7", numActionListener, Color.blue);
		addButton(panel2, "8", numActionListener, Color.blue);
		addButton(panel2, "9", numActionListener, Color.blue);
		addButton(panel2, "÷", new Signs(), Color.red);
		addButton(panel2, "n!", new Signs(), Color.magenta);
		addButton(panel2, "sqrt", new Signs(), Color.magenta);
		addButton(panel2, "4", numActionListener, Color.blue);
		addButton(panel2, "5", numActionListener, Color.blue);
		addButton(panel2, "6", numActionListener, Color.blue);
		addButton(panel2, "×", new Signs(), Color.red);
		addButton(panel2, "sin", new Signs(), Color.magenta);
		addButton(panel2, "x^2", new Signs(), Color.magenta);
		addButton(panel2, "1", numActionListener, Color.blue);
		addButton(panel2, "2", numActionListener, Color.blue);
		addButton(panel2, "3", numActionListener, Color.blue);
		addButton(panel2, "-", new Signs(), Color.red);
		addButton(panel2, "cos", new Signs(), Color.magenta);
		addButton(panel2, "x^3", new Signs(), Color.magenta);
		addButton(panel2, "0", numActionListener, Color.blue);
		addButton(panel2, "-/+", new Clear(), Color.blue);
		addButton(panel2, ".", new Dot(), Color.blue);
		addButton(panel2, "+", new Signs(), Color.red);
		addButton(panel2, "tan", new Signs(), Color.magenta);
		addButton(panel2, "%", new Signs(), Color.magenta);
		addButton(panel2, "π", numActionListener, Color.orange);
		addButton(panel2, "e", numActionListener, Color.orange);
		addButton(panel2, "′″", new Signs(), Color.orange);
		addButton(panel2, "=", new Signs(), Color.red);


		JButton btns = new JButton("计算器");
		btns.setBorder(BorderFactory.createLoweredBevelBorder());
		btns.setEnabled(false);//按钮不可操作
		btns.setPreferredSize(new Dimension(20, 20));

		panel3.add(btns);//加入按钮
		addButton(panel3, "MC", null, Color.red);
		addButton(panel3, "MR", null, Color.red);
		addButton(panel3, "MS", null, Color.red);
		addButton(panel3, "M+", null, Color.red);

		panel4.add(panel1, BorderLayout.NORTH);
		panel4.add(panel2, BorderLayout.CENTER);
		this.add(tf, BorderLayout.NORTH);
		this.add(panel3, BorderLayout.WEST);
		this.add(panel4);

		pack();
		this.setResizable(false);//窗口不可改变大小
		this.setLocation(300, 200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	/**
	 * 统一设置按钮的的使用方式
	 * @param panel
	 * @param name
	 * @param action
	 * @param color
	 */
	private void addButton(JPanel panel, String name, ActionListener action, Color color){
		JButton bt = new JButton(name);
		panel.add(bt);//在面板上增加按钮
		bt.setForeground(color);//设置前景（字体）颜色
		bt.addActionListener(action);//增加监听事件
	}
	/**
	 * 计算器的基础操作（+ - × ÷）
	 * @param x
	 */
	private void getResult (double x){
		if(oper == "+"){result += x;}
		else if(oper == "-"){result -= x;}
		else if(oper == "×"){result *= x;}
		else if(oper == "÷"){result /= x;}
		else if(oper == "="){result = x;}
		tf.setText(df.format(result));
	}
	/**
	 * 运算符号的事件监听
	 */
	class Signs implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			/*
			 * 用ActionEvent对象的getActionCommand()方法
			 * 取得与引发事件对象相关的字符串
			 */
			String str = e.getActionCommand();

			/* sqrt求平方根 */
			if(str.equals("sqrt")){
				double i = Double.parseDouble(tf.getText());
				if(i>=0){
					/*
					 * String.valueOf() 转换为字符串
					 * df.format() 按要求保留四位小数
					 * Math.sqrt() 求算数平方根
					 */
					tf.setText(String.valueOf(df.format(Math.sqrt(i))));
				}
				else{
					tf.setText("负数不能开平方根");
				}
			}

			/* log求常用对数 */
			else if(str.equals("log")){
				double i = Double.parseDouble(tf.getText());
				if(i>0){
					tf.setText(String.valueOf(df.format(Math.log(i))));
				}else{
					tf.setText("负数不能求对数");
				}
			}

			/* %求百分比 */
			else if(str.equals("%")){
				tf.setText(df.format(Double.parseDouble(tf.getText()) / 100));
			}

			/* 1/x求倒数 */
			else if(str.equals("1/x")){
				if(Double.parseDouble(tf.getText()) == 0){
					tf.setText("除数不能为零");
				}else{
					tf.setText(df.format(1 / Double.parseDouble(tf.getText())));
				}
			}

			/* sin求正弦函数 */
			else if(str.equals("sin")){
				double i = Double.parseDouble(tf.getText());
				tf.setText(String.valueOf(df.format(Math.sin(i))));
			}

			/* cos求余弦函数 */
			else if(str.equals("cos")){
				double i = Double.parseDouble(tf.getText());
				tf.setText(String.valueOf(df.format(Math.cos(i))));
			}

			/* tan求正切函数 */
			else if(str.equals("tan")){
				double i = Double.parseDouble(tf.getText());
				tf.setText(String.valueOf(df.format(Math.tan(i))));
			}

			/* n!求阶乘 */
			else if(str.equals("n!")){
				double i = Double.parseDouble(tf.getText());
				if((i%2==0)||(i%2==1))//判断为整数放进行阶乘操作
				{
					int j = (int)i;//强制类型转换
					int result=1;
					for(int k=1;k<=j;k++)
						result *= k;
					tf.setText(String.valueOf(result));
				}
				else
				{
					tf.setText("无法进行阶乘");
				}
			}

			/* x^2求平方 */
			else if(str.equals("x^2")){
				double i = Double.parseDouble(tf.getText());
				tf.setText(String.valueOf(df.format(i*i)));
			}

			/* x^3求立方 */
			else if(str.equals("x^3")){
				double i = Double.parseDouble(tf.getText());
				tf.setText(String.valueOf(df.format(i*i*i)));
			}

			/* ′″角度转换 */
			/**
			 * 将角度值转换成弧度值，方便三角函数的计算
			 */
			else if(str.equals("′″")){
				double i = Double.parseDouble(tf.getText());
				tf.setText(String.valueOf(i/180*Math.PI));
			}
			
			else{
				if(flag){
					IfResult = false;
				}
				if(IfResult){
					oper = str;
				}else{ 
					getResult(Double.parseDouble(tf.getText()));
					oper = str;
					IfResult = true;
				}
			}
		}
	}
	/**
	 * 清除按钮的事件监听
	 */
	class Clear implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			/*
			 * 用ActionEvent对象的getActionCommand()方法
			 * 取得与引发事件对象相关的字符串
			 */
			String str = e.getActionCommand();
			if(str == "C"){
				tf.setText("0");
				IfResult = true;
				result = 0;
			}else if(str == "-/+"){
				double i = 0 - Double.parseDouble(tf.getText().trim());
				tf.setText(df.format(i));
			}else if(str == "Backspace"){
				if(Double.parseDouble(tf.getText()) > 0){
					if(tf.getText().length() > 1){
						tf.setText(tf.getText().substring(0, tf.getText().length() - 1));
						//使用退格删除最后一位字符
					}else{
						tf.setText("0");
						IfResult = true;
					}
				}else{
					if(tf.getText().length() > 2){
						tf.setText(tf.getText().substring(0, tf.getText().length() - 1));
					}else{
						tf.setText("0");
						IfResult = true;
					}
				}
			}else if(str == "CE"){
				tf.setText("0");
				IfResult = true;
			}
		}
	}
	/**
	 * 数字输入的事件监听
	 */
	class Num implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			String str = e.getActionCommand();
			if(IfResult){
				tf.setText("");
				IfResult = false;
			}
			if(str=="π")
			{
				tf.setText(String.valueOf(Math.PI));
			}
			else if(str=="e")
			{
				tf.setText(String.valueOf(Math.E));
			}
			else{
				tf.setText(tf.getText().trim() + str);
				if(tf.getText().equals("0")){
					tf.setText("0");
					IfResult = true;
					flag = true;
				}
			}
		}
	}
	/**
	 * 小数点的事件监听
	 */
	class Dot implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			IfResult = false;
			if(tf.getText().trim().indexOf(".") == -1){
				tf.setText(tf.getText() + ".");
			}
		}
	}
	/**
	 * main方法
	 */
	public static void main(String[] args) {
		new Calculator().setVisible(true);
	}
}  

