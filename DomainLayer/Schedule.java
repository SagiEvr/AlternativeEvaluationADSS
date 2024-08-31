package DomainLayer;

import java.sql.Time;
import java.util.HashMap;
import java.util.LinkedList;

public class Schedule {
    private HashMap<String, LinkedList<String>> unavailableTimes; //Dictionary of <date, list of unavailable hours>
    public Schedule(){
        unavailableTimes = new HashMap<String, LinkedList<String>>();
    }
    public boolean isAvailable(String date, String time) {
        if(unavailableTimes.containsKey(date)){
            LinkedList<String> times = unavailableTimes.get(date);
            return times.contains(time);
        }
        return true;
    }

    public void addUnavailableTime(String date, String time){
        if(unavailableTimes.containsKey(date)){
            LinkedList<String> times = unavailableTimes.get(date);
            times.add(time);
        }else{
            LinkedList<String> times = new LinkedList<String>();
            times.add(time);
            unavailableTimes.put(date, times);
        }
    }

    public void availableTime(String date, String time){
        if(unavailableTimes.containsKey(date)){
            unavailableTimes.get(date).remove(time);
        }
    }
}
