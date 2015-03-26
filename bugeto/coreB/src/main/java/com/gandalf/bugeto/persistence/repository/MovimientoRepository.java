package com.gandalf.bugeto.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.gandalf.bugeto.persistence.domain.MovCategory;
import com.gandalf.bugeto.persistence.domain.MovType;
import com.gandalf.bugeto.persistence.domain.Movimiento;
import com.gandalf.bugeto.persistence.domain.User;

public interface MovimientoRepository extends PagingAndSortingRepository<Movimiento, Long>, MovimientoRepositoryCustom {

	@Query("from Movimiento")
	public List<Movimiento> findAllMovimientos();

	@Query("from Movimiento where user = ?1")
	public List<Movimiento> findMovimientosByUser(User user);

	@Query("from MovCategory")
	public List<MovCategory> findAllMovCategory();

	@Query("from MovCategory where catId = ?1")
	public MovCategory findMovCategoryBycatId(Long catId);

	@Query("from MovCategory where movType = ?1")
	public List<MovCategory> findAllMovCategoryByMovType(MovType movType);

	@Query("from MovType")
	public List<MovType> findAllMovType();

}
