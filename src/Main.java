import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        ArrayList<Bejegyzes> bejegyzesek= new ArrayList<>();
        bejegyzesek.add(new Bejegyzes("Tüdő R Ákos", "Holnap lesz a szülinapom!"));
        bejegyzesek.add(new Bejegyzes("Kis Miklós", "Leesik a vércukrom!"));


        int szam;
        Scanner scanner= new Scanner(System.in);
        do{
            System.out.println("Adj meg hány adatot akarsz adni a listához: ");
            while (!scanner.hasNextInt()){
                System.out.println("Nem egész számot adott meg!");
                scanner.next();
            }
            szam= scanner.nextInt();
        }while (szam<=-1);
        for (int i = 0; i < szam; i++) {
            System.out.println("Adj meg a szerzőt: ");
            String szerzo= scanner.next();
            System.out.println("Adj meg a bejegyzést: ");
            String tartalom= scanner.next();
            bejegyzesek.add(new Bejegyzes(szerzo, tartalom));

        }
        BufferedReader br = new BufferedReader(new FileReader("bejegyzesek.csv"));
            while (br.readLine() != null) {
                String[] sor = br.readLine().split(";");
                bejegyzesek.add(new Bejegyzes(sor[0], sor[1]));
            }
            br.close();
        Random random= new Random();
        for (int i = 0; i < bejegyzesek.size()*20; i++) {
            bejegyzesek.get(random.nextInt(bejegyzesek.size())).like();
        }
        System.out.println("Adj meg egy szöveget: ");
        String szoveg= scanner.next();
        bejegyzesek.get(1).setTartalom(szoveg);
        for (Bejegyzes b: bejegyzesek){
            System.out.println(b);
        }
        System.out.println("Legnépszerűbb bejegyzés: ");
        Bejegyzes leglike= bejegyzesek.get(0);
        for(Bejegyzes b: bejegyzesek){
            if(b.getLikeok()>leglike.getLikeok()){
                leglike= b;
            }
        }
        System.out.println(System.lineSeparator());
        System.out.println(leglike.getTartalom()+ System.lineSeparator()+ "Like szám: "+ leglike.getLikeok());
        if(leglike.getLikeok()>35){
            System.out.println("Van olyan bejegyzés ami 35-nél több likot kapott.");
        }
        else {
            System.out.println("Nincs olyan bejegyzés ami 35-nél több likot kapott.");
        }
        int darab= 0;
        for(Bejegyzes b: bejegyzesek){
            if(b.getLikeok()<15){
                darab++;
            }
        }
        System.out.println("15-nél kevesebb likot: " + darab+ " db bejegyzés kapott!");

        ArrayList<Integer> likok = new ArrayList<>();
        for(Bejegyzes b: bejegyzesek){
            likok.add(b.getLikeok());
        }
        System.out.println(System.lineSeparator());
        Collections.sort(likok, Collections.reverseOrder());
        FileWriter rendezet = new FileWriter("bejegyzesek_rendezett.txt");
        BufferedWriter bufferedWriter= new BufferedWriter(rendezet);
        for (int s: likok){
            for (Bejegyzes b : bejegyzesek){
                if(s==b.getLikeok()){
                    System.out.println(b);
                    bufferedWriter.write(b.toString());
                    bufferedWriter.newLine();
                }
            }
        }
        bufferedWriter.close();

    }
}
