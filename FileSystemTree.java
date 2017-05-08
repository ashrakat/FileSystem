
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;


public class FileSystemTree {
	private Folder root;
	
	FileSystemTree(){
		root = new Folder();
		root.folderName = "root";
		root.filePath = "/root";
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Calendar cal = Calendar.getInstance();
		root.creationDate = dateFormat.format(cal.getTime()).toString();
		root.lastModificationDate = dateFormat.format(cal.getTime()).toString();
	}

	public Folder getRoot() {
		return root;
	}

	public void setRoot(Folder root) {
		this.root = root;
	}
	
	
	

}
