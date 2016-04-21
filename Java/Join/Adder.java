import java.util.*;

public class Adder implements Joiner<Integer, Integer>
{
	public Integer join(Integer val1, Integer val2)
	{
		return val1 + val2 ;
	}
}