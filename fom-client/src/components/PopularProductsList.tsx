import React from 'react';
import { PopularProduct } from '../types/PopularProduct';
import StarRating from './StarRating';



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
            <td>
                <StarRating rating={p.averageRating} />
                <span className="ml-2 text-sm text-gray-600">({p.formatedRating})</span>
            </td>
            <td>{p.priceEur}</td>
          </tr>
        ))}
      </tbody>
    </table>
  );
};

export default PopularProductList;