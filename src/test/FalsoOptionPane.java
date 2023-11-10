package test;

import vista.IOptionPane;

public class FalsoOptionPane implements IOptionPane {

	private String msj = null;
	
	public FalsoOptionPane() {
		super();
	}

	@Override
	public void ShowMessage(String arg0) {
		this.msj = arg0;
		
	}
	
	public String getMensaje() {
		return msj;
	}
}
