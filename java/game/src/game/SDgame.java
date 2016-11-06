package game;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.border.*;
public class SDgame extends JFrame implements ActionListener, KeyListener {
	private static final long serialVersionUID = 1L;
	Container con;
	JPanel control;
	JMenu menuFile = new JMenu("游戏");
	JMenuItem newGame = new JMenuItem("新建游戏");
	JMenuItem exitGame = new JMenuItem("退出游戏");
	Border black = BorderFactory.createLineBorder(Color.RED);
	Border raisedBevel = BorderFactory.createRaisedBevelBorder();
	Border border = BorderFactory.createCompoundBorder(raisedBevel, black);
	Font font = new Font("", Font.BOLD, 35);
	static JButton[][] buttonNum = new JButton[9][9];
	int forcusX = 0, forcusY = 0;
	static int[][] itemTotal = new int[9][9];
	static long starttime = -1; 
	static long overtime = -1;
	static int easyLevel = 0; 
	public  SDgame() {
		this.setTitle("数独小游戏");
		this.setLocation(200, 0);
		this.setSize(900, 900);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		menuFile.add(newGame);
		newGame.addActionListener(this);
		menuFile.add(exitGame);
		exitGame.addActionListener(this);
		JMenuBar menuBar = new JMenuBar();
		menuBar.add(menuFile);
		this.setJMenuBar(menuBar);
		con = this.getContentPane();
		control = new JPanel();
		control.setLayout(new GridLayout(3, 3));
		JPanel[] panelNum = new JPanel[9];
		// ////////////////////////////////////////////
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				buttonNum[i][j] = new JButton("");
				buttonNum[i][j].setFont(font);
				buttonNum[i][j].addActionListener(this);
				buttonNum[i][j].addKeyListener(this);
			}
		}
		//////////////////////////////////////////////	
		for (int i = 0; i < 9; i++) {
			panelNum[i] = new JPanel();
			panelNum[i].setLayout(new GridLayout(3, 3));
			panelNum[i].add(buttonNum[(i / 3) * 3][(i % 3) * 3]);
			panelNum[i].add(buttonNum[(i / 3) * 3][(i % 3) * 3 + 1]);
			panelNum[i].add(buttonNum[(i / 3) * 3][(i % 3) * 3 + 2]);
			panelNum[i].add(buttonNum[(i / 3) * 3 + 1][(i % 3) * 3]);
			panelNum[i].add(buttonNum[(i / 3) * 3 + 1][(i % 3) * 3 + 1]);
			panelNum[i].add(buttonNum[(i / 3) * 3 + 1][(i % 3) * 3 + 2]);
			panelNum[i].add(buttonNum[(i / 3) * 3 + 2][(i % 3) * 3]);
			panelNum[i].add(buttonNum[(i / 3) * 3 + 2][(i % 3) * 3 + 1]);
			panelNum[i].add(buttonNum[(i / 3) * 3 + 2][(i % 3) * 3 + 2]);
			panelNum[i].setBorder(border);
			control.add(panelNum[i]);
		}
		con.add(new JScrollPane(control));
		this.setVisible(true);
	}
	public void keyPressed(KeyEvent e) {
		if (starttime < 0) {// 按键监听事件
			return;
		}
		int keycode = e.getKeyCode();
		int num = -1;
		switch (keycode) {
		case KeyEvent.VK_DELETE:
			num = 0;
			break;
		case KeyEvent.VK_1:
			num = 1;
			break;
		case KeyEvent.VK_2:
			num = 2;
			break;
		case KeyEvent.VK_3:
			num = 3;
			break;
		case KeyEvent.VK_4:
			num = 4;
			break;
		case KeyEvent.VK_5:
			num = 5;
			break;
		case KeyEvent.VK_6:
			num = 6;
			break;
		case KeyEvent.VK_7:
			num = 7;
			break;
		case KeyEvent.VK_8:
			num = 8;
			break;
		case KeyEvent.VK_9:
			num = 9;
			break;
		case KeyEvent.VK_NUMPAD1:
			num = 1;
			break;
		case KeyEvent.VK_NUMPAD2:
			num = 2;
			break;
		case KeyEvent.VK_NUMPAD3:
			num = 3;
			break;
		case KeyEvent.VK_NUMPAD4:
			num = 4;
			break;
		case KeyEvent.VK_NUMPAD5:
			num = 5;
			break;
		case KeyEvent.VK_NUMPAD6:
			num = 6;
			break;
		case KeyEvent.VK_NUMPAD7:
			num = 7;
			break;
		case KeyEvent.VK_NUMPAD8:
			num = 8;
			break;
		case KeyEvent.VK_NUMPAD9:
			num = 9;
			break;		
		}
		if (num >= 0) {
			itemTotal[forcusX][forcusY] = num;
			showNumOnButtons(itemTotal);
			if(Judge.judge(itemTotal))
				Win.showWinGame();
		} 
	}
	public void actionPerformed(ActionEvent ae) {//鼠标事件监听
 	     if (ae.getSource() == newGame) {
			try {
				String s = JOptionPane.showInputDialog(this, "请输入难度系数(0-81):");
				if (s == null)
					return;
				int snum = Integer.parseInt(s);
				if (snum >= 0 && snum <= 81) {
					easyLevel = snum;
				}else {
					JOptionPane.showMessageDialog(this, "难度系数范围不正确，请重新输入！");
					return;
				}
			} catch (NumberFormatException nfe) {
				JOptionPane.showMessageDialog(this, "输入格式不正确，请重新输入！");
				return;
			}
			itemTotal = level.getNewItems(easyLevel);
			starttime = System.currentTimeMillis();
			showNumOnButtons(itemTotal);
		}
		else if (ae.getSource() == exitGame) {
			System.exit(0);
		}
		else {
			if (starttime < 0) {//如果开始时间小于0，返回  游戏未开始
				return;
				}
			JButton button = (JButton) ae.getSource();
			int I = 0, J = 0;
			boolean ifFind = false;
			for (I = 0; I < 9; I++) {// 寻找按钮坐标
				for (J = 0; J < 9; J++) {
					if (button == buttonNum[I][J]) {
						ifFind = true;
						break;
					}
				}
				if (ifFind)
					break;
			}
			forcusX = I;
			forcusY = J;
			
		}
	}
	public static void showNumOnButtons(int[][] item) {//把数字显示到按钮上的函数 并且如果数字为0 显示为空
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (item[i][j] == 0)
					buttonNum[i][j].setText("  ");
				else
					buttonNum[i][j].setText("" + item[i][j]);
			}
		}
	}
    public static void main(String[] args) {
		new SDgame();
	}
	public void keyTyped(KeyEvent e) {}
	public void keyReleased(KeyEvent e) {}
}

class Judge{//判断类
	public static boolean judge(int[][] item) {// 判断是否所有的数字都已经正确填满
		for (int i = 0; i < 9; i++) {
			if (!Judge.judgeLine(item[i]))
				return false;
		}
		for (int j = 0; j < 9; j++) {
			int[] temp = new int[9];
			for (int i = 0; i < 9; i++) {
				temp[i] = item[i][j];
			}
			if (!Judge.judgeLine(temp))
				return false;
		}
		int[][] newitem = Judge.transformOfItems(item);
		for (int i = 0; i < 9; i++) {
			if (!Judge.judgeLine(newitem[i]))
				return false;
		}
		return true;
	}

	public static boolean judgeLine(int[] item) {// 判断是否每行都正确填满
		int[] temp = new int[9];
		for (int i = 0; i < 9; i++) {
			temp[i] = item[i];
		}
		Arrays.sort(temp);
		for (int i = 0; i < 9; i++) {
			if (temp[i] != i + 1)
				return false;
		}
		return true;
	}

	public static int[][] transformOfItems(int[][] oriItem) {// 转换矩阵形式
		int[][] result = new int[9][9];
		for (int i = 0; i < 9; i++) {
			int index = 0;
			int n = (i / 3) * 3, m = (i % 3) * 3;
			for (int j = n; j < n + 3; j++) {
				for (int k = m; k < m + 3; k++) {
					result[j][k] = oriItem[i][index++];
				}
			}
		}
		return result;
	}
}

class level{
	public static int[][] getNewItems(int l) {// 得到根据难易程度随机遮盖的数组
		int[][] result = getCompleteItems();
		for (int i = 0; i < l; i++) {
			int r = (int) (Math.random() * 81);
			if (r == 81)
				r -= 1;
			int indexi = r / 9;
			int indexj = r % 9;
			result[indexi][indexj] = 0;
		}
		return result;
	}

	  static int[][] getCompleteItems() {//得到初始数组
		int[][] temp = { { 7, 1, 6, 3, 5, 8, 4, 2, 9 },{ 8, 4, 9, 2, 6, 7, 3, 1, 5 }, { 3, 5, 2, 4, 1, 9, 6, 8, 7 },
				         { 5, 6, 7, 9, 4, 1, 8, 3, 2 }, { 4, 8, 1, 5, 3, 2, 7, 9, 6 },{ 9, 2, 3, 8, 7, 6, 5, 4, 1 },
				         { 2, 9, 4, 6, 8, 5, 1, 7, 3 },{ 1, 3, 5, 7, 2, 4, 9, 6, 8 }, { 6, 7, 8, 1, 9, 3, 2, 5, 4 } };
		int[][] result = new int[9][9];
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				result[i][j] = temp[i][j];
			}
		}
		return result;
	}
}
class Win{
	public static void showWinGame() {//过关显示
		if (SDgame.starttime > 0) {
			String message = new String("恭喜你，已过关！");
			SDgame.overtime = System.currentTimeMillis();
			message += "\n本关难度系数：";
			Integer cureasyLevel = SDgame.easyLevel;
			message += cureasyLevel.toString();
			message += "\n过关共用时间：";
			Integer usetime = (int) (SDgame.overtime - SDgame.starttime);
			usetime /= 1000;
			String time;
			if (usetime <= 60) {
				time = usetime.toString();
				time += " 秒";
			} else if (usetime <= 3600) {
				Integer minute = usetime / 60;
				Integer second = usetime % 60;
				time = minute.toString() + " 分 " + second.toString() + " 秒";
			} else {
				Integer hour = usetime / 3600;
				Integer minute = usetime / 60;
				Integer second = usetime % 60;
				time = hour.toString() + " 小时 " + minute.toString() + " 分 "
						+ second.toString() + " 秒";
			}
			message += time;
			JOptionPane.showMessageDialog(null, message);
			for (int i = 0; i < 9; i++) {//把所有的数字替换为0 
				for (int j = 0; j < 9; j++) {
					SDgame.itemTotal[i][j] = 0;
				}
			}
			SDgame.showNumOnButtons(SDgame.itemTotal);
			SDgame.starttime = -1;
		}
	}

	
}
