package crtl;

import java.util.ArrayList;
import java.util.List;
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

import com.esprit.gestionPI.dao.EnseignantDaoRemote;
import com.esprit.gestionPI.dao.PIDaoRemote;
import com.esprit.gestionPI.persistence.Classe;
import com.esprit.gestionPI.persistence.Enseignant;
import com.esprit.gestionPI.persistence.PI;

@ManagedBean
@SessionScoped
public class PICtrl1 {
	private PI pi;
	private String coordinateur;
	
	@PostConstruct
	public void init() {
		pi= new PI();
	    
	}
	
@EJB
PIDaoRemote piDaoRemote;
@EJB
EnseignantDaoRemote enseignantDaoRemote;
	
	public String doCreatePI(){
	FacesContext context=FacesContext.getCurrentInstance();
	getProxy();
	try {
		piDaoRemote.add(pi);
		pi=new PI();
		FacesMessage message=new FacesMessage(FacesMessage.SEVERITY_INFO,"Info","Création réuissite");
		context.addMessage(null, message);
		}catch(Exception e){
			FacesMessage message=new FacesMessage(FacesMessage.SEVERITY_ERROR,"Erreur","Erreur de création");
			context.addMessage(null, message);
		}
	return"";
	}
	
	
	public List<String> chargerListEnseignant(String query){
		FacesContext context=FacesContext.getCurrentInstance();
		getProxy();
		List<String> matched;
		matched= new ArrayList<String>();//retour
		List<Enseignant> enseignants;
		enseignants = new ArrayList<Enseignant>();
		try {
			enseignants=enseignantDaoRemote.findallList();
			System.out.println("test 1 réussi");
		} catch (Exception e) {
		}
		String saisi = null;
		query = query.toLowerCase(); 
		for(int i=0; i<enseignants.size(); i++) {
			saisi=enseignants.get(i).getNom();
			if(saisi.startsWith(query)) {
                matched.add(enseignants.get(i).getNom()+" "+enseignants.get(i).getPrenom());
		}
		}
		return matched;
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
			piDaoRemote= (PIDaoRemote) context.lookup("gestion_suiviPI/PIDao!com.esprit.gestionPI.dao.PIDaoRemote");
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public PI getPi() {
		return pi;
	}
	public void setPi(PI pi) {
		this.pi = pi;
	}
	public String getCoordinateur() {
		return coordinateur;
	}
	public void setCoordinateur(String coordinateur) {
		this.coordinateur = coordinateur;
	}
	
	
	
}
