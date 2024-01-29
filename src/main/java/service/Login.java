package service;

import domain.Student;

public interface Login<T> {

    T find(int id);

    void login();
}