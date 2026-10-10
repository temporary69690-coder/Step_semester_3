public class Cart {
    private static final int MAX_ITEMS = 20;
    private final String cartId;
    private final double[] prices = new double[MAX_ITEMS];
    private int count;

    public Cart(String cartId, int initialCapacity) {
        this.cartId = cartId;
        // initialCapacity ignored, using MAX_ITEMS fixed size
        this.count = 0;
    }

    public void addItem(double price) {
        if (count < MAX_ITEMS) {
            prices[count] = price;
            count++;
        }
    }

    public double getTotal() {
        double total = 0;
        for (int i = 0; i < count; i++) {
            total += prices[i];
        }
        return total;
    }

    public int getItemCount() {
        return count;
    }

    public static void main(String[] args) {
        Cart cart = new Cart("CART-5", 20);
        cart.addItem(250);
        cart.addItem(99);
        cart.addItem(151);
        System.out.println("cart.getTotal(): " + cart.getTotal());
        System.out.println("cart.getItemCount(): " + cart.getItemCount());
    }
}