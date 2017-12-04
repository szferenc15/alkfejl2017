export interface CinemaInfo {
  id: number;
  country: string;
  city: string;
  district: string;
  street: string;
  houseNumber: number;
  name: string;
  amenitiesCharge: number;
}

export class CinemaInfoDatabase {
  private cinemaInfoData: CinemaInfo[] = [
    {
      id: 0,
      country: "Magyarorszag",
      city: "Budapest",
      district: null,
      street: "Kerepesi",
      houseNumber: 9,
      name: "CW Arena",
      amenitiesCharge: 40
    },
    {
      id: 1,
      country: "Oroszország",
      city: "Moszkva",
      district: "XVI",
      street: "Bol'shoy Ovchinnikovskiy Pereulok",
      houseNumber: 16,
      name: "CW Pyat' Zvozd",
      amenitiesCharge: 100
    },
  ];

  getData(): CinemaInfo[] {
    return this.cinemaInfoData.slice();
  }
}


