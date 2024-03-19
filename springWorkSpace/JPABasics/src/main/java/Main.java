import com.wileyedge.dao.EmployeeDao;
import com.wileyedge.dao.IDao;

public class Main {

	public static void main(String[] args) {
		IDao dao = new EmployeeDao();
		dao.createEmployee(10, "Shwati", "Kumari");
		dao.createEmployee(11, "Harsh", "Kankane");
		dao.createEmployee(12, "Shwati", "Kumari");
		dao.updateEmployee(10, "Kaju");
		dao.removeEmployee(10);
	}

}
