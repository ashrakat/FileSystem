import java.util.List;

public class File {

	String name;
	String type;
	String location;
	int size;
	String creationDate;
	String lastModificationDate;
	List<DiskSlot> diskSlots;

	
	public File(String name, String type, String location, int size, String creationDate, String lastModificationDate,
			List<DiskSlot> diskSlots) {
	
		this.name = name;
		this.type = type;
		this.location = location;
		this.size = size;
		this.creationDate = creationDate;
		this.lastModificationDate = lastModificationDate;
		this.diskSlots = diskSlots;
	}

	public File() {
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public String getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}

	public String getLastModificationDate() {
		return lastModificationDate;
	}

	public void setLastModificationDate(String lastModificationDate) {
		this.lastModificationDate = lastModificationDate;
	}
	
	public List<DiskSlot> getDiskSlots() {
		return diskSlots;
	}

	public void setDiskSlots(List<DiskSlot> diskSlots) {
		this.diskSlots = diskSlots;
	}
	
}
