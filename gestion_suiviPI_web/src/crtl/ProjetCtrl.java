package crtl;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.FileUploadEvent;

import com.esprit.gestionPI.dao.ProjetDaoRemote;
import com.esprit.gestionPI.persistence.Photo;
import com.esprit.gestionPI.persistence.Projet;
import com.esprit.gestionPI.persistence.SpecificationDocument;
import com.esprit.gestionPI.persistence.Video;

@ManagedBean
@SessionScoped
public class ProjetCtrl {
	Photo photo;
	Video video;
	SpecificationDocument document;
	private String destination;
	private String CheminComplet;
//	@ManagedProperty(value="#{fileUploadController}")
//	private FileUploadController fileUploadController;
//	@ManagedProperty(value="#{fileUploadController1}")
//	private FileUploadController1 fileUploadController1;
	

	public FileUploadController2 getFileUploadController2() {
		return fileUploadController2;
	}

	public void setFileUploadController2(FileUploadController2 fileUploadController2) {
		this.fileUploadController2 = fileUploadController2;
	}

	@ManagedProperty(value="#{fileUploadController2}")
	private FileUploadController2 fileUploadController2;

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getCheminComplet() {
		return CheminComplet;
	}

	public void setCheminComplet(String cheminComplet) {
		CheminComplet = cheminComplet;
	}

	private Projet projet;

	@PostConstruct
	public void init() {
		projet = new Projet();
		destination = "D:\\\\tmp\\";
		Photo photo = new Photo();
		Video video= new Video();
		SpecificationDocument document=new SpecificationDocument();
	}

	@EJB
	ProjetDaoRemote remote;

	
	public String doCreateClasse() {
		FacesContext context = FacesContext.getCurrentInstance();
		// getProxy();
		try {

			Photo photo = new Photo();
			Video video= new Video();
			SpecificationDocument document=new SpecificationDocument();
			FacesContext facesContext = FacesContext.getCurrentInstance();
		
			FileUploadController fileUploadController = (FileUploadController) facesContext
					.getApplication()
					.createValueBinding("#{fileUploadController}")
					.getValue(facesContext);
			
//			FileUploadController1 fileUploadController1 = (FileUploadController1) facesContext
//					.getApplication()
//					.createValueBinding("#{fileUploadController1}")
//					.getValue(facesContext);
			
			FileUploadController2 fileUploadController2 = (FileUploadController2) facesContext
					.getApplication()
					.createValueBinding("#{fileUploadController2}")
					.getValue(facesContext);
			if (fileUploadController==null) {
				System.out.println("composant null");
			}
			
			byte[] data = fileUploadController.getFile().getContents();
			if (fileUploadController==null) {
				System.out.println("composant null");
			}
//			byte[] data1 = fileUploadController1.getFile().getContents();
			byte[] data2 = fileUploadController2.getFile().getContents();
			
			photo.setData(data);
			projet.setPhoto(photo);
			photo.setProjet(projet);
//			video.setData(data1);
//			projet.setVideo(video);
//			video.setProjet(projet);
			document.setData(data2);
			projet.setDocument(document);
			remote.add(projet);
			projet = new Projet();
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Info", "Création réuissite");
			context.addMessage(null, message);
		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
			FacesMessage message = new FacesMessage(
					FacesMessage.SEVERITY_ERROR, "Erreur", "Erreur de création");
			context.addMessage(null, message);
		}
		return "";
	}

	// public void getProxy() {
	// Properties properties = new Properties();
	// // properties.put("java.naming.factory.url.pkgs",
	// // "org.jboss.ejb.client.naming");
	// properties.put("java.naming.factory.initial",
	// "org.jboss.naming.remote.client.InitialContextFactory");
	// properties.put("java.naming.provider.url", "remote://localhost:4447");
	// // properties.put("jboss.naming.client.ejb.context", true);
	// //
	// properties.put("jboss.naming.client.connect.options.org.xnio.Options.SASL_POLICY_NOPLAINTEXT",
	// // false);
	// properties.put(Context.SECURITY_PRINCIPAL, "user1");// user name pour un
	// // simple user
	// properties.put(Context.SECURITY_CREDENTIALS, "user2");// password
	// try {
	// Context context = new InitialContext(properties);
	// remote = (ProjetDaoRemote) context
	// .lookup("gestion_suiviPI/ProjetDao!com.esprit.gestionPI.dao.ProjetDaoRemote");
	// } catch (NamingException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	// }

	public Projet getProjet() {
		return projet;
	}

	public void setProjet(Projet projet) {
		this.projet = projet;
	}

	public void upload(FileUploadEvent event) {
		FacesMessage msg = new FacesMessage("Success! ", event.getFile()
				.getFileName() + " is uploaded.");
		FacesContext.getCurrentInstance().addMessage(null, msg);
		// Do what you want with the file
		try {
			copyFile(event.getFile().getFileName(), event.getFile()
					.getInputstream());

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void copyFile(String fileName, InputStream in) {
		try {

			// write the inputStream to a FileOutputStream
			OutputStream out = new FileOutputStream(destination + fileName);
			CheminComplet = (destination + fileName);
			System.out.println(CheminComplet);

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

}
