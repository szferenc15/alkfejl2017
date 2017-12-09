export interface Category {
  category: string;
}

export interface Trailer {
  url: string;
}

export interface Film {
  title?: string;
  picture?: string;
  language?: string;
  playTime?: number;
  premiere?: Date;
  ageLimit?: number;
  directorFirstName?: string;
  directorLastName?: string;
  country?: string;
  year?: number;
  rate?: number;
  description?: string;
  categories?: Category[];
  trailers?: Trailer[];
}
