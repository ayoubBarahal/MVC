package mod.sco;

import java.sql.SQLException;
import java.util.Vector;

public class Test {
    public static void main(String[] args) throws SQLException {

        Scolarite scolarite = new Scolarite();

        String num_Ins="1234" ;

        Vector<Note> notes =  scolarite.getNotes(num_Ins) ;

        System.out.println("---------------   lES INFORMATIONS SUR ETUDIANT -------------------------- ");

        for (Note note:notes){
            System.out.println("Id de l'étudiant : "+note.getNum_Ins());
            System.out.println("   Matiére       : "+note.getMatiere());
            System.out.println("   note          : "+note.getNote());
            System.out.println("-----------------------------------------------");
        }


    }
}
