package factory;

public class WomenBuildingFactory  extends BuildingFactory{
	
	public  BaoXian getBaoxian()
	{
		return new WomenPersonInjur();
	}
	
	public JiJin getJijin()
	{
		return new WomenJinJin();
	}
}
