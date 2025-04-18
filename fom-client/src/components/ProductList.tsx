import React from 'react';
import { Product } from '../types/Product';



type Props = {
  products: Product[];
};

const ProductList: React.FC<Props> = ({ products }) => {
  return (
    <table>
      <thead>
        <tr>
          <th>Kod</th>
          <th>Naziv</th>
          <th>EUR</th>
          <th>USD</th>
          <th>Valuta</th>
        </tr>
      </thead>
      <tbody>
        {products.map((p) => (
          <tr key={p.id}>
            <td>{p.code}</td>
            <td>{p.name}</td>
            <td>{p.priceEur}</td>
            <td>{p.priceUsd}</td>
            <td>{p.currency}</td>
          </tr>
        ))}
      </tbody>
    </table>
  );
};

export default ProductList;