export interface FilmInfo {
  id: number;
  title: string;
  language: string;
  synchron: boolean;
  inscriptive: boolean;
  imax: boolean;
  threeDimensional: boolean;
  fourDimensional: boolean;
  playTime: number;
  premiere: Date;
  ageLimit: number;
  directorFirstName: string;
  directorLastName: string;
  country: string;
  year: number;
  rate: number;
  description: string;
}

export class FilmInfoDatabase {
  private cinemaInfoData: FilmInfo[] = [
    {
      id: 0,
      title: 'Thor: Ragnarok',
      language: 'magyar',
      synchron: true,
      inscriptive: false,
      imax: true,
      threeDimensional: true,
      fourDimensional: false,
      playTime: 131,
      premiere: new Date(2017,11,1),
      ageLimit: 12,
      directorFirstName: 'Taika',
      directorLastName: 'Waititi',
      country: 'USA',
      year: 2017,
      rate: 4,
      description: 'A Marvel Studios uj filmjeben Thort porolyetol megfosztva bebortonzik az univerzum tulso felen.'
    },
    {
      id: 1,
      title: 'Star Wars: The Last Jedi',
      language: 'orosz',
      synchron: true,
      inscriptive: false,
      imax: true,
      threeDimensional: true,
      fourDimensional: false,
      playTime: 150,
      premiere: new Date(2017,12,14),
      ageLimit: 12,
      directorFirstName: 'Rian',
      directorLastName: 'Johnson',
      country: 'USA',
      year: 2017,
      rate: 5,
      description: 'A Star Wars: Az utolso Jedikben a Skywalker saga folytatodik.'
    },
  ];

  getData(): FilmInfo[] {
    return this.cinemaInfoData;
  }
}


