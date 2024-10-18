<%@ page import="form.beans.NoteForm" %>
<%@ page import="mod.sco.Scolarite" %>
<%@ page import="java.util.Vector" %>
<%@ page import="mod.sco.Note" %><%--
  Created by IntelliJ IDEA.
  User: hp
  Date: 14/10/2024
  Time: 15:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<html>
<head>
    <title>Notes</title>
    <style>
        table {

            border-collapse: collapse;
            margin: 20px 0;
        }
        th, td {
            border: 1px solid #000;
            padding: 10px;
            text-align: left;
            width: 70px;
        }
        th {
            background-color: #f2f2f2;
        }
    </style>
</head>
<body>

    <form action="recherche.php" method="post">
        <label>Num Inscription :</label>
        <input type="text" name="num_Ins" >
        <input type="submit" value="OK">
    </form>
    <%
        // Récupérer l'objet NoteForm stocké dans la session
        NoteForm nf = (NoteForm) session.getAttribute("nf");

        if (nf != null) {
            // Récupérer la liste des notes de l'étudiant
            Vector<Note> notes = nf.getNotes();
            if (notes != null && !notes.isEmpty()) {
                double total = 0;
                int noteCount = notes.size();

                // Calculer la moyenne
                for (Note note : notes) {
                    total += note.getNote();
                }
                double moyenne = noteCount > 0 ? total / noteCount : 0;

                // Afficher le tableau des notes
    %>
    <table style="border: 2px;width: 150px">
            <tr>
                <th>Matière</th>
                <th>Note</th>
            </tr>

            <%
                if (noteCount > 0) {
                    for (Note note : notes) {
            %>
            <tr>
                <td><%= note.getMatiere() %></td>
                <td><%= note.getNote() %></td>
            </tr>
            <%
                }
            } else {
            %>
            <tr>
                <td colspan="2"> </td>
            </tr>
            <% } %>

            <tr>
                <td><strong>Moyenne</strong></td>
                <td><%= String.format("%.2f", moyenne) %></td>
            </tr>
        </table>

            <%
        } }
        %>

</body>
</html>
