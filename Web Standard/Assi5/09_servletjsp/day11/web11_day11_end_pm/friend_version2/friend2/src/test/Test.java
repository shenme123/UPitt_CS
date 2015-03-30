package test;

import dao.UserDAO;
import entity.User;

public class Test {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		UserDAO dao = new UserDAO();
		int id = dao.save(new User("zs","zs1223","test",22,"m","123"));
		System.out.println(id);
	}

}
