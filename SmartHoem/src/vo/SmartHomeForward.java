package vo;

public class SmartHomeForward {
	
	private String path;  //주소	
	private boolean redirect=true; //방식(리다이렉트 유무) 
	
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public boolean isRedirect() {
		return redirect;
	}
	public void setRedirect(boolean redirect) {
		this.redirect = redirect;
	}
}
