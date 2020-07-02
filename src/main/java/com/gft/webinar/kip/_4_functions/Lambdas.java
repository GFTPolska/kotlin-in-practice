package com.gft.webinar.kip._4_functions;

import com.gft.webinar.kip.Employee;

import java.util.function.Predicate;

public class Lambdas {

    public static final Predicate<Employee> EP_1 = Employee::isTopPerformer;
    public static final Predicate<Employee> EP_2 = Employee::isTopPerformer;

}
