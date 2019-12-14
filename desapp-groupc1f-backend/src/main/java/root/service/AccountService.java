package root.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import root.model.Account;
import root.repository.AccountRepository;
@Service
@Transactional
public class AccountService {
	 	
		@Autowired
	    private AccountRepository accountRepository;
				
	    public Page<Account> paginas(Pageable pageable){
	        return accountRepository.findAll(pageable);
	    }
}
