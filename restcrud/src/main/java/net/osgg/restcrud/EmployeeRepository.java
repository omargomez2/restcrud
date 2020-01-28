package net.osgg.restcrud;

import net.osgg.restcrud.EmployeeEntity;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

import java.util.Date;

import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;


@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long> {
	
	List<EmployeeEntity> findByEmailContaining(String email);
	
	Optional <EmployeeEntity> findById(UUID id);
	
	@Transactional
	@Modifying
	@Query("DELETE from EmployeeEntity e WHERE e.id = ?1")
	void deleteById(UUID id);
	
	List<EmployeeEntity> findAllByDate(Date date);
}
