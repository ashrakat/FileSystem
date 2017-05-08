
abstract class AllocationTechnique {
	Disk disk;
	
	AllocationTechnique(){
		disk = new Disk();
	}

	public Disk getDisk() {
		return disk;
	}

	public void setDisk(Disk disk) {
		this.disk = disk;
	}

	abstract void saveFile(String fileName, int fileSize, String filePath);
	abstract void saveFolder(String folderName, String folderPath);
	abstract void deleteFile(String filePath);
	abstract void deleteFolder(String folderName, String folderPath);
}
