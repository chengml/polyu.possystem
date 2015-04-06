/* a class that represents a flavor and has an assoicated cost */
package natalie.project.possystem.domain;
public class Flavor {
	private String _flavorDescr;
	private double _flavorCost;
	
	public Flavor(String _name, double _cost){
		_flavorDescr = _name;
		_flavorCost = _cost;
	}
	public String getDescr() {
		return _flavorDescr;
	}
	public double getCost() {
		return _flavorCost;
	}
}
