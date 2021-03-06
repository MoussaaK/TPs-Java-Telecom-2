package org.moussa.serie09.exo18;

public class Employee extends Person{

	/**
	 * Default Serial Version
	 */
	private static final long serialVersionUID = -2186261823595425534L;
	public double salary;

	public Employee() {}

	/**
	 * @param salary
	 */
	public Employee(double salary) {
		super();
		this.setSalary(salary);
	}

	public double getSalary() {
		return salary;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Employee [firstName=" + firstName + ", lastName=" + lastName + ", age=" + age
				+ ", salary=" + salary + "]";
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}
}
