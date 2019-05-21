package leetcode.algorithms;

import leetcode.entity.Employee;

import java.util.*;

/**
 * Description: 690. Employee Importance
 *
 * @author Baltan
 * @date 2017/12/30 10:37
 */
public class GetImportance {
    public static void main(String[] args) {
        Employee e1 = new Employee();
        e1.id = 1;
        e1.importance = 5;
        List<Integer> list1 = new ArrayList<>();
        list1.add(2);
        list1.add(3);
        e1.subordinates = list1;
        Employee e2 = new Employee();
        e2.id = 2;
        e2.importance = 3;
        List<Integer> list2 = new ArrayList<>();
        e2.subordinates = list2;
        Employee e3 = new Employee();
        e3.id = 3;
        e3.importance = 3;
        List<Integer> list3 = new ArrayList<>();
        e3.subordinates = list3;
        List<Employee> employees = new ArrayList<>();
        employees.add(e1);
        employees.add(e2);
        employees.add(e3);
        System.out.println(getImportance(employees, 1));
    }

    public static int getImportance(List<Employee> employees, int id) {
        int totalImportanceValue = 0;
        Map<Integer, Employee> employeeMap = new HashMap<>();
        Stack<Employee> stack = new Stack<>();
        for (int i = 0; i < employees.size(); i++) {
            Employee employee = employees.get(i);
            employeeMap.put(employee.id, employee);
        }
        stack.push(employeeMap.get(id));
        while (!stack.isEmpty()) {
            Employee currEmployee = stack.pop();
            totalImportanceValue += currEmployee.importance;
            List<Integer> subordinates = currEmployee.subordinates;
            for (int i = 0; i < subordinates.size(); i++) {
                stack.push(employeeMap.get(subordinates.get(i)));
            }
        }
        return totalImportanceValue;
    }
}