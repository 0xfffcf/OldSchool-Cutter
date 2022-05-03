package bot.runescape.menu;

import bot.runescape.Main;
import bot.runescape.node.Node;
import bot.runescape.tasks.TaskFactory;
import bot.runescape.tasks.woodCutting.client.WoodCutting;

import java.awt.*;
import java.awt.event.*;
import java.util.Objects;
import javax.swing.*;

import static org.dreambot.api.methods.MethodProvider.log;

/**
 * The menu class is a JFrame.
 * It is the default menu when the script start up.
 * It as made so the player can choose which task he/she wants to do.
 *
 * @author 0xfffcf
 * @version 1.1.0
 * @since 1.0.0
 */
public class Menu extends JFrame {
    private JComboBox<String> skillCombo;
    private final Main main;

    /**
     * Create a new Menu.
     *
     * @param main The main method that runs the tasks.
     */
    public Menu(Main main) {
        initComponents();
        this.main = main;
    }

    public String getSkillCombo() {
        return Objects.requireNonNull(skillCombo.getSelectedItem()).toString();
    }

    /* Class Function */

    /**
     * ActionEvent, it waits for the player to start the script.
     * Once the action got activated.
     * The menu dispose and it opens the menu for the specific task.
     *
     * @param e An ActionEvent that wait for the player to interact with it.
     */
    private void startButtonActionPerformed(ActionEvent e) {
        this.dispose();
        Node task = TaskFactory.getTask(getSkillCombo(), main);
        task.openMenu();
    }

    /**
     * Create a new GUI for the Menu.
     */
    private void initComponents() {
        skillCombo = new JComboBox<>();
        JButton startButton = new JButton();
        JLabel botType = new JLabel();

        //======== this ========
        setTitle("Menu");
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- skillCombo ----
        skillCombo.setForeground(Color.white);
        skillCombo.setModel(new DefaultComboBoxModel<>(new String[] {
            "Walker",
            "Wood Cutting"
        }));
        contentPane.add(skillCombo);
        skillCombo.setBounds(5, 5, 145, 40);

        //---- startButton ----
        startButton.setText("Start");
        startButton.setForeground(Color.white);
        startButton.addActionListener(this::startButtonActionPerformed);
        contentPane.add(startButton);
        startButton.setBounds(5, 50, 375, 40);

        //---- botType ----
        botType.setText("Select the skill you want to train.");
        botType.setForeground(Color.white);
        contentPane.add(botType);
        botType.setBounds(155, 15, 225, 25);

        contentPane.setPreferredSize(new Dimension(385, 110));
        pack();
        setLocationRelativeTo(getOwner());
    }
}
