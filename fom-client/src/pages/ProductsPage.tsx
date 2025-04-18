import React, { useEffect, useState } from 'react';
import { fetchProducts } from '../api/productsApi';
import { Product } from '../types/Product';
import ProductList from '../components/ProductList';

const ProductsPage = () => {
  const [products, setProducts] = useState<Product[]>([]);
  const [code, setCode] = useState('');
  const [name, setName] = useState('');

  useEffect(() => {
    fetchProducts().then(setProducts);
  }, []);

  const handleSubmit = async (e: React.FormEvent) => {
    e.preventDefault();
    const data = await fetchProducts(code, name);
    setProducts(data);
  };

  return (
    <div className="container">
      <h2>Filtriraj proizvode</h2>
      <form onSubmit={handleSubmit}>
        <input placeholder="Kod" value={code} onChange={(e) => setCode(e.target.value)} />
        <input placeholder="Naziv" value={name} onChange={(e) => setName(e.target.value)} />
        <button type="submit">Filtriraj</button>
      </form>
      <ProductList products={products} />
    </div>
  );
};

export default ProductsPage;