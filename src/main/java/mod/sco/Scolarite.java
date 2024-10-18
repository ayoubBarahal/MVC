package mod.sco;

import java.sql.*;
import java.util.Vector;

public class Scolarite {


    public Vector<Note> getNotes(String num_Ins) throws SQLException {
        Vector<Note> notes = new Vector<>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try{
            conn=DatabaseConn.getConnection() ;
            String sql="select * from notes where num_ins like ?";
            ps=conn.prepareStatement(sql);
            ps.setString(1, num_Ins);
            rs = ps.executeQuery();

            while(rs.next()){
                Note note = new Note();
                note.setId_note(rs.getInt("id_Note"));
                note.setNum_Ins(rs.getString("Num_Ins"));
                note.setMatiere(rs.getString("Matiere"));
                note.setNote(rs.getFloat("Note"));

                notes.add(note);
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
        return notes;

    }



}
