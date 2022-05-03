package bot.runescape.tasks.walker.gui;

import bot.runescape.tasks.walker.client.Walker;

import java.awt.*;
import java.awt.event.*;
import java.util.Objects;
import javax.swing.*;

/**
 * @author 0xfffcf
 * @version 1.1.0
 * @since 1.1.0
 */
public class WalkerMenu extends JFrame {
    private JComboBox<String> locationCombo;
    private final Walker ctx;

    /**
     * WalkerMenu constructor.
     * Create the GUI for the walker.
     *
     * @param main an instance of the main to pass the context.
     */
    public WalkerMenu(Walker main) {
        this.ctx = main;
        initComponents();
    }

    public String getLocationComboName() {
        return Objects.requireNonNull(locationCombo.getSelectedItem()).toString();
    }

    /* Class Function */

    private void startButton(ActionEvent e) {
        ctx.setStartScript(true);
        this.dispose();
    }

    /**
     * Create the menu.
     */
    private void initComponents() {
        JLabel locationLabel = new JLabel();
        JButton startButton = new JButton();
        locationCombo = new JComboBox<>();
        Image icon = Toolkit.getDefaultToolkit().getImage("https://i.imgur.com/p6p96rL.png");

        //======== this ========
        setTitle("Walker Menu");
        setIconImage(icon);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- label1 ----
        locationLabel.setText("Select the location you want to go");
        locationLabel.setForeground(Color.white);
        contentPane.add(locationLabel);
        locationLabel.setBounds(15, 20, 230, 25);

        //---- button1 ----
        startButton.setText("Start");
        startButton.addActionListener(this::startButton);
        contentPane.add(startButton);
        startButton.setBounds(10, 65, 380, 55);

        //---- comboBox1 ----
        locationCombo.setModel(new DefaultComboBoxModel<>(new String[]{
                "Grand Exchange",
                "Seers Village"
        }));
        locationCombo.setForeground(Color.white);
        contentPane.add(locationCombo);
        locationCombo.setBounds(new Rectangle(new Point(240, 15), locationCombo.getPreferredSize()));

        contentPane.setPreferredSize(new Dimension(400, 130));
        pack();
        setLocationRelativeTo(getOwner());
    }
}
