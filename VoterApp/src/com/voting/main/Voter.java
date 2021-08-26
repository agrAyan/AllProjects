package com.voting.main;

import java.util.Scanner;

import com.voting.exceptions.LocalityNotFoundException;
import com.voting.exceptions.NoVoterIDException;
import com.voting.exceptions.NotEligibleException;
import com.voting.exceptions.UnderAgeException;
import com.voting.service.ElectionBooth;

public class Voter {

	public static void main(String[] args) throws NotEligibleException {
		ElectionBooth booth = new ElectionBooth();
		Scanner kb = new Scanner(System.in);
		boolean eligible;

		try {
			System.out.println("enter age ");
			int age = kb.nextInt();
			boolean checkAge = booth.checkAge(age);
			if (checkAge) {
				System.out.println("enter locality ");
				kb.nextLine();
				String locality = kb.nextLine();
				boolean checkLocality = booth.checkLocality(locality);
				if (checkLocality) {
					System.out.println("enter voter id ");
					int vid = kb.nextInt();
					boolean checkVid = booth.checkVoterId(vid);
					if (checkVid) {
						eligible = booth.checkEligibility(age, locality, vid);
						if (eligible)
							System.out.println("you are eligible for vote");
					}
				}
			}
		} catch (UnderAgeException e) {
			System.out.println(e.getMessage());

		} catch (LocalityNotFoundException e) {
			System.out.println(e.getMessage());

		} catch (NoVoterIDException e) {
			System.out.println(e.getMessage());

		} catch (NotEligibleException e) {
			System.out.println(e.getMessage());
		}

	}

}
