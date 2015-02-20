package lab.aikibo.init;

import java.util.Map;

import lab.aikibo.services.AuthenticationService;
import lab.aikibo.services.AuthenticationServiceImpl;
import lab.aikibo.services.UserCredential;

import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.Page;

public class AuthenticationInit implements org.zkoss.zk.ui.util.Initiator {
	  
	// services 
	AuthenticationService authService = new AuthenticationServiceImpl();
	
	public void doInit(Page page, Map<String,Object> args) {
		UserCredential cre = authService.getUserCredential();
		if(cre == null || cre.isAnonymous()) {
			Executions.sendRedirect("/login.zul");
			return;
		}
	}

}
