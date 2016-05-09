package State;


import java.awt.Color;
import javax.swing.ImageIcon;

public class Context{

   private WeatherState state;

   public Context(){
	  state = new SunnyState();
   }

   //This method is called by the client class to show the
   //current state in a String format
   public String getWeatherState() {
	  return state.getCurrentState();
   }
   //This method is called by the client class to show the
   //color in a String format
   public Color getColor() {
	  return state.setColor();
   }

   //This method is called by the client class to get the
   //image icon, which will be displayed on the screen
   public ImageIcon getImgIcon(){
	  return state.setImgIcon();
   }
   //No conditional statements here. Better for extention;
   //Add a new state will not need to change any code here.
   public String doAction(){
	  state.changeState();
	  state = state.createStateObj();
      String voice = state.act();
      return voice;
   }
}
