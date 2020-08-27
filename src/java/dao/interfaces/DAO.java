package dao.interfaces;

import exceptions.DAOException;
import java.util.List;

public interface DAO<T> {
    
    T buscar(int id) throws DAOException;

    List<T> buscarTodos() throws DAOException;

    void inserir(T t) throws DAOException;

    void atualizar(T t) throws DAOException;

    void remover(T t) throws DAOException;
}
