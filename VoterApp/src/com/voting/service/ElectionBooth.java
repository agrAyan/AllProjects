package com.voting.service;

import com.voting.exceptions.*;

public class ElectionBooth {
	String localities[] = { "ABC Nagar", "XYZ Nagar", "RK Nagar" };

	// if age is less than 18 throw exception
	public boolean checkAge(int age) throws UnderAgeException {

		if (age < 18)
			throw new UnderAgeException("under 18 cannt cast vote");
		else
			return true;

	}

	// check if the locality matches with the array
	public boolean checkLocality(String locality) throws LocalityNotFoundException {
		boolean check = false;
		for (String l : localities) {
			if (l.equals(locality)) {
				check = true;
			}

		}
		if (check)
			return true;
		else
			throw new LocalityNotFoundException("locality not found");
	}

	
	// check if id is within 1000 - 9000
	public boolean checkVoterId(int vid) throws NoVoterIDException {
		if (vid < 1000 || vid > 9000)
			throw new NoVoterIDException("enter valid voter ID");
		else
			return true;
	}

	
	public boolean checkEligibility(int age, String locality, int vid) throws NotEligibleException {
		{
			try {
				boolean check = checkAge(age);
				if (check) {
					boolean checkLocality = checkLocality(locality);
					if (checkLocality) {
						boolean checkvid = checkVoterId(vid);
						if (checkvid)
							return true;

					}

				}

			} catch (UnderAgeException e) {
				// e.printStackTrace();
				throw new UnderAgeException("under 18 cannot cast vote");

			} catch (LocalityNotFoundException e) {
				// e.printStackTrace();
				throw new UnderAgeException("Locality not found. ");

			} catch (NoVoterIDException e) {
				// e.printStackTrace();
				throw new UnderAgeException("enter valid voter ID. Try Again");

			} catch (NotEligibleException e) {
				throw new NotEligibleException("any other exception");
			}
			return false;

		}

	}
}
