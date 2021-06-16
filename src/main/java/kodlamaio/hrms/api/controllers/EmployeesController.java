package kodlamaio.hrms.api.controllers;

import kodlamaio.hrms.business.abstracts.EmployeeService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Employee;
import kodlamaio.hrms.entities.dtos.EmployeeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/employees")
public class EmployeesController
{
    private final EmployeeService employeeService;

    @Autowired
    public EmployeesController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/get-all")
    public DataResult<List<Employee>> getAll() {
        return this.employeeService.getAll();
    }

    @PostMapping("/add")
    public Result add(@RequestBody EmployeeDto employeeDto) {
        return this.employeeService.add(employeeDto);
    }
}
