import javax.swing.*;

import java.awt.*;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UserInterface extends JFrame {
    public JLabel lblAppTitle = new JLabel("Order Entry System");
    public JLabel lblCustomerInfo = new JLabel("Enter Customer Info");
    public JLabel lblName = new JLabel("Name:     ");
    public JLabel lblAddress = new JLabel("Address:");
    public JLabel lblPhone = new JLabel("Phone:    ");
    public JLabel lblPizzaInfo = new JLabel("Enter Pizza Details");
    public JLabel lblSize = new JLabel("Size:");
    public JLabel lblCrust = new JLabel("Crust:");
    public JLabel lblTopping = new JLabel("Topping:");
	public JTextField txtName = new JTextField(10);
	public JTextField txtAddress = new JTextField(10);
    public JTextField txtPhone = new JTextField(10);
    public JRadioButton rdbDelivery = new JRadioButton("Delivery:", true);
    public JRadioButton rdbPickUp = new JRadioButton("Pick Up:");
    public JComboBox<String> cboSize = new JComboBox<String>();
    public JComboBox<String> cboCrust = new JComboBox<String>();
    public JComboBox<String> cboTopping = new JComboBox<String>();
	public JButton btnAddPizza = new JButton("Add Pizza");
    public JButton btnConfirmOrder = new JButton("Confirm Order");
    public JTextArea pizzaList = new JTextArea("Pizza List", 12, 20);
    public JScrollPane scrollablePizzaList = new JScrollPane(pizzaList, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

    public static void main(String[] args) {
        new UserInterface();
    }

    UserInterface() {
        //set up the frame
        this.setTitle("Magic Pan Pizza Order Entry System");
        this.setBackground(Color.darkGray);
        this.setDefaultCloseOperation((JFrame.EXIT_ON_CLOSE));
        this.setSize(700,300);
        this.setResizable(false);
        this.setLocationRelativeTo(null);

        //set up header panel
        JPanel HeaderPanel = new JPanel();
        HeaderPanel.add(lblAppTitle);
        HeaderPanel.setFont(new Font("Verdana", Font.BOLD, 18));

        //set up customer info panel
        JPanel customerInfoPanel = new JPanel();
        JPanel deliveryPanel = new JPanel();
        JPanel namePanel = new JPanel();
        JPanel addressPanel = new JPanel();
        JPanel phonePanel = new JPanel();
        ButtonGroup deliveryOptions = new ButtonGroup();
        deliveryOptions.add(rdbDelivery);
        deliveryOptions.add(rdbPickUp);
        deliveryPanel.add(rdbDelivery);
        deliveryPanel.add(rdbPickUp);
        namePanel.add(lblName);
        namePanel.add(txtName);
        phonePanel.add(lblPhone);
        phonePanel.add(txtPhone);
        addressPanel.add(lblAddress);
        addressPanel.add(txtAddress);
        customerInfoPanel.setLayout(new BoxLayout(customerInfoPanel,BoxLayout.Y_AXIS));
        customerInfoPanel.add(deliveryPanel);
        customerInfoPanel.add(namePanel);
        customerInfoPanel.add(addressPanel);
        customerInfoPanel.add(phonePanel);

        //set up combobox options
        cboSize.addItem("L");
        cboSize.addItem("M");
        cboSize.addItem("S");
        cboCrust.addItem("Pan");
        cboCrust.addItem("Thin");
        cboCrust.addItem("Deep Dish");
        cboTopping.addItem("Pepperoni");
        cboTopping.addItem("Cheese Only");

        //set up pizza selection panel
        JPanel pizzaSelectionPanel = new JPanel();
        JPanel sizePanel = new JPanel();
        JPanel crustPanel = new JPanel();
        JPanel toppingPanel = new JPanel();
        JPanel addPizzaBtnPanel = new JPanel();
        sizePanel.add(lblSize);
        sizePanel.add(cboSize);
        crustPanel.add(lblCrust);
        crustPanel.add(cboCrust);
        toppingPanel.add(lblTopping);
        toppingPanel.add(cboTopping);
        addPizzaBtnPanel.add(btnAddPizza);
        pizzaSelectionPanel.setLayout(new BoxLayout(pizzaSelectionPanel,BoxLayout.Y_AXIS));
        pizzaSelectionPanel.add(sizePanel);
        pizzaSelectionPanel.add(crustPanel);
        pizzaSelectionPanel.add(toppingPanel);
        pizzaSelectionPanel.add(addPizzaBtnPanel);

        //build pizza list
        JPanel pizzaListPanel = new JPanel();
        pizzaList.setEditable(false);
        pizzaListPanel.add(scrollablePizzaList);
        

        //build body panel
        JPanel bodyPanel = new JPanel(); 
        bodyPanel.setLayout(new BoxLayout(bodyPanel,BoxLayout.X_AXIS));
        bodyPanel.add(customerInfoPanel);
        bodyPanel.add(pizzaSelectionPanel);
        bodyPanel.add(pizzaListPanel);

        //build footer panel
        JPanel footerPanel = new JPanel();
        footerPanel.add(btnConfirmOrder);

        JPanel orderSuccessfulPanel = new JPanel();

        btnConfirmOrder.addActionListener(ConfirmOrder());
        btnAddPizza.addActionListener(AddPizza());

        //add panels to the frame
        this.add(HeaderPanel, BorderLayout.NORTH);
        this.add(bodyPanel, BorderLayout.CENTER);
        this.add(footerPanel, BorderLayout.SOUTH);

		this.setVisible(true);
    }

    private ActionListener AddPizza() {
        return null;
    }

    private ActionListener ConfirmOrder() {
        return null;
    }
}