package dao;

import model.*;

import javax.persistence.*;
import java.util.List;

class TurmaDAO {
    private EntityManager em;

    public TurmaDAO(EntityManager em) {
        this.em = em;
    }

    public void salvar(Turma turma) {
        em.getTransaction().begin();
        em.persist(turma);
        em.getTransaction().commit();
    }

    public Turma buscarPorId(int id) {
        return em.find(Turma.class, id);
    }

    public List<Turma> listarTodos() {
        return em.createQuery("FROM Turma", Turma.class).getResultList();
    }

    public void atualizar(Turma turma) {
        em.getTransaction().begin();
        em.merge(turma);
        em.getTransaction().commit();
    }

    public void deletar(int id) {
        Turma turma = buscarPorId(id);
        if (turma != null) {
            em.getTransaction().begin();
            em.remove(turma);
            em.getTransaction().commit();
        }
    }
}
