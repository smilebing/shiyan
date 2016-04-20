package factory;



public class Comprehensive implements BaoXian
{
   private String description;

   public String getBaoXianInfo()
   {
	description = "Comprehensive Coverage: \n\nPays for damage to or loss of your"+
	              "car in the event of fire, theft or"+
	              "vandalism. Again, your lender may"+
	              "require this coverage if your car is financed.";
	return description;
   }
}