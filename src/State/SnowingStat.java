package State;

import java.awt.Color;

import javax.swing.ImageIcon;

public class SnowingStat extends WeatherState {

	public SnowingStat() {
		state = SNOW;
	}

	public String getCurrentState() {
		return state;
	}

	public String act() {
		String voice = "snowing...";
		return voice;
	}

	public Color setColor() {
		return Color.black;
	}

	public ImageIcon setImgIcon() {
		ImageIcon windyIcon = new ImageIcon("images/Windy.jpg");
		return windyIcon;
	}
}
