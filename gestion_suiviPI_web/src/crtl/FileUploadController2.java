package crtl;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

@ManagedBean(name="fileUploadController2")
@SessionScoped
public class FileUploadController2 {

	private String destination;
	private  String CheminComplet;
	private UploadedFile file;
	public FileUploadController2() {
	}
	public String getCheminComplet() {
		return CheminComplet;
	}

	public void setCheminComplet(String cheminComplet) {
		CheminComplet = cheminComplet;
	}

	@PostConstruct
	public void init() {

	  destination="D:\\tmp\\";  
	}
	
	public void upload(FileUploadEvent event) {  
        FacesMessage msg = new FacesMessage("Success! ", event.getFile().getFileName() + " is uploaded.");  
        FacesContext.getCurrentInstance().addMessage(null, msg);
        // Do what you want with the file  
        file = event.getFile();
        try {
            copyFile(event.getFile().getFileName(), event.getFile().getInputstream());
            CheminComplet=destination+event.getFile().getFileName();
            System.out.println(CheminComplet);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }  
    public void copyFile(String fileName, InputStream in) {
        try {
          
          
             // write the inputStream to a FileOutputStream
             OutputStream out = new FileOutputStream(destination+fileName);
             
         
             int read = 0;
             byte[] bytes = new byte[1024];
          
             while ((read = in.read(bytes)) != -1) {
                 out.write(bytes, 0, read);
             }
          
             in.close();
             out.flush();
             out.close();
          
             System.out.println("New file created!");
             } catch (IOException e) {
             System.out.println(e.getMessage());
             }
 }
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public UploadedFile getFile() {
		return file;
	}
	public void setFile(UploadedFile file) {
		this.file = file;
	}
}
