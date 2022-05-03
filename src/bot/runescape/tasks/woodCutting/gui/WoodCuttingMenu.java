package bot.runescape.tasks.woodCutting.gui;

import bot.runescape.tasks.woodCutting.client.WoodCutting;

import java.awt.*;
import java.awt.event.*;
import java.util.Objects;
import javax.swing.*;

/**
 * @author 0xfffcf
 * @since 1.0.0
 */
public class WoodCuttingMenu extends JFrame {
    private JComboBox<String> treeCombo;
    private JComboBox<String> dropCombo;
    private final WoodCutting ctx;

    /**
     * WoodCuttingMenu constructor.
     * Create the GUI for the wood cutting.
     *
     * @param main an instance of the main to pass the context.
     */
    public WoodCuttingMenu(WoodCutting main) {
        this.ctx = main;
        initComponents();
    }

    public String getTreeComboName() {
        return Objects.requireNonNull(treeCombo.getSelectedItem()).toString();
    }

    public String getDropLog() {
        return String.valueOf(dropCombo.getSelectedItem());
    }

    /* Class Function */

    private void button1ActionPerformed(ActionEvent e) {
        ctx.setStartScript(true);
        this.dispose();
    }

    /**
     * Create the menu.
     */
    private void initComponents() {
        JButton startButton = new JButton();
        treeCombo = new JComboBox<>();
        JLabel treeTypeLabel = new JLabel();
        dropCombo = new JComboBox<>();
        JLabel dropLabel = new JLabel();
        Image icon = Toolkit.getDefaultToolkit().getImage("https://i.imgur.com/p6p96rL.png");

        //======== this ========
        setTitle("WoodCutter Menu");
        setIconImage(icon);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- startButton ----
        startButton.setText("Start");
        startButton.setForeground(Color.white);
        startButton.addActionListener(this::button1ActionPerformed);
        contentPane.add(startButton);
        startButton.setBounds(10, 95, 415, 60);

        //---- treeCombo ----
        treeCombo.setModel(new DefaultComboBoxModel<>(new String[]{
                "Tree",
                "Oak",
                "Willow",
                "Yew",
                "Maple"
        }));
        treeCombo.setForeground(Color.white);
        contentPane.add(treeCombo);
        treeCombo.setBounds(10, 5, 105, 40);

        //---- treeTypeLabel ----
        treeTypeLabel.setText("Select your type of tree.");
        treeTypeLabel.setForeground(Color.white);
        contentPane.add(treeTypeLabel);
        treeTypeLabel.setBounds(125, 15, 165, 25);

        //---- dropCombo ----
        dropCombo.setModel(new DefaultComboBoxModel<>(new String[]{
                "No",
                "Yes"
        }));
        dropCombo.setForeground(Color.white);
        contentPane.add(dropCombo);
        dropCombo.setBounds(10, 45, 105, 40);

        //---- dropLabel ----
        dropLabel.setText("Drop items?");
        dropLabel.setForeground(Color.white);
        contentPane.add(dropLabel);
        dropLabel.setBounds(125, 55, 259, 20);

        contentPane.setPreferredSize(new Dimension(435, 165));
        pack();
        setLocationRelativeTo(getOwner());
    }
}