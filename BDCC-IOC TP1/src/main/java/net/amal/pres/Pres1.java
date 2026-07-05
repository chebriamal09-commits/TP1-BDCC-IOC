package net.amal.pres;

import net.amal.framework.context.XmlApplicationContext;
import net.amal.metier.IMetier;

public class Pres1 {

    public static void main(String[] args) {

        XmlApplicationContext context =
                new XmlApplicationContext("BDCC-IOC TP1/src/main/resources/beans.xml");

        IMetier metier = context.getBean(IMetier.class);

        System.out.println("Res = " + metier.calcule());
    }
}