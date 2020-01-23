package net.osgg.restcrud;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
 
import net.osgg.restcrud.EmployeeEntity;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long> {
	List<EmployeeEntity> findByEmailContaining(String email);
	Optional <EmployeeEntity> findById(UUID id);
	@Transactional
	@Modifying
	@Query("DELETE from EmployeeEntity e WHERE e.id = ?1")
	void deleteById(UUID id);
}
