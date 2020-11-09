package dto;

public class Division {

    private String uid;
    private int divivendo;
    private int divisor;

    public Division(String uid, int divivendo, int divisor) {
        this.uid = uid;
        this.divivendo = divivendo;
        this.divisor = divisor;
    }

    public Division(){

    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public int getDivivendo() {
        return divivendo;
    }

    public void setDivivendo(int divivendo) {
        this.divivendo = divivendo;
    }

    public int getDivisor() {
        return divisor;
    }

    public void setDivisor(int divisor) {
        this.divisor = divisor;
    }
}
