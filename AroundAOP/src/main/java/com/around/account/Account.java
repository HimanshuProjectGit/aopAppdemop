package com.around.account;

import org.springframework.stereotype.Service;

@Service
public class Account {
	
	public Integer deposit(Integer balance, Integer b) {
		System.out.println("Around advice deposit: Rs."+balance);
		return 1000+balance;
	}

}
