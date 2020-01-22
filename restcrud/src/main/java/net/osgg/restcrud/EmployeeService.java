package net.osgg.restcrud;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
import net.osgg.restcrud.EmployeeEntity;
import net.osgg.restcrud.RecordNotFoundException;
import net.osgg.restcrud.EmployeeRepository;

@Service
public class EmployeeService {
	@Autowired
    EmployeeRepository repository;
     
    public List<EmployeeEntity> getAllEmployees(){
        List<EmployeeEntity> employeeList = repository.findAll();
         
        if(employeeList.size() > 0) {
            return employeeList;
        } else {
            return new ArrayList<EmployeeEntity>();
        }
    }

    public List<EmployeeEntity> getEmployeesByEmailContaining(String email){
        List<EmployeeEntity> employeeList = repository.findByEmailContaining(email);
         
        if(employeeList.size() > 0) {
            return employeeList;
        } else {
            return new ArrayList<EmployeeEntity>();
        }
    }
    
    public EmployeeEntity getEmployeeById(Long id) throws RecordNotFoundException{
        Optional<EmployeeEntity> employee = repository.findById(id);
         
        if(employee.isPresent()) {
            return employee.get();
        } else {
        	throw new RecordNotFoundException("Record does not exist for the given Id");
        }
    }
     
    public EmployeeEntity createEmployee(EmployeeEntity entity){
          entity = repository.save(entity);
          return entity;
    } 

    public EmployeeEntity updateEmployee(EmployeeEntity entity) throws RecordNotFoundException 
    {
        Optional<EmployeeEntity> employee = repository.findById(entity.getId());
         
        if(employee.isPresent()){
            return repository.save(entity);
        } else {
        	throw new RecordNotFoundException("Record does not exist for the given Id");
        }
    } 
    
    public void deleteEmployeeById(Long id) throws RecordNotFoundException{
        Optional<EmployeeEntity> employee = repository.findById(id);
         
        if(employee.isPresent()) {
            repository.deleteById(id);
        } else {
            throw new RecordNotFoundException("Record does not exist for the given Id");
        }
    } 
}
