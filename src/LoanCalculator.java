import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoanCalculator extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtInterestRate;
	private JTextField txtNumberOfYears;
	private JTextField txtLoanAmount;
	private JTextField txtMonthlyPayment;
	private JTextField txtTotalPayment;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoanCalculator frame = new LoanCalculator();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LoanCalculator() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblInterestRate = new JLabel("Annual Interest Rate:");
		lblInterestRate.setBounds(20, 20, 138, 16);
		contentPane.add(lblInterestRate);
		
		JLabel lblNumberOfYears = new JLabel("Number of Years:");
		lblNumberOfYears.setBounds(20, 50, 130, 16);
		contentPane.add(lblNumberOfYears);
		
		JLabel lblLoanAmount = new JLabel("Loan Amount:");
		lblLoanAmount.setBounds(20, 78, 138, 16);
		contentPane.add(lblLoanAmount);
		
		JLabel lblMonthlyPayment = new JLabel("Monthly Payment:");
		lblMonthlyPayment.setBounds(20, 106, 138, 16);
		contentPane.add(lblMonthlyPayment);
		
		JLabel lblTotalPayment = new JLabel("Total Payment:");
		lblTotalPayment.setBounds(20, 134, 138, 16);
		contentPane.add(lblTotalPayment);
		
		txtInterestRate = new JTextField();
		txtInterestRate.setBounds(162, 15, 130, 26);
		contentPane.add(txtInterestRate);
		txtInterestRate.setColumns(10);
		
		txtNumberOfYears = new JTextField();
		txtNumberOfYears.setBounds(162, 45, 130, 26);
		contentPane.add(txtNumberOfYears);
		txtNumberOfYears.setColumns(10);
		
		txtLoanAmount = new JTextField();
		txtLoanAmount.setBounds(162, 73, 130, 26);
		contentPane.add(txtLoanAmount);
		txtLoanAmount.setColumns(10);
		
		txtMonthlyPayment = new JTextField();
		txtMonthlyPayment.setBounds(162, 101, 130, 26);
		contentPane.add(txtMonthlyPayment);
		txtMonthlyPayment.setColumns(10);
		
		txtTotalPayment = new JTextField();
		txtTotalPayment.setBounds(162, 129, 130, 26);
		contentPane.add(txtTotalPayment);
		txtTotalPayment.setColumns(10);
		
		JButton btnCalculate = new JButton("Calculate");
		btnCalculate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
			   double interestRate = ( ( (Double.parseDouble(txtInterestRate.getText())) / 100 ) / 12 );
			   double months = ( Double.parseDouble(txtNumberOfYears.getText()) * 12 );
			   double amount = Double.parseDouble(txtLoanAmount.getText());
			   
			   double payment = (interestRate * amount) / (1 - Math.pow((1 + interestRate) , -(months)));
			   
			   String displayPayment = String.format("%.2f", payment);
			   
			   txtMonthlyPayment.setText(displayPayment);
			   
			   double totalPayment = payment * months;
			   
			   String displayTotalPayment = String.format("%.2f", totalPayment);
			   
			   txtTotalPayment.setText(displayTotalPayment);
				
			}
		});
		btnCalculate.setBounds(175, 167, 117, 29);
		contentPane.add(btnCalculate);
	}
}
