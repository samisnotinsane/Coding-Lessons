import java.util.*;

class Camp implements Comparable<Camp>
{
	private String name;
	private int size;

	public Camp(String name, int size)
	{
		this.name = name;
		this.size = size;
	}

	public String getName()
	{
		return this.name;
	}

	public int getSize() 
	{
		return this.size;
	}

	@Override
	public String toString() {
		return "Camp '" + this.name + "' size: "+ this.size + ".";
	}

	@Override
	public int compareTo(Camp cmp) {
		return cmp.size - this.size;
	}
}