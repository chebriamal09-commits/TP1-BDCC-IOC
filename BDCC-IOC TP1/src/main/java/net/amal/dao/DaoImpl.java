package net.amal.dao;

import net.amal.framework.annotations.Component;

@Component
public class DaoImpl implements IDao {

    public DaoImpl() {
    }

    @Override
    public double getData() {
        System.out.println("Version base de données");
        return 34;
    }
}