package net.amal.ext;

import net.amal.dao.IDao;
import org.springframework.stereotype.Repository;

@Repository("d2")
public class DaoImplV2 implements IDao {

    @Override
    public double getData() {
        System.out.println("vertion capteur ...");
        double t = 12;
        return t;
    }
}
