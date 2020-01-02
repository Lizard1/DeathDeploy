package hibernate.service;

import hibernate.dao.serv.AccountDao;
import hibernate.service.serv.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import hibernate.model.Account;

import java.util.List;


@Service
public class AccountServiceImpl implements AccountService, Runnable {

    @Autowired
    private AccountDao accountDao;

    @Override
    @Transactional
    public List<Account> getAllAccounts() {
        return accountDao.findAllAccounts();
    }

    @Override
    @Transactional
    public Account getAccountById(int id) {
        return accountDao.findAccountById(id);
    }

    @Override
    public void run() {


    }
}
