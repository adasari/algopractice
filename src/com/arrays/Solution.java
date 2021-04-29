package com.arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
package com.arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SoftwareSystem {
	
	public static void main(String[] args) {
		String[] input = new String[] {
			"DEPEND TELNET TCPIP NETCARD",
			"DEPEND TCPIP NETCARD",
			"DEPEND NETCARD TCPIP",
			"DEPEND DNS TCPIP NETCARD",
			"DEPEND BROWSER TCPIP HTML",
			"INSTALL NETCARD",
			"INSTALL TELNET",
			"INSTALL foo",
			"REMOVE NETCARD",
			"INSTALL BROWSER",
			"INSTALL DNS",
			"LIST",
			"REMOVE TELNET",
			"REMOVE NETCARD",
			"REMOVE DNS",
			"REMOVE NETCARD",
			"INSTALL NETCARD",
			"REMOVE TCPIP",
			"REMOVE BROWSER",
			"REMOVE TCPIP",
			"LIST",
			"END"
			
			
		};
		
//		input = new String[] {
//				"DEPEND TCPIP NETCARD",
//				"DEPEND NETCARD TCPIP"
//			};
		
		doIt(input);
	}

	private static Map<String, Software> softwares = new HashMap<>();
	private static List<Software> installed = new ArrayList<>();

	private static void install(Software s) {
		System.out.println("Installing " + s);
		installed.add(s);
	}

	private static boolean isInstalled(Software s) {
		return installed.contains(s);
	}

	private static Software getSoftwares(String name) {
		Software s =softwares.get(name);
		if (s == null) {
			s = new Software(name);
			softwares.put(name, s);
		}
		
		return s;
	}
	
	static void doIt(String[] input) {
		for (String cmd : input) {
			String[] cmdSplits = cmd.split("\\s+");

			String cmdStr = cmdSplits[0];

			switch (cmdStr) {
			case "DEPEND":
				System.out.println(cmd);
				String name = cmdSplits[1];
				for (int i = 2; i < cmdSplits.length; i++) {
                	String currentDependency = cmdSplits[i];
                	
                	List<Software> dependencies = getSoftwares(currentDependency).getDepedencies();
                	if (dependencies != null && dependencies.contains(getSoftwares(name))) {
                		System.out.println(currentDependency + " depends on "+ name + ", ignoring command");
                	} else {
                		getSoftwares(name).addDependencies(getSoftwares(currentDependency));
                	}
				}
				break;
			case "INSTALL":
				Software toBeInstalled = getSoftwares(cmdSplits[1]);
				System.out.println(cmd);
				if (isInstalled(toBeInstalled)) {
					System.out.println(toBeInstalled + " is already installed");					
				}else {
					List<Software> dependencies = toBeInstalled.getDepedencies();
					if (dependencies != null) {
						for (Software s : dependencies) {
							if (!isInstalled(s)) {
								install(s);
							}
						}
					}
					
					install(toBeInstalled);
				}
				break;
			case "REMOVE":
				System.out.println(cmd);
				Software s = getSoftwares(cmdSplits[1]);
				if (!isInstalled(s)) {
					System.out.println(s + " is not installed");					
				} else if (canRemove(s)) {
					System.out.println("Removing "+ s);
					installed.remove(s);
					
					List<Software> dependencies = s.getDepedencies();
					for (Software ds : dependencies) {
						if (canRemove(ds)) {
							System.out.println("Removing "+ ds);
							installed.remove(ds);
						}
					}
					
				} else {
					System.out.println(s + " is still needed");
				}
				
				break;

			case "LIST":
				System.out.println(cmd);
				for (Software st : installed) {
					System.out.println(st);
				}
				
				break;
			case "END":
				System.out.println(cmd);
				break;
			}
		}
	}

	public static boolean canRemove(Software s) {
		for (Software i : installed) {
			List<Software> depSoftwares = i.getDepedencies();
			if (depSoftwares != null) {
				for (Software d : depSoftwares) {
					if (s.equals(d)) {
						return false;
					}
				}
			}
		}
		return true;
	}

}



class Component {
	private String name;
	private List<Component> depedencies;

	public Component(String name) {
		this.name = name;
		this.depedencies = new ArrayList<Component>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Component> getDepedencies() {
		return depedencies;
	}

	public void setDepedencies(List<Component> depedencies) {
		this.depedencies = depedencies;
	}

	void addDependencies(Component s) {
		this.depedencies.add(s);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Component other = (Component) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return this.name;
	}
	
	

}

*/


public class Solution {
	
	static void doIt(String[] input) {
        if (input == null || input.length == 0) return;
        Graph graph = new Graph();
        for (String cmd : input) {
            if (cmd.startsWith("DEPEND")) {
                String[] cmdSplits = cmd.split(" ");
                String u = cmdSplits[1];
                for (int i = 2; i < cmdSplits.length; i++) {
                	graph.addEdge(u, cmdSplits[i]);                }                
            } else if (cmd.startsWith("INSTALL")) {
            	
                
            } else if (cmd.startsWith("REMOVE")) {
                
            } else if (cmd.startsWith("LIST")) {
                
            }
        }        
    }

}

class Graph {
    Map<String, List<String>> adjList;
    Map<String, Boolean> status;
    
    public Graph() {
    	adjList = new HashMap<String, List<String>>();
    	status = new HashMap<>();
    }
    
    
    public boolean IsDepdend(String one, String two) {
    	if (adjList.containsKey(one)) {
    		return adjList.get(one).contains(two);
    	}
    	
    	return false;
    }
    
    public void addEdge(String U, String V) {
        // if U, V
       List<String> adjs =  adjList.get(U);
       if (adjs == null) {
    	   adjs = new ArrayList<>();    
    	   adjList.put(U, adjs);
       }
       
       System.out.println("");
       adjs.add(V);     
      
    }
    
    public void install(String item) {
    	List<String> adjs = adjList.get(item);
    	for (String softwares : adjs) {
    		
    	}
    }
    
    public void remove(String item) {
    	
    }
}
