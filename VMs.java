/**
 *
 * @author Hyunkun Cho, James Vitek
 */
package config;

import java.util.HashMap;


public class VMs {
    public String type, name, os, ver, src, eth0, eth1, eth2;
    public HashMap<String, String> conns = new HashMap<>();

    VMs (String name) {
        this.type = "VM";
        this.name = name;
        System.out.println("New VM created: " + this.name);
    }
    
    public String generateString() {
        //generate string to use for the .cfg file when saved
        String str;
        str = this.type + " " + this.name + " { \n";
        if (this.os != null && !this.os.equals("")) { 
            str += "\tos : " + this.os + " \n"; 
        }
        if (this.ver != null && !this.ver.equals("")) { 
            str += "\tver : \"" + this.ver + "\" \n"; 
        }
        if (this.src != null && !this.src.equals("")) { 
            str += "\tsrc : \"" + this.src + "\" \n"; 
        }
        if (this.eth0 != null && !this.eth0.equals("")) { 
            str += "\teth0 : \"" + this.eth0 + "\" \n"; 
        }
        if (this.eth1 != null && !this.eth1.equals("")) { 
            str += "\teth1 : \"" + this.eth1 + "\" \n"; 
        }
        if (this.eth2 != null && !this.eth2.equals("")) { 
            str += "\teth2 : \"" + this.eth2 + "\" \n"; 
        }
        str += "}\n\n";
        
        return str;
    }
    public String solutionString() {
        String str = "";
        for (String p : conns.keySet()) {
            str += "(" + this.name + "." + p + " " + conns.get(p) + "),\n";
        }
        return str;
    }
    
    public String connectionAdd(String host, String conn) {
        if(conns.get(host) != null){
            return "Already connected";
        }
        else {
            conns.put(host, conn);
            return "Add " + host + ", " + conn + " to " + this.name;
        }
    }

    public String connectionRemove(String host){
        if (conns.get(host) != null){
            conns.remove(host);
            return "Connection removed " + this.name + "+" + host;
        }
        else {
            return "Connection remove failed";
        }
    }

    public void checkToRemoveHub (String H){
        for (String port : conns.keySet()) {
            if(conns.get(port).contains(H)) {
                conns.remove(port);
            }
        }
    }

    public String getName() {
        return name;
    }
    public void setName(String n) {
        this.name = n;
    }

    public String getOs() {
        return os;
    }
    public void setOs(String o){
        this.os = o;
    }

    public String getVr() {
        return ver;
    }
    public void setVr(String v) {
        this.ver = v;
    
    }

    public String getSrc() {
        return src;
    }
    public void setSrc(String s) {
        this.src = s;
    }
    
    public String getEh0() {
        return eth0;
    }
    public boolean setEth0(String eth0){
        if(validIP(eth0)){
            this.eth0 = eth0;
            return true;
        } else {
            return false;
        }
    }

    public String getEth1(){
        return eth1;
    }
    public boolean setEth1(String eth1){
        if(validIP(eth1)){
            this.eth1 = eth1;
            return true;
        } else {
            return false;
        }
    }

    public String getEth2(){
        return eth2;
    }
    public boolean setEth2(String eth2){
        if(validIP(eth2)){
            this.eth2 = eth2;
            return true;
        } else {
            return false;
        }
    }
    
    public boolean validIP (String IP) {
        try {
            String[] parts = IP.split( "\\." );
            for (String s : parts ) {
                int i = Integer.parseInt( s );
                if ( (i < 0) || (i > 255) ) {
                    return false;
                }
            }
            if ( parts.length != 4 ) {
                return false;
            }  
            if (IP.endsWith(".") ) {
                return false;
            }
            if (IP == null || IP.isEmpty() ) {
                return true;
            }
            return true;
        } catch (NumberFormatException nfe) {
            return false;
        }
    }
}
