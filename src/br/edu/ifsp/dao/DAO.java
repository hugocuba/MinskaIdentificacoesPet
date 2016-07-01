package br.edu.ifsp.dao;

import java.util.List;

import br.edu.ifsp.database.Database;
import br.edu.ifsp.database.MariaDatabase;
import br.edu.ifsp.model.IModel;
import br.edu.ifsp.model.Pessoa;

public abstract class DAO<E extends IModel> {

    protected Database database;

    public DAO() {
        this.database = new MariaDatabase("root", "root", "minska");
    }

    public abstract boolean insert(E objeto);

    public abstract int insertAutoId(E objeto);

    public abstract boolean update(E objeto);

    public abstract boolean delete(E objeto);

    public abstract List<E> listAll();

    public abstract E getById(int id);

    public List<Pessoa> listCliente() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<Pessoa> listVendedor() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
