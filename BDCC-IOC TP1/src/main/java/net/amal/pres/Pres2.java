package net.amal.pres;

import net.amal.dao.IDao;
import net.amal.metier.IMetier;

import java.io.File;
import java.util.Scanner;


public class Pres2 {
    //FileNotFoundException, ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(new File("config.txt"));

        String daoClassName = scanner.nextLine();//lire la classe
        Class cDao = Class.forName(daoClassName);//charger la classe au mémoire
        IDao d = (IDao) cDao.newInstance();//instancier la classe

        String metierClassName = scanner.nextLine();
        Class cMetier = Class.forName(metierClassName);
        IMetier metier = (IMetier) cMetier.getConstructor(IDao.class).newInstance(d);

        System.out.println("RES="+metier.calcule());

    }
}
