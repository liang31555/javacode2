package cn.itcast.net.uploadpic;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
import javax.swing.filechooser.FileNameExtensionFilter;

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
public class UploadPicByGUI extends javax.swing.JFrame {
	private JTextField jTextField1;
	private JButton jButton1;
	private JButton jButton2;
	private JTextArea jTextArea1;
	private File srcFile;

	/**
	 * Auto-generated main method to display this JFrame
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				UploadPicByGUI inst = new UploadPicByGUI();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}

	public UploadPicByGUI() {
		super();
		initGUI();
	}

	private void initGUI() {
		try {
			getContentPane().setLayout(null);
			setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
			{
				jTextField1 = new JTextField();
				getContentPane().add(jTextField1);
				jTextField1.setBounds(19, 27, 424, 47);
			}
			{
				jButton1 = new JButton();
				getContentPane().add(jButton1);
				jButton1.setText("\u6d4f\u89c8...");
				jButton1.setBounds(460, 27, 91, 47);
				jButton1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jButton1ActionPerformed(evt);
					}
				});
			}
			{
				jTextArea1 = new JTextArea();
				getContentPane().add(jTextArea1);
				jTextArea1.setBounds(19, 95, 424, 130);
			}
			{
				jButton2 = new JButton();
				getContentPane().add(jButton2);
				jButton2.setText("\u4e0a\u4f20");
				jButton2.setBounds(460, 100, 91, 125);
				jButton2.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jButton2ActionPerformed(evt);
					}
				});
			}
			pack();
			this.setSize(570, 296);
		} catch (Exception e) {
			// add your error handling code here
			e.printStackTrace();
		}
	}

	private void jButton1ActionPerformed(ActionEvent evt) {

		JFileChooser chooser = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter(
				"JPG & Images", "jpg");
		chooser.setFileFilter(filter);
		int returnVal = chooser.showOpenDialog(this);
		if (returnVal == JFileChooser.APPROVE_OPTION) {

			srcFile = chooser.getSelectedFile();
			
			jTextField1.setText(srcFile.getAbsolutePath());
			
		}

	}

	private void uploadPic(File srcFile) throws IOException {
		Socket s = new Socket("192.168.1.223", 10007);

		// 2,读取源图片。
		FileInputStream fis = new FileInputStream(srcFile);

		// 3,目的是socket 输出流。
		OutputStream out = s.getOutputStream();

		byte[] buf = new byte[1024];

		int len = 0;
		while ((len = fis.read(buf)) != -1) {
			out.write(buf, 0, len);
		}

		// 告诉服务器端图片数据发送完毕，不要等着读了。
		s.shutdownOutput();

		// 读取上传成功字样。
		InputStream in = s.getInputStream();
		byte[] bufIn = new byte[1024];
		int lenIn = in.read(bufIn);
		jTextArea1.setText(new String(bufIn, 0, lenIn));

		// 关闭。
		fis.close();
		s.close();

	}
	
	private void jButton2ActionPerformed(ActionEvent evt) {
		if(srcFile==null){
			jTextArea1.setText("请选择一个扩展名为jpg的图片");
			return;
		}
		
		if(srcFile.length()>1024*1024*3){
			jTextArea1.setText("文件体积过大，不行！");
			return;
		}
		

		try {
			uploadPic(srcFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
