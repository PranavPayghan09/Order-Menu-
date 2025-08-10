import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomePage extends JFrame {
    public HomePage() {
        setTitle("Restaurant Ordering System");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Background Image Panel
        JLabel background = new JLabel(new ImageIcon("St_TAE_2/src/ui dashboard.jpg")); // Ensure image path is correct
        background.setLayout(new GridBagLayout());
        background.setOpaque(true);

        background.setBackground(new Color(0, 0, 0, 5)); // 70% visibility overlay
        add(background);
        background.setLayout(new GridBagLayout());
        add(background);
        // Logo
        JLabel logo = new JLabel("Deliousious Bites", SwingConstants.CENTER);
        logo.setFont(new Font("Arial", Font.BOLD, 24));
        logo.setForeground(Color.cyan);

        // Buttons
        JButton loginButton = new JButton("Login");
        JButton createAccountButton = new JButton("Create Account");

        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                openLoginWindow();
            }
        });

        createAccountButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                openCreateAccountWindow();
            }
        });

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 1, 10, 10));
        panel.setOpaque(false);
        panel.add(logo);
        panel.add(loginButton);
        panel.add(createAccountButton);

        background.add(panel);
    }

    private void openLoginWindow() {
        JFrame loginFrame = new JFrame("Login");
        loginFrame.setSize(400, 300);
        loginFrame.setLocationRelativeTo(null);
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2, 1, 10, 10));
        JButton memberLogin = new JButton("Member Login");
        JButton adminLogin = new JButton("Admin Login");

        memberLogin.addActionListener(e -> new LoginFrame().setVisible(true));
        adminLogin.addActionListener(e -> new AdminLogin().setVisible(true));

        panel.add(memberLogin);
        panel.add(adminLogin);
        loginFrame.add(panel);
        loginFrame.setVisible(true);
    }

    private void openCreateAccountWindow() {
        JFrame createFrame = new JFrame("Create Account");
        createFrame.setSize(400, 300);
        createFrame.setLocationRelativeTo(null);
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2, 1, 10, 10));
        JButton memberCreate = new JButton("Member Sign Up");
        JButton adminCreate = new JButton("Admin Sign Up");

        memberCreate.addActionListener(e -> new SignUpFrame().setVisible(true));
        adminCreate.addActionListener(e -> new AdminSignUp().setVisible(true));

        panel.add(memberCreate);
        panel.add(adminCreate);
        createFrame.add(panel);
        createFrame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new HomePage().setVisible(true);
        });
    }
//    LoginFrame
class LoginFrame extends JFrame {
    public LoginFrame() {
        setTitle("Member Login");
        setSize(400, 350);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setUndecorated(true); // Removes default window borders
        setLayout(null);

        // Panel for Styling
        JPanel panel = new JPanel();
        panel.setBackground(new Color(40, 40, 40));
        panel.setBounds(0, 0, 400, 350);
        panel.setLayout(null);

        // Title
        JLabel title = new JLabel("Member Login");
        title.setForeground(Color.WHITE);
        title.setFont(new Font("Arial", Font.BOLD, 20));
        title.setBounds(130, 20, 200, 30);
        panel.add(title);

        // Email Field
        JTextField emailField = new JTextField();
        emailField.setBounds(50, 70, 300, 40);
        emailField.setFont(new Font("Arial", Font.PLAIN, 14));
        emailField.setBorder(BorderFactory.createTitledBorder("Email"));
        panel.add(emailField);

        // Password Field
        JPasswordField passwordField = new JPasswordField();
        passwordField.setBounds(50, 130, 300, 40);
        passwordField.setBorder(BorderFactory.createTitledBorder("Password"));
        panel.add(passwordField);

        // Login Button
        JButton loginButton = new JButton("Login");
        loginButton.setBounds(50, 200, 300, 40);
        loginButton.setBackground(new Color(255, 165, 0));
        loginButton.setForeground(Color.WHITE);
        loginButton.setFont(new Font("Arial", Font.BOLD, 16));
        loginButton.setFocusPainted(false);
        panel.add(loginButton);

        // Close Button
        JButton closeButton = new JButton("X");
        closeButton.setBounds(360, 10, 30, 30);
        closeButton.setBackground(Color.RED);
        closeButton.setForeground(Color.WHITE);
        closeButton.setFocusPainted(false);
        closeButton.addActionListener(e -> dispose());
        panel.add(closeButton);

        add(panel);
        setVisible(true);
    }
}

    //    AdminLogin Frame
    class AdminLogin extends JFrame {
        public AdminLogin() {
            setTitle("Admin Login");
            setSize(400, 350);
            setLocationRelativeTo(null);
            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            setUndecorated(true);
            setLayout(null);

            JPanel panel = new JPanel();
            panel.setBackground(new Color(30, 30, 30));
            panel.setBounds(0, 0, 400, 350);
            panel.setLayout(null);

            JLabel title = new JLabel("Admin Login");
            title.setForeground(Color.WHITE);
            title.setFont(new Font("Arial", Font.BOLD, 20));
            title.setBounds(140, 20, 200, 30);
            panel.add(title);

            JTextField emailField = new JTextField();
            emailField.setBounds(50, 70, 300, 40);
            emailField.setBorder(BorderFactory.createTitledBorder("Admin Email"));
            panel.add(emailField);

            JPasswordField passwordField = new JPasswordField();
            passwordField.setBounds(50, 130, 300, 40);
            passwordField.setBorder(BorderFactory.createTitledBorder("Password"));
            panel.add(passwordField);

            JButton loginButton = new JButton("Login");
            loginButton.setBounds(50, 200, 300, 40);
            loginButton.setBackground(new Color(50, 205, 50));
            loginButton.setForeground(Color.WHITE);
            loginButton.setFont(new Font("Arial", Font.BOLD, 16));
            loginButton.setFocusPainted(false);
            panel.add(loginButton);

            JButton closeButton = new JButton("X");
            closeButton.setBounds(360, 10, 30, 30);
            closeButton.setBackground(Color.RED);
            closeButton.setForeground(Color.WHITE);
            closeButton.setFocusPainted(false);
            closeButton.addActionListener(e -> dispose());
            panel.add(closeButton);

            add(panel);
            setVisible(true);
        }
    }

    //    SignUpRrame
    class SignUpFrame extends JFrame {
        public SignUpFrame() {
            setTitle("Member Sign Up");
            setSize(400, 400);
            setLocationRelativeTo(null);
            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            setUndecorated(true);
            setLayout(null);

            JPanel panel = new JPanel();
            panel.setBackground(new Color(20, 20, 20));
            panel.setBounds(0, 0, 400, 400);
            panel.setLayout(null);

            JLabel title = new JLabel("Create Member Account");
            title.setForeground(Color.WHITE);
            title.setFont(new Font("Arial", Font.BOLD, 18));
            title.setBounds(90, 20, 250, 30);
            panel.add(title);

            JTextField nameField = new JTextField();
            nameField.setBounds(50, 70, 300, 40);
            nameField.setBorder(BorderFactory.createTitledBorder("Full Name"));
            panel.add(nameField);

            JTextField emailField = new JTextField();
            emailField.setBounds(50, 130, 300, 40);
            emailField.setBorder(BorderFactory.createTitledBorder("E-mail"));
            panel.add(emailField);

            JPasswordField passwordField = new JPasswordField();
            passwordField.setBounds(50, 190, 300, 40);
            passwordField.setBorder(BorderFactory.createTitledBorder("Password"));
            panel.add(passwordField);

            JButton signUpButton = new JButton("Sign Up");
            signUpButton.setBounds(50, 250, 300, 40);
            signUpButton.setBackground(new Color(0, 191, 255));
            signUpButton.setForeground(Color.WHITE);
            signUpButton.setFont(new Font("Arial", Font.BOLD, 16));
            signUpButton.setFocusPainted(false);
            panel.add(signUpButton);

            JButton closeButton = new JButton("X");
            closeButton.setBounds(360, 10, 30, 30);
            closeButton.setBackground(Color.RED);
            closeButton.setForeground(Color.WHITE);
            closeButton.setFocusPainted(false);
            closeButton.addActionListener(e -> dispose());
            panel.add(closeButton);

            add(panel);
            setVisible(true);
        }
    }

    //    AdminSignUp frame
    class AdminSignUp extends JFrame {
        public AdminSignUp() {
            setTitle("Admin Sign Up");
            setSize(400, 400);
            setLocationRelativeTo(null);
            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            setUndecorated(true);
            setLayout(null);

            JPanel panel = new JPanel();
            panel.setBackground(new Color(10, 10, 10));
            panel.setBounds(0, 0, 400, 400);
            panel.setLayout(null);

            JLabel title = new JLabel("Create Admin Account");
            title.setForeground(Color.WHITE);
            title.setFont(new Font("Arial", Font.BOLD, 18));
            title.setBounds(100, 20, 250, 30);
            panel.add(title);

            JTextField nameField = new JTextField();
            nameField.setBounds(50, 70, 300, 40);
            nameField.setBorder(BorderFactory.createTitledBorder("Admin Name"));
            panel.add(nameField);

            JTextField emailField = new JTextField();
            emailField.setBounds(50, 130, 300, 40);
            emailField.setBorder(BorderFactory.createTitledBorder("Admin Email"));
            panel.add(emailField);

            JPasswordField passwordField = new JPasswordField();
            passwordField.setBounds(50, 190, 300, 40);
            passwordField.setBorder(BorderFactory.createTitledBorder("Password"));
            panel.add(passwordField);

            JButton signUpButton = new JButton("Sign Up");
            signUpButton.setBounds(50, 250, 300, 40);
            signUpButton.setBackground(new Color(255, 69, 0));
            signUpButton.setForeground(Color.WHITE);
            signUpButton.setFont(new Font("Arial", Font.BOLD, 16));
            signUpButton.setFocusPainted(false);
            panel.add(signUpButton);

            add(panel);
            setVisible(true);
        }
    }




}
