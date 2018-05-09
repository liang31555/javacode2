package cn.itcast.reflect.test;

public class MouseByUSB implements USB {

	@Override
	public void open() {
		System.out.println("mouse open");
	}

	@Override
	public void close() {
		System.out.println("mouse close");

	}

}
