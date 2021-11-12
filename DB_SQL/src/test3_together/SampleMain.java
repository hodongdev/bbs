package test3_together;

import java.util.ArrayList;

public class SampleMain {

	public static void main(String[] args) {

		SampleDAO dao = new SampleDAO();

		ArrayList<SampleDTO> books = dao.findAll();

//		for Ãâ·Â
		for (SampleDTO s : books) {
			System.out.println("id: " + s.getId());
			System.out.println("name : " + s.getName());
			System.out.println("price : " + s.getPrice());
			System.out.println();

		}

	}

}
