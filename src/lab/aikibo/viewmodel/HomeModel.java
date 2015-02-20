package lab.aikibo.viewmodel;

import java.io.Serializable;

import org.zkoss.bind.annotation.GlobalCommand;
import org.zkoss.zk.ui.Executions;

public class HomeModel implements Serializable {

	private static final long serialVersionUID = 342575641702276413L;
	
	@GlobalCommand
	public void redirectToNewForm() {
		Executions.sendRedirect("/login.zul");
	}

}
