/* Extends the FlavoredSellableDecorator, represents a decorator that be added to the icecream */
/* This is a generic decorator that takes a description and a cost */
package natalie.project.possystem.domain;
public class GenericDecorator extends FlavoredSellableDecorator{
	
	protected FlavoredSellable _icecream; // the flavor we are decorating
	protected String _decor_descr;
	protected double _decor_cost;
	 public GenericDecorator(FlavoredSellable _icecreamIn, String _decor_flavor_in, double _decor_cost_in) {
	 this._icecream = _icecreamIn;
	 _decor_cost = _decor_cost_in;
	 _decor_descr = _decor_flavor_in;
	
	 _icecream.setCost( _icecreamIn.getCost() + _decor_cost);
	// _icecream.setDescription(_icecreamIn.getDescription() + "\n"+"with "+_decor_descr);
	 
	 this.setFlavor(_icecreamIn.getFlavor());
	 }
	 public String getDescription() {
	 //return _icecream. getDescription();
		 return _decor_descr;
	 }
	 public double getCost() {
	 //return _icecream.getCost();
		 return _decor_cost;
	 }
}
