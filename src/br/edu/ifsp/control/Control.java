package br.edu.ifsp.control;

import java.util.List;

import br.edu.ifsp.dao.DAO;
import br.edu.ifsp.model.IModel;

public abstract class Control<E extends IModel> {

    protected DAO<E> dao;

    public Control(DAO<E> dao) {
        this.dao = dao;
    }

    public abstract List<E> listAll();
}
