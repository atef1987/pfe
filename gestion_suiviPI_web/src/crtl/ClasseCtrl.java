package crtl;

import java.util.Properties;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.esprit.gestionPI.dao.ClasseDaoRemote;
import com.esprit.gestionPI.persistence.Classe;
@ManagedBean
@SessionScoped
public class ClasseCtrl {
	
	private Classe classe;
	@PostConstruct
	public void init() {
		classe= new Classe();
	    
	}
	@EJB
	ClasseDaoRemote remote;
	public String doCreateClasse(){
		FacesContext context=FacesContext.getCurrentInstance();
		getProxy();
		try{
		remote.add(classe);
	    classe= new Classe();
		FacesMessage message=new FacesMessage(FacesMessage.SEVERITY_INFO,"Info","Création réuissite");
		context.addMessage(null, message);
		}catch(Exception e){
			FacesMessage message=new FacesMessage(FacesMessage.SEVERITY_ERROR,"Erreur","Erreur de création");
			context.addMessage(null, message);
		}
		return"";
	}
	public void getProxy(){
		Properties properties=new Properties();
		//properties.put("java.naming.factory.url.pkgs", "org.jboss.ejb.client.naming");
		properties.put("java.naming.factory.initial", "org.jboss.naming.remote.client.InitialContextFactory");
		properties.put("java.naming.provider.url", "remote://localhost:4447");
		//properties.put("jboss.naming.client.ejb.context", true);
		//properties.put("jboss.naming.client.connect.options.org.xnio.Options.SASL_POLICY_NOPLAINTEXT", false);
		properties.put(Context.SECURITY_PRINCIPAL, "user1");//user name pour un simple user
		properties.put(Context.SECURITY_CREDENTIALS, "user2");//password
		try {
			Context context= new InitialContext(properties);
			remote= (ClasseDaoRemote) context.lookup("gestion_suiviPI/ClasseDao!com.esprit.gestionPI.dao.ClasseDaoRemote");
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public Classe getClasse() {
		return classe;
	}
	public void setClasse(Classe classe) {
		this.classe = classe;
	}
	
}
