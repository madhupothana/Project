document.addEventListener('DOMContentLoaded', () => {
  const cartItemsContainer = document.getElementById('cart-items');
  const cartTotalElement = document.getElementById('cart-total');
  const checkoutButton = document.getElementById('checkout-btn');

  const cartItems = JSON.parse(localStorage.getItem('cartItems')) || [];
  
  function updateCart() {
    cartItemsContainer.innerHTML = '';
    let total = 0;
    cartItems.forEach(item => {
      const cartItem = document.createElement('li');
      cartItem.textContent = `${item.name} - $${item.price.toFixed(2)}`;
      cartItemsContainer.appendChild(cartItem);
      total += item.price;
    });
    cartTotalElement.textContent = `$${total.toFixed(2)}`;
  }

  updateCart();

  checkoutButton.addEventListener('click', () => {
    alert('Thank you for your purchase!');
    cartItems.length = 0; // Clear the cart
    localStorage.setItem('cartItems', JSON.stringify(cartItems));
    updateCart();
  });
});
