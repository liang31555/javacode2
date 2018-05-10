package cn.itcast.swing;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
import javax.swing.filechooser.FileNameExtensionFilter;

import cn.itcast.util.separator.Separator;

/**
 * This code was edited or generated using CloudGarden's Jigloo SWT/Swing GUI
 * Builder, which is free for non-commercial use. If Jigloo is being used
 * commercially (ie, by a corporation, company or business for any purpose
 * whatever) then you should purchase a license for each developer using Jigloo.
 * Please visit www.cloudgarden.com for details. Use of Jigloo implies
 * acceptance of these licensing terms. A COMMERCIAL LICENSE HAS NOT BEEN
 * PURCHASED FOR THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED LEGALLY FOR
 * ANY CORPORATE OR COMMERCIAL PURPOSE.
 */
public class MyMenu extends javax.swing.JFrame {
//	private static final String LINE_SEPARATOR = System.getProperty("line.separator");
	private JMenuBar jMenuBar1;
	private JScrollPane jScrollPane1;
	private JTextArea jTextArea1;
	private JMenuItem jMenuItem2;
	private JMenuItem jMenuItem1;
	private JMenu jMenu1;

	/**
	 * Auto-generated main method to display this JFrame
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				MyMenu inst = new MyMenu();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}

	public MyMenu() {
		super();
		initGUI();
	}

	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
			{
				jScrollPane1 = new JScrollPane();
				getContentPane().add(jScrollPane1, BorderLayout.CENTER);
				{
					jTextArea1 = new JTextArea();
					jScrollPane1.setViewportView(jTextArea1);
				}
			}
			{
				jMenuBar1 = new JMenuBar();
				setJMenuBar(jMenuBar1);
				{
					jMenu1 = new JMenu();
					jMenuBar1.add(jMenu1);
					jMenu1.setText("\u6587\u4ef6");
					{
						jMenuItem1 = new JMenuItem();
						jMenu1.add(jMenuItem1);
						jMenuItem1.setText("\u6253\u5f00");
						jMenuItem1.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent evt) {
								jMenuItem1ActionPerformed(evt);
							}

						});
					}
					{
						jMenuItem2 = new JMenuItem();
						jMenu1.add(jMenuItem2);
						jMenuItem2.setText("\u9000\u51fa");
						jMenuItem2.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent evt) {
								jMenuItem2ActionPerformed(evt);
							}
						});
					}
				}
			}
			pack();
			this.setSize(627, 391);
		} catch (Exception e) {
			// add your error handling code here
			e.printStackTrace();
		}
	}

	private void jMenuItem2ActionPerformed(ActionEvent evt) {
		System.exit(0);
	}

	private void jMenuItem1ActionPerformed(ActionEvent evt) {

		// 创建一个文件选择器。
		JFileChooser chooser = new JFileChooser();
		
		//创建一个文件扩展名过滤器。
		FileNameExtensionFilter filter = new FileNameExtensionFilter(
				"Java & Txt", "java", "txt");
		//给文件选择器设置过滤器。
		chooser.setFileFilter(filter);
		
		//文件选择器调用显示选择文件对话框。并获取该对话框返回值。
		int returnVal = chooser.showOpenDialog(this);
		//判断返回值。
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			
			//清空文件区域。
			jTextArea1.setText("");
			//获取选择的目录。
			File file = chooser.getSelectedFile();
//			System.out.println(file.getAbsolutePath());
			
			//读取文件。
			try {
				BufferedReader bufr = new BufferedReader(new FileReader(file));
				
				String line = null;
				while((line=bufr.readLine())!=null){
					
					jTextArea1.append(line+Separator.LINE_SEPARATOR);
					
				}
				
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}

	}
}
