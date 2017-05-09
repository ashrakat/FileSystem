import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ContiguousAllocation extends AllocationTechnique {
	
	private FileSystemTree fileSystemTree = new FileSystemTree();
	private int lastIndex = 0;
	
	private Folder contains(Folder folder , String folderName){
		
		for(Folder f : folder.getFolders())
			if(f.getFolderName().equals(folderName))
				return f;
		
		return null;
	}
	
	
	private Folder checkPath(String filePath){
		String[] Directories = filePath.split("/");
		
		Folder parent = fileSystemTree.getRoot();
		
		for(int i = 0 ; i < Directories.length; ++i){
			if(contains(parent, Directories[i]) != null)
				parent = contains(parent, Directories[i]);
			else return null ;
		}
		
		return parent;
		
	}
	
	@Override
	public void saveFile(String fileName, int fileSize, String filePath) {
		
		Folder folder;
		DiskSlot diskSlot = new DiskSlot();
		
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Calendar cal = Calendar.getInstance();
		String creationDate = dateFormat.format(cal.getTime()).toString();
		
		String[] fileType = fileName.split("."); 

		
		if(checkPath(filePath) != null)
			folder = checkPath(filePath);
		else{
			System.err.println("Directory doesn't exist!");
			return;
		}
		
		
		for(File file : folder.getFiles()){
			if(file.getName().equals(fileName)){
				System.err.println("File with a same name already exists!");
				return;
			}
		}
		
		diskSlot.setFirstBlockIndex(lastIndex);
		lastIndex += fileSize;
		diskSlot.setNumberOfBlocks(fileSize);
		
		File file = new File(fileName,fileType[1],filePath,fileSize,creationDate,creationDate,diskSlot);
		
		folder.getFiles().add(file);
		
		System.out.println("Created successfully!");
		
	}
	
	

	@Override
	public void saveFolder(String folderName, String folderPath) {
		
		Folder parentFolder;

		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Calendar cal = Calendar.getInstance();
		String creationDate = dateFormat.format(cal.getTime()).toString();
		

		
		if(checkPath(folderPath) != null)
			parentFolder = checkPath(folderPath);
		else{
			System.err.println("Directory doesn't exist!");
			return;
		}
		
		
		for(Folder folderTemp : parentFolder.getFolders()){
			if(folderTemp.getFolderName().equals(folderName)){
				System.err.println("Folder with a same name already exists!");
				return;
			}
		}
		
		Folder childFolder = new Folder(folderName,folderPath,creationDate,creationDate);
		
		parentFolder.getFolders().add(childFolder);
		
		System.out.println("Created successfully!");
		
	}

	@Override
	public void deleteFile(String filePath) {
		
		Folder folder;
		
		String[] tempFile = filePath.split("/");
		String fileName = tempFile[tempFile.length-1];
		
		filePath.replaceFirst(fileName, "");

		
		if(checkPath(filePath) != null)
			folder = checkPath(filePath);
		else{
			System.err.println("Directory doesn't exist!");
			return;
		}
		
		
		for(File file : folder.getFiles()){
			if(file.getName().equals(fileName)){
				folder.getFiles().remove(file);
				System.out.println("Deleted successfully!");
				return;
			}
		}
		
		System.err.println("File not found!");
		
	}

	@Override
	public void deleteFolder(String folderName, String folderPath) {
		
		Folder parentFolder;
		
		if(checkPath(folderPath) != null)
			parentFolder = checkPath(folderPath);
		else{
			System.err.println("Directory doesn't exist!");
			return;
		}
		
		
		for(Folder folderTemp : parentFolder.getFolders()){
			if(folderTemp.getFolderName().equals(folderName)){
					parentFolder.getFolders().remove(folderTemp);
					System.out.println("Deleted successfully!");
				return;
			}
		}
		
		System.err.println("Folder not found!");
		
		
	}
	
	
	

}
