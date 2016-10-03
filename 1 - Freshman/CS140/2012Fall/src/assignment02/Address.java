package assignment02;

//@author Gabriel Ochoa

public class Address
{

	private String title, street1, street2, aptNum, city, state, zip, country;
	
	public Address(String title, String street1, String street2, String aptNum, String city, String state, String zip, String country)
	{
		this.title = title;
		this.street1 = street1;
		this.street2 = street2;
		this.aptNum = aptNum;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.country = country;
	}
	
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

	}

	public String getTitle()
	{
		return title;
	}

	public String getStreet1()
	{
		return street1;
	}

	public String getStreet2()
	{
		return street2;
	}
	public String getAptNum()
	{
		return aptNum;
	}

	public String getCity()
	{
		return city;
	}

	public String getState()
	{
		return state;
	}

	public String getZip()
	{
		return zip;
	}

	public String getCountry()
	{
		return country;
	}

}