package ui.util;

import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import ui.Img;

public class MyButton extends JButton{
	public MyButton(int x,int y){
		super();
		setMargin(new Insets(0, 0, 0, 0));
		setContentAreaFilled(false);
		setBorderPainted(false);
		setIcon(Img.getButton0());
		setRolloverIcon(Img.getButton_over());
		setBounds(x, y, Img.getButton0().getIconWidth(), Img.getButton0().getIconHeight());
	}
	public MyButton(int x,int y,ButtonType type){
		super();
		setMargin(new Insets(0, 0, 0, 0));
		setContentAreaFilled(false);
		setBorderPainted(false);
		switch(type){
		case BIG:
			setIcon(Img.getButtonBig());
			setBounds(x, y, Img.getButtonBig().getIconWidth(), Img.getButtonBig().getIconHeight());
			setRolloverIcon(Img.getButtonBig_p());
			break;
		case SEARCH:
			setIcon(Img.getBtn_search());
			setBounds(x, y, Img.getBtn_search().getIconWidth(), Img.getBtn_search().getIconHeight());
			setRolloverIcon(Img.getButton_over());
			break;
		case EXIT:
			setIcon(Img.getExit_btn());
			setRolloverIcon(Img.getExit_btn_pressed());
			setBounds(x, y, Img.getExit_btn().getIconWidth(), Img.getExit_btn().getIconHeight());
	        break;
		case LOGIN:
			setIcon(Img.getBtn_login());
			setRolloverIcon(Img.getButton_over());
			setBounds(x, y, Img.getBtn_login().getIconWidth(), Img.getBtn_login().getIconHeight());
			break;

		}
	}
	
	public static void main(String[] args) {
		JFrame frame=new JFrame();
		JPanel panel=new JPanel();
		MyButton btn=new MyButton(10,10);
		btn.setBounds(0,0,20,20);
		panel.add(btn);
		frame.setContentPane(panel);
		frame.setVisible(true);
		frame.setSize(600, 800);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}
}
