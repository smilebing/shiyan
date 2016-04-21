package factory;

public abstract class BuildingFactory {
	
	public static BuildingFactory getBuildingFactory(String type)
	{
		BuildingFactory bFactory=null;
		if(type.equals("man class"))
		{
			bFactory=new ManBuildingFactory();
		}
		else if(type.equals("women class")) 
		{
			bFactory=new WomenBuildingFactory();
		}
		return bFactory;
	}
	
	
	public abstract BaoXian getBaoxian();
	public abstract JiJin getJijin();
	
}
