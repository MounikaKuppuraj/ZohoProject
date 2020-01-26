package org;

import java.util.ArrayList;
import java.util.Scanner;
import javax.script.ScriptException;

public class TestSolution {
	public TestSolution(Employee e[]) {
		e[0] = new Employee(1, "A", 45, "CEO", "Management", null);
		e[1] = new Employee(2, "B", 23, "Product Finance Manager", "Finance", e[0]);
		e[2] = new Employee(3, "C", 36, "Project HR", "Human Resource", e[1]);
		e[3] = new Employee(4, "D", 32, "Product Manager", "Management", e[2]);
		e[4] = new Employee(5, "E", 36, "Product Manager", "Management", e[2]);
		e[5] = new Employee(6, "F", 35, "Product Manager", "Management", e[3]);
		e[6] = new Employee(7, "G", 28, "Lead Software Dev", "Production", e[4]);
		e[7] = new Employee(8, "H", 29, "Software Dev Engineer", "Production", e[6]);
		e[8] = new Employee(9, "I", 33, "Lead Software Engineer in Test", "Production", e[5]);
		e[9] = new Employee(10, "J", 38, "Software Test Engineer", "Production", e[8]);
	}

	public void displayEmployeeDetails(Employee e) {
		if (e.getReportingTo() != null) {
			System.out.println(e + " " + e.getReportingTo().getName());
		} else {
			System.out.println(e + " " + e.getReportingTo());
		}
	}

	public void employeeHierarchy(Employee e[], String name) {
		for (int i = 0; i < e.length; i++) {
			if (e[i].getName().equals(name)) {
				Employee e1 = e[i];
				while (e1 != null) {
					System.out.print(e1.getName() + "->");
					e1 = e1.getReportingTo();
				}
			}
		}
	}
	public void displayDetails(ArrayList<Employee> ae){
		for (int i = 0; i < ae.size(); i++) {
			System.out.println(ae.get(i));
		}
	}

	public void queryIntegerDetails(ArrayList<Employee> ae, ArrayList<String> lst) {
		if (lst.get(0).equals("age")) {
			if (lst.get(1).equals("1")) {
				for (int j = 0; j < ae.size();) {
					if (!(ae.get(j).getAge() > Integer.parseInt(lst.get(2)))) {
						ae.remove(j);
					} else {
						j++;
					}
				}
			}
			if (lst.get(1).equals("2")) {
				for (int j = 0; j < ae.size();) {
					if (!(ae.get(j).getAge() < Integer.parseInt(lst.get(2)))) {
						ae.remove(j);
					} else {
						j++;
					}
				}
			}
			if (lst.get(1).equals("3")) {
				for (int j = 0; j < ae.size();) {
					if (!(ae.get(j).getAge() != Integer.parseInt(lst.get(2)))) {
						ae.remove(j);
					} else {
						j++;
					}
				}
			}
		}

		displayDetails(ae);
	}

	public void queryStringDetails(ArrayList<Employee> ae, ArrayList<String> lst) {
		ArrayList<String> data = new ArrayList<String>();
		if (lst.get(0).equals("name")) {
			for (int j = 0; j < ae.size(); j++) {
				data.add(ae.get(j).getName());
			}
		}
		if (lst.get(0).equals("designation")) {
			for (int j = 0; j < ae.size(); j++) {
				data.add(ae.get(j).getDesignation());
			}
		}
		if (lst.get(0).equals("department")) {
			for (int j = 0; j < ae.size(); j++) {
				data.add(ae.get(j).getDepartment());
			}
		}

		if (lst.get(1).equals("1")) {
			for (int j = 0; j < ae.size();) {
				if (!(data.get(j).startsWith(lst.get(2)))) {
					ae.remove(j);
					data.remove(j);
				} else {
					j++;
				}
			}
		}
		if (lst.get(1).equals("2")) {
			for (int j = 0; j < ae.size();) {
				if (!(data.get(j).contains(lst.get(2)))) {
					ae.remove(j);
					data.remove(j);
				} else {
					j++;
				}
			}
		}
		if (lst.get(1).equals("3")) {
			for (int j = 0; j < ae.size();) {
				if (!(data.get(j).endsWith(lst.get(2)))) {
					ae.remove(j);
					data.remove(j);
				} else {
					j++;
				}
			}
		}
		if (lst.get(1).equals("4")) {
			for (int j = 0; j < ae.size();) {
				if (data.get(j).contains(lst.get(2))) {
					ae.remove(j);
					data.remove(j);
				} else {
					j++;
				}
			}
		}
		
		displayDetails(ae);
	}

	public static void main(String[] args) throws ScriptException {
		Employee[] e = new Employee[10];
		TestSolution t = new TestSolution(e);
		Scanner sc = new Scanner(System.in);
		String option;
		do {
			System.out.println();
			System.out
					.println("Enter Input\n1.Display Employee Details\n2.Query Employee Details\n3.Employee Hierarchy");
			option = sc.next();
			if (option.equals("1")) {
				System.out.println("Id Name Age Designation Department ReportingTo");
				for (int i = 0; i < e.length; i++) {
					t.displayEmployeeDetails(e[i]);
				}
			}
			if (option.equals("2")) {
				ArrayList<Employee> ae = new ArrayList<Employee>();
				for (int k = 0; k < e.length; k++) {
					ae.add(e[k]);
				}
				String op;
				String field;
				do {
					ArrayList<String> l = new ArrayList<String>();
					System.out.println("Enter Field Name OR Exit");
					field = sc.next();
					if (!field.equals("exit")) {
						l.add(field);
					}
					if (field.equals("age")) {
						System.out.println("1.>\n2.<\n3.!=");
						op = sc.next();
						System.out.println("Enter age:");
						String age = sc.next();
						l.add(op);
						l.add(age);
						t.queryIntegerDetails(ae, l);
					}
					if (field.equals("name") || field.equals("department") || field.equals("designation")) {
						System.out.println("1.startsWith\n2.contains\n3.endsWith\n4.notContains");
						op = sc.next();
						System.out.println("Enter string");
						String str = sc.next();
						l.add(op);
						l.add(str);
						t.queryStringDetails(ae, l);
					}
				} while (!field.equals("exit"));
			}
			if (option.equals("3")) {
				System.out.println("Enter Employee Name");
				String name = sc.next();
				t.employeeHierarchy(e, name);
			}
		} while (!option.equals("exit"));
		sc.close();

	}

}
