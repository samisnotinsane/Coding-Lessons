public class JoinDecorator<E extends Joiner>
{
	private E obj;

	public JoinDecorator(E obj) 
	{
		this.obj = obj;
	}

	public void join() 
	{
		obj.join();
	}
}