package mod;

import form.beans.NoteForm;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import mod.sco.DatabaseConn;
import mod.sco.Scolarite;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

public class ControleurServlet extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("Note", new NoteForm());
        req.getRequestDispatcher("Note.jsp").forward(req,resp);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

            Scolarite sco=new Scolarite();
            NoteForm nf=new NoteForm();

            nf.setNum_Ins(request.getParameter("num_Ins"));

            try {
                nf.setNotes(sco.getNotes(nf.getNum_Ins()));
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

            HttpSession session=request.getSession();
            session.setAttribute("nf",nf);

            response.sendRedirect("Note.jsp");
    }


}
