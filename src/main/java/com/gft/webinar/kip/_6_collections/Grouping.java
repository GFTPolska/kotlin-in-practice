package com.gft.webinar.kip._6_collections;

import com.gft.webinar.kip.Department;
import com.gft.webinar.kip.Employee;
import com.gft.webinar.kip.util.EmployeesProvider;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Grouping {

    public static void main(String[] args) {
        highestPaidEmployees(EmployeesProvider.INSTANCE.getEmployees()).forEach(((department, employee) -> {
            System.out.println("""
                %s: %s %s - %s"""
                .stripIndent()
                .formatted(department.getName(), employee.getFirstName(), employee.getLastName(), employee.getSalary())
            );
        }));

        System.out.println(totalSalaryPerDepartment(EmployeesProvider.INSTANCE.getEmployees()));
    }

    public static Map<Department, Employee> highestPaidEmployees(List<Employee> employees) {
        return employees.stream()
            .collect(Collectors.toMap(
                Employee::getDepartment,
                Function.identity(),
                BinaryOperator.maxBy(Comparator.comparingDouble(Employee::getSalary))
            ));
    }

    public static Map<Department, Double> totalSalaryPerDepartment(List<Employee> employees) {
        return employees.stream()
            .collect(Collectors.groupingBy(
                Employee::getDepartment,
                Collectors.summingDouble(Employee::getSalary)
            ));
    }

}
