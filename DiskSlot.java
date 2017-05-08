
public class DiskSlot {
	int firstBlockIndex;
	int numberOfBlocks;
	DiskSlot(){
		firstBlockIndex = -1;
		numberOfBlocks = -1;
	}
	public int getFirstBlockIndex() {
		return firstBlockIndex;
	}
	public void setFirstBlockIndex(int firstBlockIndex) {
		this.firstBlockIndex = firstBlockIndex;
	}
	public int getNumberOfBlocks() {
		return numberOfBlocks;
	}
	public void setNumberOfBlocks(int numberOfBlocks) {
		this.numberOfBlocks = numberOfBlocks;
	}
	
}
