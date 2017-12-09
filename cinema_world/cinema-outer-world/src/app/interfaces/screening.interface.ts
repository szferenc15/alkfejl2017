import { Time } from '@angular/common';

export interface Screening {
  twoDimensional?: boolean;
  threeDimensional?: boolean;
  fourDimensional?: boolean;
  language?: string;
  synchron?: boolean;
  inscriptive?: boolean;
  screenDay?: Date;
  screenTime?: Time;
}
