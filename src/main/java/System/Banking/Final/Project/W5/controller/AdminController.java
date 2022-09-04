package System.Banking.Final.Project.W5.controller;


import System.Banking.Final.Project.W5.dto.AccountHolderDTO;
import System.Banking.Final.Project.W5.models.users.AccountHolder;
import System.Banking.Final.Project.W5.services.users.AccountHolderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class AdminController {

    @Autowired
    AccountHolderService accountHolderService;

    @PostMapping("/create-holder")
    @ResponseStatus(HttpStatus.CREATED)
    public AccountHolder createAccountHolder(@RequestBody AccountHolderDTO accountHolderDTO) {

        return accountHolderService.createAccountHolder(accountHolderDTO);
    }





}
