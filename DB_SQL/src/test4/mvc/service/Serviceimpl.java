package test4.mvc.service;

import java.util.Scanner;
import java.util.Vector;

import test4.mvc.dao.Dao;
import test4.mvc.dao.OracleDao;
import test4.mvc.dto.Product;

public class Serviceimpl implements Service {
	Scanner sc = new Scanner(System.in);
	Dao dao = new OracleDao();
	
	@Override
	public void addProduct() {//insert
		System.out.println("��ǰ �̸���?");
		String name = sc.next();
		System.out.println("��ǰ ������?");
		int price = sc.nextInt();
		Product p = new Product(0,name,price);
		dao.insert(p);
		
	}

	@Override
	public void editProduct() {//update
		System.out.println("������ ��ǰ��ȣ : ");
		int num = sc.nextInt();
		Product p = dao.select(num);
		System.out.println(p);
		System.out.println("�� ��ǰ�̸� : ");
		String name = sc.next();
		System.out.println("�� ��ǰ���� : ");
		int price = sc.nextInt();
		p.setName(name);
		p.setPrice(price);
		dao.update(p.getNum(), p);
	}

	@Override
	public void delProduct() {//delete
		System.out.println("������ ��ǰ��ȣ : ");
		int num = sc.nextInt();
		dao.delete(num);
	}

	@Override
	public Product getProduct() {//select one
		System.out.println("�˻��� ��ȣ��?");
		int num = sc.nextInt();
		Product p = dao.select(num);
		return p;
	}

	@Override
	public Vector<Product> getProducts() {//select all
		Vector<Product> v = dao.selectAll();
		return v;
	}

}
