package factory;



public class PersonInjur implements BaoXian{
   private String description;

   public String getBaoXianInfo(){
	  description = "Personal Injury Protection \n\nPays medical expenses and some percentage"+
	                "of lost wages to you or anyone authorized"+
	                "to drive your car, no matter who caused the accident.";
	  return description;
   }
}
