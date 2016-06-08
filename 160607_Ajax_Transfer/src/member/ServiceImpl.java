package member;

import java.util.List;

public class ServiceImpl implements Service {
	private Dao dao;
	
	public ServiceImpl(){
		dao = new DaoImpl();
	}
	@Override
	public void addMember(Member m) {
		dao.insert(m);
	}

	@Override
	public Member getMember(int num) {
		return dao.select(num);
	}

	@Override
	public boolean login(int num, String name) {
		
		boolean flag = false;
		if(name != null && name.equals(dao.select(num).getName()) ){
			flag=true;
			return flag;
		}
		return flag;
	}

	@Override
	public void editInfo(Member m) {
		dao.update(m);
	}

	@Override
	public void delMember(int num) {
		dao.delete(num);
	}
	@Override
	public List<Member> getMemberAll() {
		return dao.selectALL();
	}

}
