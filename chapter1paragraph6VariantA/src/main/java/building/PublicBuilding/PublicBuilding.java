/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package building.PublicBuilding;

import building.IBuilding;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 * 
 * @author Acer
 */
public abstract class PublicBuilding implements IBuilding {
    
    private boolean _isBuilt;
    private LocalTime[] _timeOfOpening;         //opening on each day of a week
    private LocalTime[] _timeOfClosing;         //closing on each day of a week
    
    public PublicBuilding(){
        
        _isBuilt = false;
        _timeOfOpening = new LocalTime[7];
        _timeOfClosing = new LocalTime[7];
    }
    
    @Override
    public final String typeOfBuilding(){
        
        return "PublicBuilding";
    }
    
    @Override
    public boolean isBuilt(){
        
        return _isBuilt;
    }
    
    /**
     * if building opened now, returns true, else false
     * @return
     */
    public boolean isOpened(){
        
        var weekDay = LocalDate.now().getDayOfWeek().getValue();
        
        return (LocalTime.now().isAfter(_timeOfOpening[weekDay - 1])
                && LocalTime.now().isBefore(_timeOfClosing[weekDay - 1]));
    }
}
