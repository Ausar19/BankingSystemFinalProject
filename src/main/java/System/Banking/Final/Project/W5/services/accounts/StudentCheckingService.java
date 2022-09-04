package System.Banking.Final.Project.W5.services.accounts;

import System.Banking.Final.Project.W5.models.accounts.StudentChecking;
import System.Banking.Final.Project.W5.repository.accounts.StudentCheckingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentCheckingService {


    @Autowired
    StudentCheckingRepository studentCheckingRepository;

    public List<StudentChecking> allStudentAccounts() {
        return studentCheckingRepository.findAll();
    }


}
