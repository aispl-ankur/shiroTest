package com;


import net.sourceforge.stripes.action.ActionBean;
import net.sourceforge.stripes.action.ActionBeanContext;
import net.sourceforge.stripes.action.DefaultHandler;
import net.sourceforge.stripes.action.ForwardResolution;
import net.sourceforge.stripes.action.Resolution;
import net.sourceforge.stripes.validation.Validate;


import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;

public class LoginActionBean implements ActionBean {
	
	private ActionBeanContext context;
	@Validate(required=true)
	private String userName;
	private String password;
	
 
	public ActionBeanContext getContext() { return context; }
    public void setContext(ActionBeanContext context) { this.context = context; }
    
    

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	/*public Subject getSubject() {
        Factory<SecurityManager> factory = new IniSecurityManagerFactory();
       SecurityManager securityManager = factory.createInstance();
       SecurityUtils.setSecurityManager(securityManager);
            SecurityUtils.getSubject();
            
            return SecurityUtils.getSubject();
}*/
	public Subject getSubject()
	{
		Factory<SecurityManager> factory=new IniSecurityManagerFactory();
		SecurityManager manager=factory.getInstance();
		
		SecurityUtils.setSecurityManager(manager);
		SecurityUtils.getSubject();
		return SecurityUtils.getSubject();
	}

	@DefaultHandler	
    public Resolution login() {
		
		UsernamePasswordToken token = new UsernamePasswordToken(getUserName(), getPassword());
		token.setRememberMe(true);
		try {
			getSubject().login(token);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return new ForwardResolution("/welcome.jsp");
		
		
	}

	
		
	
	
}
