package cn.itcast.reflect.test;

public class KeyByUSB implements USB {

	@Override
	public void open() {
		System.out.println("key open");

	}

	@Override
	public void close() {
		System.out.println("key close");

	}

}
