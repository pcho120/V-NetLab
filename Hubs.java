/**
 *
 * @author Hyunkun Cho, James Vitek
 */ 

package config;

import java.util.ArrayList;
import java.util.Iterator;

public class Hubs {
    public String type, name, name2, info, subnet, netmask;
    public ArrayList<String> infoList;
    public int hubNum = 20;
    Hubs (String name) {
        this.type = "hub";
        this.name = name;
        this.info = "";
        this.name2 = "vinf" + hubNum; //vinf20 ~ vinf24
        this.infoList = new ArrayList<>();
        hubNum++;
    }

    public String saveHub() {
        String str = this.type + " " + this.name + " { \n";

        if (this.info != null && !this.info.equals("")) { 
            str += "\tinf : " + this.info + " \n"; 
        }
        if (this.subnet != null && !this.subnet.equals("")) { 
            str += "\tsubnet : \"" + this.subnet + "\" \n"; 
        }
        if (this.netmask != null && !this.netmask.equals("")) { 
            str += "\tnetmask : \"" + this.netmask + "\" \n"; 
        }
        str += "}\n\n";
        return str;
    }
	
	public String getName() {
        return name;
    }
	public void setName(String name) {
        this.name = name;
    }

    public String getName2() {
        //internal
        return name2;
    }

	public String getInfo() {
        return info;
    }
	public void setInfo(String info) {
		this.info = info;
	}
	public void createInfo() {
        //create text into the info field
		if (infoList.size() > 0) {
            for (int n = 0; n < infoList.size(); n++) {
                if (n == 0) {
                    this.info = infoList
					.get(n);
                } else {
                    this.info += ", " + infoList
					.get(n);
                }
            }
        } else {
            this.info = "";
        }
        	
	}
	public void moreInfo(String s) {
        if (!this.infoList.contains(s)) {
            this.infoList.add(s);
            createInfo();
        }
	}
	public void deleteInfo(String s) {
        if (this.infoList.contains(s)) {
            this.infoList.remove(s);
            createInfo();
        }
    }
	public void deleteVM(String n) {
        for (Iterator<String> iterator = this.infoList
		.iterator(); iterator.hasNext();) {
            String listItem = iterator.next();
            if (listItem.contains(n)) {
                iterator.remove();
            }
        }
        createInfo();
    }

	public String getSubnet() {
        return subnet;
    }
	public boolean setSubnet(String subnet) {
		if (validIP(subnet)) { //check if is valid IP
            this.subnet = subnet;
            return true;
        } else {
            return false;
        }
	}

	public String getNetmask() {
        return netmask;
    }
   public boolean setNetmask(String netmask) {
        if (validIP(netmask)) { //check if is valid IP
            this.netmask = netmask;
            return true;
        } else {
            return false;
        }
    }
	//Check if IP is valid
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

