package test.edu.javaee.spring.aop;

import java.util.LinkedList;
import java.util.List;

import dev.edu.javaee.spring.aop.Advice;
import dev.edu.javaee.spring.aop.Advisor;
import dev.edu.javaee.spring.aop.framework.AdvisedSupport;
import dev.edu.javaee.spring.aop.framework.JdkDynamicAopProxy;
import dev.edu.javaee.spring.aop.framework.ProxyFactory;



public class ProxyFactoryBean {
	
    private String proxyInterfaces;
	private Object target;
	private List<Object> interceptorNames;
	private ProxyFactory proxyFactory = new ProxyFactory();
	
	public String getProxyInterfaces() {
		return proxyInterfaces;
	}
	public void setProxyInterfaces(String proxyInterfaces) {
		this.proxyInterfaces = proxyInterfaces;
		try {
			this.proxyFactory.setInterfaces(Class.forName(proxyInterfaces));
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public Object getTarget() {
		return target;
	}
	public void setTarget(Object target) {
		this.target = target;
		this.proxyFactory.setTarget(target);
	}
	

	public List<Object> getInterceptorNames() {
		return interceptorNames;
	}
	public void setInterceptorNames(List<Object> interceptorNames) {
		this.interceptorNames = interceptorNames;
		
		for(Object obj: interceptorNames){
			this.proxyFactory.addAdvisor((Advisor) obj);
		}
	}
	public ProxyFactory getProxyFactory() {
		return proxyFactory;
	}
	
	public void setProxyFactory(ProxyFactory proxyFactory) {
		this.proxyFactory = proxyFactory;
	}
	
	public Object getProxy() {
		
		return this.proxyFactory.getProxy();
		
	}
	
	

}
