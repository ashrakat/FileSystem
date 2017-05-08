import java.util.Scanner;

public class Main {
	static Scanner in = new Scanner(System.in);
	
	static AllocationTechnique contiguousAllocation = new ContiguousAllocation();
	
	public static void main(String[] args) {
		String command = in.next();
		while(!command.equals("Exit")){
			switch (command){
				case "CFile":{
					String fileName = in.next();
					int fileSize = in.nextInt();
					String filePath = in.next();
					contiguousAllocation.saveFile(fileName, fileSize, filePath);
					break;
					
				}
				case "CFolder":{
					String folderName = in.next();
					String folderPath = in.next();
					contiguousAllocation.saveFolder(folderName, folderPath);
					break;
				}
				case "DeleteFile":{
					String filePath = in.next();
					contiguousAllocation.deleteFile(filePath);
					break;
				}
				case "DeleteFolder":{
					String folderName = in.next();
					String folderPath = in.next();
					contiguousAllocation.deleteFolder(folderName, folderPath);
					break;
				}
				case "DisplayStatus":{
					contiguousAllocation.getDisk().displayStatus();
					break;
				}
				case "DisplayFileSystemTree":{
					contiguousAllocation.getDisk().displayFileSystemTree();
					break;
				}
				case "Exit":{
					break;
				}
				default:{
					System.out.println("Please enter a correct command!");
				}
			}
			command = in.next();
			
		}
		
		
	}

}
