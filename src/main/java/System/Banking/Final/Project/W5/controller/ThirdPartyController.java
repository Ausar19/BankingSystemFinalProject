package System.Banking.Final.Project.W5.controller;


import System.Banking.Final.Project.W5.dto.ThirdPartyDTO;
import System.Banking.Final.Project.W5.models.users.ThirdParty;
import System.Banking.Final.Project.W5.services.users.ThirdPartyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ThirdPartyController {


    @Autowired
    ThirdPartyService thirdPartyService;


    @PostMapping("/create-third-party")
    @ResponseStatus(HttpStatus.CREATED)
    public ThirdParty createThirdParty(@RequestBody ThirdPartyDTO thirdPartyDTO) {

        return thirdPartyService.createThirdParty(thirdPartyDTO);
    }


}
