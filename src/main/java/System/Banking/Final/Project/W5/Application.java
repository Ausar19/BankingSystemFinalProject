package System.Banking.Final.Project.W5;

import System.Banking.Final.Project.W5.models.accounts.Checking;
import System.Banking.Final.Project.W5.models.accounts.CreditCard;
import System.Banking.Final.Project.W5.models.accounts.Savings;
import System.Banking.Final.Project.W5.models.accounts.StudentChecking;
import System.Banking.Final.Project.W5.models.addresses.Address;
import System.Banking.Final.Project.W5.models.users.AccountHolder;
import System.Banking.Final.Project.W5.models.users.Admin;
import System.Banking.Final.Project.W5.models.users.Role;
import System.Banking.Final.Project.W5.models.users.ThirdParty;
import System.Banking.Final.Project.W5.repository.accounts.*;
import System.Banking.Final.Project.W5.repository.users.AccountHolderRepository;
import System.Banking.Final.Project.W5.repository.users.AdminRepository;
import System.Banking.Final.Project.W5.repository.users.RoleRepository;
import System.Banking.Final.Project.W5.repository.users.ThirdPartyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.math.BigDecimal;
import java.time.LocalDate;

@SpringBootApplication
public class Application implements CommandLineRunner {

	//autowired a las accounts
	@Autowired
	AccountRepository accountRepository;

	@Autowired
	CheckingRepository checkingRepository;

	@Autowired
	CreditCardRepository creditCardRepository;

	@Autowired
	SavingsRepository savingsRepository;

	@Autowired
	StudentCheckingRepository studentCheckingRepository;

	@Autowired
	RoleRepository roleRepository;


	//autowired a los users

	@Autowired
	AccountHolderRepository accountHolderRepository;

	@Autowired
	AdminRepository adminRepository;

	@Autowired
	ThirdPartyRepository thirdPartyRepository;

	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}


	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		//I INSTANTIATED MANY ADDRESSES, ACCOUNTS, AND USERS TO MAKE THE TEST EASIER

		Address address1 = new Address("Bilbao", "España", 45264, 20, "Calle Pamplona");
		Address address2 = new Address("Barcelona", "España", 48961, 11, "Calle Zamora");
		Address address3 = new Address("Valencia", "España", 45645, 18, "Calle Kotlin");
		Address address4 = new Address("Madrid", "España", 985264, 61, "Calle Jamaica");
		Address address5 = new Address("Oporto", "Portugal", 49756, 72, "Calle Trotsky");
		Address address6 = new Address("Zaragoza", "España", 89744, 41, "Calle Fruu");

		AccountHolder user1 = new AccountHolder("paco4", passwordEncoder().encode("admin1234"), "Paco", LocalDate.of(1992, 1, 29), address1, address2);
		accountHolderRepository.save(user1);

		AccountHolder user2 = new AccountHolder("rodolfo12", passwordEncoder().encode("admin1234"), "Rodolfo", LocalDate.of(2000, 1, 29), address2);
		accountHolderRepository.save(user2);

		AccountHolder user3 = new AccountHolder("hassan52", passwordEncoder().encode("admin1234"), "Hassan", LocalDate.of(1998, 1, 29), address3);
		accountHolderRepository.save(user3);

		AccountHolder user4 = new AccountHolder("luka22", passwordEncoder().encode("admin1234"), "Luka", LocalDate.of(2005, 1, 29), address4);
		accountHolderRepository.save(user4);

		AccountHolder user5 = new AccountHolder("yakichan8", passwordEncoder().encode("admin1234"), "Yaki", LocalDate.of(2004, 1, 29), address5, address6);
		accountHolderRepository.save(user5);


		Checking checking1 = new Checking(new BigDecimal("2000.0"), user1, null, "pepepe888");
		checkingRepository.save(checking1);

		Checking checking2 = new Checking(new BigDecimal("500.0"), user2, null, "pepepe888");
		checkingRepository.save(checking2);

		Checking checking3 = new Checking(new BigDecimal("800.0"), user3, null, "pepepe888");
		checkingRepository.save(checking3);


		CreditCard creditCard1 = new CreditCard(new BigDecimal("1000.0"), user1, null, new BigDecimal("8000.0"), new BigDecimal("0.1"));
		creditCardRepository.save(creditCard1);

		CreditCard creditCard2 = new CreditCard(new BigDecimal("50.0"), user2, null, new BigDecimal("30.0"), new BigDecimal("0.2"));
		creditCardRepository.save(creditCard2);

		CreditCard creditCard3 = new CreditCard(new BigDecimal("40.0"), user3, null, new BigDecimal("700.0"), new BigDecimal("0.01"));
		creditCardRepository.save(creditCard3);

		CreditCard creditCard4 = new CreditCard(new BigDecimal("900.0"), user4, null, new BigDecimal("520000.50"), new BigDecimal("0.3"));
		creditCardRepository.save(creditCard4);


		Savings saving1 = new Savings(new BigDecimal("900.0"), user1, null, new BigDecimal("0.0025"), new BigDecimal("2000"), "sssssddd44");
		savingsRepository.save(saving1);

		Savings saving2 = new Savings(new BigDecimal("40.0"), user2, null, new BigDecimal("0.0025"), new BigDecimal("100"), "sssssddd44");
		savingsRepository.save(saving2);

		Savings saving3 = new Savings(new BigDecimal("8550.0"), user3, null, new BigDecimal("0.8"), new BigDecimal("350"), "sssssddd44");
		savingsRepository.save(saving3);

		Savings saving4 = new Savings(new BigDecimal("500.0"), user5, null, "sssssddd44");
		savingsRepository.save(saving4);


		StudentChecking student1 = new StudentChecking(new BigDecimal("500.0"), user4, user1, "sssssddd44");
		studentCheckingRepository.save(student1);

		StudentChecking student2 = new StudentChecking(new BigDecimal("40.0"), user1, null, "sssssddd44");
		studentCheckingRepository.save(student2);

		StudentChecking student3 = new StudentChecking(new BigDecimal("55500.0"), user2, null, "sssssddd44");
		studentCheckingRepository.save(student3);


		Admin admin1 = new Admin("admin1111", passwordEncoder().encode("contrasena88"), "Admin1");
		adminRepository.save(admin1);


		Role adminRole = new Role("ADMIN", admin1);
		roleRepository.save(adminRole);
		adminRepository.save(admin1);


		Role holderRole = new Role("ACCOUNT HOLDER", user1);
		roleRepository.save(holderRole);
		accountHolderRepository.save(user1);

		Role holderRole2 = new Role("ACCOUNT HOLDER", user2);
		roleRepository.save(holderRole2);
		accountHolderRepository.save(user2);

		Role holderRole3 = new Role("ACCOUNT HOLDER", user3);
		roleRepository.save(holderRole3);
		accountHolderRepository.save(user3);

		Role holderRole4 = new Role("ACCOUNT HOLDER", user4);
		roleRepository.save(holderRole4);
		accountHolderRepository.save(user4);

		ThirdParty thirdParty1 = new ThirdParty("thirdpartymember", passwordEncoder().encode("password"), 484646485L, "hashed");
		thirdPartyRepository.save(thirdParty1);

		Role thirdPartyRole = new Role("THIRD PARTY", thirdParty1);
		roleRepository.save(thirdPartyRole);
		thirdPartyRepository.save(thirdParty1);


	}
}
