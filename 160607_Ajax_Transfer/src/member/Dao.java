package member;

public interface Dao {
	void insert(Member m);
	Member select(int num);
	void update(Member m); //��ȭ, �̸��ϸ� ����
	void delete(int num); 
}
