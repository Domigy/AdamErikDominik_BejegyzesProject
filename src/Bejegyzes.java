import java.time.LocalDateTime;

public class Bejegyzes {
    private String szerzo;
    private String tartalom;
    private int likeok;
    private LocalDateTime letrejott;
    private LocalDateTime szerkesztve;

    public Bejegyzes(String szerzo, String tartalom) {
        this.szerzo = szerzo;
        this.tartalom = tartalom;
        this.likeok=0;
        this.letrejott= LocalDateTime.now();
        this.szerkesztve = LocalDateTime.now();
    }

    public String getSzerzo() {
        return szerzo;
    }

    public String getTartalom() {
        return tartalom;
    }

    public void setTartalom(String tartalom) {
        this.tartalom = tartalom;
        this.szerkesztve= LocalDateTime.now();
    }

    public int getLikeok() {
        return likeok;
    }

    public LocalDateTime getLetrejott() {
        return letrejott;
    }

    public LocalDateTime getSzerkesztve() {
        return szerkesztve;
    }
    public void like(){
        this.likeok++;
    }

    @Override
    public String toString() {
        if(letrejott==szerkesztve) {

            return szerzo + " - " + likeok + " - " + letrejott + System.lineSeparator() +
                    tartalom;
        }
        else{
            return szerzo + " - " + likeok + " - " + letrejott + System.lineSeparator() +
                    "Szerkesztve: " + szerkesztve + System.lineSeparator() +
                    tartalom;
        }
    }
}
