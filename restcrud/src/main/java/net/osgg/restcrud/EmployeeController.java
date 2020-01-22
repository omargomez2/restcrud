package net.osgg.restcrud;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
 
import net.osgg.restcrud.EmployeeEntity;
import net.osgg.restcrud.RecordNotFoundException;
import net.osgg.restcrud.EmployeeService;
 
@RestController
@RequestMapping("/api/v1")
public class EmployeeController {
	@Autowired
    EmployeeService service;
 
    @GetMapping("/employees")
    public ResponseEntity<List<EmployeeEntity>> getAllEmployees() {
        List<EmployeeEntity> list = service.getAllEmployees();
        return new ResponseEntity<List<EmployeeEntity>>(list, new HttpHeaders(), HttpStatus.OK);
    }
 
    @GetMapping("/employees/{id}")
    public ResponseEntity<EmployeeEntity> getEmployeeById(@PathVariable("id") Long id) 
                                                    throws RecordNotFoundException {
        EmployeeEntity entity = service.getEmployeeById(id);
        return new ResponseEntity<EmployeeEntity>(entity, new HttpHeaders(), HttpStatus.OK);
    }
    
    @GetMapping("/employees/findbyemail/{email}")
    public ResponseEntity<List<EmployeeEntity>> getEmployeeById(@PathVariable("email") String email) {
    	List<EmployeeEntity> list = service.getEmployeesByEmailContaining(email);
        return new ResponseEntity<List<EmployeeEntity>>(list, new HttpHeaders(), HttpStatus.OK);
    }    
 
    @PostMapping("/employees")
    public ResponseEntity<EmployeeEntity> createOrUpdateEmployee(@RequestBody EmployeeEntity employee){
        EmployeeEntity newed = service.createEmployee(employee);
        return new ResponseEntity<EmployeeEntity>(newed, new HttpHeaders(), HttpStatus.OK);
    }    
    
    @PutMapping("/employees")
    public ResponseEntity<EmployeeEntity> updateEmployee(@RequestBody EmployeeEntity employee) 
    															throws RecordNotFoundException{
    	EmployeeEntity updated = service.updateEmployee(employee);
        return new ResponseEntity<EmployeeEntity>(updated, new HttpHeaders(), HttpStatus.OK);
    }    
    
 
    @DeleteMapping("/employees/{id}")
    public HttpStatus deleteEmployeeById(@PathVariable("id") Long id) 
                                                    throws RecordNotFoundException {
        service.deleteEmployeeById(id);
        return HttpStatus.OK;
    }
}
