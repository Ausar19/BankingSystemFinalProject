package System.Banking.Final.Project.W5.controller;


import System.Banking.Final.Project.W5.dto.AccountDTO;
import System.Banking.Final.Project.W5.models.accounts.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;


@RestController
public class AccountHolderController {

    @Autowired
    AccountService accountService;

    //========================================POSTMAPPING========================================//


    @PostMapping("/create-account-one-holder")
    @ResponseStatus(HttpStatus.CREATED)
    public Account createAccount(@RequestBody AccountDTO accountDTO, @RequestParam Long holderId) {

        return accountService.createAccount(accountDTO, holderId);
    }


    @PostMapping("/create-account-two-holders")
    @ResponseStatus(HttpStatus.CREATED)
    public Account createAccountTwoHolders(@RequestBody AccountDTO accountDTO, @RequestParam Long holderId, @RequestParam Long secondaryHolderId) {

        return accountService.createAccountTwoHolders(accountDTO, holderId, secondaryHolderId);
    }


    //========================================GETMAPPING========================================//


    @GetMapping("/all-accounts")
    @ResponseStatus(HttpStatus.OK)
    public List<Account> allAccounts() {

        return accountService.allAccounts();
    }


    @GetMapping("/my-balance")
    @ResponseStatus(HttpStatus.OK)
    public BigDecimal checkMyBalance(@AuthenticationPrincipal UserDetails userDetails, @RequestParam Long accountId) {

        return accountService.checkMyBalance(userDetails.getUsername(), accountId);
    }


    @GetMapping("/admin-check-balance")
    @ResponseStatus(HttpStatus.OK)
    public BigDecimal checkBalanceAdmin(@RequestParam Long id) {

        return accountService.checkBalanceAdmin(id);
    }


    //========================================PATCHMAPPING========================================//


    @PatchMapping("/admin-change-balance")
    @ResponseStatus(HttpStatus.OK)
    public Account changeBalanceAdmin(@RequestParam Long accountId, BigDecimal newBalance) {

        return accountService.changeBalanceAdmin(accountId, newBalance);
    }


    //========================================DELETEMAPPING========================================//


    @DeleteMapping("/delete-account/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public String deleteAccount(@PathVariable Long id){

        return accountService.deleteAccount(id);
    }


    //========================================PUTMAPPING========================================//


    @PutMapping("/new-transfer")
    @ResponseStatus(HttpStatus.OK)
    public String transferMoney(@AuthenticationPrincipal UserDetails userDetails,
                                @RequestParam Long sendingId,
                                @RequestParam BigDecimal amount,
                                @RequestParam Long receiveId){

        return accountService.newTransfer(userDetails, sendingId, amount, receiveId);
    }


    @PutMapping("/third-party-transfer")
    @ResponseStatus(HttpStatus.OK)
    public String transferThirdParty(@RequestHeader String hashedKey,
                                     @RequestParam Long sendingAccountId,
                                     @RequestParam BigDecimal amount,
                                     @RequestParam Long receiveAccountId,
                                     @RequestParam String secretKeySendingAccount){

        return accountService.transferThirdParty(hashedKey, sendingAccountId, amount, receiveAccountId, secretKeySendingAccount);
    }

    @PutMapping("/transfer") // solo admin -- OK
    @ResponseStatus(HttpStatus.OK)
    public String transferMoney(@RequestParam String senderName,
                                @RequestParam Long senderId,
                                @RequestParam BigDecimal amount,
                                @RequestParam Long receiveId){

        return accountService.transfer(senderName, senderId, amount, receiveId);
    }


}
