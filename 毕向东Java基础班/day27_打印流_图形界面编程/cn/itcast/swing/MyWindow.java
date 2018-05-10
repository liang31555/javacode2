package cn.itcast.swing;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;


/**
* This code was edited or generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a corporation,
* company or business for any purpose whatever) then you
* should purchase a license for each developer using Jigloo.
* Please visit www.cloudgarden.com for details.
* Use of Jigloo implies acceptance of these licensing terms.
* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED FOR
* THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED
* LEGALLY FOR ANY CORPORATE OR COMMERCIAL PURPOSE.
*/
public class MyWindow extends javax.swing.JFrame {
	private static final String LINE_SEPARATOR = System.getProperty("line.separator");
	private JButton jButton1;
	private JTextArea jTextArea1;
	private JScrollPane jScrollPane1;
	private JTextField jTextField1;

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				MyWindow inst = new MyWindow();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public MyWindow() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
			getContentPane().setLayout(null);
			{
				jButton1 = new JButton();
				getContentPane().add(jButton1);
				jButton1.setText("\u786e\u5b9a");
				jButton1.setBounds(466, 21, 128, 50);
				jButton1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jButton1ActionPerformed(evt);
					}
				});
			}
			{
				jTextField1 = new JTextField();
				getContentPane().add(jTextField1);
				jTextField1.setBounds(17, 21, 437, 50);
				jTextField1.addKeyListener(new KeyAdapter() {
					public void keyPressed(KeyEvent evt) {
						jTextField1KeyPressed(evt);
					}
				});
			}
			{
				jScrollPane1 = new JScrollPane();
				getContentPane().add(jScrollPane1);
				jScrollPane1.setBounds(17, 83, 577, 272);
				{
					jTextArea1 = new JTextArea();
					jScrollPane1.setViewportView(jTextArea1);
				}
			}
			pack();
			this.setSize(626, 401);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}
	
	private void jButton1ActionPerformed(ActionEvent evt) {
		
		
		showDir();
	}

	private void showDir() {
		//通过在文本框输入具体的目录，将目录中的当前文件或者文件夹的名称列出到文本区域中。
		/*
		 * 思路：
		 * 1，获取文本框中的路径。
		 * 2，将路径封装成File对象。list();
		 * 3，将list()列表中的内容展现在文本区域中。
		 */
		
		//1，获取路径。通过文本框对象完成。
		String str_dir = jTextField1.getText();
		
		//2,将字符串路径封装成File对象。
		File dir = new File(str_dir);
		//判断。
		if(dir.exists()&&dir.isDirectory()){
			
			
			//清空文本区域。
			jTextArea1.setText("");
			//3,获取文件名称列表。
			String[] names = dir.list();
			for(String name :names){
			//4，将名字显示到文本区域。
			jTextArea1.append(name+LINE_SEPARATOR);
			}
			
		}
	}
	
	private void jTextField1KeyPressed(KeyEvent evt) {
		
		if(evt.getKeyCode()==KeyEvent.VK_ENTER){
			showDir();
		}
		
	}

}




