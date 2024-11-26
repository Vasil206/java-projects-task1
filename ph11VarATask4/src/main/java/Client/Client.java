/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Client;

import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Acer
 */
public class Client extends Thread {

    private static int _NUMBER = 1;
    
    private final Semaphore _callCenter;
    
    public Client(Semaphore callCenter){
        
        super("Client " + _NUMBER);
        _NUMBER++;
        
        _callCenter = callCenter;
    }
    
    @Override
    public void run(){
        
        var rand = new Random();

        System.out.println(super.getName() + " is waiting...");

        try {    
            boolean isGetCalling = _callCenter.tryAcquire(rand.nextInt(5), TimeUnit.SECONDS);
            
            if (isGetCalling){
                
                System.out.println(super.getName() + " is speaking...");
            
                this.sleep(rand.nextInt(5000));
            }
            
            System.out.println(super.getName() + " called down.");
            
        } catch (InterruptedException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            _callCenter.release();
        }
    }
    
}
