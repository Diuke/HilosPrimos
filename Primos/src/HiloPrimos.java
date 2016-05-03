/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author juan-
 */
public class HiloPrimos implements Runnable{

    int inf;
    int sup;
    
    public HiloPrimos(int infInterval, int supInterval){
        inf = infInterval;
        sup = supInterval;
    }
    
    @Override
    public void run() {
        boolean primo;
        if(inf != sup){
            for(int i = inf+1; i<=sup; i++){
                primo = true;
                for(int j = 2; j<(i/2); j++){
                    if(i % j == 0){
                        primo = false;
                        break;
                    }
                }
                if(primo) new Const().incCont();
            }
        }
        
    }
    
}
