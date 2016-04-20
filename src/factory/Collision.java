package factory;



public class Collision implements BaoXian
{
   private String description;

   public String getBaoXianInfo()
   {
	   description = "Collision Coverage: \n\nPays for damage to your car, less"+
	                 "any deductible, no matter who is at"+
	                 "fault. If your car is financed, your"+
	                 "lender may require you to buy this coverage"+
	                 "and may even require a particular deductible amount.";
	   return description;
   }
}