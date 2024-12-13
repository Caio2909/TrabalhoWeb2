package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Aluno;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dao.AlunoDAO;

@WebServlet("/salvarAluno")
public class SalvarAlunoServlet extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final String PERSISTENCE_UNIT_NAME = "Sigaa"; // Ajuste conforme necessário

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Obter o nome do formulário
        String nome = request.getParameter("nome");

        // Configurar EntityManager
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        EntityManager em = emf.createEntityManager();
        AlunoDAO alunoDAO = new AlunoDAO(em);

        try {
            // Criar e salvar o aluno
            Aluno aluno = new Aluno();
            aluno.setNome(nome);
            alunoDAO.salvar(aluno);

            // Responder com sucesso
            response.getWriter().println("Aluno salvo com sucesso!");
        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().println("Erro ao salvar o aluno.");
        } finally {
            em.close();
            emf.close();
        }
    }
}