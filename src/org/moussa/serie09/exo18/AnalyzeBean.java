package org.moussa.serie09.exo18;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class AnalyzeBean {

	public Class<? extends Object> getClassName(Object o) {
		return o.getClass();
	}

	public Object getInstance(String className) throws InstantiationException, IllegalAccessException {
		Object obj = null;
		try {
			obj =  Class.forName(className).newInstance();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return obj;
	}

	private Predicate<String> isValidProperties = string -> string.startsWith("set") 
															|| string.startsWith("get")
															|| string.startsWith("is");

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

	Predicate<String> isNotComment = string -> !string.startsWith("#");
	Predicate<String> isBean = string -> string.startsWith("bean");
	Predicate<String> isNotEmpty = string -> !string.isEmpty();
	Function<String, String> fieldNameInRange = line -> line.substring(line.indexOf('.') + 1, line.indexOf('='));
	Function<String, String> beanName = line -> line.substring(line.indexOf("bean.name=") + "bean.name=".length());

	public List<Object> read(String fileName) throws IllegalAccessException, ClassNotFoundException,
													 InstantiationException, NoSuchFieldException,
													 SecurityException {
		File file = new File(fileName);
		Class<?> clazz = null;
		//Object p1 = null, p2 = null;
		List<Object> objects = new ArrayList<>();
		try(FileReader fr = new FileReader(file);
				BufferedReader br = new BufferedReader(fr);) {
			
			List<String> beansName = br.lines().filter(isNotEmpty.and(isNotComment)
																 .and(isBean))
											   .map(beanName).collect(Collectors.toList());
			//System.out.println(beansName);
			for (String beanName : beansName) {
				FileReader newFr = new FileReader(file);
				BufferedReader newBr = new BufferedReader(newFr);
				String line = newBr.readLine();
				Object tmpBean = null;
				while(line != null) {
					if(isNotComment.test(line)) {
						if(line.startsWith(beanName + ".class")) {
							String className = line.substring(line.indexOf("=") + 1);
							try {
								clazz = Class.forName(className);
								tmpBean = clazz.newInstance();
							} catch (ClassNotFoundException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							} 
						} else if(line.startsWith(beanName)) {
							String fieldName = fieldNameInRange.apply(line);
							Field field = clazz.getField(fieldName);
							String value = line.substring(line.indexOf("=") + 1);
							if(field.getType() == String.class) {
								field.set(tmpBean, value);
							} else if (field.getType() == int.class) {
								field.set(tmpBean, Integer.parseInt(value));
							}
						}
						
					}
					if(!objects.contains(tmpBean) && tmpBean != null)
						objects.add(tmpBean);
					line = newBr.readLine();
				}
				newBr.close();
			}
			/*FileReader newFr = new FileReader(file);
			BufferedReader newBr = new BufferedReader(newFr);
			String line = newBr.readLine();
			while(line != null) {
				if(isNotComment.test(line)) {
					if(line.startsWith("p1.class")) {
						String className = line.substring(line.indexOf("=") + 1);
						try {
							clazz = Class.forName(className);
							p1 = clazz.newInstance();
						} catch (ClassNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} 
					} else if(line.startsWith("p1")) {
						String fieldName = fieldNameInRange.apply(line);
						Field field = clazz.getField(fieldName);
						String value = line.substring(line.indexOf("=") + 1);
						if(field.getType() == String.class) {
							field.set(p1, value);
						} else if (field.getType() == int.class) {
							field.set(p1, Integer.parseInt(value));
						}
					} else if(line.startsWith("p2.class")) {
						String className = line.substring(line.indexOf("=") + 1);
						try {
							clazz = Class.forName(className);
							p2 = clazz.newInstance();
						} catch (ClassNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					} else if(line.startsWith("p2")) {
						String fieldName = fieldNameInRange.apply(line);
						Field field = clazz.getField(fieldName);
						String value = line.substring(line.indexOf("=") + 1);
						if(field.getType() == String.class) {
							field.set(p2, value);
						} else if (field.getType() == int.class) {
							field.set(p2, Integer.parseInt(value));
						}
					}
				}
				
				line = newBr.readLine();
			}
			newBr.close();*/
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*objects.add(p1);
		objects.add(p2);*/

		return objects;
	}
}
