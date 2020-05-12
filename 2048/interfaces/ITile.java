package interfaces;

//best�mmer vilka metoder tile m�ste inneh�lla.

public interface ITile {

	public void randomSize();

	public void increase();


	public int getValue();

	public boolean getFuse();
	
	public void switchFuse();
	
	public int getIncreases();
	
	public void setup(int amount);
	
}
