package com.thecodeveal.app.repo;

import java.util.*;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.thecodeveal.app.model.BankDetails;

@Repository
public interface BankDetailsRepository extends JpaRepository<BankDetails, Long> {
	@Query(value="Select * from AUTH_USER_DETAILS u JOIN BANK_DETAILS b where u.bank_details_id=b.id and u.user_name=?1", nativeQuery=true)
	BankDetails findByUsername(String username);
//	List<BankDetails> deleteByUsername(String username);
	List<BankDetails> findAll();
}