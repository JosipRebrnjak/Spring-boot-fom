import axios from 'axios';
import { Product } from '../types/Product';

const API_URL = 'http://localhost:8080/api/products'; // prilagodi prema backu

export const fetchProducts = async (code?: string, name?: string): Promise<Product[]> => {
  const params: any = {};
  if (code) params.code = code;
  if (name) params.name = name;

  const response = await axios.get<Product[]>(API_URL, { params });
  return response.data;
};