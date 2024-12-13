package dao;

import model.*;

import javax.persistence.*;
import java.util.List;

class MatriculaDAO {
    private EntityManager em;

    public MatriculaDAO(EntityManager em) {
        this.em = em;
    }

    public void salvar(Matricula matricula) {
        em.getTransaction().begin();
        em.persist(matricula);
        em.getTransaction().commit();
    }

    public Matricula buscarPorId(int id) {
        return em.find(Matricula.class, id);
    }

    public List<Matricula> listarTodos() {
        return em.createQuery("FROM Matricula", Matricula.class).getResultList();
    }

    public void atualizar(Matricula matricula) {
        em.getTransaction().begin();
        em.merge(matricula);
        em.getTransaction().commit();
    }

    public void deletar(int id) {
        Matricula matricula = buscarPorId(id);
        if (matricula != null) {
            em.getTransaction().begin();
            em.remove(matricula);
            em.getTransaction().commit();
        }
    }
}
