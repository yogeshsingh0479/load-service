package load_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import load_service.entity.LoadData;

public interface LoadRepository extends JpaRepository<LoadData, Long>{

}
