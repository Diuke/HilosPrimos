import java.util.ArrayList;
import java.util.Scanner;

public class Primos{
    
    
    public static void main(String[] args) {
        int xmin, xmax, d, hilos;
        Scanner s = new Scanner(System.in);
        d = s.nextInt();
        hilos = s.nextInt();
        xmin = (int) Math.pow(10, d - 1);
        xmax = (int) (Math.pow(10, d) - 1);
        if(d == 1){
            xmin = 2;
        }
        int intervalos = (xmax - xmin)/hilos;
        int lastIntervalo = intervalos + ((xmax - xmin)%hilos);
        ArrayList<Thread> ts = new ArrayList<>();
        
        for(int k = 0; k < hilos; k++){
            if(k < hilos-1){
                //ts.add(new Thread(new xmin*(intervalos*k), xmin*(intervalos*(k+1))));
                ts.add(new Thread(new HiloPrimos(xmin+(intervalos*k), xmin+(intervalos*(k+1)))));
                ts.get(k).start();
            }
            else{
                ts.add(new Thread(new HiloPrimos(xmax-lastIntervalo,xmax)));
                ts.get(k).start();
            }
        }
        boolean active = true;
        while(active){
            active = false;
            for(int l = 0; l<ts.size(); l++){
                if(ts.get(l).isAlive()){
                    active = true;
                }
            }
        }
        System.out.println(new Const().getCont());
        
        
    }

}
