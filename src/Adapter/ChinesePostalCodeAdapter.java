package Adapter;

public class ChinesePostalCodeAdapter extends ChinesePostalCode implements ZipCodeValidator{

	 private ChinesePostalCode objCPostCode;

	  public ChinesePostalCodeAdapter(ChinesePostalCode pCode) {
	     objCPostCode = pCode;
	  }
	  public boolean isValidZipCode(String zip, String state) {
	      return isValidChinesePcode(zip, state);
	  }
}
