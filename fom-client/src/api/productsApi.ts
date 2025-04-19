import axios from 'axios';
import { Product } from '../types/Product';
import { PopularProduct } from '../types/PopularProduct';


const API_URL = import.meta.env.VITE_PRODUCTS_API_URL; // URL prema Product grani Backenda 

interface ProductFilterParams {
    code?: string;
    name?: string;
  }

interface ApiResponse<T> {
    success: boolean;
    message: string;
    data: T;
  }

export const fetchProducts = async (code?: string, name?: string): Promise<Product[]> => {
  const params: ProductFilterParams = {};
  if (code) params.code = code;
  if (name) params.name = name;

  try {
  const response = await axios.get<ApiResponse<Product[]>>(`${API_URL}/filter`, { params });
  console.log(response.data);
  return response.data.data;
  } catch (error) {
    console.error('Greška pri dohvatu produkata:', error);
    throw error; 
  }
};

export const fetchPopularProducts = async (): Promise<PopularProduct[]> => {
  try {
  const response = await axios.get<ApiResponse<PopularProduct[]>>(`${API_URL}/popular`, {});
  console.log(response.data);
  return response.data.data;
  } catch (error) {
    console.error('Greška pri dohvatu popularnih produkata:', error);
    throw error; 
  }
};