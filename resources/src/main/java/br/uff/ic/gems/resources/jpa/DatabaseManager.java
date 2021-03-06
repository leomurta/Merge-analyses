/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uff.ic.gems.resources.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author gleiph
 */
public class DatabaseManager {

    private static EntityManager instance = null;

    private static EntityManagerFactory factory;

    public DatabaseManager() {
    }

    public static EntityManager getManager() {
        if (instance == null) {
            factory = Persistence.createEntityManagerFactory("testPU");
//            EntityManagerFactory factory = Persistence.createEntityManagerFactory("Automatic");

//            EntityManagerFactory factory = Persistence.createEntityManagerFactory("krakenUpdated");
//            EntityManagerFactory factory = Persistence.createEntityManagerFactory("AnalysesTrue");
            instance = factory.createEntityManager();
        }

        return instance;
    }

    public static void closeManager() {
        instance.close();
        factory.close();
    }
}
