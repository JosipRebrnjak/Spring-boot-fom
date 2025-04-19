import React from 'react';
import { PopularProduct } from '../types/PopularProduct';



type Props = {
  popularProducts: PopularProduct[];
};

const PopularProductList: React.FC<Props> = ({ popularProducts }) => {
  return (
    <table>
      <thead>
        <tr>
          <th>Kod</th>
          <th>Naziv</th>
          <th>Ocjena</th>
          <th>EUR</th>
        </tr>
      </thead>
      <tbody>
        {popularProducts.map((p) => (
          <tr key={p.code}>
            <td>{p.code}</td>
            <td>{p.name}</td>
            <td>{p.formatedRating}</td>
            <td>{p.priceEur}</td>
          </tr>
        ))}
      </tbody>
    </table>
  );
};

export default PopularProductList;