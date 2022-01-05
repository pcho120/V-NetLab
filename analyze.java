/**
 *
 * @author Hyunkun Cho, Marcus Jones 
 */
package config;
import java.io.*;
import java.util.*;
import java.util.regex.Pattern;

public class analyze {

    String line, param, value, curType, curName;
    String[] lineRead;
    HashMap<String, VMs> vmMap = new HashMap<>();
    HashMap<String, Hubs> hubMap = new HashMap<>();
    HashMap<String, String> solutionMap = new HashMap<>();
    VMs curVmItem = new VMs("");
    Hubs curHubItem = new Hubs("");
    Boolean findObjects = true;
    Boolean findSolutions = false;
    Boolean parseVM = false;
    Boolean parseHub = false;
    
    public analyze(FileReader file){
        
        try {
            BufferedReader bufferedReader = new BufferedReader(file);

            while((line = bufferedReader.readLine()) != null) {
                //System.out.println(line);
                if (findObjects) {
                    lineRead = line.split(" ");
                    if (lineRead.length == 3) {
                        if (lineRead[2].contains("{")) {
                            curType = lineRead[0];
                            curName = lineRead[1];
                            if (curType.equals("VM")) {
                                VMs item = new VMs(curName);
                                vmMap.put(curName, item);
                                curVmItem = vmMap.get(curName);
                                parseVM = true;
                                findObjects = false; parseHub = false;
                            } else if (curType.equals("hub")) {
                                Hubs item = new Hubs(curName);
                                hubMap.put(curName, item);
                                curHubItem = hubMap.get(curName);
                                parseHub = true;
                                findObjects = false; parseVM = false;
                            } else {
                                System.out.println("Incorrect item type. Should be hub or vm.");
                            }
                        } else {
                            System.out.println("Invalid object opening statement.");
                        }
                    } else if (lineRead.length == 2 && lineRead[0].contains("partial_solution")){
                        //partial solution line read, go to next section
                        findObjects = false;
                        findSolutions = true;
                    } else if (line.trim().equals("")) {
                        //System.out.println("Blank line found.");
                    } else {
                        System.out.println("Length incorrect. Actual length: " + lineRead.length);
                    }
                } else if (findSolutions){
                    line = line.trim().replaceAll("[(),]", "");
                    lineRead = line.split(" ");
                    if (lineRead.length == 2) {
                        param = lineRead[0];
                        value = lineRead[1];
                        //System.out.println(param + " " + value);
                        solutionMap.put(param, value); //puts into map (Gemini.eth0 , v2.vinf21)
                        
                        String[] paramSplit = param.split(Pattern.quote(".")); //split Gemini.eth0 into [Gemini, eth0]
                        curVmItem = vmMap.get(paramSplit[0]); //gets item based on name above
                        curVmItem.connectionAdd(paramSplit[1], value);
                    }
                } else if (parseVM) {
                    lineRead = line.trim().split(":");
                    if (lineRead.length == 2) {
                        param = lineRead[0].trim();
                        value = lineRead[1].trim().replace("\"", "");
                        try {
                            switch(param) {
                                case "os":
                                    curVmItem.setOs(value);
                                    break;
                                case "ver":
                                    curVmItem.setVr(value);
                                    break;
                                case "src":
                                    curVmItem.setSrc(value);
                                    break;
                                case "eth0":
                                    curVmItem.setEth0(value);
                                    break;
                                case "eth1":
                                    curVmItem.setEth1(value);
                                    break;
                                case "eth2":
                                    curVmItem.setEth2(value);
                                    break;
                                default:
                                    System.out.println("Unknown Parameter Error. vm");
                            }
                        } catch(NullPointerException e) {
                            System.out.println("The object you're trying to access doesn't exist.");
                        }
                   } else if (lineRead.length == 1 && lineRead[0].contains("}")) {
                       findObjects = true;
                   }
                } else if (parseHub) {
                    lineRead = line.trim().split(":");
                    if (lineRead.length == 2) {
                        param = lineRead[0].trim();
                        value = lineRead[1].trim().replace("\"", "");
                        try {
                            switch(param) {
                                case "info":
                                    curHubItem.setInfo(value);
                                    break;
                                case "subnet":
                                    curHubItem.setSubnet(value);
                                    break;
                                case "netmask":
                                    curHubItem.setNetmask(value);
                                    break;
                                default:
                                    System.out.println("Unknown Parameter Error. hub");
                            }
                        } catch(NullPointerException e) {
                            System.out.println("The object you're trying to access doesn't exist.");
                            System.out.println(e.getMessage());
                        }
                   } else if (lineRead.length == 1 && lineRead[0].contains("}")) {
                       findObjects = true;
                   }
                }
            }   
            
            // Always close files.
            bufferedReader.close();
            printMap(vmMap);
            printMap(hubMap);
            printMap(solutionMap);
            //return itemsMap; leftover from old method
        }
        catch(IOException ex) {
            System.out.println(ex.getMessage());
            //return null; leftover from old method
        }
    } 
    
    public HashMap<String, VMs> getVmMap() {
        return vmMap;
    }
    
    public HashMap<String, Hubs> getHubMap() {
        return hubMap;
    }
    
    public static void printMap(Map map) {
        for (Object name : map.keySet()) {
            String key = name.toString();
            String value = map.get(name).toString();
            System.out.println(key + " " + value);
        }
    }
}