/*represent something that can be sold by the POS system that has a flavor */
/*the Ice cream class extends this class, other other might be a pop sickle */
package natalie.project.possystem.domain;
public abstract class FlavoredSellable {
	protected Flavor _flavor;
	protected String _descr;
	protected double _cost = 0;
	public Flavor getFlavor() {
		return _flavor;
	}
	
	public void setFlavor(Flavor _inFlavor) {
		_flavor = _inFlavor;
		_cost = _inFlavor.getCost();
		_descr =  _inFlavor.getDescr();
	}
	public void setCost(double _costIn){
		_cost = _costIn;
	}
	public String getDescription() {
		return _descr  + " - $"+ _cost;
	}

	public void setDescription(String _new_descr_in){
		_descr = _new_descr_in;
	}
	public abstract double getCost();
}
