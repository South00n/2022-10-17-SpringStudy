package com.sist.spring1;
/*
 *   MainClass�� HelloŬ������ �����Ѵ�
 */
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Hello hello = new Hello();
		// new�� ����ϸ� ���ռ��� ���� ���α׷�
		String msg = hello.sayHello("����");
		System.out.println(msg);
	}

}
