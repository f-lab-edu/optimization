package flab.optimization.repository;

import flab.optimization.entity.Sangga;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface SanggaRepository extends JpaRepository<Sangga, Long>, SanggaRepositoryCustom {
    Page<Sangga> findSanggaByNameContaining(String name, Pageable pageable);

    @Query("select s" +
            " from Sangga s" +
            " join fetch s.bigClassificationName" +
            " join fetch s.mediumClassificationName" +
            " join fetch s.smallClassificationName" +
            " where s.name like %:name%")
    Page<Sangga> findSanggaByNameContainingV2(@Param("name") String name, Pageable pageable);

    @Override
    Page<Sangga> findSanggaByNameContainingV3(String name, Pageable pageable);
}
