package entity;

public class CursosEstudianteRelationship {

    private int id;
    private int estudianteID;
    private int profesoresID;

    public CursosEstudianteRelationship(int id, int estudianteID, int profesoresID) {
        this.id = id;
        this.estudianteID = estudianteID;
        this.profesoresID = profesoresID;
    }

    public CursosEstudianteRelationship() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEstudianteID() {
        return estudianteID;
    }

    public void setEstudianteID(int estudianteID) {
        this.estudianteID = estudianteID;
    }

    public int getProfesoresID() {
        return profesoresID;
    }

    public void setProfesoresID(int profesoresID) {
        this.profesoresID = profesoresID;
    }
}
