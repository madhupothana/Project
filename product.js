document.addEventListener('DOMContentLoaded', () => {
  const products = [
    
        { "id": 1, "name": "Product 1", "price": 10.99 },
        { "id": 2, "name": "Product 2", "price": 15.99 },
        { "id": 3, "name": "Product 3", "price": 12.49 },
        { "id": 4, "name": "Product 4", "price": 8.75 },
        { "id": 5, "name": "Product 5", "price": 22.50 },
        { "id": 6, "name": "Product 6", "price": 5.99 },
        { "id": 7, "name": "Product 7", "price": 18.25 },
        { "id": 8, "name": "Product 8", "price": 14.99 },
        { "id": 9, "name": "Product 9", "price": 9.95 },
        { "id": 10, "name": "Product 10", "price": 11.50 },
        { "id": 11, "name": "Product 11", "price": 7.25 },
        { "id": 12, "name": "Product 12", "price": 20.00 },
        { "id": 13, "name": "Product 13", "price": 13.99 },
        { "id": 14, "name": "Product 14", "price": 6.49 },
        { "id": 15, "name": "Product 15", "price": 16.75 },
        { "id": 16, "name": "Product 16", "price": 9.99 },
        { "id": 17, "name": "Product 17", "price": 19.95 },
        { "id": 18, "name": "Product 18", "price": 8.50 },
        { "id": 19, "name": "Product 19", "price": 14.25 },
        { "id": 20, "name": "Product 20", "price": 23.00 }
         
  ];
  var count = 12;
  const paginationButtons = document.getElementById('pages');
  const productsContainer = document.querySelector('.products');

  function displayTablePage(pageNumber) {
    const startIndex = (pageNumber - 1) * count;
    const endIndex = startIndex + count;
    const products1 = products.slice(startIndex, endIndex);
    const productsContainer = document.querySelector('.products');
    productsContainer.innerHTML = ''; // Clear previous content

    products1.forEach(product => {
      const productCard = document.createElement('div');
      productCard.className = 'product-card';
      productCard.innerHTML = `
        <div class="product-image">
          <img src="img1.jpg" alt="${product.name}">
        </div>
        <h3>${product.name}</h3>
        <p>Price: $${product.price.toFixed(2)}</p>
        <button class="add-to-cart-btn" data-id="${product.id}">Add to Cart</button>
      `;
      productsContainer.appendChild(productCard);
    });
  }

  productsContainer.addEventListener('click', event => {
    if (event.target.classList.contains('add-to-cart-btn')) {
      const productId = parseInt(event.target.getAttribute('data-id'));
      const product = products.find(p => p.id === productId);
      if (product) {
        addToCart(product);
      }
    }
  });

  function createPaginationButtons(totalPages) {
    paginationButtons.innerHTML = '';
    for (let i = 1; i <= totalPages; i++) {
        const button = document.createElement('button');
        button.textContent = i;
        button.addEventListener('click', () => displayTablePage(i));
        paginationButtons.appendChild(button);
    }
}

  const totalPages = Math.ceil(products.length /count);
  createPaginationButtons(totalPages);
  displayTablePage(1);

  function addToCart(product) {
    const cartItems = JSON.parse(localStorage.getItem('cartItems')) || [];
    cartItems.push(product);
    localStorage.setItem('cartItems', JSON.stringify(cartItems));
    alert('Item added to cart.');
  }
});