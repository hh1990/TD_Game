package Utils;

public enum EnumWorldSize {
	SMALL(25,25),
	MEDIUM(50, 50),
	BIG(100, 100);

	public int xSize, ySize;
	EnumWorldSize(int xSize, int ySize){
		this.xSize = xSize;
		this.ySize = ySize;
	}
}
