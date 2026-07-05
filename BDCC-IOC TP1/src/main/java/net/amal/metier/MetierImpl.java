package net.amal.metier;

import net.amal.dao.IDao;
import net.amal.framework.annotations.Component;
import net.amal.framework.annotations.Inject;

@Component
public class MetierImpl implements IMetier {

    @Inject
    private IDao dao;

    public MetierImpl() {
    }

    @Override
    public double calcule() {
        double t = dao.getData();
        return t * 12 * Math.PI / 2 * Math.cos(t);
    }

    public void setDao(IDao dao) {
        this.dao = dao;
    }
}