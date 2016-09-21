/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package magasintest.test;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import magasinonline.Categorie;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author admin
 */
public class Magasintest {

    @Test
    public void Magasintest() {
        EntityManager em = Persistence.createEntityManagerFactory("MagasinOnlinePU").createEntityManager();
        //ici on fait des modifications sur les data.      
        em.getTransaction().begin();
        Categorie c1 = new Categorie();
        c1.setNom("Chaussure à talons");
        
        //on insert dans l'objet
        em.persist(c1);
        //apres on commit 
        em.getTransaction().commit();

    }

}
