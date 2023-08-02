package com.abc.Dao;

class InputNotInCorrectWay extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InputNotInCorrectWay(String s)
	{
		super(s);
	}
}
public class CheckingParameters 
{

	public boolean checkMobile(String m)
	{
		
		boolean f=true;
		try
		{
		    if (m.length() != 10) 
		    {
		    	f=false;
		    	throw new InputNotInCorrectWay("Moile Number Should of length 10 only");
		    } 
		    else 
		    {
		      if (!(m.charAt(0) == '9' || m.charAt(0) == '8' || m.charAt(0) == '7' || m.charAt(0) == '6')) 
		      {
		    	  f=false;
		    	  throw new InputNotInCorrectWay("Moile Number Should start with 9,8,7,6 only");
		      }
		    }
		}
	    catch(InputNotInCorrectWay e)
		{
	    	System.out.println(e);
		}
		return f;
	  }
	
	public boolean checkAadhar(String a)
	{
		boolean b=true;
		try
		{
			if(a.length()!=10)
			{
				b=false;
				throw new InputNotInCorrectWay("Aadhar Number should of length 10");
			}
			for(int i=0;i<a.length();i++)
			{
				if(!(Character.isDigit(a.charAt(i)) || a.charAt(i)>='a' && a.charAt(i)<='z' ||a.charAt(i)>='A' && a.charAt(i)<='Z') )
				{
					b=false;
					throw new InputNotInCorrectWay("Aadhar Number should not contain special characters");
				}
			}
		}
		catch(InputNotInCorrectWay e)
		{
			System.out.println(e);
		}
		return b;
	}
}
