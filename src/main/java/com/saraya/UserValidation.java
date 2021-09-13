package com.saraya;

import org.springframework.stereotype.Service;



@Service
public class UserValidation {
	


		public boolean isValid(String user, String pass) {
			return user.equalsIgnoreCase("laye") &&
					pass.equals("secret");
		}
		
	}


