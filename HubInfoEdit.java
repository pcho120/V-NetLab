/**
 *
 * @author Nicholas Cubberly, Hyunkun Cho
 */ 



package config;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.*;

public class HubInfoEdit extends javax.swing.JFrame {
    
    //Initializing Variables
    private javax.swing.JLabel name;
    private javax.swing.JLabel HubLabel;
    private javax.swing.JLabel InfoLabel;
    private javax.swing.JLabel SubnetLabel;
    private javax.swing.JLabel MaskLabel;
    private javax.swing.JButton DeleteButton;
    private javax.swing.JButton CancelButton;
    private javax.swing.JButton SubmitButton;
    private javax.swing.JTextField InfoInput;
    private javax.swing.JTextField SubnetInput;
    private javax.swing.JTextField MaskInput;

    

    public HubInfoEdit(applicationWindow main){
        initComponents();
        Window = main;
    }

    applicationWindow Window = null;
    Hubs HubNet = null;

    private void initComponents(){
        name = new javax.swing.JLabel();
        HubLabel = new javax.swing.JLabel();
        InfoLabel = new javax.swing.JLabel();
        SubnetLabel = new javax.swing.JLabel();
        MaskLabel = new javax.swing.JLabel();

        DeleteButton = new javax.swing.JButton();
        CancelButton = new javax.swing.JButton();
        SubmitButton = new javax.swing.JButton();

        InfoInput = new javax.swing.JTextField();
        SubnetInput = new javax.swing.JTextField();
        MaskInput = new javax.swing.JTextField();
        
        name.setFont(new java.awt.Font("Times New Roman", 2, 16));
        HubLabel.setText("HUB:");
        InfoLabel.setText("Info:");
        SubnetLabel.setText("Subnet:");
        MaskLabel.setText("Netmask:");
        SubmitButton.setText("Submit");
        CancelButton.setText("Cancel");
        DeleteButton.setText("Delete");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        SubmitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent Event) {
                SubmitButtonSuccessful(Event);
            }
        });

        CancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent Event) {
                CancelButtonSuccessful(Event);
            }
        });

        InfoInput.setEditable(true);

        DeleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent Event) {
                DeleteButtonSuccessful(Event);
            }
        });

        javax.swing.GroupLayout Format = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(Format);

        Format.setHorizontalGroup(Format.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Format.createSequentialGroup()
                .addContainerGap()
                .addGroup(Format.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        
                    .addGroup(Format.createSequentialGroup()
                        .addComponent(DeleteButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 117, Short.MAX_VALUE)
                        .addComponent(SubmitButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CancelButton))

                    .addGroup(Format.createSequentialGroup()
                        .addGroup(Format.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(HubLabel)
                            .addComponent(InfoLabel)
                            .addComponent(SubnetLabel)
                            .addComponent(MaskLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(Format.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(name, javax.swing.GroupLayout.DEFAULT_SIZE, 
                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(InfoInput)
                            .addComponent(SubnetInput)
                            .addComponent(MaskInput))))
                .addContainerGap())
            );

        
        Format.setVerticalGroup(Format.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Format.createSequentialGroup()
                .addContainerGap()
                .addGroup(Format.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(HubLabel)
                    .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, 
                        14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(Format.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(InfoLabel)
                    .addComponent(InfoInput, javax.swing.GroupLayout.PREFERRED_SIZE, 
                        javax.swing.GroupLayout.DEFAULT_SIZE, 
                        javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(Format.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SubnetLabel)
                    .addComponent(SubnetInput, javax.swing.GroupLayout.PREFERRED_SIZE, 
                        javax.swing.GroupLayout.DEFAULT_SIZE, 
                        javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(Format.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(MaskLabel)
                    .addComponent(MaskInput, javax.swing.GroupLayout.PREFERRED_SIZE, 
                        javax.swing.GroupLayout.DEFAULT_SIZE, 
                        javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 
                    javax.swing.GroupLayout.DEFAULT_SIZE, 
                    Short.MAX_VALUE)
                .addGroup(Format.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SubmitButton)
                    .addComponent(CancelButton)
                    .addComponent(DeleteButton))
                .addContainerGap()));

        pack();

    }

    private void SubmitButtonSuccessful(java.awt.event.ActionEvent event) {
        SetHubNetInfo();
    }

    private void CancelButtonSuccessful(java.awt.event.ActionEvent event) {
        Window.jLabel2.setText("");
        this.dispose();
    }

    private void DeleteButtonSuccessful(java.awt.event.ActionEvent Event) {
        JFrame Frame = new JFrame("Confirm");
        Integer Options = JOptionPane.showConfirmDialog(Frame, "Are you sure?", "Confirm", JOptionPane.YES_NO_OPTION);
        if (Options == 0) {
            if (Window.delete(HubNet.name)) {
                this.dispose();
            }
            else {
                System.out.println("ERROR! Cannot Delete.");
            }
        }
    }

    public void SetNet(Hubs net){
        HubNet = net;
    }

    public void SetHubNetInfo() {
        HubNet.setInfo(this.InfoInput.getText());
        boolean Subnet1 = HubNet.setSubnet(this.SubnetInput.getText());
        boolean Netmask1 = HubNet.setNetmask(this.MaskInput.getText());
        if (Subnet1 && Netmask1) {
            Window.jLabel2.setText(HubNet.name + ": UPDATED!");
        }
        else {
            Window.jLabel2.setText("ERROR!!");
        }
        this.dispose();
    }

    public void ChangeName(String NewInput) {
        name.setText(NewInput);
    }

    public void ChangeInfoInput(String NewInput){
        InfoInput.setText(NewInput);
    }

    public void ChangeSubnetInput(String NewInput){
        SubnetInput.setText(NewInput);
    }
    
    public void ChangeMaskInput(String NewInput){
        MaskInput.setText(NewInput);
    }

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        }
        catch (ClassNotFoundException i) {
            java.util.logging.Logger.getLogger(HubInfoEdit.class.getName())
            .log(java.util.logging.Level.SEVERE, null, i);
        }
        catch (InstantiationException i) {
            java.util.logging.Logger.getLogger(HubInfoEdit.class.getName())
            .log(java.util.logging.Level.SEVERE, null, i);
        }
        catch (IllegalAccessException i) {
            java.util.logging.Logger.getLogger(HubInfoEdit.class.getName())
            .log(java.util.logging.Level.SEVERE, null, i);
        }
        catch (javax.swing.UnsupportedLookAndFeelException i) {
            java.util.logging.Logger.getLogger(HubInfoEdit.class.getName())
            .log(java.util.logging.Level.SEVERE, null, i);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HubInfoEdit(null).setVisible(true);
            }
        });
    }
}