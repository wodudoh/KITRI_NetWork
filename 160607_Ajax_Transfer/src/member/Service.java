package member;

import java.util.List;

public interface Service {
	void addMember(Member m);
	Member getMember(int num);
	List<Member> getMemberAll();
	boolean login(int num, String name);
	void editInfo(Member m);
	void delMember(int num);
}
