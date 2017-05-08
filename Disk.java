import java.util.ArrayList;
import java.util.List;

public class Disk {
	int capacity;
	int blockSize;
	List<Boolean> blocks;
	FileSystemTree fileSystemTree;
	List<File> files;
	List<Folder> folders;	
	Disk() {
		capacity = (int) 1e6;
		blockSize = 1;
		blocks = new ArrayList<Boolean>();
		for(int i = 0; i < capacity/blockSize; i++){
			blocks.add(false);
		}
		fileSystemTree = new FileSystemTree();
		files = new ArrayList<File>();
		folders = new ArrayList<Folder>();
	}
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	public int getBlockSize() {
		return blockSize;
	}
	public void setBlockSize(int blockSize) {
		this.blockSize = blockSize;
	}
	public List<Boolean> getBlocks() {
		return blocks;
	}
	public void setBlocks(List<Boolean> blocks) {
		this.blocks = blocks;
	}
	public FileSystemTree getFileSystemTree() {
		return fileSystemTree;
	}
	public void setFileSystemTree(FileSystemTree fileSystemTree) {
		this.fileSystemTree = fileSystemTree;
	}
	public List<File> getFiles() {
		return files;
	}
	public void setFiles(List<File> files) {
		this.files = files;
	}
	public List<Folder> getFolders() {
		return folders;
	}
	public void setFolders(List<Folder> folders) {
		this.folders = folders;
	}
	void displayStatus(){
		
	}
	void displayFileSystemTree(){
		
	}
	
}
