import javax.swing.*;

import javafx.event.ActionEvent;

import java.awt.*;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UserInterface extends JFrame {
    private Account userAccount = new Account(); 

    public JLabel lblTitle = new JLabel("Bank Transaction System");
    public JLabel lblType = new JLabel("Type:");
    public JLabel lblAmount = new JLabel("Amount:");
    public JLabel lblDescription = new JLabel("Description:");
    public JLabel lblDisplayAmountLabel = new JLabel("Current Balance: ");
    public JLabel lblDisplayAmount = new JLabel("");
    public JTextField txtAmount = new JTextField(5);
    public JTextField txtDescription = new JTextField(15);
    public JRadioButton rdbDeposit = new JRadioButton("Deposit", true);
    public JRadioButton rdbWithdrawal = new JRadioButton("Withdrawal");
    public JRadioButton rdbMiscellaneous = new JRadioButton("Miscellaneous"); 
    public ButtonGroup transactionOptions = new ButtonGroup();
    public JButton btnSave = new JButton("Save");
    public JTextArea transactionList = new JTextArea("Transaction History:\n", 20, 65);
    public JScrollPane scrollableTransactionList = new JScrollPane(transactionList, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
    

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public static void main(String[] args) {
            new UserInterface();
        }

        UserInterface() {
        NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance();

        //set up the frame
        this.setTitle("Lab 11 - Bank Transaction GUI");
        this.setDefaultCloseOperation((JFrame.EXIT_ON_CLOSE));
        this.setSize(800,800);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        
        //set up header panel
        JPanel headerPanel = new JPanel();
        headerPanel.add(lblTitle);
        headerPanel.setFont(new Font("Verdana", Font.BOLD, 18));

        //set up body panel
        JPanel bodyPanel = new JPanel();
        JPanel transactionTypePanel = new JPanel();
        JPanel infoEntryPanel = new JPanel();
        JPanel amountEntryPanel = new JPanel();
        JPanel descriptionEntryPanel = new JPanel();
        JPanel transactionResultsPanel = new JPanel();
        transactionOptions.add(rdbDeposit);
        transactionOptions.add(rdbWithdrawal);
        transactionOptions.add(rdbMiscellaneous);
        transactionTypePanel.add(lblType);
        transactionTypePanel.add(rdbDeposit);
        transactionTypePanel.add(rdbWithdrawal);
        transactionTypePanel.add(rdbMiscellaneous);
        amountEntryPanel.add(lblAmount);
        amountEntryPanel.add(txtAmount);
        descriptionEntryPanel.add(lblDescription);
        descriptionEntryPanel.add(txtDescription);
        infoEntryPanel.add(amountEntryPanel);
        infoEntryPanel.add(descriptionEntryPanel);
        infoEntryPanel.add(btnSave);
        infoEntryPanel.setLayout(new BoxLayout(infoEntryPanel,BoxLayout.Y_AXIS));
        lblDisplayAmount.setText(currencyFormatter.format(userAccount.getBalance()));
        transactionResultsPanel.add(lblDisplayAmountLabel);
        transactionResultsPanel.add(lblDisplayAmount);
        bodyPanel.add(transactionTypePanel);
        bodyPanel.add(infoEntryPanel);
        bodyPanel.add(transactionResultsPanel);
        bodyPanel.setLayout(new BoxLayout(bodyPanel,BoxLayout.Y_AXIS));

        //est up footer panel
        JPanel footerPanel = new JPanel();
        transactionList.setEditable(false);
        footerPanel.add(scrollableTransactionList);

        //set up button action
        btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
                try {
                    if (rdbDeposit.isSelected()) {
                        userAccount.deposit(BigDecimal.valueOf(Double.parseDouble(txtAmount.getText())), txtDescription.getText());
                    } else if (rdbWithdrawal.isSelected()) {
                        userAccount.withdrawal(BigDecimal.valueOf(Double.parseDouble(txtAmount.getText())), txtDescription.getText());
                    } else {
                        userAccount.miscellaneous(BigDecimal.valueOf(Double.parseDouble(txtAmount.getText())), txtDescription.getText());
                    }
                    lblDisplayAmountLabel.setText("Current Balance: ");
                    lblDisplayAmount.setText(currencyFormatter.format(userAccount.getBalance()));
                    transactionList.setText("Transaction History: \n");

                    List<Transaction> reverseList = userAccount.getHistory();
                    Collections.reverse(reverseList);

                    for (Transaction t : reverseList) {
                        transactionList.append(t.toString() + "\n");
                    }
                    Collections.reverse(reverseList);

                } catch (NullPointerException ex){
                    lblDisplayAmountLabel.setText("WARNING: ");
                    lblDisplayAmount.setText("Please Enter an Amount");
                }
                catch (NumberFormatException ex){
                    lblDisplayAmountLabel.setText("WARNING: ");
                    lblDisplayAmount.setText("Please enter a numerical value");
                }
                catch (AccountException ex){
                    lblDisplayAmountLabel.setText("WARNING: ");
                    lblDisplayAmount.setText(ex.getMessage());
                }
                catch (Exception ex){
                    lblDisplayAmountLabel.setText("WARNING: ");
                    lblDisplayAmount.setText(ex.getMessage());
                }
			}
        });

        //add panels to the frame
        this.add(headerPanel, BorderLayout.NORTH);
        this.add(bodyPanel, BorderLayout.CENTER);
        this.add(footerPanel, BorderLayout.SOUTH);

		this.setVisible(true);
        }
}