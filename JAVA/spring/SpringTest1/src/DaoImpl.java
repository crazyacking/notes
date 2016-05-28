import java.util.Calendar;

/**
 * Created by crazyacking on 16-5-10.
 */
public class DaoImpl implements IDao {
    public String sayHello(String name){
        int hour= Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
        if(hour>=7 && hour<12) return "Good Morning, "+name;
        else if(hour>=12 && hour<5) return "Good Afternoon, "+name;
        else return "Good Evening, "+name;
    }
}
