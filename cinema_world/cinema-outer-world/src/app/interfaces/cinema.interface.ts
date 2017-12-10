import { Screening } from './screening.interface';
import { Film } from './film.interface';

export interface Cinema {
  country?: string;
  city?: string;
  district?: string;
  street?: string;
  houseNumber?: number;
  name?: string;
  amenitiesCharge?: number;
  films?: Film[];
  screenings?: Screening[];
}
