package it.epicode.dao;

import it.epicode.entity.Utente;
import jakarta.persistence.EntityManager;

import java.util.List;

public class UserDAO {

    private EntityManager em;

    public void insertUtente(Utente utente) {
        em.getTransaction().begin();
        em.persist(utente);
        em.getTransaction().commit();
    }

    public Utente utentePerId(Long id) {
        return em.find(Utente.class, id);
    }

    public void updateUtente(Utente utente) {
        em.getTransaction().begin();
        em.merge(utente);
        em.getTransaction().commit();
    }

    public void deleteUtente(Utente utente) {
        em.getTransaction().begin();
        em.remove(utente);
        em.getTransaction().commit();
    }

    public void insertAll(List<Utente> utenti) {
        em.getTransaction().begin();
        for (Utente e : utenti) {
            em.persist(e);
        }
        em.getTransaction().commit();
    }

    public List<Utente> trovaUtenti(){
        return this.em.createNamedQuery("trovaUtenti", Utente.class).getResultList();
    }
}
