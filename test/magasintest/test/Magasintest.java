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
import magasinonline.Client;
import magasinonline.Produit;
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
        
        c1.setNom("Sneaker");        
        //on insert dans l'objet
        em.persist(c1);
        
        Categorie c2 = new Categorie();
        c1.setNom("Lunette de soleil");        
        //on insert dans l'objet
        em.persist(c2);
        
        Produit rayban = new Produit();
        rayban.setCategorie(c2);
        em.persist(rayban);
        
        //apres on commit 
        em.getTransaction().commit();

    }
    @Test
    public void ListeprodcategoritTest() {
        EntityManager em = Persistence.createEntityManagerFactory("MagasinOnlinePU").createEntityManager();
        
        Categorie caty = em.find(Categorie.class, 52L); //suffixer avec L la valeur 
        //System.out.println(caty.getProduits());
        for(Produit p: caty.getProduits()){
            System.out.println(p);
        }
        
    }
   
    @Test
    public void listeclientcommandtest() {
        EntityManager em = Persistence.createEntityManagerFactory("MagasinOnlinePU").createEntityManager();
    em.getTransaction().begin();
        Client c1 = new Client();
        
        c1.setId(1L);
        //on insert dans l'objet
        em.persist(c1);
         /*
        Categorie c2 = new Categorie();
        c1.setNom("Lunette de soleil");        
        //on insert dans l'objet
        em.persist(c2);
        
        Produit rayban = new Produit();
        rayban.setCategorie(c2);
        em.persist(rayban);
        
        //apres on commit 
        em.getTransaction().commit();
    
        Client cl =em.find(Client.class,1L);
        for(Commande c: cl.getCommande()) {
        System.out(println(c);
        }
    */ }

}
