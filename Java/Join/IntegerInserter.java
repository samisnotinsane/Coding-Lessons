import java.util.*;

public class IntegerInserter implements Joiner<Integer, ArrayList<Integer>> 
{
	public ArrayList<Integer> join(Integer num, ArrayList<Integer> numList)
	{
		ArrayList<Integer> returnNumList = new ArrayList<>();

		returnNumList.addAll(numList); // copy all values

		for(int i=0; i<numList.size(); i++)
		{
			Integer element = numList.get(i);
			if(num < element) {
				returnNumList.add(i, num);
				break;
			}
		}
		return returnNumList;
	}

}