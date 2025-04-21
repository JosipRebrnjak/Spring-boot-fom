import axios from 'axios';
import { Review } from '../types/Review';
import { handleError } from '../utils/axiosErrorHandler';


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
        return response.data.data; 
    } catch (error) {
        const errorMessage = handleError(error);
        throw new Error(errorMessage);
    }
};

