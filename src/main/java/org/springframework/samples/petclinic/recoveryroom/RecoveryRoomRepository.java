package org.springframework.samples.petclinic.recoveryroom;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface RecoveryRoomRepository extends CrudRepository<RecoveryRoom, Integer>{

    List<RecoveryRoom> findAll();

    @Query("select rt from RecoveryRoomType rt")
    List<RecoveryRoomType> findAllRecoveryRoomTypes();

    Optional<RecoveryRoom> findById(int id);

    RecoveryRoom save(RecoveryRoom p);

    @Query("select rt from RecoveryRoomType rt where rt.name = ?1")
    RecoveryRoomType getRecoveryRoomType(String name);

    @Query("select rr from RecoveryRoom rr where rr.size > ?1")
    List<RecoveryRoom> findBySizeMoreThan(double size);
}
