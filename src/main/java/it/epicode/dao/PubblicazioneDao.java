package it.epicode.dao;

import it.epicode.entity.Pubblicazione;
import jakarta.persistence.EntityManager;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class PubblicazioneDao {

    private EntityManager em;

    public void insertPubblicazione(Pubblicazione pubblicazione) {
        em.getTransaction().begin();
        em.persist(pubblicazione);
        em.getTransaction().commit();
    }

    public Pubblicazione pubblicazionePerId(Long id) {
        return em.find(Pubblicazione.class, id);
    }

    public void updatePubblicazione(Pubblicazione pubblicazione) {
        em.getTransaction().begin();
        em.merge(pubblicazione);
        em.getTransaction().commit();
    }

    public void deletePubblicazione(Pubblicazione pubblicazione) {
        em.getTransaction().begin();
        em.remove(pubblicazione);
        em.getTransaction().commit();
    }

    public void insertAll(List<Pubblicazione> pubblicazioni) {
        em.getTransaction().begin();
        for (Pubblicazione e : pubblicazioni) {
            em.persist(e);
        }
        em.getTransaction().commit();
    }

    public List<Pubblicazione> trovaPrestiti(){
        return this.em.createNamedQuery("trovaPrestiti", Pubblicazione.class).getResultList();
    }
}