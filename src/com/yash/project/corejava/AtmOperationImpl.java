package com.yash.project.corejava;

import java.util.HashMap;
import java.util.Map;

public class AtmOperationImpl implements AtmOperationInterf {
	ATM atm=new ATM();
    Map<Double,String> mStatement=new HashMap<>();
    @Override
    public void viewBalance() {
        System.out.println("Available Balance is : "+atm.getBalance());

    }

    @Override
    public void withdrawAmount(double withdrawAmount) {
        if(withdrawAmount%100==0) {
            if (withdrawAmount <= atm.getBalance()) {
            	mStatement.put(withdrawAmount, " Amount Withdrawn");
                System.out.println("Collect the Cash " + withdrawAmount);
                atm.setBalance(atm.getBalance() - withdrawAmount);
                viewBalance();
            } else {
                System.out.println("Insufficient Balance !!");
            }
        }
        else {
            System.out.println("Please enter the amount in multipal of 100");
        }

    }

    @Override
    public void depositAmount(double depositAmount) {
    	mStatement.put(depositAmount," Amount Deposited");
        System.out.println(depositAmount+" Deposited Successfully !!");
        atm.setBalance(atm.getBalance()+depositAmount);
        viewBalance();

    }

    @Override
    public void viewMiniStatement() {
    	
    	mStatement.forEach((k,v)->System.out.println((k+" "+v)));
    	
//        for(Map.Entry<Double,String> m:ministmt.entrySet()){
//            System.out.println(m.getKey()+""+m.getValue());
//        }

    }
}
