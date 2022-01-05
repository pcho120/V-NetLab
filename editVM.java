/**
 *
 * @author Hyunkun Cho 
 */
package config;

import java.util.HashMap;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class editVM extends javax.swing.JFrame {

    private javax.swing.JLabel networkItemLabel;
    private javax.swing.JLabel srcLabel;
    private javax.swing.JLabel verLabel;
    private javax.swing.JLabel osLabel;
    private javax.swing.JLabel eth0Label;
    private javax.swing.JLabel eth1Label;
    private javax.swing.JLabel eth2Label;

    private javax.swing.JButton confBtn;
    private javax.swing.JButton cancelBtn;
    private javax.swing.JButton eth0Connect;
    private javax.swing.JButton eth1Connect;
    private javax.swing.JButton eth2Connect;
    private javax.swing.JButton deleteBtn;

    private javax.swing.JLabel name;
    private javax.swing.JTextField ver;
    private javax.swing.JTextField os;
    private javax.swing.JTextField src;
    private javax.swing.JTextField eth0;
    private javax.swing.JTextField eth1;
    private javax.swing.JTextField eth2;

    public editVM(applicationWindow main) {
        initComponents();
        mainWindow = main;
    }

    private void initComponents() {

        networkItemLabel = new javax.swing.JLabel();
        srcLabel = new javax.swing.JLabel();
        verLabel = new javax.swing.JLabel();
        osLabel = new javax.swing.JLabel();
        eth0Label = new javax.swing.JLabel();
        eth1Label = new javax.swing.JLabel();
        eth2Label = new javax.swing.JLabel();

        confBtn = new javax.swing.JButton();
        cancelBtn = new javax.swing.JButton();
        eth0Connect = new javax.swing.JButton();
        eth1Connect = new javax.swing.JButton();
        eth2Connect = new javax.swing.JButton();
        deleteBtn = new javax.swing.JButton();

        name = new javax.swing.JLabel();
        ver = new javax.swing.JTextField();
        os = new javax.swing.JTextField();
        src = new javax.swing.JTextField();
        eth0 = new javax.swing.JTextField();
        eth1 = new javax.swing.JTextField();
        eth2 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        name.setFont(new java.awt.Font("Tahoma", 1, 14));
    
        networkItemLabel.setText("Network Item:");
        //ver.setToolTipText("");
        verLabel.setText("Ver:");
        osLabel.setText("OS:");
        eth0Label.setText("eth0:");
        eth1Label.setText("eth1:");
        eth2Label.setText("eth2:");

        confBtn.setText("Confirm");
        confBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                confBtnActionPerformed(e);
            }
        });

        cancelBtn.setText("Cancel");
        cancelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                cancelBtnActionPerformed(e);
            }
        });

        srcLabel.setText("Src:");

        eth0Connect.setText("Connect");
        eth0Connect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                eth0ConnectActionPerformed(e);
            }
        });

        eth1Connect.setText("Connect");
        eth1Connect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                eth1ConnectActionPerformed(e);
            }
        });

        eth2Connect.setText("Connect");
        eth2Connect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                eth2ConnectActionPerformed(e);
            }
        });

        deleteBtn.setText("Delete");
        deleteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                deleteBtnActionPerformed(e);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(deleteBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(confBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cancelBtn))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(networkItemLabel)
                            .addComponent(verLabel)
                            .addComponent(osLabel)
                            .addComponent(eth0Label)
                            .addComponent(eth1Label)
                            .addComponent(eth2Label)
                            .addComponent(srcLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ver)
                            .addComponent(name, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(os)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(eth1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(eth1Connect))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(eth2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(eth2Connect))
                            .addComponent(src)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(eth0, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(eth0Connect)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(networkItemLabel)
                    .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ver, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(verLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(osLabel)
                    .addComponent(os, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(srcLabel)
                    .addComponent(src, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(eth0Label)
                    .addComponent(eth0, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(eth0Connect))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(eth1Label)
                    .addComponent(eth1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(eth1Connect))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(eth2Label)
                    .addComponent(eth2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(eth2Connect))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(confBtn)
                    .addComponent(cancelBtn)
                    .addComponent(deleteBtn))
                .addContainerGap())
        );

        pack();
    }
   
    VMs netVM = null;
    applicationWindow mainWindow = null;
    
    public void setNetVM(VMs vm) {
        netVM = vm;
    }
    
    public void nameChange(String txt) {
        name.setText(txt);
    }
    public void osChange(String txt) {
        os.setText(txt);
    }
    public void verChange(String txt) {
        ver.setText(txt);
    }
    public void srcChange(String txt) {
        src.setText(txt);
    }
    public void eth0Change(String txt) {
        eth0.setText(txt);
    }
    public void eth1Change(String txt) {
        eth1.setText(txt);
    }
    public void eth2Change(String txt) {
        eth2.setText(txt);
    }
    
    public void setVmItem() {
        netVM.setVr(this.ver.getText());
        netVM.setSrc(this.src.getText());
        netVM.setOs(this.os.getText());
        boolean e0 = netVM.setEth0(this.eth0.getText());
        boolean e1 = netVM.setEth1(this.eth1.getText());
        boolean e2 = netVM.setEth2(this.eth2.getText());
        
        //test if all fields are properly ready to be set
        if (e0 && e1 && e2) { 
            mainWindow.jLabel2.setText(netVM.name + " updated.");
        } else {
            mainWindow.jLabel2.setText("One or more of your eth port IPs were invalid.");
        }
        this.dispose();
    }
    
    private void cancelBtnActionPerformed(java.awt.event.ActionEvent evt) {
        mainWindow.jLabel2.setText("");
        this.dispose();
    }

    private void confBtnActionPerformed(java.awt.event.ActionEvent evt) {
        setVmItem();
    }

    private void eth0ConnectActionPerformed(java.awt.event.ActionEvent evt) {
        connectEthVm(netVM, "eth0");
    }

    private void eth1ConnectActionPerformed(java.awt.event.ActionEvent evt) {
        connectEthVm(netVM, "eth1");
    }

    private void eth2ConnectActionPerformed(java.awt.event.ActionEvent evt) {
        connectEthVm(netVM, "eth2");
    }

    public void connectEthVm(VMs item, String port) {
        HashMap<String, Hubs> itemSet = mainWindow.getHubs();
        JFrame frame = new JFrame("Connect to a hub.");
        String frametext = "Enter the name of the hub to connect ";
        
        frametext += item.getName() + "." + port + " to:\n";
               
        for (String key : itemSet.keySet()) {
            Hubs hub = itemSet.get(key);
            frametext += "\n" + hub.getName();
        }
        String name = JOptionPane.showInputDialog(frame, frametext);
        if (name != null && !name.equals("")){ 
            //if hub name is valid make the connection
            name = name.replaceAll("\\s+","");
            if (itemSet.get(name) != null) {
                Hubs hub = itemSet.get(name);
                String add = item.connectionAdd(port, "v2." + hub.getName2());
                hub.moreInfo(item.getName() + "." + port);
                mainWindow.connectAll(item.name, hub.name);
                mainWindow.jLabel2.setText(add);
                this.dispose();
            } else {
                mainWindow.jLabel2.setText("ERROR: The hub " + name + " does not exist.");
                this.dispose();
            }
        } else if (name != null && name.equals("")) { 
            //if name is empty remove the connection
            String remove = item.connectionRemove(port);
            for (Hubs hub : itemSet.values()) {
                hub.deleteInfo(item.getName() + "." + port);
            }
            mainWindow.jLabel2.setText(remove);
            this.dispose();
        }
    }


    private void deleteBtnActionPerformed(java.awt.event.ActionEvent evt) {
        JFrame frame = new JFrame("Confirm Delete");
        Integer deleted = JOptionPane.showConfirmDialog(frame, "Are you sure?", "Confirm delete.", JOptionPane.YES_NO_OPTION); //confirm user wants to delete
        if (deleted == 0){
            if (mainWindow.delete(netVM.name)){
                this.dispose(); //close window after deletion
            } else { 
                System.out.println("netVM not detected, can't delete."); 
            }
        }
    }
    
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(editVM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(editVM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(editVM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(editVM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new editVM(null).setVisible(true);
            }
        });
    }
}