package rep;

import java.util.List;

public class ServiceImple implements Service {

	private Dao dao;
	
	public ServiceImple(){
		dao = new DaoImple();
	}
	
	@Override
	public int addRep(Reply r) {
		return dao.insert(r);
	}

	@Override
	public Reply getRep(int num) {
		return dao.select(num);
	}

	@Override
	public List getAll() {
		return dao.selectAll();
	}

	@Override
	public int editRep(Reply r) {
		return dao.update(r);
	}

	@Override
	public int delRep(int num) {
		// TODO Auto-generated method stub
		return dao.delete(num);
	}

}
