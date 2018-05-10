package cn.itcast.reflect.test;

public class NoteBook {

	/**
	 * 运行
	 */
	public void run(){
		System.out.println("notebook run");
	}
	
	/**
	 * 使用usb的设备。
	 */
	public void useUSB(USB usb){//多态
		if(usb!=null){
			usb.open();
			usb.close();
		}
	}
}
