package test4.mvc.controller;

import java.util.Scanner;
import java.util.Vector;

import test4.mvc.dto.Product;
import test4.mvc.service.Service;
import test4.mvc.service.Serviceimpl;

public class ProductMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean isStop = false;
		Service service = new Serviceimpl();
		while (!isStop) {
			System.out.println("1.��ǰ��� 2.��ǰ�˻� 3.��ü�˻� 4.���� 5.���� 6.����");
			int number = sc.nextInt();

			switch (number) {
			case 1:
				service.addProduct();
				break;
			case 2:
				Product p = service.getProduct();
				System.out.println(p);
				break;
			case 3:
				Vector<Product> v = service.getProducts();
				for (int i = 0; i < v.size(); i++) {
					System.out.println(v.get(i));
				}
				break;
			case 4:
				service.editProduct();
				break;
			case 5:
				service.delProduct();
				break;
			case 6:
				isStop = true;
				break;
			default:
				System.out.println("�߸��� Ű�Է��Դϴ�.");
				break;
			}
		}
		sc.close();
	}

}
