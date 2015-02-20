package lab.aikibo.viewmodel;

import java.io.Serializable;

import org.zkoss.bind.annotation.Command;
import org.zkoss.zk.ui.Executions;

import lab.aikibo.services.AuthenticationService;
import lab.aikibo.services.AuthenticationServiceImpl;

public class LogoutModel implements Serializable {

	private static final long serialVersionUID = 4670371001250339726L;
	
	AuthenticationService authService = new AuthenticationServiceImpl();
	
	@Command
	public void logout() {
		authService.logout();
		Executions.sendRedirect("/");
	}

}
