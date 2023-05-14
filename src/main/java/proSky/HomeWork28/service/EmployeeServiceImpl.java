package proSky.HomeWork28.service;

import org.springframework.stereotype.Service;
import proSky.HomeWork28.exception.EmployeeAlreadyAddedException;
import proSky.HomeWork28.exception.EmployeeNotFoundException;
import proSky.HomeWork28.model.Employee;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Service

public class EmployeeServiceImpl implements EmployeeService {
    private final Map<String, Employee> employees;
    public EmployeeServiceImpl() {
        this.employees = new HashMap<>();
        add("Ivan","Ivanov");
        add("Semen","Semenov");
        add("Andrey","Andreev");
        add("Ilaa","Ilin");
        add("Aleksey","Alekseev");
        add("Sergey","Sergeev");
        add("Petr","Petrov");
        add("Egor","Egorov");}
    @Override
    public Employee add(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employees.containsKey(employee.getFullName()))
            throw new EmployeeAlreadyAddedException(employee);
        employees.put(employee.getFullName() ,employee);
        return employee;}
    @Override
    public Employee remove(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (!employees.containsKey(employee.getFullName()))
            throw new EmployeeNotFoundException(employee);
        employees.remove(employee.getFullName());
        return employee;
    }

    @Override
    public Employee find(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (!employees.containsKey(employee.getFullName())){
            throw new EmployeeNotFoundException(employee);}
        return employee;
    }

    @Override
    public Collection<Employee>findAll() {
        return employees.values();
    }
}
