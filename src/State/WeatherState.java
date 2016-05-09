package State;
import java.util.Random;
import java.awt.Color;
import javax.swing.ImageIcon;

public abstract class WeatherState{
    protected final String SUNNY = "Sunny";
    protected final String RAINY = "Rainy";
    protected final String WINDY = "Windy";
    //*******************添加了这里
    protected final String SNOW ="Sonw";

    protected String state;
    
    //*******************添加了这里
    private final String[] MOOD ={SUNNY, RAINY, WINDY,SNOW};

    public void changeState() {
	   Random generator = new Random();
	   int n = MOOD.length;
	   int randomIndex = generator.nextInt( n );
	   state = MOOD[randomIndex];
    }
    public WeatherState createStateObj(){
	   WeatherState subState = null;
	   if( state.compareTo(SUNNY) == 0)
	      subState = new SunnyState();
	   else if( state.compareTo(RAINY) == 0)
	      subState = new RainyState();
	   else if(state.compareTo(WINDY) == 0)
	      subState = new WindyState();
	   //*******************添加了这里
	   else if(state.compareTo(SNOW)==0)
		   subState=new SnowingStat();
	   return subState;
    }
    public abstract String act();
    public abstract String getCurrentState();
    public abstract Color setColor();
    public abstract ImageIcon setImgIcon();
}
//问题 
//可以用什么模式替代状态模式

//中介者模式和适配器模式的区别

