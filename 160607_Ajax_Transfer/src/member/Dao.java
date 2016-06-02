package member;

public interface Dao {
	void insert(Member m);
	Member select(int num);
	void update(Member m); //전화, 이메일만 수정
	void delete(int num); 
}
