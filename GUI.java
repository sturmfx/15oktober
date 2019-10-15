package com.company;

import javax.swing.*;
import java.awt.*;

public class GUI extends JFrame
{
    int index = 0;
    public Person[] persons;
    public JTextField name = new JTextField("   NAME   ");
    public JTextField second_name = new JTextField("SECOND NAME");
    public JTextField age = new JTextField("AGE");
    public JButton add = new JButton("ADD");
    public JButton save = new JButton("SAVE");
    public GUI(int n, String file)
    {
        persons = new Person[n];
        this.setLayout(new FlowLayout());
        this.setSize(500, 100);
        this.setVisible(true);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        add.addActionListener(e ->
        {
            if(index < n-1)
            {
                persons[index] = new Person(name.getText(), second_name.getText(), age.getText());
                index++;
                name.setText("");
                second_name.setText("");
                age.setText("");
            }
        });
        save.addActionListener(e ->
        {
            PersonWriter.write(persons, file);
        });

        add(name);
        add(second_name);
        add(age);
        add(add);
        add(save);

    }

}
