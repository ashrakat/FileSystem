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
		for (int i = 0; i < capacity / blockSize; i++) {
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

	void displayStatus() {
		int occupiedSpace = 0;
		int emptySpace = 0;
		List<Integer> emptySlots = new ArrayList<Integer>();
		
		for (int i = 0; i < blocks.size(); i++) {
			if (blocks.get(i) == true){
				occupiedSpace += blockSize;
			}
			else {
				if(i == 0 || i == blocks.size()-1 || blocks.get(i-1) || blocks.get(i+1) ) {
					emptySlots.add(i);
					if(i > 0 && i < blocks.size()-1 && blocks.get(i-1) && blocks.get(i+1)) {
						emptySlots.add(i);
					}
				}
			}
		}
		
		emptySpace = capacity - occupiedSpace;
		
		System.out.println(" ----------------------------------------------- ");
		System.out.println("  Occupied Space     :  " + occupiedSpace + " KB ");
		System.out.println("  Empy Space         :  " +   emptySpace  + " KB ");
		System.out.println(" ----------------------------------------------- ");
		
		System.out.println(" ----------------------------------- ");
		System.out.println("    Empty Slots in Terms of Blocks   ");
		System.out.println(" ----------------------------------- ");
		
		for(int i = 0; i < emptySlots.size(); i += 2){
			System.out.println("\t" + emptySlots.get(i) + "\t|\t" + emptySlots.get(i+1));
		}
		
	}

		
	void displayFileSystemTree() {
		System.out.println(" ---------------------- ");
		System.out.println("    File System Tree    ");
		System.out.println(" ---------------------- ");
		
		DFS(" |__", fileSystemTree.getRoot());
	}
	
	private void DFS(String level, Folder root){
		if(root == null){
			return;
		}
		
		System.out.println(level + " " + root.getFolderName());
		
		level += "__";
		
		for(int i = 0; i < root.getFolders().size(); i++){
			DFS(level, root.getFolders().get(i));
		}
		
		for(int i = 0; i < root.getFiles().size(); i++){
			System.out.println(level + " " + root.getFiles().get(i).getName());
		}
	}

}
