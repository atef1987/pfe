package crtl;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import javax.faces.model.SelectItem;

import org.omnifaces.util.selectitems.SelectItemsBuilder;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.esprit.gestionPI.dao.PIDaoRemote;
import com.esprit.gestionPI.persistence.PI;

@ManagedBean
@SessionScoped
public class PICtrl {
	private PI pi;
	private String item;
	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	private List<PI> pis;
	 private List<SelectItem> selectItems;
	 private PI selectedItem;
	 

	public PI getSelectedItem() {
		return selectedItem;
	}

	public void setSelectedItem(PI selectedItem) {
		this.selectedItem = selectedItem;
	}

	public List<SelectItem> getSelectItems() {
		return selectItems;
	}

	public void setSelectItems(List<SelectItem> selectItems) {
		this.selectItems = selectItems;
	}

	public List<PI> getPis() {
		return pis;
	}

	public void setPis(List<PI> pis) {
		this.pis = pis;
	}

	@PostConstruct
	public void init() {
		pi = new PI();
        pis= new ArrayList<PI>();
	}

	@EJB
	PIDaoRemote remote;

	public String doCreatePI() {
		FacesContext context = FacesContext.getCurrentInstance();
//		getProxy();
		try {
			remote.add(pi);
			pi = new PI();
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Info", "Création réuissite");
			context.addMessage(null, message);
		} catch (Exception e) {
			FacesMessage message = new FacesMessage(
					FacesMessage.SEVERITY_ERROR, "Erreur", "Erreur de création");
			context.addMessage(null, message);
		}
		return "";
	}

	public List<PI> ToutPI() {

		FacesContext context = FacesContext.getCurrentInstance();
//		getProxy();
		try {
			pis = remote.findList();
			pi = new PI();
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Info", "Création réuissite");
			context.addMessage(null, message);
		} catch (Exception e) {
			FacesMessage message = new FacesMessage(
					FacesMessage.SEVERITY_ERROR, "Erreur", "Erreur de création");
			context.addMessage(null, message);
		}
		return pis;
	}
	public void updatePI() {
		FacesContext context = FacesContext.getCurrentInstance();
//		getProxy();
		try {
			remote.update(pi);
			pi = new PI();
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Info", "modification réuissite");
			context.addMessage(null, message);
		} catch (Exception e) {
			FacesMessage message = new FacesMessage(
					FacesMessage.SEVERITY_ERROR, "Erreur", "Erreur de modification");
			context.addMessage(null, message);
		}
	}
	public void supprimerPI() {
		FacesContext context = FacesContext.getCurrentInstance();
//		getProxy();
		try {
			remote.delete(pi.getIdPI());
			pi = new PI();
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Info", "suppression réuissite");
			context.addMessage(null, message);
		} catch (Exception e) {
			FacesMessage message = new FacesMessage(
					FacesMessage.SEVERITY_ERROR, "Erreur", "Erreur de suppression");
			context.addMessage(null, message);
		}
	}
	

//	public void getProxy() {
//		Properties properties = new Properties();
//		// properties.put("java.naming.factory.url.pkgs",
//		// "org.jboss.ejb.client.naming");
//		properties.put("java.naming.factory.initial",
//				"org.jboss.naming.remote.client.InitialContextFactory");
//		properties.put("java.naming.provider.url", "remote://localhost:4447");
//		// properties.put("jboss.naming.client.ejb.context", true);
//		// properties.put("jboss.naming.client.connect.options.org.xnio.Options.SASL_POLICY_NOPLAINTEXT",
//		// false);
//		properties.put(Context.SECURITY_PRINCIPAL, "user1");// user name pour un
//															// simple user
//		properties.put(Context.SECURITY_CREDENTIALS, "user2");// password
//		try {
//			Context context = new InitialContext(properties);
//			remote = (PIDaoRemote) context
//					.lookup("gestion_suiviPI/PIDao!com.esprit.gestionPI.dao.PIDaoRemote");
//		} catch (NamingException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}

	public PI getPi() {
		return pi;
	}

	public void setPi(PI pi) {
		this.pi = pi;
	}
}
