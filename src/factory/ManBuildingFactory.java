package factory;

public class ManBuildingFactory extends BuildingFactory {
	
	public BaoXian getBaoxian()
	{
		return new ManPersonInjur();
	}
	
	public JiJin  getJijin()
	{
		return new ManJiJin();
	}
}
