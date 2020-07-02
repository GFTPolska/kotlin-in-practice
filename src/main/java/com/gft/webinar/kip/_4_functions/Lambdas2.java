package com.gft.webinar.kip._4_functions;

import com.gft.webinar.kip.Employee;

import java.util.function.Predicate;

public class Lambdas2 {

    public static final Predicate<Employee> EP_1 = Lambdas.EP_1;
    public static final Predicate<Employee> EP_2 = Employee::isTopPerformer;
    public static final Predicate<Employee> EP_3 = employee -> true;

}
