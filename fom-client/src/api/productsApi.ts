import axios from 'axios';
import { Product } from '../types/Product';


const API_URL = import.meta.env.VITE_PRODUCTS_API_URL; // URL prema Product grani Backenda 

interface ProductFilterParams {
    code?: string;
    name?: string;
  }

export const fetchProducts = async (code?: string, name?: string): Promise<Product[]> => {
  const params: ProductFilterParams = {};
  if (code) params.code = code;
  if (name) params.name = name;

  try {
  const response = await axios.get<Product[]>(`${API_URL}/filter`, { params });
  console.log(response.data);
  return response.data;
  } catch (error) {
    console.error('Greška pri dohvatu produkata:', error);
    throw error; 
  }
};