package cn.itcast.reflect.test;

public class NoteBook {

	/**
	 * ����
	 */
	public void run(){
		System.out.println("notebook run");
	}
	
	/**
	 * ʹ��usb���豸��
	 */
	public void useUSB(USB usb){//��̬
		if(usb!=null){
			usb.open();
			usb.close();
		}
	}
}
