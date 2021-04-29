package com.arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SoftwareSystem {

	public static void main(String[] args) {
		String[] input = new String[] { "DEPEND TELNET TCPIP NETCARD", "DEPEND TCPIP NETCARD", "DEPEND NETCARD TCPIP",
				"DEPEND DNS TCPIP NETCARD", "DEPEND BROWSER TCPIP HTML", "INSTALL NETCARD", "INSTALL TELNET",
				"INSTALL foo", "REMOVE NETCARD", "INSTALL BROWSER", "INSTALL DNS", "LIST", "REMOVE TELNET",
				"REMOVE NETCARD", "REMOVE DNS", "REMOVE NETCARD", "INSTALL NETCARD", "REMOVE TCPIP", "REMOVE BROWSER",
				"REMOVE TCPIP", "LIST", "END"

		};

//		input = new String[] {
//				"DEPEND A B C",
//				"DEPEND B D",
//				"INSTALL A",
//				"INSTALL A"
//			};

//		input = new String[] {
//				"DEPEND A B C",
//				"INSTALL B",
//				"INSTALL C",
//				"INSTALL A",
//				"REMOVE A"
//			};

		input = new String[] { "DEPEND TELNET TCPIP NETCARD", "DEPEND TCPIP NETCARD", "DEPEND NETCARD TCPIP",
				"DEPEND DNS TCPIP NETCARD", "DEPEND BROWSER TCPIP HTML", "INSTALL NETCARD", "INSTALL TELNET",
				"INSTALL foo", "REMOVE NETCARD", "INSTALL BROWSER", "INSTALL DNS", "LIST", "REMOVE TELNET",
				"REMOVE NETCARD", "REMOVE DNS", "REMOVE NETCARD", "INSTALL NETCARD", "REMOVE TCPIP", "REMOVE BROWSER",
				"REMOVE TCPIP", "LIST", "END" };

		doIt(input);
	}

	static void doIt(String[] input) {
		ComponentSystem componentSystem = new ComponentSystem();
		for (String cmd : input) {
			String[] cmdSplits = cmd.split("\\s+");

			String cmdStr = cmdSplits[0];

			switch (cmdStr) {
			case "DEPEND":
				System.out.println(cmd);
				String name = cmdSplits[1];
				for (int i = 2; i < cmdSplits.length; i++) {
					String currentDependency = cmdSplits[i];

					List<Component> dependencies = componentSystem.getSoftwares(currentDependency).getDepedencies();
					if (dependencies != null && dependencies.contains(componentSystem.getSoftwares(name))) {
						System.out.println(currentDependency + " depends on " + name + ", ignoring command");
					} else {
						componentSystem.getSoftwares(name)
								.addDependencies(componentSystem.getSoftwares(currentDependency));
					}
				}
				break;
			case "INSTALL":
				System.out.println(cmd);
				componentSystem.install(cmdSplits[1]);
				break;
			case "REMOVE":
				System.out.println(cmd);
			//	componentSystem.remove(cmdSplits[1], true);
				break;

			case "LIST":
				System.out.println(cmd);
				for (Component st : componentSystem.getInstalledComponents()) {
					System.out.println(st);
				}

				break;
			case "END":
				System.out.println(cmd);
				break;
			}
		}
	}

}

// A - B -> C
// D -> C

class ComponentSystem {

	private Map<String, Component> components = new HashMap<>();
	private List<Component> installedComponents = new ArrayList<>();

	private void install(Component s) {
		System.out.println("Installing " + s);
		installedComponents.add(s);
	}

	public Map<String, Component> getComponents() {
		return components;
	}

	public List<Component> getInstalledComponents() {
		return installedComponents;
	}

	public void install(String name) {
		Component toBeInstalled = this.getSoftwares(name);

		if (this.isInstalled(toBeInstalled)) {
			System.out.println(toBeInstalled + " is already installed");
		} else {
			List<Component> dependencies = toBeInstalled.getDepedencies();
			if (dependencies != null) {
				for (Component s : dependencies) {
					if (!this.isInstalled(s)) {
						this.install(s.getName());
					}
				}
			}

			install(toBeInstalled);
		}
	}

	public boolean isInstalled(Component s) {
		return installedComponents.contains(s);
	}

	public Component getSoftwares(String name) {
		Component s = components.get(name);
		if (s == null) {
			s = new Component(name);
			components.put(name, s);
		}

		return s;
	}

	public boolean canRemove(Component s) {
		for (Component i : installedComponents) {
			List<Component> depComps = i.getDepedencies();
			if (depComps != null) {
				for (Component d : depComps) {
					if (s.equals(d)) {
						return false;
					}
				}
			}
		}
		return true;
	}

	public void remove(String name) {
		Component s = this.getSoftwares(name);
		if (!this.isInstalled(s)) {
			System.out.println(s + " is not installed");
		} else if (this.canRemove(s)) {
			System.out.println("Removing " + s);

			this.getInstalledComponents().remove(s);
			List<Component> dependencies = s.getDepedencies();
			if (dependencies != null) {
				for (Component ds : dependencies) {
					if (this.canRemove(ds)) {
						System.out.println("Removing " + ds);
						this.getInstalledComponents().remove(ds);
					}
				}
			}

		} else {
			System.out.println(s + " is still needed");
		}
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

	public List<Component> getDepedencies() {
		return depedencies;
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
