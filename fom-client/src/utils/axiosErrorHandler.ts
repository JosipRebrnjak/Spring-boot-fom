import axios from 'axios';

export const handleError = (error: unknown): string => {
  if (axios.isAxiosError(error)) {
    return error.response?.data?.message || 'Nepoznata greška s poslužiteljem';
  }
  return 'Došlo je do nepoznate greške';
};