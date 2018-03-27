package org.moussa.serie09.exo18;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;

public class AnalyzeBean {

	public Class<? extends Object> getClassName(Object o) {
		return o.getClass();
	}

	public Object getInstance(String className) {
		Object obj = null;
		try {
			obj =  Class.forName(className).newInstance();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return obj;
	}

	private Predicate<String> isValidProperties = string -> string.startsWith("set") || string.startsWith("get");

	public List<String> getProperties(Object o) {

		List<String> propertiesNames = new ArrayList<>();
		Class<? extends Object> className = o.getClass();
		for (Method m : className.getMethods()) {
			if(isValidProperties.test(m.getName()))
				propertiesNames.add(m.getName());
		}
		return propertiesNames;
	}

	private Function<String, String> nameToGetterName = s -> s = "get" + String.valueOf(s.charAt(0)).toUpperCase() + s.substring(1);

	public Object get(Object bean, String property) {
		Method getter = null;
		Object obj = null;

		try {
			getter = this.getClassName(bean).getMethod(nameToGetterName.apply(property));
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			obj = getter.invoke(bean);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return obj;
	}

	private Function<String, String> nameToSetterName = s -> s = "set" + String.valueOf(s.charAt(0)).toUpperCase() + s.substring(1);
	private BiFunction<Object, String, Class<?>> getType = (bean, property) -> {
		try {
			return this.getClassName(bean).getMethod(nameToGetterName.apply(property)).getReturnType();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	};
	
	public void set(Object bean, String property, Object value) {
		Method setter = null;
		Class<?> classType = null;
		try {
			classType = getType.apply(bean, property);
		} catch (SecurityException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			setter = this.getClassName(bean).getMethod(nameToSetterName.apply(property), classType);
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			setter.invoke(bean, value);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	Predicate<String> isComment = string -> string.startsWith("#");
	public List<Object> read(String fileName) {
		File file = new File(fileName);
		Class<?> clazz = null;
		try(FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);) {
			for(int i=0; i< 11; i++) {
				String line = br.readLine();
				if(!isComment.test(line)) {
					System.out.println(line);
				}
			}
				
				
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
}
