package repository;

public interface SameRepoOperations<T> {

    T find(int id);

    void addRepoSomeoneInfo(T person);

    void removeRepoSomeoneInfo(T person);

    void getRepoSomeoneInfo(int id);

    void updateAdressInfo(T person, String adress);


}
