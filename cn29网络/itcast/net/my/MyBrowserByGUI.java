package cn.itcast.net.my;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.URL;
import java.net.URLConnection;
import java.net.UnknownHostException;

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
public class MyBrowserByGUI extends javax.swing.JFrame {
	private JTextField jTextField1;
	private JButton jButton1;
	private JTextArea jTextArea1;
	private JScrollPane jScrollPane1;

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				MyBrowserByGUI inst = new MyBrowserByGUI();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public MyBrowserByGUI() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
			getContentPane().setLayout(null);
			{
				jTextField1 = new JTextField();
				getContentPane().add(jTextField1);
				jTextField1.setBounds(12, 18, 522, 44);
			}
			{
				jButton1 = new JButton();
				getContentPane().add(jButton1);
				jButton1.setText("\u8f6c\u5230");
				jButton1.setBounds(546, 18, 84, 44);
				jButton1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jButton1ActionPerformed(evt);
					}
				});
			}
			{
				jScrollPane1 = new JScrollPane();
				getContentPane().add(jScrollPane1);
				jScrollPane1.setBounds(12, 68, 617, 358);
				{
					jTextArea1 = new JTextArea();
					jScrollPane1.setViewportView(jTextArea1);
				}
			}
			pack();
			this.setSize(649, 479);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}
	
	private void jButton1ActionPerformed(ActionEvent evt) {
		
		try {
			accessServer();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	/**
	 * @throws UnknownHostException
	 * @throws IOException
	 */
	private void accessServer() throws UnknownHostException, IOException {
		
		String str_url = jTextField1.getText();
		URL url = new URL(str_url);
		
		URLConnection conn = url.openConnection();
		
		InputStream in = conn.getInputStream();
		byte[] buf = new byte[1024];
		int len = in.read(buf);
		String text = new String(buf,0,len);
		jTextArea1.setText(text);
		
		
		
//		String host = url.getHost();
//		int port = url.getPort();
//		String path = url.getPath();
//		Socket s = new Socket(host,port);
//		//把IE的信息发送给服务端。
//		PrintWriter out = new PrintWriter(s.getOutputStream(),true);
//		out.println("GET "+path+" HTTP/1.1");
//		out.println("Accept: */*");
//		out.println("Host: 192.168.1.223:8080");
//		out.println("Connection: close");
//		out.println();//空行。
//		
//		//读取服务端的数据。
//		InputStream in = s.getInputStream();
//		byte[] buf = new byte[1024];
//		int len = in.read(buf);
//		String text = new String(buf,0,len);
//		jTextArea1.setText(text);
//		
//		s.close();
	}

}
