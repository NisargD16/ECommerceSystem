// Name: Nisarg Doshi
//Student #: 501109700
public class CartItem extends Product
{
	private Product product; //reference to a product object
	private String productOptions; // reference to productOption string

    public CartItem(Product product, String productOptions)
    {
        this.product = product;
		this.productOptions = productOptions;
    }

    public Product getProduct() //getters
	{
		return product;
    }

    public String getProductOptions() //getters
	{
		return productOptions;
    }

    public void print()  //print method for a cart item
	{
		product.print();
	}
	public boolean equals(Object other) //custom made equal method to check if two products are equal based on their ID
	{
		CartItem otherC = (CartItem) other;  
		return this.product.getId().equals(otherC.product.getId());  
	}
}
	

