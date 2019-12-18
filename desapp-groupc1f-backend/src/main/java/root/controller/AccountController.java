package root.controller;

import java.util.HashMap;
import java.util.Map;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import root.controller.exception.ResourceNotFoundException;
import root.controller.exception.UserInvalidException;
import root.model.Account;
import root.repository.AccountRepository;
import root.service.AccountService;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestParam;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1")
public class AccountController {
	
	@Autowired
	private AccountRepository accountRepository;
	@Autowired
    private AccountService accountService;	
	
	private static final Logger LOG = LoggerFactory.getLogger(AccountController.class);
	
	@GetMapping("/accounts")
	public ResponseEntity<Page<Account>> paginas(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(defaultValue = "name") String order,
            @RequestParam(defaultValue = "true") boolean asc
    ){
		Page<Account> account = accountService.paginas(
                PageRequest.of(page, size, Sort.by(order)));
        if(!asc)
        	account = accountService.paginas(
                    PageRequest.of(page, size, Sort.by(order).descending()));
        LOG.info("Successful access to the user list");
        return new ResponseEntity<Page<Account>>(account, HttpStatus.OK);
        
	}
	
	@PostMapping("/accounts")
	public Account createAccount(@Valid @RequestBody Account account) throws UserInvalidException {
		if (account.isValidAccount()) {
			LOG.info("User created: " + account.getUserName() + " through createAccount()");
			return accountRepository.save(account);
		} else throw new UserInvalidException("Usuario invalido");
	}
	
	@GetMapping("/accounts/{id}")
	public ResponseEntity<Account> getAccountById(@PathVariable(value = "id") Long accountId)
			throws ResourceNotFoundException {
		
		Account account = accountRepository.findById(accountId)
				.orElseThrow(() -> new ResourceNotFoundException("Account not found for this id :: " + accountId));
		LOG.info("getAccountById : SUCCESSFULL " + "id : " + accountId );
		return ResponseEntity.ok().body(account);
		
	}
	
	@PutMapping("/accounts/{id}")
	public ResponseEntity<Account> updateAccount(@PathVariable(value = "id") Long accountId,
			@Valid @RequestBody Account accountDetails) throws ResourceNotFoundException {
		Account account = accountRepository.findById(accountId)
				.orElseThrow(() -> new ResourceNotFoundException("Account not found for this id :: " + accountId));

		account.setSurname(accountDetails.getSurname());
		account.setName(accountDetails.getName());
		account.setEmail(accountDetails.getEmail());
		account.setPhone(accountDetails.getPhone());
		account.setLocation(accountDetails.getLocation());
		account.setDirection(accountDetails.getDirection());
		final Account updatedAccount = accountRepository.save(account);
		LOG.info("updateAccount : SUCCESSFULL " + account.getUserName() + " ID:" + accountId);
		return ResponseEntity.ok(updatedAccount);
	}
	
	@DeleteMapping("/accounts/{id}")
	public Map<String, Boolean> deleteAccount(@PathVariable(value = "id") Long accountId)
			throws ResourceNotFoundException {
		Account account = accountRepository.findById(accountId)
				.orElseThrow(() -> new ResourceNotFoundException("Account not found for this id :: " + accountId));

		accountRepository.delete(account);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		LOG.info("deleteAccount : SUCCESSFULL " + account.getSurname() + " ID: " + accountId);
		return response;
	}
}
