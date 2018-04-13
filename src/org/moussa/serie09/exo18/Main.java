package org.moussa.serie09.exo18;

public class Main {

	public static void main(String[] args) throws IllegalAccessException, ClassNotFoundException,
												  InstantiationException, NoSuchFieldException, SecurityException {
		// TODO Auto-generated method stub
		
		AnalyzeBean bean = new AnalyzeBean();
		Person person = new Person();
		Employee employee = new Employee();
		String fileName = "files/BeanToAnalyze";
		Class<? extends Object> className = bean.getClassName(person);
		System.out.println(className);
		
		Object clazz = null;
		clazz = bean.getInstance(className.getName());
		System.out.println(clazz);
		
		System.out.println("Properties of person  : " + bean.getProperties(person));
		System.out.println("Properties of Employee  : " + bean.getProperties(employee));
		
		bean.set(person, "FirstName", "Moussa");
		bean.set(person, "LastName", "Konate");
		bean.set(person, "Age", 20);
		
		System.out.println(person);
		System.out.println(bean.read(fileName));
	}
}
