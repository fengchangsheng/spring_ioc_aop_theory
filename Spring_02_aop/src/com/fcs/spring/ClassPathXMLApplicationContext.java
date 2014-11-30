package com.fcs.spring;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
/**
 * @author fcs
 * ---->jdom.jar  解析配置文件   完成控制反转 (由容器管理)
 * 2014-10-9
 */
public class ClassPathXMLApplicationContext implements BeanFactory{
	private Map<String,Object> beans = new HashMap<String, Object>();
	
	public ClassPathXMLApplicationContext() throws Exception{
		SAXBuilder sb = new SAXBuilder();
		Document doc = sb.build(this.getClass().getClassLoader().getResourceAsStream("beans.xml"));
		Element root = doc.getRootElement();//获取根元素
		List list = root.getChildren("bean");//获取名字为bean的所有元素
		for (int i = 0; i < list.size(); i++) {
			Element element = (Element)list.get(i);
			String id = element.getAttributeValue("id");
			String clazz = element.getAttributeValue("class");
			System.out.println(id+":"+clazz);
			Object o = Class.forName(clazz).newInstance();
			beans.put(id, o);
			
			for(Element pElement : (List<Element>) element.getChildren("property")){
				String name = pElement.getAttributeValue("name");//userDAO
				String bean = pElement.getAttributeValue("ref");//u
				Object beanObject = beans.get(bean);//new UserDAOImpl();
				
				String methodName = "set"+name.substring(0, 1).toUpperCase()+name.substring(1);
				System.out.println("method name = "+methodName);
				
				Method m = o.getClass().getMethod(methodName,beanObject.getClass().getInterfaces()[0] );
				m.invoke(o, beanObject);
			}
		}
	}

	@Override
	public Object getBean(String name) {
		return beans.get(name);
	}
}
