package crtl;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.imageio.ImageIO;
import javax.naming.Context;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

public class FileUploadBean {
	 public static final String NAME = "fileUploadBean";


	   /**
	    */
	   public void uploadImageEvent(FileUploadEvent event) {
		   FacesContext context=FacesContext.getCurrentInstance();
	            UploadedFile uploadFile = event.getFile();
	                 if (uploadFile != null) {
	                    try {
	                    	
	             BufferedImage b = ImageIO.read(uploadFile .getInputstream());
	             FacesMessage message=new FacesMessage(FacesMessage.SEVERITY_INFO,"Info","Image upload was successful.");
	                       context.addMessage(null, message);
	            } catch (IOException e) {
	         
	            } finally {
	                          }
	                  } else {
	                	  FacesMessage message=new FacesMessage(FacesMessage.SEVERITY_ERROR,"Erreur","Image upload failed.");
	                             context.addMessage(null, message);
	                }
	   }

	   
	   
	}


