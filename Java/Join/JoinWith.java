import java.util.*;

public class JoinWith implements Joiner<String, String>
{
	String joinStr; 

	public JoinWith(String str)
	{
		joinStr = str;
	}

	public String join(String str1, String str2)
	{
		return str1 + this.joinStr + str2 ;
	}
}