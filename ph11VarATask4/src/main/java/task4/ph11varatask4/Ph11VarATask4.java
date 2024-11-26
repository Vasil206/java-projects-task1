/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package task4.ph11varatask4;

import Client.Client;
import java.util.concurrent.Semaphore;

/**
 *
 * CallCenter. В организации работает несколько операторов. Оператор может 
 * обслуживать только одного клиента, остальные должны ждать своей очереди. 
 * Клиент может положить трубку и перезвонить еще раз через некоторое время.
* 
 * @author Acer
 */
public class Ph11VarATask4 {

    public static void main(String[] args) {
        
        Semaphore callCenter = new Semaphore(3, true);
        
        for(int i = 0; i < 10; i++){
            
            new Client(callCenter).start();
        }
    }
}
