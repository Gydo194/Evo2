/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author gydokosten
 */
import Evo2.*;
//import java.util.concurrent.Callable;

public class e2test {
    
    
  
    //public static final Evo2 i = new Evo2(3001);
    public static void main(String[] args) {
        
        Evo2 i = new Evo2(3001);
        HttpResponse resp = new HttpResponse("/i","hallo",200);
        i.addResponse(resp);
        
        Thread sthread = new Thread(i);
        sthread.start();
        
       
        HttpResponse resp2 = new HttpResponse("/o","hallo2",200);
        i.addResponse(resp2);
        
       // i.addResponse(call);
       //CallBack cb = new CallBack("/");
       ExecuteOnRequest exec = new ExecuteOnRequest("/exec", "<h1>Executing...</h1>",200,"/usr/bin/say '%r'");
       i.addResponse(exec);
       
        
        
        
    }
    
 
    
}

