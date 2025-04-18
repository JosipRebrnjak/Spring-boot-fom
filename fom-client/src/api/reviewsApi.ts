import axios from 'axios';
import { Review } from '../types/Review';


const API_URL = import.meta.env.VITE_REVIEWS_API_URL; // URL prema review grani Backenda

export const createReview = async (productId: number, review: Review): Promise<Review> => {
    try {
        const response = await axios.post(`${API_URL}/${productId}`, review);
        return response.data.data; 
    } catch (error) {
        const errorMessage = handleError(error);
        throw new Error(errorMessage);
    }
};


export const fetchReviewsByProductId = async (productId: number): Promise<Review[]> => {
    try {
        const response = await axios.get(`${API_URL}/${productId}`);
        console.log(response);
        return response.data.data; // Pretpostavka da je odgovor u formatu { data: [...] }
    } catch (error) {
        const errorMessage = handleError(error);
        throw new Error(errorMessage);
    }
};

const handleError = (error: unknown): string => {
    if (axios.isAxiosError(error)) {
      // Ako je greška od Axios-a, vratit ćemo specifičnu poruku greške
      return error.response?.data?.message || 'Nepoznata greška s poslužiteljem';
    }
    // Ako nije greška od Axios-a, vratit ćemo generičku poruku
    return 'Došlo je do nepoznate greške';
  };