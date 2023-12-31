package pkgUT;

import org.apache.poi.ss.formula.functions.*;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import pkgLogic.Loan;

public class TestPMT {

	@Test
	public void TestPMT() {

		double PMT;
		double r = 0.07 / 12;
		double n = 20 * 12;
		double p = 150000;
		double f = 0;
		boolean t = false;
		PMT = Math.abs(FinanceLib.pmt(r, n, p, f, t));
		double PMTExpected = 1162.95;
		assertEquals(PMTExpected, PMT, 0.01);
	}

	@Test
	public void TestLoanWithNoExtraPayment() {

		double dLoanAmount = 50000;
		double dInterestRate = 0.07;
		int iNbrOfYears = 20;
		LocalDate localDate = LocalDate.now();
		double dAdditionalPayment = 0;
		double dEscrow = 0;

		Loan loan = new Loan(dLoanAmount, dInterestRate, iNbrOfYears, localDate, dAdditionalPayment, dEscrow);
		

		 System.out.println("Number of Payments: " + loan.getLoanPayments().size());
		 System.out.println("Total Payments: " + loan.getTotalPayments());
		 System.out.println("Total Interest: " + loan.getTotalInterest());

		 assertTrue(loan.getLoanPayments().size() == 240);
		 assertEquals(loan.getTotalPayments(), 93035.87, 0.01);
		 assertEquals(loan.getTotalInterest(), 43035.87, 0.01);
		
		
		
	}
		


	@Test
	public void TestLoanWithExtraPayment() {

		double dLoanAmount = 50000;
		double dInterestRate = 0.07;
		int iNbrOfYears = 20;
		LocalDate localDate = LocalDate.now();
		double dAdditionalPayment = 200;
		double dEscrow = 0;

		Loan loan = new Loan(dLoanAmount, dInterestRate, iNbrOfYears, localDate, dAdditionalPayment, dEscrow);

		
		assertEquals(loan.getTotalPayments(), 69342.64, 0.01);
		assertEquals(loan.getTotalInterest(), 19291.83, 0.01);
		assertEquals(loan.getAdditionalPayment(), 200.00, 0.01);
		 

	}
}

