
/**
 *
 * @author Saleh Aldawlah, Hyunkun Cho, James Vitek
 */

package config;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.*;

public class applicationWindow extends javax.swing.JFrame {

    public applicationWindow() {
        initComponents();
    }

    private javax.swing.JButton vmButton;
    private javax.swing.JButton hubButton;
    private javax.swing.JButton deleteAllButton;
    private javax.swing.JColorChooser jColorChooser1;
    private javax.swing.JLabel jLabel1;
    public javax.swing.JLabel jLabel2;
    private javax.swing.JMenu menubarFile;
    private javax.swing.JMenu helpMenu;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem fileItemImport;
    private javax.swing.JMenuItem fileItemExport;
    private javax.swing.JMenuItem exitMenu;
    private javax.swing.JMenuItem aboutMenu;
    private javax.swing.JScrollPane scrollPn;
    private javax.swing.JPanel vmP;
    private javax.swing.JPanel hubP;
    private javax.swing.JPanel panel;
    private javax.swing.JFileChooser fileOpen;

    private void initComponents() {

        jColorChooser1 = new javax.swing.JColorChooser();
        vmButton = new javax.swing.JButton();
        hubButton = new javax.swing.JButton();
        deleteAllButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel(); //console
        scrollPn = new javax.swing.JScrollPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        menubarFile = new javax.swing.JMenu();
        fileItemImport = new javax.swing.JMenuItem();
        fileItemExport = new javax.swing.JMenuItem();
        exitMenu = new javax.swing.JMenuItem();
        helpMenu = new javax.swing.JMenu();
        aboutMenu = new javax.swing.JMenuItem();
        vmP = new javax.swing.JPanel();
        hubP = new javax.swing.JPanel();
        panel = new javax.swing.JPanel();
        fileOpen = new javax.swing.JFileChooser();


        jColorChooser1.setFont(new java.awt.Font("Tahoma", 0, 12)); 

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(775, 500));
        setPreferredSize(new java.awt.Dimension(775, 500));
        setFont(new java.awt.Font("Tahoma", 0, 12)); 

        vmButton.setFont(new java.awt.Font("Tahoma", 0, 12)); 
        vmButton.setText("Add vm");
        vmButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vmNewClicked(evt);
            }
        });

        hubButton.setFont(new java.awt.Font("Tahoma", 0, 12)); 
        hubButton.setText("Add hub");
        hubButton.addActionListener(new java.awt.event.ActionListener(){
            public void actionPerformed(java.awt.event.ActionEvent evt){
                hubNewClicked(evt);
            }
        });

        deleteAllButton.setFont(new java.awt.Font("Tahoma", 0, 12));
        deleteAllButton.setText("Delete All");
        deleteAllButton.addActionListener(new java.awt.event.ActionListener(){
            public void actionPerformed(java.awt.event.ActionEvent evt){
                deleteAllClicked(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12));
        jLabel1.setText("Console:");

        jLabel2.setText(" ");

        jMenuBar1.setFont(new java.awt.Font("Tahoma", 0, 12)); 

        menubarFile.setText("File");
        fileItemImport.setText("Import/Open");
        fileItemImport.addActionListener(new java.awt.event.ActionListener(){
            public void actionPerformed(java.awt.event.ActionEvent e){
                openMenuItemActionPerformed(e);
            }
        });

        fileItemExport.setText("Export/Save");
        fileItemExport.addActionListener(new java.awt.event.ActionListener(){
            public void actionPerformed(java.awt.event.ActionEvent e){
                saveAsMenuItemActionPerformed(e);
            }
        });
        
        exitMenu.setText("Exit");
        exitMenu.addActionListener(new java.awt.event.ActionListener(){
            public void actionPerformed(java.awt.event.ActionEvent e){
                exitMenuItemActionPerformed(e);
            }
        });
        helpMenu.setText("Help");
        aboutMenu.setText("About");

        menubarFile.add(fileItemImport);
        menubarFile.add(fileItemExport);
        menubarFile.add(exitMenu);
        jMenuBar1.add(menubarFile);
        helpMenu.add(aboutMenu);
        jMenuBar1.add(helpMenu);
        setJMenuBar(jMenuBar1);

        vmP.setPreferredSize(new java.awt.Dimension(300, 0));
        vmP.setLayout(new javax.swing.BoxLayout(vmP, javax.swing.BoxLayout.Y_AXIS));

        hubP.setPreferredSize(new java.awt.Dimension(305, 0));
        hubP.setMaximumSize(new java.awt.Dimension(305, 30000));
        hubP.setLayout(new javax.swing.BoxLayout(hubP, javax.swing.BoxLayout.Y_AXIS));

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
            .addContainerGap()
            .addComponent(vmP, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(hubP, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
            .addContainerGap()
            .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
            .addComponent(hubP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(vmP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        scrollPn.setViewportView(panel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(scrollPn)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(vmButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(hubButton)
                        .addComponent(deleteAllButton)
                        .addGap(0, 613, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(vmButton)
                    .addComponent(hubButton)
                    .addComponent(deleteAllButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollPn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }

    HashMap<String, VMs> vmMap = new HashMap<>();
    HashMap<String, Hubs> hubMap = new HashMap<>();
    HashMap<String, JButton> itemMap = new HashMap<>();
    ImageIcon vmImage = new javax.swing.ImageIcon(getClass().getResource("/config/images/vm.jpg"));
    ImageIcon hubImage = new javax.swing.ImageIcon(getClass().getResource("/config/images/hub.jpg"));
    
    public void createItem(String type, String name){
        switch (type) {
            case "VM": {
                VMs vm = new VMs(name);
                vmMap.put(name, vm);
                setVM(vm);
                jLabel2.setText("VM " + name + " created");
                break;
            }
            case "hub" : {
                Hubs hub = new Hubs(name);
                hubMap.put(name, hub);
                setHub(hub);
                jLabel2.setText("Hub " + name + " created");
                break;
            }
            default:
            System.out.println("invalid");
            break;
        }
    }

    public void setVM(VMs vm){
        //after click 'new vm', vm image show
        JButton vmBtn = new JButton(vm.name);
        vmBtn.setVerticalTextPosition(SwingConstants.BOTTOM);
        vmBtn.setHorizontalTextPosition(SwingConstants.CENTER);
        vmBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
        itemMap.put(vm.name, vmBtn);
        VMs netVM = vmMap.get(vm.name);
        applicationWindow main = this;

        vmBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                editVM edit = new editVM(main);
                edit.nameChange(netVM.name);
                edit.osChange(netVM.os);
                edit.verChange(netVM.ver);
                edit.srcChange(netVM.src);
                edit.eth0Change(netVM.eth0);
                edit.eth1Change(netVM.eth1);
                edit.eth2Change(netVM.eth2);
                edit.setNetVM(netVM);
                edit.setVisible(true);
            }
        });
        
        vmBtn.setIcon(vmImage);
        vmP.add(vmBtn);
        vmP.revalidate();
        validate();
    }

    public void vmNewClicked(java.awt.event.ActionEvent evt) {
        // when new vm cliked
        jLabel2.setText("new vm clicked");
        JFrame vmFrame = new JFrame();
        String vmName = JOptionPane.showInputDialog(vmFrame, "Enter name: ");
        jLabel2.setText("");
        if(vmName != null && !vmName.equals("")){
            vmName = vmName.replaceAll("\\s", "");
            if(vmMap.get(vmName) != null){
                jLabel2.setText("FAILED - name exists");
            } else {
                createItem("VM", vmName);
            }
        }
    }

    public void setHub(Hubs hub){
        JButton btn = new JButton(hub.name);
        btn.setVerticalTextPosition(SwingConstants.BOTTOM);
        btn.setHorizontalTextPosition(SwingConstants.CENTER);
        btn.setAlignmentX(Component.CENTER_ALIGNMENT);
        itemMap.put(hub.name, btn);
        Hubs netHub = hubMap.get(hub.name);
        applicationWindow main = this;
        btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                HubInfoEdit edit = new HubInfoEdit(main);
                edit.ChangeName(netHub.name);
                edit.ChangeInfoInput(netHub.info);
                edit.ChangeSubnetInput(netHub.subnet);
                edit.ChangeMaskInput(netHub.netmask);
                edit.SetNet(netHub);
                edit.setVisible(true);
            }
        });
        btn.setIcon(hubImage);
        hubP.add(btn);
        hubP.revalidate();
        validate();
    }

    public void hubNewClicked(java.awt.event.ActionEvent evt){
        //when new hub clicked
        jLabel2.setText("new hub clicked");
        JFrame hubFrame = new JFrame();
        String hubName = JOptionPane.showInputDialog(hubFrame, "Enter name:");
        jLabel2.setText("");
        if(hubName != null && !hubName.equals("")){
            hubName = hubName.replaceAll("\\s", "");
            if(hubMap.get(hubName) != null){
                jLabel2.setText("FAILED - name exists");
            } else {
                createItem("hub", hubName);
            }
        }
    }

    public void deleteAllClicked(java.awt.event.ActionEvent evt){
        jLabel2.setText("delete all clicked");
        vmP.removeAll();
        vmP.revalidate();
        vmP.repaint();
        
        hubP.removeAll();
        hubP.revalidate();
        hubP.repaint();
    }

    public boolean delete (String name) {
        //delete item
        if(vmMap.get(name) != null) {
            for (Hubs hub : hubMap.values()) {
                hub.deleteVM(name);
            }
            vmP.remove(itemMap.get(name));
            vmP.revalidate();
            vmP.repaint();
            vmMap.remove(name);
            jLabel2.setText(name + " removed");
            return true;
        } else if (hubMap.get(name) != null) {
            for (VMs vm : vmMap.values()) {
                vm.checkToRemoveHub(hubMap.get(name).getName2());
            }
            vmP.remove(itemMap.get(name));
            vmP.revalidate();
            vmP.repaint();
            hubMap.remove(name);
            jLabel2.setText(name + " removed");
            return true;
        } else {
            jLabel2.setText("Network does not exist");
            return true;
        }
    }

    public void drawLine(Point p1, Point p2) {
        //draw lines on connected items
        Graphics graphic = vmP.getGraphics();
        int x1 = (int) Math.round(p1.getX()) + 50;
        int y1 = (int) Math.round(p1.getY()) + 50;
        int x2 = (int) Math.round(p2.getX()) + 400;
        int y2 = (int) Math.round(p2.getY()) + 50;
        graphic.drawLine(x1, y1, x2, y2);

        //System.out.println("drawLine called");
    }

    public void connectAll(String vm, String hub){
        JButton vmB = itemMap.get(vm);
        JButton hubB = itemMap.get(hub);
        drawLine(vmB.getLocation(), hubB.getLocation());
        //System.out.println("connectAll called");
    }

    public void connect() {
        //System.out.println("connect called");
        for (VMs vm : vmMap.values()){
            HashMap<String, String> connects = vm.conns;
            for (String s : connects.values()){
                s = s.substring(3);
                for(Hubs hub : hubMap.values()){
                    if(hub.name2.equals(s)){
                        connectAll(vm.name, hub.name);
                        //System.out.println("connect innerloop called");
                    }
                }
            }
        }
    }

    public HashMap<String, VMs> getVMs() {
        return vmMap;
    }

    public HashMap<String, Hubs> getHubs() {
        return hubMap;
    }

    public void exitMenuItemActionPerformed(java.awt.event.ActionEvent e){
        System.exit(0);
    }

    public void openMenuItemActionPerformed(java.awt.event.ActionEvent e) {
        vmP.removeAll();
        hubP.removeAll();
        int val = fileOpen.showOpenDialog(this);
        if(val == JFileChooser.APPROVE_OPTION){
            File f = fileOpen.getSelectedFile();
            try{
                analyze anaylze = new analyze(new FileReader(f.getAbsolutePath()));
                vmMap = anaylze.getVmMap();
                hubMap = anaylze.getHubMap();
                for(VMs vm : vmMap.values()){
                    setVM(vm);
                }
                for(Hubs hub : hubMap.values()){
                    setHub(hub);
                }
                
                this.connect();
                this.jLabel2.setText("Chosen file opened");
            } catch(IOException exe) {

            }
        } else {
            System.out.println("Open file cancelled");
        }
    }

    public void saveAsMenuItemActionPerformed(java.awt.event.ActionEvent e){
        //write config file based on current data in program
        saveFile save = new saveFile();
        String str;
        str = "";
        
        int returnVal = fileOpen.showSaveDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = fileOpen.getSelectedFile();
            
            for (VMs item : vmMap.values()) {
                str += item.generateString();
            }
            
            for (Hubs item : hubMap.values()) {
                str += item.saveHub();
            }
            str += "partial_solution {\n";
            
            for (VMs item : vmMap.values()) {
                str += item.solutionString();
            }
            if (str.charAt(str.length()-2)==',') {
                str = str.substring(0, str.length()-2);
            }
            
            str += "\n}\n";
            
            try {
                config.saveFile.saveAsCfg(str, new File(file.getAbsolutePath() ));
                jLabel2.setText("File saved.");
            } catch (IOException ex) {
                Logger.getLogger(applicationWindow.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            System.out.println("File access cancelled by user.");
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
            java.util.logging.Logger.getLogger(applicationWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(applicationWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(applicationWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(applicationWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new applicationWindow().setVisible(true);
            }
        });
    }
    
}
