package form.beans;

import mod.sco.Note;

import java.io.Serializable;
import java.util.Vector;

public class NoteForm implements Serializable {

    private String num_Ins ;
    private Vector<Note> Notes = new Vector<>();

    public Vector<Note> getNotes() {
        return Notes;
    }

    public void setNotes(Vector<Note> lesNotes) {
        this.Notes = lesNotes;
    }

    public String getNum_Ins() {
        return num_Ins;
    }

    public void setNum_Ins(String num_Ins) {
        this.num_Ins = num_Ins;
    }


}
