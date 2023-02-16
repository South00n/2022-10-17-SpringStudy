package com.sist.myapp;

import java.util.*;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sist.dao.*;

import lombok.Setter;

public class MainClass {
	
	@Setter
	private SeoulDAO dao;
	
	public static void main(String[] args) {
		String[] table = {"","seoul_location","seoul_nature", "seoul_shop"};
		Scanner sc = new Scanner(System.in);
		System.out.print("���̺� ���� : ");
		int no = sc.nextInt();
		
		ApplicationContext app =
				new ClassPathXmlApplicationContext("app.xml");
		MainClass mc = (MainClass)app.getBean("mc"); // ���������� ������ ��ü�� �о ���(������ �Ϸ�� ����)
		// �̱��� �޸� 1�� ���, ��� Ŭ�������� ������ ����, �ٸ�Ŭ������ ������� ���� (������ => �������� Ŭ����)
		// ���ռ��� ���� ���α׷� (���������� ���ϰ�, �о��� ��쿡 ..), ������ ���� (����)
		// ��ü������ ��ü�� ���� ���� (10�� => 7�� => ĸ��ȭ, ������, ���/����)
		// �ν��Ͻ����� vs �������� => �ڹٿ��� �亯�� ���� ��� (100%)
		Map map = new HashMap();
		map.put("seoul_tbl", table[no]);
		List<SeoulVO> list = mc.dao.seoulListData(map);
		for(SeoulVO vo : list) {
			System.out.println(vo.getNo() + "." + vo.getTitle());
		}
		System.out.println("=============================");
		System.out.print("�󼼺� ��ȣ �Է� : ");
		int i = sc.nextInt();
		map.put("seoul_tbl", table[no]);
		map.put("no", i);
		SeoulVO vo = mc.dao.seoulDetailData(map);
		System.out.println("��ȣ : " + vo.getNo());
		System.out.println("���� : " + vo.getTitle());
		System.out.println("�ּ� : " + vo.getAddress());
		System.out.println("�� : " + vo.getMsg());
	}
}
