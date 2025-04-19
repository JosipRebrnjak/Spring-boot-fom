import React from 'react';

type Props = {
  rating: number;
  max?: number;
};

const StarRating: React.FC<Props> = ({ rating, max = 5 }) => {
  const stars = [];

  for (let i = 0; i < max; i++) {
    const fillLevel = Math.min(Math.max(rating - i, 0), 1); // 0 do 1
    const gradId = `starGrad-${rating}-${i}`; // jedinstveni ID za svaku zvjezdicu

    stars.push(
      <svg
        key={i}
        xmlns="http://www.w3.org/2000/svg"
        viewBox="0 0 24 24"
        width="24"
        height="24"
        className="inline-block"
      >
        <defs>
          <linearGradient id={gradId}>
            <stop offset={`${fillLevel * 100}%`} stopColor="gold" />
            <stop offset={`${fillLevel * 100}%`} stopColor="#e5e7eb" />
          </linearGradient>
        </defs>
        <path
          fill={`url(#${gradId})`}
          d="M12 .587l3.668 7.571 8.332 1.151-6.064 5.952 1.472 8.312L12 18.896l-7.408 4.677 1.472-8.312L0 9.309l8.332-1.151z"
        />
      </svg>
    );
  }

  return <div className="flex items-center gap-1">{stars}</div>;
};

export default StarRating;
