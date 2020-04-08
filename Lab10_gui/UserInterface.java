import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.util.ArrayList;
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
    public JLabel lblSpacer = new JLabel("            ");
    public JLabel lblSpacer2 = new JLabel("            ");
    public JLabel lblTestSpace = new JLabel("");
	public JTextField txtName = new JTextField(10);
	public JTextField txtAddress = new JTextField(10);
    public JTextField txtPhone = new JTextField(10);
    public JRadioButton rdbDelivery = new JRadioButton("Delivery:", true);
    public JRadioButton rdbPickUp = new JRadioButton("Pick Up:");
    public JComboBox<String> cboSize = new JComboBox<String>();
    public JComboBox<String> cboCrust = new JComboBox<String>();
    public JComboBox<String> cboTopping = new JComboBox<String>();
	public JButton btnAddPizza = new JButton("Add Pizza");
	public JButton btnRemovePizza = new JButton("Remove Pizza");
    public JButton btnConfirmOrder = new JButton("Confirm Order");
    public JButton btnPreviousOrders = new JButton("Previous Orders");
    public JTextArea pizzaList = new JTextArea("Pizza List:\n", 12, 20);
    public JScrollPane scrollablePizzaList = new JScrollPane(pizzaList, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

    ArrayList<Pizza> workingPizzaList = new ArrayList<Pizza>();
    ArrayList<Order> workingOrderList = new ArrayList<Order>();

    public static void main(String[] args) {
        new UserInterface();
    }

    UserInterface() {
        //set up the frame
        this.setTitle("Magic Pan Pizza Order Entry System");
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
        customerInfoPanel.add(lblCustomerInfo);
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
        sizePanel.add(lblSpacer2);
        crustPanel.add(lblCrust);
        crustPanel.add(cboCrust);
        toppingPanel.add(lblTopping);
        toppingPanel.add(cboTopping);
        addPizzaBtnPanel.add(btnAddPizza);
        addPizzaBtnPanel.add(btnRemovePizza);
        pizzaSelectionPanel.setLayout(new BoxLayout(pizzaSelectionPanel,BoxLayout.Y_AXIS));
        pizzaSelectionPanel.add(lblPizzaInfo);
        pizzaSelectionPanel.add(sizePanel);
        pizzaSelectionPanel.add(crustPanel);
        pizzaSelectionPanel.add(toppingPanel);
        pizzaSelectionPanel.add(addPizzaBtnPanel);

        //build pizza list panel
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
        JPanel buttonPanel = new JPanel();
        JPanel errorPanel = new JPanel();
        buttonPanel.add(btnConfirmOrder);
        buttonPanel.add(btnPreviousOrders);
        errorPanel.add(lblTestSpace);
        footerPanel.setLayout(new BoxLayout(footerPanel,BoxLayout.Y_AXIS));
        footerPanel.add(buttonPanel);
        footerPanel.add(errorPanel);

        btnConfirmOrder.addActionListener(new ConfirmOrder());
        btnPreviousOrders.addActionListener(new PreviousOrders());
        btnAddPizza.addActionListener(new AddPizza());
        rdbDelivery.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                txtAddress.setEnabled(true);
            }
        });
        rdbPickUp.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                txtAddress.setEnabled(false);
                txtAddress.setText("");
            }
        });
        btnRemovePizza.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                workingPizzaList.remove(workingPizzaList.size() - 1);
                pizzaList.setText("Pizza List:\n");
                for (Pizza pizza : workingPizzaList) {
                    pizzaList.append("\n" + pizza.toString() + "\n");
                }
            }
        });

        //add panels to the frame
        this.add(HeaderPanel, BorderLayout.NORTH);
        this.add(bodyPanel, BorderLayout.CENTER);
        this.add(footerPanel, BorderLayout.SOUTH);

		this.setVisible(true);
    }

    public class AddPizza implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Boolean pepperoniChecker = cboTopping.getSelectedItem().toString().toLowerCase().equals("pepperoni");

            Pizza newPizza = new Pizza(cboSize.getSelectedItem().toString(), 
                                        cboCrust.getSelectedItem().toString(), 
                                        pepperoniChecker);

            workingPizzaList.add(newPizza);

                pizzaList.append("\n" + newPizza.toString() + "\n");
            
        }
    }

    public class PreviousOrders implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            JTextArea orderList = new JTextArea("", 12, 20);
            orderList.setEditable(false);
            try {
                for (Order order : workingOrderList) {
                    orderList.append("\n" + order.getOrderDetails() + "\n");
                }
            }  catch (NullPointerException message){
            }
            catch (NumberFormatException message){
            }
            catch (OrderException message){
                orderList.setText("There are no orders yet");
            }
            catch (Exception message){
            }
                JScrollPane scrollableOrderList = new JScrollPane(orderList, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
                JButton okButton = new JButton("OK");
            
                JDialog previousOrdersFrame = new JDialog();
                previousOrdersFrame.setTitle("Confirm Order");
                previousOrdersFrame.setDefaultCloseOperation((JDialog.DISPOSE_ON_CLOSE));
                previousOrdersFrame.setSize(500,300);
                previousOrdersFrame.setResizable(false);
                previousOrdersFrame.setLocationRelativeTo(null);
            
                JPanel ordersBody = new JPanel();
            
                ordersBody.add(scrollableOrderList);
                ordersBody.add(okButton);

                okButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        previousOrdersFrame.setVisible(false);
                    }
                });

                previousOrdersFrame.add(ordersBody);
                previousOrdersFrame.setVisible(true);
        }
    }

    public class ConfirmOrder implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance();
            lblTestSpace.setText("");

            try {
                Order newOrder = txtAddress.getText().isEmpty() 
                                ? new Order(txtName.getText(), txtPhone.getText(), rdbDelivery.isSelected())
                                : new Order(txtName.getText(), txtAddress.getText(), txtPhone.getText(), rdbDelivery.isSelected());
                for (Pizza pizza : workingPizzaList) {
                    newOrder.addPizza(pizza);
                }           

                JLabel lblNameHeader = new JLabel("Name:");
                JLabel lblNameData = new JLabel(newOrder.getName());
                JLabel lblAddressHeader = new JLabel("Address:");
                JLabel lblAddressData = new JLabel(newOrder.getAddress());            
                JLabel lblPhoneHeader = new JLabel("Phone:");
                JLabel lblPhoneData = new JLabel(newOrder.getPhone());            
                JLabel lblDeliveryData = new JLabel(newOrder.isDelivery ? "           DELIVERY" : "           PICK-UP");            
                JLabel lblDeliveryTimeHeader = new JLabel("EST "
                                                    + (newOrder.isDelivery ? "Delivery" : "Pick-Up")
                                                    + " Time: ");
                JLabel lblDeliveryTimeData = new JLabel((newOrder.isDelivery 
                                                        ? Double.valueOf(newOrder.calculateBakeTime() + Double.valueOf("15")).toString()
                                                        : Double.valueOf(newOrder.calculateBakeTime()).toString()) + " Minutes" );
                JLabel lblCostHeader = new JLabel("Cost:");
                JLabel lblCostData = new JLabel(currencyFormatter.format(newOrder.calculateCost()));
                JLabel emptyCell = new JLabel("     ");

                JTextArea pizzaListConfirm = new JTextArea("Pizza List:\n", 12, 20);
                JScrollPane scrollablePizzaList = new JScrollPane(pizzaListConfirm, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

                JButton confirmButton = new JButton("Confirm");
                JButton backButton = new JButton("Back");

                JPanel cutomerInfoHeaders = new JPanel();
                JPanel customerInfoData = new JPanel();
                JPanel customerInfoPanel = new JPanel();
                JPanel pizzaListPanel = new JPanel();
                JPanel buttonPanel = new JPanel();

                JDialog confimFrame = new JDialog();
                confimFrame.setTitle("Confirm Order");
                confimFrame.setDefaultCloseOperation((JDialog.DISPOSE_ON_CLOSE));
                confimFrame.setSize(500,300);
                confimFrame.setResizable(false);
                confimFrame.setLocationRelativeTo(null);

                //set up customer info panel
                cutomerInfoHeaders.add(lblNameHeader);
                customerInfoData.add(lblNameData);
                cutomerInfoHeaders.add(lblAddressHeader);
                customerInfoData.add(lblAddressData);
                cutomerInfoHeaders.add(lblPhoneHeader);
                customerInfoData.add(lblPhoneData);
                cutomerInfoHeaders.add(lblDeliveryData);
                customerInfoData.add(emptyCell);
                cutomerInfoHeaders.add(lblDeliveryTimeHeader);
                customerInfoData.add(lblDeliveryTimeData);
                cutomerInfoHeaders.add(lblCostHeader);
                customerInfoData.add(lblCostData);
                
                cutomerInfoHeaders.setLayout(new BoxLayout(cutomerInfoHeaders,BoxLayout.Y_AXIS));
                customerInfoData.setLayout(new BoxLayout(customerInfoData,BoxLayout.Y_AXIS));
                customerInfoPanel.setLayout(new BoxLayout(customerInfoPanel,BoxLayout.X_AXIS));
                customerInfoPanel.add(cutomerInfoHeaders, BorderLayout.WEST);
                customerInfoPanel.add(customerInfoData, BorderLayout.EAST);

                //set up pizza list panel
                for (Pizza pizza : workingPizzaList) {
                    pizzaListConfirm.append("\n" + pizza.toString() + "\n");
                }
                pizzaListPanel.add(scrollablePizzaList);
                
                //set up button panel
                buttonPanel.add(confirmButton);
                buttonPanel.add(backButton);

                backButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        confimFrame.setVisible(false);
                    }
                });
                confirmButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        workingOrderList.add(newOrder);

                        workingPizzaList.clear();
                        pizzaListConfirm.setText("Pizza List:\n");
                        pizzaList.setText("Pizza List:\n");
                        UserInterface.this.scrollablePizzaList.setViewportView(pizzaList);
                        txtAddress.setText("");
                        txtName.setText("");
                        txtPhone.setText("");
                        cboCrust.setSelectedItem("Pan");
                        cboSize.setSelectedItem("L");
                        cboTopping.setSelectedItem("Pepperoni");
                        rdbDelivery.setSelected(true);
                        confimFrame.setVisible(false);
                    }
                });


                confimFrame.add(customerInfoPanel, BorderLayout.WEST);
                confimFrame.add(pizzaListPanel, BorderLayout.EAST);
                confimFrame.add(buttonPanel, BorderLayout.SOUTH);
                confimFrame.setVisible(true);
            }  catch (NullPointerException message){
                lblTestSpace.setText(message.toString());
            }
            catch (NumberFormatException message){
                lblTestSpace.setText(message.toString());
            }
            catch (OrderException message){
                lblTestSpace.setText(message.toString());
            }
            catch (Exception message){
                lblTestSpace.setText(message.toString());
            }
        }
    }
}